package br.com.farmacia.modelo;

public abstract class Pessoa {
	private String email;
	private String telefone;
	private Localizacao localizacao;
	private Login login;
	private String perfil;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("email: " + getEmail() + ",");
		sb.append("telefone: " + getTelefone() + ",");
		sb.append("perfil: " + getPerfil() + ",");
		sb.append("\nlogin: " + getLogin() + ",");
		sb.append("\nlocalizacao: " + getLocalizacao() + "]");
		return sb.toString();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
