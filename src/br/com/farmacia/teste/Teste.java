package br.com.farmacia.teste;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import br.com.farmacia.modelo.Categoria;
import br.com.farmacia.modelo.TipoPagamento;
import br.com.farmacia.modelo.pagamento.PagamentoEstrategia;

public class Teste {
	public static void main(String[] args) {
		PagamentoEstrategia pagamentoEstrategia = TipoPagamento.BOLETO.realizarPagamento();
		String pagamento = pagamentoEstrategia.pagar(new BigDecimal(50));
		System.out.println(pagamento);
		
		Field[] campos = Categoria.GripeResfriado.class.getDeclaredFields();
		for(Field field : campos)
			System.out.println(field.getName());
		
		System.out.println(System.currentTimeMillis());

	}
}
