package br.com.farmacia.modelo;

public interface Categoria {
	interface SaudeMulher {
		String ANTICONCEPCIONAL = "Anticoncepcional"; 
		String GINECOLOGICO = "Ginecol�gico";
		String MENOPAUSA = "Menopausa"; 
		String PILULA_DIA_SEGUINTE = "P�lula do Dia Seguinte";
	}
	interface DorFebre {
		String ANALGESICO = "Analg�sico"; 
		String ANTI_INFLAMATORIO = "Anti-inflamat�rio";
		String CONTUSAO = "Contus�o";
		String COLICA = "C�lica";
		String ENXAQUECA = "Enxaqueca"; 
		String DOR_CABECA = "Dor de cabe�a"; 
		String RELAXANTE_MUSCULAR = "Relaxante muscular"; 
		String ANTI_TERMICO = "Antit�rmico";
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
		String CREME_ASSADURA = "Creme Assadura"; 
		String FRALDA = "Fralda";
		String HIGIENTE_BUCAL = "Higiene bucal";
		String ACESSORIOS = "Acess�rios";
	}
	interface SistemaNervoso  {
		String ALCOOLISMO = "Alcoolismo";
		String ANTIDEPRESSIVO = "Antidepressivo";
		String DISTURBIOS_MENTAIS = "Dist�rbios Mentais";
		String ALZHEIMER = "Alzheimer";
		String ANTIPISCICOTICO = "Antipisicotico";
		String ESCLEROSE_MULTIPLA = "Esclerose M�ltipla";
		String ANESTESICO = "Anest�sico";
		String CALMANTE = "Calmante";
		String PARKINSON = "Parkinson";
		String ANSIEDADE = "Ansiedade";
		String CONVULSAO = "Convuls�o";
		String TRANSTORNO_BIPOLAR = "Transtorno Bipolar";
	}


}
