package br.com.farmacia.controller.farmacia;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.modelo.InsereMedicamento;

public class InserirMedicamentoLogica implements Logica{
	private LogicaHelper logicaHelper;
	
	public InserirMedicamentoLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)  {
		if(logicaHelper.getPessoa().isPresent()) {
			return "/paginas/cliente-final/cliente-cadastrado.jsp";
		}

		try {
			
			String pagina = null;
			Optional<InsereMedicamento> inserir = Optional.empty();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
