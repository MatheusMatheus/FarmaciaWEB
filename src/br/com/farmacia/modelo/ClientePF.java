package br.com.farmacia.modelo;

import java.time.LocalDate;

public class ClientePF extends Pessoa<ClientePF> {
	private String cpf;
	private LocalDate dataNascimento;
	private String sexo;
	private String nome;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n[CPF: " + getCpf() + ", ");
		sb.append("data de nascimento: " + getDataNascimento() + ", ");
		sb.append("sexo:" + getSexo() + ", ");
		sb.append("nome: " + getNome() + ", ");
		sb.append(super.toString());
		return sb.toString();
	}

	public String getCpf() {
		return cpf;
	}

	public ClientePF setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public ClientePF setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public String getSexo() {
		return sexo;
	}

	public ClientePF setSexo(String sexo) {
		this.sexo = sexo;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public ClientePF setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	protected ClientePF getThis() {
		return this;
	}


}
