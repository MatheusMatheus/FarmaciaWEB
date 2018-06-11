package br.com.farmacia.controller.cliente;

import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.dto.ClienteDTO;
import br.com.farmacia.dto.LoginDTO;
import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;

public class ClienteLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			Connection connection = (Connection) req.getSession(false).getAttribute("connection");
			Login login = new Login();
			login.setId(System.currentTimeMillis());
			login.setSenha(req.getParameter("senha"));
			login.setUsuario(req.getParameter("email"));

			if (connection != null) {
				LoginDTO loginDTO = new LoginDTO(connection);
				if (!loginDTO.validaLogin(login).isPresent()) {
					return "/paginas/realiza-cadastro.jsp";
				}
				return "/paginas/login.jsp";
			}

			Localizacao localizacao = new Localizacao();
			localizacao.setId(System.currentTimeMillis());
			localizacao.setCep(req.getParameter("cep"));
			localizacao.setCidade(req.getParameter("cidade"));
			localizacao.setEndereco(req.getParameter("endereco"));
			localizacao.setEstado(req.getParameter("estado"));

			ClientePF clientePF = new ClientePF();
			clientePF.setLogin(login);
			clientePF.setLocalizacao(localizacao);
			clientePF.setCpf(req.getParameter("cpf"));
			clientePF.setDataNascimento(LocalDate.parse(req.getParameter("dtnasc")));
			clientePF.setEmail(req.getParameter("email"));
			clientePF.setNome(req.getParameter("nome"));
			clientePF.setPerfil(Perfil.CLIENTE);
			clientePF.setSexo(req.getParameter("sexo"));
			clientePF.setTelefone(req.getParameter("telefone"));

			ClienteDTO clienteDTO = new ClienteDTO(connection);
			clienteDTO.inserir(clientePF);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
