package br.com.farmacia.modelo;

public interface Categoria {
	interface SaudeMulher {
		String ANTICONCEPCIONAL = "Anticoncepcional"; 
		String GINECOLOGICO = "Ginecológico";
		String MENOPAUSA = "Menopausa"; 
		String PILULA_DIA_SEGUINTE = "Pílula do dia seguinte";
	}
	interface DorFebre {
		String ANALGESICO = "Analgésico"; 
		String ANTI_INFLAMATORIO = "Anti-inflamatório";
		String CONTUSAO = "Contusão";
		String COLICA = "Cólica";
		String ENXAQUECA = "Enxaqueca"; 
		String DOR_CABECA = "Dor de cabeça"; 
		String RELAXANTE_MUSCULAR = "Relaxante muscular"; 
		String ANTI_TERMICO = "Antitérmico";
	}
	interface GripeResfriado{
		String TOSSE = "Tosse";
		String ANTIGRIPAL = "Antigripal";
	}
	interface HigientePessoal   {
		String ABSORVENTE = "Absorvente";
		String PRESERVATIVO = "Preservativo";
		String DESODORANTE = "Desodorante";
		String SHAMPOO = "Shampoo";
	}
	interface Infantil {
		String ALIMENTOS = "Alimentos"; 
		String BANHO = "Banho";
		String CREME_ASSADURA = "Creme assadura"; 
		String FRALDA = "Fralda";
		String HIGIENTE_BUCAL = "Higiene bucal";
		String ACESSORIOS = "Acessórios";
	}
	interface SistemaNervoso  {
		String ALCOOLISMO = "Alcoolismo";
		String ANTIDEPRESSIVO = "Antidepressivo";
		String DISTURBIOS_MENTAIS = "Disturbios mentais";
		String ALZHEIMER = "Alzheimer";
		String ANTIPISCICOTICO = "Antipisicotico";
		String ESCLEROSE_MULTIPLA = "Esclerose múltipla";
		String ANESTESICO = "Anestésico";
		String CALMANTE = "Calmante";
		String PARKINSON = "Parkinson";
		String ANSIEDADE = "Ansiedade";
		String CONVULSAO = "Convulsão";
		String TRANSTORNO_BIPOLAR = "Transtorno bipolar";
	}


}
