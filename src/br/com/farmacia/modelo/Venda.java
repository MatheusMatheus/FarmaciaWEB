package br.com.farmacia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.farmacia.modelo.pagamento.PagamentoEstrategia;

public class Venda {
	private LocalDate data;
	private ClientePF cliente;
	private List<Medicamento> medicamentos;
	private PagamentoEstrategia pagamentoEstrategia;

	public Venda(PagamentoEstrategia pagamentoEstrategia) {
		this.pagamentoEstrategia = pagamentoEstrategia;
		this.medicamentos = new ArrayList<>();
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

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public PagamentoEstrategia getPagamentoEstrategia() {
		return pagamentoEstrategia;
	}

}
