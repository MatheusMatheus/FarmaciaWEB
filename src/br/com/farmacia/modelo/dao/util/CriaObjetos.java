package br.com.farmacia.modelo.dao.util;

import br.com.farmacia.modelo.Login;

public class CriaObjetos {
	private CriaObjetos() {}
	public static Login newLogin(long id, String usuario, String senha) {
		Login login = new Login();
		login.setId(id);
		login.setSenha(senha);
		login.setUsuario(usuario);
		return login;
	}
}
