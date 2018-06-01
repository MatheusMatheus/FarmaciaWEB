package br.com.farmacia.modelo;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;

public class Medicamento {
	private long id;
	private BigDecimal preco;
	private String nome;
	private LocalDate validade;
	private String descricao;
	private Path fotoPath;
	private String fabricante;
	private int quantidade;
	private String categoria;
	private TipoMedicamento tipo;

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("\n[id: " + getId() + "],");
		sBuilder.append("[preco: " + getPreco() + "],");
		sBuilder.append("[nome: " + getNome() + "],");
		sBuilder.append("[validade: " + getValidade() + "],");
		sBuilder.append("[descricao: " + getDescricao() + "],");
		sBuilder.append("[foto_path: " + getFotoPath() + "],");
		sBuilder.append("[fabricante: " + getFabricante() + "],");
		sBuilder.append("[quantidade: " + getQuantidade() + "],");
		sBuilder.append("[categoria: " + getCategoria() + "],");
		sBuilder.append("[tipo: " + getTipo() + "]");
		return sBuilder.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Path getFotoPath() {
		return fotoPath;
	}

	public void setFotoPath(Path fotoPath) {
		this.fotoPath = fotoPath;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

}
