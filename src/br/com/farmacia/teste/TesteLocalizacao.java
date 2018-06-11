package br.com.farmacia.teste;

import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.LocalizacaoDAO;
import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class TesteLocalizacao {
	public static void main(String[] args) {
		GenericDAO<Localizacao> dao = new LocalizacaoDAO(ConnectionFactory.getConnection());
		
		
		Localizacao localizacao = new Localizacao();
		localizacao.setCep("72302108");
		localizacao.setCidade("Sao Luis");
		localizacao.setEndereco("QR 106 CJ 08 CS 05");
		localizacao.setEstado("Maranhao");
		localizacao.setId(5465466);
		
		dao.inserir(localizacao);
		//dao.alterar(localizacao);
		//dao.excluir(localizacao);
		//dao.listar().forEach(System.out::println);
		
	}
}
