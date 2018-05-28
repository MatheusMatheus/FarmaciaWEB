package br.com.farmacia.teste;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;

import br.com.farmacia.modelo.Categoria;
import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.InsereMedicamento;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.TipoMedicamento;
import br.com.farmacia.modelo.dao.GenericDAO;
import br.com.farmacia.modelo.dao.InsereMedicamentoDAO;

public class TesteInsercaoMedicamento {
	public static void main(String[] args) {
		Localizacao localizacao = new Localizacao();
		localizacao.setCep("72302108");
		localizacao.setCidade("Sao Luis");
		localizacao.setEndereco("QR 106 CJ 08 CS 05");
		localizacao.setEstado("Maranhão");
		localizacao.setId(5465466);
		
		Login login = new Login();
		login.setId(513513);
		login.setUsuario("matheus.rodrigues");
		login.setSenha("798794");
		
		FarmaciaPJ farmacia = new FarmaciaPJ();
		farmacia.setCnpj("88380900000152");
		farmacia.setEmail("fjçalskjfçlsakjflçksjfça@gmail.com");
		farmacia.setLocalizacao(localizacao);
		farmacia.setLogin(login);
		farmacia.setLogoPath(Paths.get("/asdfaf/asdsf"));
		farmacia.setNomeFantasia("Farmacia do bagulho louco");
		farmacia.setPerfil(Perfil.FARMACIA);
		farmacia.setRazaoSocial("lkasjdçflksjaçflkjasdçlfj");
		farmacia.setTelefone("31589544");
		
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
		
		InsereMedicamento insere = new InsereMedicamento();
		insere.setData(LocalDate.now());
		insere.setFarmacia(farmacia);
		insere.setId(35135131);
		insere.setMedicamento(medicamento);
		insere.setQuantidade(90);
		
		GenericDAO<InsereMedicamento> dao = new InsereMedicamentoDAO();
		//dao.inserir(insere);
		//dao.listar().forEach(System.out::println);
	}
}
