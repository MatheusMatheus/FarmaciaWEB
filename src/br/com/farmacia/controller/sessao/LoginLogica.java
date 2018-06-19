package br.com.farmacia.controller.sessao;

import java.sql.Connection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.dto.LoginDTO;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.Pessoa;

public class LoginLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res){
		try {
			Login login = new Login();
			login.setId(System.currentTimeMillis());
			login.setSenha(req.getParameter("senha"));
			login.setUsuario(req.getParameter("usuario"));
			
			Connection connection = (Connection)req.getAttribute("connection");
			LoginDTO loginDTO = new LoginDTO(connection);
			
			Optional<? extends Pessoa> clienteValido = loginDTO.validaLogin(login);
			if(clienteValido.isPresent()) {
				Pessoa pessoa = clienteValido.get();
				// Use existing session if exist or create one new session
				HttpSession session = req.getSession(true);	
				if(pessoa.getPerfil().equals(Perfil.CLIENTE))
					session.setAttribute("clienteValido", clienteValido.get());
				
				if(pessoa.getPerfil().equals(Perfil.ADMINISTRADOR))
					session.setAttribute("clienteValido", clienteValido.get());
				session.setMaxInactiveInterval(120);
				
				return "/index.jsp";
			} else {
				connection.close();
				return "/paginas/login.jsp";
			}			
		} catch (Exception e) {
			return "/index.jsp";
		}
	}

}
