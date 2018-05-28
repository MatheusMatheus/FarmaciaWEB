package br.com.farmacia.teste;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;

import br.com.farmacia.modelo.Categoria;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.TipoMedicamento;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.MedicamentoDAO;

public class TesteMedicamento {
	public static void main(String[] args) {
		Medicamento medicamento = new Medicamento();
		medicamento.setCategoria(Categoria.SistemaNervoso.ALZHEIMER);
		medicamento.setDescricao("Remédio para Alzheimer");
		medicamento.setFabricante("Farmacia da esquina");
		medicamento.setFotoPath(Paths.get("/remedios/farmacia"));
		medicamento.setNome("Galantamina");
		medicamento.setPreco(new BigDecimal(150.25));
		medicamento.setQuantidade(100);
		medicamento.setTipo(TipoMedicamento.ESPECIFICO);
		medicamento.setValidade(LocalDate.of(2020, Month.APRIL, 10));
		medicamento.setId(513513);
		
		
		GenericDAO<Medicamento> dao = new MedicamentoDAO();
		dao.inserir(medicamento);
		//dao.alterar(medicamento);
		//dao.excluir(medicamento);
		//dao.listar().forEach(System.out::println);
	}
}
