package br.com.farmacia.controller.farmacia;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.ControllerUtil;
import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.dto.FarmaciaDTO;
import br.com.farmacia.dto.LocalizacaoDTO;
import br.com.farmacia.modelo.FarmaciaPJ;

public class FarmaciaLogica implements Logica {
	private LogicaHelper logicaHelper;
	public FarmaciaLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			String pagina = null;
			Optional<FarmaciaPJ> farmaciaValida = (Optional<FarmaciaPJ>)(Optional<?>)logicaHelper.getPessoa();
			
			if (!farmaciaValida.isPresent()) {
				FarmaciaPJ farmaciaPJ = ControllerUtil.getFarmacia(req, logicaHelper.getLogin());
				
				LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO(logicaHelper.getConnection());
				localizacaoDTO.inserir(farmaciaPJ.getLocalizacao());

				logicaHelper.getLoginDTO().inserir(logicaHelper.getLogin());

				FarmaciaDTO farmaciaDTO = new FarmaciaDTO(logicaHelper.getConnection());
				farmaciaDTO.inserir(farmaciaPJ);
				pagina = "/index.jsp";
			} else {
				pagina = "/paginas/admin-farmacia/farmacia-cadastrada.jsp";
			}
			
			logicaHelper.getSession().setAttribute("farmaciaValida", farmaciaValida.orElse(null));
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}


}
