package br.com.farmacia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsereMedicamento {
	private FarmaciaPJ farmacia;
	private List<Medicamento> medicamentos;
	private LocalDate data;

	public InsereMedicamento() {
		this.medicamentos = new ArrayList<>();
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
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

}
