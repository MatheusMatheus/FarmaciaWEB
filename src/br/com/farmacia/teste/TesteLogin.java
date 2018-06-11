package br.com.farmacia.teste;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.LoginDAO;
import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class TesteLogin {
	public static void main(String[] args) {
		Login login = new Login();
		login.setId(System.currentTimeMillis());
		login.setUsuario("matheus@gmail.com");
		login.setSenha("12345");
		
		LoginDAO dao = new LoginDAO(ConnectionFactory.getConnection());
		dao.inserir(login);
		
		//dao.alterar(login);
		//dao.excluir(login);
		//dao.listar().forEach(System.out::println);
	}
}
