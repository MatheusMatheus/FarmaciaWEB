package br.com.farmacia.modelo;

import java.text.NumberFormat;

import br.com.farmacia.modelo.pagamento.PagamentoEstrategia;

public enum TipoPagamento{

	CREDITO {
		@Override
		public PagamentoEstrategia realizarPagamento() {
			return va -> "Valor pago com crédito: " + formatador.format(va.doubleValue());			
		}
	},
	DEBITO {
		@Override
		public PagamentoEstrategia realizarPagamento() {
			return va -> "Valor pago com débito: " + formatador.format(va.doubleValue());
		}
	},
	BOLETO {
		@Override
		public PagamentoEstrategia realizarPagamento() {
			return va -> "Valor pago com boleto: " + formatador.format(va.doubleValue());
		}
	};
	
	private static NumberFormat formatador = NumberFormat.getCurrencyInstance();

	public abstract PagamentoEstrategia realizarPagamento();
}
