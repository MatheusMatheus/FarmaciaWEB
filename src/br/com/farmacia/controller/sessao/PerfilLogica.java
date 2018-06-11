package br.com.farmacia.controller.sessao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.modelo.Login;

public class PerfilLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		Login login = null;
		if(session != null)
			login = (Login) session.getAttribute("login");
		
		
		return null;
	}

}
