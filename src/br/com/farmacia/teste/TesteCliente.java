package br.com.farmacia.teste;

import java.time.LocalDate;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class TesteCliente {
	public static void main(String[] args) {
		Localizacao localizacao = new Localizacao();
		localizacao.setCep("72302108");
		localizacao.setCidade("Sao Luis");
		localizacao.setEndereco("QR 106 CJ 08 CS 05");
		localizacao.setEstado("Maranhao");
		localizacao.setId(5465466L);
		
		Login login = new Login();
		login.setId(1528667212874L);
		login.setUsuario("matheus@gmail.com");
		login.setSenha("12345");
		
		ClientePF cliente = new ClientePF();
		cliente.setCpf("04408803197");
		cliente.setDataNascimento(LocalDate.of(1995, 2, 10));
		cliente.setEmail("matheus@gmail.com");
		cliente.setNome("Matheus Lindo");
		cliente.setPerfil(String.valueOf(Perfil.CLIENTE));
		cliente.setLocalizacao(localizacao);
		cliente.setLogin(login);
		cliente.setSexo("M");
		cliente.setTelefone("12345678");
		
		GenericDAO<ClientePF> dao = new ClienteDAO(ConnectionFactory.getConnection());
		//dao.inserir(cliente);
		dao.listar().ifPresent(System.out::println);
	}
}
