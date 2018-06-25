package br.com.farmacia.controller.sessao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.farmacia.controller.Logica;
import br.com.farmacia.controller.LogicaHelper;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.Pessoa;

public class LoginLogica implements Logica {
	private LogicaHelper logicaHelper;
	
	public LoginLogica(LogicaHelper logicaHelper) {
		this.logicaHelper = logicaHelper;
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res){
		try {
			String pagina = null;
			
			
			if(logicaHelper.getPessoa().isPresent()) {
				Pessoa pessoa = logicaHelper.getPessoa().get();
				
				// Use existing session if exist or create one new session
				HttpSession session = logicaHelper.getSession();
				
				if(pessoa.getPerfil().equals(Perfil.CLIENTE.name()))
					session.setAttribute("clienteValido", logicaHelper.getPessoa().orElse(null));
				
				if(pessoa.getPerfil().equals(Perfil.ADMINISTRADOR.name()))
					session.setAttribute("farmaciaValida", logicaHelper.getPessoa().orElse(null));
				session.setMaxInactiveInterval(120);
				
				pagina = "/index.jsp";
			} else {
				pagina = "/paginas/paginas-auxiliares/login-invalido.jsp";
			}		
			
			return pagina;
		} catch (Exception e) {
			e.printStackTrace();;
			return "/index.jsp";
		}
	}

}
