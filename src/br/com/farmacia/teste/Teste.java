package br.com.farmacia.teste;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.TipoMedicamento;

public class Teste  {
	public static void main(String[] args)  {
		Medicamento medicamento = new Medicamento();
		medicamento.setTipo(TipoMedicamento.fromString("Genérico"));
		System.out.println(medicamento.getTipo());

	}
	

}
