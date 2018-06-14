package br.com.farmacia.filtro;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.farmacia.modelo.dao.util.ConnectionFactory;


@WebFilter(urlPatterns = "*")
public class SessaoFiltro implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			// Cast para ter acesso a mais atributos do request
			HttpServletRequest req = (HttpServletRequest)request;

			String url = getFullURL(req);
			
			// Cria uma nova sessão caso não exista nenhuma
			HttpSession session = req.getSession(true);
			
			// Tenta recuperar uma conexão com o BD
			Connection connection = (Connection) session.getAttribute("connection");
			
			// Atribui conexão à sessão, caso essa não exista
			if(connection == null && !url.contains("Logout")) {
				connection = ConnectionFactory.getConnection();
				session.setAttribute("connection", connection);
			}
			
			
			request.setAttribute("connection", connection);
			chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private String getFullURL(HttpServletRequest request) {
	    StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
	    String queryString = request.getQueryString();

	    if (queryString == null) {
	        return requestURL.toString();
	    } else {
	        return requestURL.append('?').append(queryString).toString();
	    }
	}

}
