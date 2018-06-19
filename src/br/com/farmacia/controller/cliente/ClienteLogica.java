package br.com.farmacia.controller.cliente;

import java.sql.Connection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.ControllerUtil;
import br.com.farmacia.controller.Logica;
import br.com.farmacia.dto.ClienteDTO;
import br.com.farmacia.dto.LocalizacaoDTO;
import br.com.farmacia.dto.LoginDTO;
import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Login;

public class ClienteLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			String pagina = null;
			ClientePF clientePF = null;
			Login login = ControllerUtil.getLogin(req);
			HttpSession session = req.getSession(false);
			Connection connection = ControllerUtil.getConnectionFromSessao(req);
			LoginDTO loginDTO = new LoginDTO(connection);
			Optional<Login> loginValido = loginDTO.validaUsuario(login);
			
			if (!loginValido.isPresent()) {
				clientePF = ControllerUtil.getCliente(req, login);
				
				LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO(connection);
				localizacaoDTO.inserir(clientePF.getLocalizacao());
				
				loginDTO.inserir(login);
				
				ClienteDTO clienteDTO = new ClienteDTO(connection);
				clienteDTO.inserir(clientePF);
				
				pagina = "/index.jsp";
			} else  {
				pagina = "/paginas/cadastro/realizar-cadastro.jsp";
			}
			
			session.setAttribute("clienteValido", clientePF);
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}


	
}
