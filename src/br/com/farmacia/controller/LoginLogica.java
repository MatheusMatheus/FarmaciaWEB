package br.com.farmacia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.LoginDAO;
import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class LoginLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Login login = new  Login();
		login.setId((int)System.currentTimeMillis());
		login.setSenha(req.getParameter("senha"));
		login.setUsuario(req.getParameter("usuario"));
		
		GenericDAO<Login> loginDao = new LoginDAO(ConnectionFactory.getConnection());
		
		return null;
	}

}
