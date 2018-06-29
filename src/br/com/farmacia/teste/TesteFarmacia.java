package br.com.farmacia.teste;

import java.nio.file.Paths;

import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;

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
		farmacia.setLocalizacao(localizacao);
		farmacia.setLogin(login);
		farmacia.setLogoPath(Paths.get("/asdfaf/asdsf"));
		farmacia.setNomeFantasia("Farmacia do bagulho louco");
		farmacia.setPerfil(Perfil.FARMACIA.name());
		farmacia.setRazaoSocial("lkasjdçflksjaçflkjasdçlfj");
		farmacia.setTelefone("31589544");
		
		//dao.alterar(farmacia);
		//dao.excluir(farmacia);
		//dao.listar().forEach(System.out::println);
	}
}
