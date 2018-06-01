package br.com.farmacia.teste;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.LoginDAO;

public class TesteLogin {
	public static void main(String[] args) {
		Login login = new Login();
		login.setId(222222222);
		login.setUsuario("matheus.rodrigues");
		login.setSenha("798794");
		
		GenericDAO<Login> dao = new LoginDAO();
		dao.inserir(login);
		//dao.alterar(login);
		//dao.excluir(login);
		//dao.listar().forEach(System.out::println);
	}
}
