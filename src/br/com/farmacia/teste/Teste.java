package br.com.farmacia.teste;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.farmacia.modelo.TipoMedicamento;

public class Teste  {
	public static void main(String[] args)  {
		System.out.println(getTipoMedicamentos());
	}
	
	public static List<String> getTipoMedicamentos() {
		Stream<TipoMedicamento> stream = Stream.of(TipoMedicamento.values());
		return stream.map(TipoMedicamento::asText).collect(Collectors.toList());
	}

}
