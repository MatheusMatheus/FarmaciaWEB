package br.com.farmacia.teste;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;

import br.com.farmacia.modelo.Categoria;
import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.Perfil;
import br.com.farmacia.modelo.TipoMedicamento;
import br.com.farmacia.modelo.TipoPagamento;
import br.com.farmacia.modelo.Venda;

public class TesteVenda {
	public static void main(String[] args) {
		/*Medicamento medicamento = new Medicamento();
		medicamento.setCategoria(Categoria.GripeResfriado.ANTIGRIPAL);
		medicamento.setDescricao("Remédio para gripe");
		medicamento.setFabricante("Gigafarma");
		medicamento.setFotoPath(Paths.get("/remedios/farmacia"));
		medicamento.setNome("Aceclofenaco");
		medicamento.setPreco(new BigDecimal(50.25));
		medicamento.setQuantidade(100);
		medicamento.setTipo(TipoMedicamento.GENERICO);
		medicamento.setValidade(LocalDate.of(2020, Month.FEBRUARY, 10));
		medicamento.setId(15318);*/
		
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
		
		Localizacao localizacao = new Localizacao();
		localizacao.setCep("72302108");
		localizacao.setCidade("Sao Luis");
		localizacao.setEndereco("QR 106 CJ 08 CS 05");
		localizacao.setEstado("Maranhao");
		localizacao.setId(5465466);
		
		Login login = new Login();
		login.setId(513513);
		login.setUsuario("matheus.rodrigues");
		login.setSenha("798794");
		
		ClientePF cliente = new ClientePF();
		cliente.setCpf("04408803197");
		cliente.setDataNascimento(LocalDate.of(1995, 2, 10));
		cliente.setNome("Matheus Lindo");
		cliente.setPerfil(Perfil.CLIENTE.name());
		cliente.setLocalizacao(localizacao);
		cliente.setLogin(login);
		cliente.setSexo("M");
		cliente.setTelefone("12345678");
		
		Venda venda = new Venda();
		venda.setMedicamento(medicamento);
		venda.setCliente(cliente);
		venda.setData(LocalDate.now());
		venda.setTipoPagamento(TipoPagamento.BOLETO);
		venda.setQuantidade(3);
		
	}
}
