package br.com.farmacia.controller.util;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.ServletException;
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
		login.setUsuario(req.getParameter("usuario"));
		return login;
	}

	public static Connection getConnectionFromSessao(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");
		
		if(connection == null) {
			connection = ConnectionFactory.getConnection();
			session.setAttribute("connection", connection);
		}
		return connection;
	}

	public static FarmaciaPJ getFarmacia(HttpServletRequest req, Login login) {
		FarmaciaPJ farmaciaPJ = null;
		try {
			farmaciaPJ = new FarmaciaPJ();
			farmaciaPJ.setLogin(login);
			farmaciaPJ.setCnpj(req.getParameter("cnpj"));
			farmaciaPJ.setLocalizacao(getLocalizacao(req));
			farmaciaPJ.setLogoPath(Paths.get(req.getPart("logoPath").getName()));
			farmaciaPJ.setNomeFantasia(req.getParameter("nomeFantasia"));
			farmaciaPJ.setPerfil(String.valueOf(Perfil.FARMACIA));
			farmaciaPJ.setRazaoSocial(req.getParameter("razaoSocial"));
			farmaciaPJ.setTelefone(req.getParameter("telefone"));
			return farmaciaPJ;
		} catch (ServletException | IOException e) {
			return null;
		}
	}
}
