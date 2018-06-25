package br.com.farmacia.dto;

import java.sql.Connection;
import java.util.Optional;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Pessoa;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.FarmaciaDAO;
import br.com.farmacia.modelo.dao.LoginDAO;

public class LoginDTO {
	private Connection connection;
	private LoginDAO loginDAO;

	public LoginDTO(Connection connection) {
		this.connection = connection;
		this.loginDAO = new LoginDAO(this.connection);
	}

	public Optional<? extends Pessoa> validaUsuario(Login login) {
		boolean cliente = loginDAO.validaUsuario(login, LoginDAO::clienteQuery);
		boolean farmacia = loginDAO.validaUsuario(login, LoginDAO::farmaciaQuery);
		
		if(!Boolean.logicalXor(cliente, farmacia)) {
			return Optional.empty();
		}
		
		if(cliente) {
			return new ClienteDAO(this.connection).getBy(login);
		}
		
		if(farmacia) {
			return new FarmaciaDAO(connection).getBy(login);
		}
		
		return Optional.empty();
		
	}
	
	public void inserir(Login login) {
		loginDAO.inserir(login);
	}
	
	public Optional<Login> getBy(Login login) {
		return loginDAO.getBy(login);
	}
	
}
