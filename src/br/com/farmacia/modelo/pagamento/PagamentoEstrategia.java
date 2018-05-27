package br.com.farmacia.modelo.pagamento;

import java.math.BigDecimal;

public interface PagamentoEstrategia {
	void pagar(BigDecimal valor);
}
