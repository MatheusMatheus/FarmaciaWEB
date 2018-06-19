package br.com.farmacia.controller.farmacia;

import java.sql.Connection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.ControllerUtil;
import br.com.farmacia.controller.Logica;
import br.com.farmacia.dto.FarmaciaDTO;
import br.com.farmacia.dto.LocalizacaoDTO;
import br.com.farmacia.dto.LoginDTO;
import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Login;

public class FarmaciaLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		try {
			Login login = ControllerUtil.getLogin(req);
			HttpSession session = req.getSession(false);
			Connection connection = ControllerUtil.getConnection(req);
			String pagina = null;

			LoginDTO loginDTO = new LoginDTO(connection);
			Optional<FarmaciaPJ> farmaciaValida = loginDTO.validaLoginFarmacia(login);

			if (!farmaciaValida.isPresent()) {
				FarmaciaPJ farmacia = ControllerUtil.getFarmacia(req, login);

				LocalizacaoDTO localizacaoDTO = new LocalizacaoDTO(connection);
				localizacaoDTO.inserir(farmacia.getLocalizacao());

				loginDTO.inserir(login);

				FarmaciaDTO farmaciaDTO = new FarmaciaDTO(connection);
				farmaciaDTO.inserir(farmacia);
				pagina = "/index.jsp";
			} else 
				pagina = "/paginas/admin-farmacia/farmacia-cadastrada.jsp";

			session.setAttribute("farmaciaValida", farmaciaValida.orElse(null));
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

}
