package br.com.farmacia.controller.farmacia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.controller.util.ControllerUtil;
import br.com.farmacia.dto.MedicamentoDTO;
import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.InsereMedicamento;
import br.com.farmacia.modelo.Medicamento;

public class InserirMedicamentoLogica implements Logica{
	private LogicaHelper logicaHelper;
	
	public InserirMedicamentoLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)  {
		FarmaciaPJ farmacia = (FarmaciaPJ)logicaHelper.getSession().getAttribute("farmaciaValida");
		if(farmacia == null) {
			return "/paginas/paginas-auxiliares/login-invalido.jsp";
		}

		try {
			Medicamento medicamento = ControllerUtil.getMedicamento(logicaHelper.getRequest());
			InsereMedicamento novoMedicamento = ControllerUtil.getInsercaoMedicamento(logicaHelper.getRequest(), farmacia, medicamento);
			
			MedicamentoDTO medicamentoDTO = new MedicamentoDTO(logicaHelper.getConnection());
			medicamentoDTO.novoCadastro(novoMedicamento, medicamento);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
