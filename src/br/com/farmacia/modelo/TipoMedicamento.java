package br.com.farmacia.modelo;

public enum TipoMedicamento {
	PERFUMARIA("Perfumaria"), 
	BIOLOGICO("Biológico"), 
	ESPECIFICO("Específico"), 
	GENERICO("Genérico"), 
	REFERENCIA("Referência"), 
	SIMILAR("Similar");
	
	private String tipo;
	private TipoMedicamento(String tipo) {
		this.tipo = tipo;
	}
	public String asText() {
		return tipo;
	}
	
	public static TipoMedicamento fromString(String string) {
		for(TipoMedicamento tipoMedicamento : TipoMedicamento.values())
			if (tipoMedicamento.tipo.equalsIgnoreCase(string))
				return tipoMedicamento;
		return null;
	}

}
