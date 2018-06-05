package br.com.farmacia.controller;

import java.sql.Connection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.LoginDAO;

public class LoginLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String senha = req.getParameter("senha");
		String usuario = req.getParameter("usuario");
		
		Connection connection = (Connection)req.getAttribute("connection");
		LoginDAO loginDao = new LoginDAO(connection);
		Optional<Login> login = loginDao.getBy(senha, usuario);
		
		if(login.isPresent()) {
			// Use existing session if exist or create one new session
			HttpSession session = req.getSession(true);			
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(120);
			return "/index.jsp";
		} else {
			return "WebContent/paginas/login.jsp";
		}
	}

}
