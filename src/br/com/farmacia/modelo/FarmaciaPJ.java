package br.com.farmacia.modelo;

import java.nio.file.Path;

public class FarmaciaPJ extends Pessoa{
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Path logoPath;

	public Path getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(Path logoPath) {
		this.logoPath = logoPath;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}