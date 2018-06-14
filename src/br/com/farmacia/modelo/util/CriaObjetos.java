package br.com.farmacia.modelo.util;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.TipoMedicamento;

public class CriaObjetos {
	public static Login newLogin(long id, String usuario, String senha) {
		Login login = new Login();
		login.setId(id);
		login.setUsuario(usuario);
		login.setSenha(senha);
		return login;
	}

	public static Localizacao newLocalizacao(long id, String cep, String endereco, String cidade, String estado) {
		Localizacao localizacao = new Localizacao();
		localizacao.setId(id);
		localizacao.setCep(cep);
		localizacao.setEndereco(endereco);
		localizacao.setCidade(cidade);
		localizacao.setEstado(estado);
		return localizacao;
	}

	public static ClientePF newCliente(String cpf, LocalDate dtnsc, String sexo, String nome, String email,
			String telefone, Localizacao localizacao, Login login, String perfil) {
		ClientePF cliente = new ClientePF();
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dtnsc);
		cliente.setSexo(sexo);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setLocalizacao(localizacao);
		cliente.setLogin(login);
		cliente.setPerfil(perfil);
		return cliente;
	}

	public static Medicamento newMedicamento(long id, BigDecimal preco, String nome, LocalDate validade,
			String descricao, Path fotoPath, String fabricante, int quantidade, String categoria,
			TipoMedicamento tipo) {

		Medicamento medicamento = new Medicamento();
		medicamento.setId(id);
		medicamento.setPreco(preco);
		medicamento.setNome(nome);
		medicamento.setValidade(validade);
		medicamento.setDescricao(descricao);
		medicamento.setFotoPath(fotoPath);
		medicamento.setFabricante(fabricante);
		medicamento.setQuantidade(quantidade);
		medicamento.setCategoria(categoria);
		medicamento.setTipo(tipo);
		return medicamento;
	}
	
	

}
