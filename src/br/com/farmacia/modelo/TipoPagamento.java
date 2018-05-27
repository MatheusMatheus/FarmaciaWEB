package br.com.farmacia.modelo;

import java.math.BigDecimal;

import br.com.farmacia.modelo.pagamento.PagamentoEstrategia;

public enum TipoPagamento  implements PagamentoEstrategia{
	CREDITO {
		@Override
		public void pagar(BigDecimal valor) {
			
		}
	}, DEBITO {
		@Override
		public void pagar(BigDecimal valor) {
			
		}
	}, BOLETO {
		@Override
		public void pagar(BigDecimal valor) {
			
		}
	}, PARCELADO {
		@Override
		public void pagar(BigDecimal valor) {
			
		}
	};


}
