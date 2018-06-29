package br.com.farmacia.controller.sessao;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;

public class LogoutLogica implements Logica{
	private LogicaHelper logicaHelper;
	
	public LogoutLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)  {
		try {
			HttpSession session = logicaHelper.getSession();
			Connection connection = logicaHelper.getConnection();
			if(connection != null) {
				connection.close();
				System.out.println("Conexão com o banco de dados fechada");
			}
			
			session.removeAttribute("farmaciaValida");
			session.removeAttribute("clienteValido");
			session.invalidate();
			System.out.println("Sessao finalizada");
			return "LogoutRedirect.java";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}

	}

}
