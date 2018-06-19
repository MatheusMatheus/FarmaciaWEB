package br.com.farmacia.modelo.dao.util;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.TipoMedicamento;
import br.com.farmacia.modelo.TipoPagamento;
import br.com.farmacia.modelo.Venda;

public class Util {
	public static Localizacao getLocalizacao(ResultSet rs) {
		try {
			Localizacao localizacao = new Localizacao();
			localizacao.setCep(rs.getString("l.cep"));
			localizacao.setCidade(rs.getString("l.cidade"));
			localizacao.setEndereco(rs.getString("l.endereco"));
			localizacao.setEstado(rs.getString("l.estado"));
			localizacao.setId(rs.getLong("l.id"));
			return localizacao;
		} catch (SQLException e) {
			System.out.println("Erro ao extrair localizacao do ResultSet " + e);
			return null;
		}

	}

	public static Medicamento getMedicamento(ResultSet rs) {
		try {
			Medicamento medicamento = new Medicamento();
			medicamento.setId(rs.getLong("m.id"));
			medicamento.setPreco(new BigDecimal(rs.getDouble("m.preco")));
			medicamento.setNome(rs.getString("m.nome"));
			medicamento.setValidade(rs.getDate("m.validade").toLocalDate());
			medicamento.setDescricao(rs.getString("m.descricao"));
			medicamento.setFotoPath(Paths.get(rs.getString("m.foto_path")));
			medicamento.setFabricante(rs.getString("m.fabricante"));
			medicamento.setQuantidade(rs.getInt("m.quantidade"));
			medicamento.setCategoria(rs.getString("m.categoria"));
			medicamento.setTipo(TipoMedicamento.valueOf(rs.getString("m.tipo")));
			return medicamento;
		} catch (SQLException e) {
			System.out.println("Erro ao extrair medicamento do ResultSet " + e);
			return null;
		}
	}

	public static Login getLogin(ResultSet rs) {
		try {
			Login login = new Login();
			login.setId(rs.getLong("lo.id"));
			login.setSenha(rs.getString("lo.senha"));
			login.setUsuario(rs.getString("lo.usuario"));
			return login;
		} catch (SQLException e) {
			System.out.println("Erro ao extrair login do ResultSet " + e);
			return null;
		}

	}
	
	public static FarmaciaPJ getFarmacia(ResultSet rs) {
		try {
			FarmaciaPJ farmacia = new FarmaciaPJ();
			farmacia = new FarmaciaPJ();
			farmacia.setLocalizacao(getLocalizacao(rs));
			farmacia.setLogin(getLogin(rs));
			farmacia.setCnpj(rs.getString("f.cnpj"));
			farmacia.setEmail(rs.getString("f.email"));
			farmacia.setLogoPath(Paths.get(rs.getString("logo_path")));
			farmacia.setNomeFantasia(rs.getString("f.nome_fantasia"));
			farmacia.setPerfil(rs.getString("f.perfil"));
			farmacia.setRazaoSocial(rs.getString("f.razao_social"));
			farmacia.setTelefone(rs.getString("f.telefone"));
			return farmacia;
		} catch (SQLException e) {
			System.out.println("Erro ao extrair farmácia do result set" + e);
			return null;
		}

	}

	public static ClientePF getCliente(ResultSet rs) {
		try {
			ClientePF cliente = new ClientePF();
			cliente.setCpf(rs.getString("c.cpf"));
			cliente.setNome(rs.getString("c.nome"));
			cliente.setEmail(rs.getString("c.email"));
			cliente.setDataNascimento(rs.getDate("c.dataNascimento").toLocalDate());
			cliente.setSexo(rs.getString("c.sexo"));
			cliente.setPerfil(rs.getString("c.perfil"));
			cliente.setLocalizacao(getLocalizacao(rs));
			cliente.setLogin(getLogin(rs));
			cliente.setTelefone(rs.getString("c.telefone"));
			return cliente;
		} catch (SQLException e) {
			System.out.println("Erro ao extrair cliente result set" + e);
			return null;
		}
	}

	public static Venda getVenda(ResultSet rs) {
		try {
			Venda venda = new Venda();
			venda.setId(rs.getLong("v.id"));
			venda.setQuantidade(rs.getInt("v.quantidade"));
			venda.setData(rs.getDate("v.dataVenda").toLocalDate());
			venda.setCliente(Util.getCliente(rs));
			venda.setMedicamento(Util.getMedicamento(rs));
			venda.setTipoPagamento(TipoPagamento.valueOf(rs.getString("v.tipo_pagamento")));
			return venda;
		} catch (SQLException e) {
			System.out.println("Erro ao extrair venda result set" + e);
			return null;
		}
	}
}
