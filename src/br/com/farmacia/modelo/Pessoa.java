package br.com.farmacia.modelo;

public abstract class Pessoa<T> {
	private String email;
	private String telefone;
	private Localizacao localizacao;
	private Login login;
	private Perfil perfil;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("email: " + getEmail() + ",");
		sb.append("telefone: " + getTelefone() + ",");
		sb.append("perfil: " + getPerfil() + ",");
		sb.append("login: " + getLogin() + ",");
		sb.append("localizacao: " + getLocalizacao() + "]");
		return sb.toString();
	}
	
	protected abstract T getThis();

	public String getEmail() {
		return email;
	}

	public T setEmail(String email) {
		this.email = email;
		return getThis();
	}

	public String getTelefone() {
		return telefone;
	}

	public T setTelefone(String telefone) {
		this.telefone = telefone;
		return getThis();
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public T setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
		return getThis();
	}

	public Login getLogin() {
		return login;
	}

	public T setLogin(Login login) {
		this.login = login;
		return getThis();
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public T setPerfil(Perfil perfil) {
		this.perfil = perfil;
		return getThis();
	}

}
