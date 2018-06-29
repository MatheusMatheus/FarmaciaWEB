package br.com.farmacia.controller.farmacia;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.controller.util.ControllerUtil;
import br.com.farmacia.controller.util.SubidorImagens;
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
			
			subirImagem(medicamento, farmacia, logicaHelper);
			return "/paginas/admin-farmacia/medicamento-inserido-sucesso.jsp";
		} catch (Exception e) {
			return "/paginas/admin-farmacia/medicamento-inserido-falha.jsp";
		}
	}
	
	private void subirImagem(Medicamento medicamento, FarmaciaPJ farmacia, LogicaHelper logicaHelper) throws ServletException, IOException {
		String nomeMed = medicamento.getNome();
		String categoria = medicamento.getCategoria();
		String razaoSocial = farmacia.getRazaoSocial();
		StringBuilder subpasta = new StringBuilder();
		subpasta.append(razaoSocial).append("/medicamentos/").append(categoria).append("/").append(nomeMed);
		
		SubidorImagens.uploadImagem(logicaHelper.getRequest(), subpasta.toString());		
	}
	
}
