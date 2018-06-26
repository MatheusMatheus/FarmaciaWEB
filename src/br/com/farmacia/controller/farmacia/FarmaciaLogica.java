package br.com.farmacia.controller.farmacia;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.controller.util.ControllerUtil;
import br.com.farmacia.dto.FarmaciaDTO;
import br.com.farmacia.dto.LocalizacaoDTO;
import br.com.farmacia.modelo.FarmaciaPJ;

public class FarmaciaLogica implements Logica {
	private LogicaHelper logicaHelper;
	public FarmaciaLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			String pagina = null;
			Optional<FarmaciaPJ> farmaciaValida = Optional.empty();
			
			// Verifica se a pessoa retornada é do tipo ClientePF
			if(logicaHelper.getPessoa().getClass().isAssignableFrom(FarmaciaPJ.class)) {
				farmaciaValida = (Optional<FarmaciaPJ>)(Optional<?>)logicaHelper.getPessoa();
			}	
			
			if(logicaHelper.getPessoa().isPresent()) {
				return "/paginas/admin-farmacia/farmacia-cadastrada.jsp";
			}
			
			if (!farmaciaValida.isPresent()) {
				farmaciaValida = Optional.of(ControllerUtil.getFarmacia(req, logicaHelper.getLogin()));
				
				LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO(logicaHelper.getConnection());
				localizacaoDTO.inserir(farmaciaValida.get().getLocalizacao());

				logicaHelper.getLoginDTO().inserir(logicaHelper.getLogin());

				FarmaciaDTO farmaciaDTO = new FarmaciaDTO(logicaHelper.getConnection());
				farmaciaDTO.inserir(farmaciaValida.get());
				pagina = "/index.jsp";
				SubidorImagens.uploadImagem(req);
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
