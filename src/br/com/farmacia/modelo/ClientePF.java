package br.com.farmacia.modelo;

import java.time.LocalDate;

public class ClientePF extends Pessoa {
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
