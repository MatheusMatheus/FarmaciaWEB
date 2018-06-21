package br.com.farmacia.controller.cliente;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			String pagina = null;
			Optional<ClientePF> clientePF = (Optional<ClientePF>)(Optional<?>)logicaHelper.getPessoa();
			
			if (!clientePF.isPresent()) {
				
				LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO(logicaHelper.getConnection());
				localizacaoDTO.inserir(clientePF.get().getLocalizacao());
				
				logicaHelper.getLoginDTO().inserir(logicaHelper.getLogin());
				
				ClienteDTO clienteDTO = new ClienteDTO(logicaHelper.getConnection());
				clienteDTO.inserir(clientePF.get());
				
				pagina = "/index.jsp";
			} else  {
				pagina = "/paginas/cadastro/realizar-cadastro.jsp";
			}
			
			logicaHelper.getSession().setAttribute("clienteValido", clientePF);
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}


	
}
