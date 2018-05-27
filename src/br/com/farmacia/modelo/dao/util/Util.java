package br.com.farmacia.modelo.dao.util;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.Medicamento;

public class Util {
	public static Localizacao getLocalizacao(ResultSet rs) {
		try {
			Localizacao localizacao = new Localizacao();
			localizacao.setCep(rs.getString("LOCALIZACAO.cep"));
			localizacao.setCidade(rs.getString("LOCALIZACAO.cidade"));
			localizacao.setEndereco(rs.getString("LOCALIZACAO.endereco"));
			localizacao.setEstado(rs.getString("LOCALIZACAO.estado"));
			localizacao.setId(rs.getInt("LOCALIZACAO.id"));
			return localizacao;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public static Medicamento getMedicamento(ResultSet rs) {
		try {
			Medicamento medicamento = new Medicamento();
			medicamento.setId(rs.getInt("id"));
			medicamento.setPreco(new BigDecimal(rs.getDouble("preco")));
			medicamento.setNome(rs.getString("nome"));
			medicamento.setValidade(rs.getDate("validade").toLocalDate());
			medicamento.setDescricao(rs.getString("descricao"));
			medicamento.setFotoPath(Paths.get(rs.getString("foto_path")));
			medicamento.setFabricante(rs.getString("fabricante"));
			medicamento.setQuantidade(rs.getInt("quantidade"));
			medicamento.setCategoria(rs.getString("categoria"));
			medicamento.setTipo(rs.getString("tipo"));
			return medicamento;
		} catch (SQLException e) {
			return null;
		}
	}
}
