package br.com.farmacia.controller;

import java.nio.file.Paths;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class ControllerUtil {
	public static ClientePF getCliente(HttpServletRequest req, Login login) {
		ClientePF clientePF = new ClientePF();
		StringBuilder nomeCompleto = new StringBuilder();
		nomeCompleto.append(req.getParameter("primeiroNome"));
		nomeCompleto.append(" ");
		nomeCompleto.append(req.getParameter("sobrenome"));
		
		clientePF.setLogin(login);
		clientePF.setLocalizacao(getLocalizacao(req));
		clientePF.setEmail(req.getParameter("email"));
		clientePF.setPerfil(String.valueOf(Perfil.CLIENTE));
		clientePF.setTelefone(req.getParameter("telefone"));
		clientePF.setSexo(req.getParameter("sexo"));
		clientePF.setNome(nomeCompleto.toString());
		clientePF.setDataNascimento(LocalDate.parse(req.getParameter("dtnasc")));
		clientePF.setCpf(req.getParameter("cpf"));
		return clientePF;
	}

	public static Localizacao getLocalizacao(HttpServletRequest req) {
		Localizacao localizacao = new Localizacao();
		localizacao.setId(System.currentTimeMillis());
		localizacao.setCep(req.getParameter("cep"));
		localizacao.setCidade(req.getParameter("cidade"));
		localizacao.setEndereco(req.getParameter("endereco"));
		localizacao.setEstado(req.getParameter("estado"));
		return localizacao;
	}

	public static Login getLogin(HttpServletRequest req) {
		Login login = new Login();
		login.setId(System.currentTimeMillis());
		login.setSenha(req.getParameter("senha"));
		login.setUsuario(req.getParameter("email"));
		return login;
	}

	public static Connection getConnection(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");
		
		if(connection == null) {
			connection = ConnectionFactory.getConnection();
			session.setAttribute("connection", connection);
		}
		return connection;
	}

	public static FarmaciaPJ getFarmacia(HttpServletRequest req, Login login) {
		FarmaciaPJ farmaciaPJ = new FarmaciaPJ();
		farmaciaPJ.setLogin(login);
		farmaciaPJ.setCnpj(req.getParameter("cnpj"));
		farmaciaPJ.setEmail(req.getParameter("email"));
		farmaciaPJ.setLocalizacao(getLocalizacao(req));
		farmaciaPJ.setLogoPath(Paths.get(req.getParameter("logoPath")));
		farmaciaPJ.setNomeFantasia(req.getParameter("nomeFantasia"));
		farmaciaPJ.setPerfil(String.valueOf(Perfil.FARMACIA));
		farmaciaPJ.setRazaoSocial(req.getParameter("razaoSocial"));
		farmaciaPJ.setTelefone(req.getParameter("telefone"));
		
		return farmaciaPJ;
	}
}
