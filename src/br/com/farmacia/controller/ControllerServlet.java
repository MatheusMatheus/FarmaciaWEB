package br.com.farmacia.controller;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")

// Anotação usada para lidar com <input type="file">
@MultipartConfig
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parametro = req.getParameter("logica");
		ResourceBundle classes = ResourceBundle.getBundle("br.com.farmacia.controller.classes");
		String nomeClasse = classes.getString(parametro);
		
		try {
			LogicaHelper logicaHelper = new LogicaHelper(req);

			// Procura no classpath a classe passada no parâmetro
			Class<?> classe = Class.forName(nomeClasse);
			
			// Se encontrar a classe, procura o construtor que tenha como parâmetro um LogicaHelper
			Constructor<?> constructor = classe.getConstructor(LogicaHelper.class);
			
			// Instancia a classe usando o construtor que tem um parâmetro
			Logica logica = (Logica)constructor.newInstance(logicaHelper);
			String pagina = logica.executa(req, res);
			
			req.getRequestDispatcher(pagina).forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}