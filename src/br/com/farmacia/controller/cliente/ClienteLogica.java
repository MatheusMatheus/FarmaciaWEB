package br.com.farmacia.controller.cliente;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.ControllerUtil;
import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.dto.ClienteDTO;
import br.com.farmacia.dto.LocalizacaoDTO;
import br.com.farmacia.modelo.ClientePF;

public class ClienteLogica implements Logica {
	private LogicaHelper logicaHelper;
	
	public ClienteLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}

	@Override
	@SuppressWarnings("unchecked")
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			String pagina = null;
			Optional<ClientePF> clienteValido = Optional.empty();
			
			// Verifica se a pessoa retornada é do tipo ClientePF
			if(logicaHelper.getPessoa().getClass().isAssignableFrom(ClientePF.class)) {
				 clienteValido = (Optional<ClientePF>)(Optional<?>)logicaHelper.getPessoa();
			}
			
			if(logicaHelper.getPessoa().isPresent()) {
				return "/paginas/cliente-final/cliente-cadastrado.jsp";
			}
			
			if (!clienteValido.isPresent()) {
				clienteValido = Optional.of(ControllerUtil.getCliente(req, logicaHelper.getLogin()));
				
				LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO(logicaHelper.getConnection());
				localizacaoDTO.inserir(clienteValido.get().getLocalizacao());
				
				logicaHelper.getLoginDTO().inserir(logicaHelper.getLogin());
				
				ClienteDTO clienteDTO = new ClienteDTO(logicaHelper.getConnection());
				clienteDTO.inserir(clienteValido.get());
				
				pagina = "/index.jsp";
			} else  {
				pagina = "/paginas/cliente-final/cliente-cadastrado.jsp";
			}
			
			logicaHelper.getSession().setAttribute("clienteValido", clienteValido.orElse(null));
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}


	
}
