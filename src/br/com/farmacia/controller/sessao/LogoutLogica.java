package br.com.farmacia.controller.sessao;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.Logica;

public class LogoutLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)  {
		try {
			HttpSession session = req.getSession(false);
			Connection connection = (Connection)session.getAttribute("connection");
			connection.close();
			System.out.println("Sessao finalizada");
			session.invalidate();
			return "/index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}

	}

}
