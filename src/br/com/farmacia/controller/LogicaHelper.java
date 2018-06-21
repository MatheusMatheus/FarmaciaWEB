package br.com.farmacia.controller;

import java.sql.Connection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.farmacia.dto.LoginDTO;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Pessoa;

public class LogicaHelper {
	private final HttpServletRequest request;
	private final Login login;
	private final HttpSession session;
	private final Connection connection;
	private final LoginDTO loginDTO;
	private final Optional<? extends Pessoa> pessoa;

	public LogicaHelper(HttpServletRequest request) {
		this.request = request;
		this.login = ControllerUtil.getLogin(request);
		this.session = request.getSession(false);
		this.connection = ControllerUtil.getConnectionFromSessao(request);
		this.loginDTO = new LoginDTO(connection);
		this.pessoa = loginDTO.validaUsuario(login);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Login getLogin() {
		return login;
	}

	public HttpSession getSession() {
		return session;
	}

	public Connection getConnection() {
		return connection;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public Optional<? extends Pessoa> getPessoa() {
		return pessoa;
	}

}
