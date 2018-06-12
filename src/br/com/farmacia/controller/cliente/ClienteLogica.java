package br.com.farmacia.controller.cliente;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.dto.ClienteDTO;
import br.com.farmacia.dto.LoginDTO;
import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public class ClienteLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			Login login = getLogin(req);
			
			HttpSession session = req.getSession(false);
			Connection connection = getConnection(req);
			
			LoginDTO loginDTO = new LoginDTO(connection);
			Optional<ClientePF> clienteValido = loginDTO.validaLogin(login);
			
			if (!clienteValido.isPresent()) {
				session.setAttribute("ja-cadastrado", "ja-cadastrado");
				return "/paginas/realiza-cadastro.jsp";
			}
			
			ClientePF clientePF = getCliente(req, login);

			ClienteDTO clienteDTO = new ClienteDTO(connection);
			clienteDTO.inserir(clientePF);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private ClientePF getCliente(HttpServletRequest req, Login login) {
		ClientePF clientePF = new ClientePF();
		StringBuilder nomeCompleto = new StringBuilder();
		nomeCompleto.append(req.getParameter("primeiroNome"));
		nomeCompleto.append(" ");
		nomeCompleto.append(req.getParameter("sobrenome"));
		
		clientePF.setLogin(login)
		 	 	 .setLocalizacao(getLocalizacao(req))
		 	 	 .setEmail(req.getParameter("email"))
		 	 	 .setPerfil(Perfil.CLIENTE)
				 .setTelefone(req.getParameter("telefone"))
				 .setSexo(req.getParameter("sexo"))
				 .setNome(nomeCompleto.toString())
				 .setDataNascimento(LocalDate.parse(req.getParameter("dtnasc")))
				 .setCpf(req.getParameter("cpf"));
		return clientePF;
	}

	private Localizacao getLocalizacao(HttpServletRequest req) {
		Localizacao localizacao = new Localizacao();
		localizacao.setId(System.currentTimeMillis());
		localizacao.setCep(req.getParameter("cep"));
		localizacao.setCidade(req.getParameter("cidade"));
		localizacao.setEndereco(req.getParameter("endereco"));
		localizacao.setEstado(req.getParameter("estado"));
		return localizacao;
	}

	private Login getLogin(HttpServletRequest req) {
		Login login = new Login();
		login.setId(System.currentTimeMillis());
		login.setSenha(req.getParameter("senha"));
		login.setUsuario(req.getParameter("email"));
		return login;
	}

	private Connection getConnection(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Connection connection = (Connection) session.getAttribute("connection");
		
		if(connection == null) {
			connection = ConnectionFactory.getConnection();
			session.setAttribute("connection", connection);
		}
		return connection;
	}
	
}
