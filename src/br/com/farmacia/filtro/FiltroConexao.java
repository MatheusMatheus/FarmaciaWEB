package br.com.farmacia.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.farmacia.modelo.dao.util.ConnectionFactory;


public class FiltroConexao {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = ConnectionFactory.getConnection();
			request.setAttribute("connection", connection);
			
			chain.doFilter(request, response);
			
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexão com o banco de dados");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
