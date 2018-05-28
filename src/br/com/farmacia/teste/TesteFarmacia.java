package br.com.farmacia.teste;

import java.nio.file.Paths;

import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.dao.FarmaciaDAO;
import br.com.farmacia.modelo.dao.GenericDAO;

public class TesteFarmacia {
	public static void main(String[] args) {
		
		Localizacao localizacao = new Localizacao();
		localizacao.setCep("72302108");
		localizacao.setCidade("Sao Luis");
		localizacao.setEndereco("QR 106 CJ 08 CS 05");
		localizacao.setEstado("Maranhão");
		localizacao.setId(5465466);
		
		Login login = new Login();
		login.setId(513513);
		login.setUsuario("matheus.rodrigues");
		login.setSenha("798794");

		FarmaciaPJ farmacia = new FarmaciaPJ();
		farmacia.setCnpj("88380900000152");
		farmacia.setEmail("fjçalskjfçlsakjflçksjfça@gmail.com");
		farmacia.setLocalizacao(localizacao);
		farmacia.setLogin(login);
		farmacia.setLogoPath(Paths.get("/asdfaf/asdsf"));
		farmacia.setNomeFantasia("Farmacia do bagulho louco");
		farmacia.setPerfil(Perfil.FARMACIA);
		farmacia.setRazaoSocial("lkasjdçflksjaçflkjasdçlfj");
		farmacia.setTelefone("31589544");
		
		GenericDAO<FarmaciaPJ> dao = new FarmaciaDAO();
		dao.inserir(farmacia);
		//dao.alterar(farmacia);
		//dao.excluir(farmacia);
		//dao.listar().forEach(System.out::println);
	}
}
