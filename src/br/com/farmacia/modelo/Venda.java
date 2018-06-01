package br.com.farmacia.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {
	private long id;
	private LocalDate data;
	private ClientePF cliente;
	private Medicamento medicamento;
	private TipoPagamento tipoPagamento;
	private int quantidade;

	public BigDecimal total() {
		return medicamento.getPreco().multiply(new BigDecimal(quantidade));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[data venda: " + getData() + ",");
		sb.append("quantidade: " + getQuantidade() + ",");
		sb.append("tipo de pagamento: " + getTipoPagamento() + ",");
		sb.append("total: " + total() + ",");
		sb.append("medicamento: " + getMedicamento() + "]");
		sb.append("cliente: " + getCliente());
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ClientePF getCliente() {
		return cliente;
	}

	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
