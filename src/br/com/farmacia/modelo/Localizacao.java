package br.com.farmacia.modelo;

public class Localizacao {
	private int id;
	private String cep;
	private String endereco;
	private String cidade;
	private String estado;
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("\n[id: " + getId() + ",");
		sBuilder.append("[cep: " + getCep() + ",");
		sBuilder.append("[endereco: " + getEndereco() + ",");
		sBuilder.append("[cidade: " + getCidade() + ",");
		sBuilder.append("[estado: " + getEstado() + "]");
		return sBuilder.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
