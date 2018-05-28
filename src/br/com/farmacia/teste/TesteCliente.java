package br.com.farmacia.teste;

import java.time.LocalDate;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.dao.ClienteDAO;
import br.com.farmacia.modelo.dao.GenericDAO;

public class TesteCliente {
	public static void main(String[] args) {
		Localizacao localizacao = new Localizacao();
		localizacao.setCep("72302108");
		localizacao.setCidade("Sao Luis");
		localizacao.setEndereco("QR 106 CJ 08 CS 05");
		localizacao.setEstado("Maranhao");
		localizacao.setId(5465466);
		
		Login login = new Login();
		login.setId(513513);
		login.setUsuario("matheus.rodrigues");
		login.setSenha("798794");
		
		ClientePF cliente = new ClientePF();
		cliente.setCpf("04408803197");
		cliente.setDataNascimento(LocalDate.of(1995, 2, 10));
		cliente.setEmail("matheus@gmail.com");
		cliente.setNome("Matheus Lindo");
		cliente.setPerfil(Perfil.CLIENTE);
		cliente.setLocalizacao(localizacao);
		cliente.setLogin(login);
		cliente.setSexo("M");
		cliente.setTelefone("12345678");
		
		GenericDAO<ClientePF> dao = new ClienteDAO();
		dao.inserir(cliente);
		//dao.listar().forEach(System.out::println);
	}
}
