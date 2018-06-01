package br.com.farmacia.modelo;

import java.time.LocalDate;

public class InsereMedicamento {
	private long id;
	private FarmaciaPJ farmacia;
	private Medicamento medicamento;
	private LocalDate data;
	private int quantidade;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[id: " + getId() + ",");
		sb.append("data: " + getData() + ",");
		sb.append("quantidade: " + getQuantidade() + ",");
		sb.append("farmacia: " + getFarmacia() + ",");
		sb.append("medicamento: " + getMedicamento() + "]");
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public FarmaciaPJ getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(FarmaciaPJ farmacia) {
		this.farmacia = farmacia;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
