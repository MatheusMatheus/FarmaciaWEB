package br.com.farmacia.modelo;

public class Login {
	private long id;
	private String usuario;
	private String senha;
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("\n[id: " + getId() + ",");
		sBuilder.append("usuario: " + getUsuario() + ",");
		sBuilder.append("senha: " + getSenha() + "]");
		return sBuilder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
