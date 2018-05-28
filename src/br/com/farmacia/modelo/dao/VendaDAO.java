package br.com.farmacia.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.farmacia.modelo.Venda;
import br.com.farmacia.modelo.dao.util.Util;

public class VendaDAO extends GenericDAO<Venda> {

	@Override
	public void inserir(Venda venda) {
		String sql = "insert into VENDA values(?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			stmt.setString(1, venda.getCliente().getCpf());
			stmt.setInt(2, venda.getMedicamento().getId());
			stmt.setDate(3, java.sql.Date.valueOf(venda.getData()));
			stmt.setString(4, venda.getTipoPagamento().toString());
			stmt.setInt(5, venda.getQuantidade());
			stmt.setInt(6, venda.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}	
	}

	@Override
	public void alterar(Venda venda) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void excluir(Venda venda) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Venda> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select c.cpf, c.nome, c.telefone, c.email, c.dataNascimento, ");
		sql.append("c.sexo, c.perfil, c.LOCALIZACAO_id, c.LOGIN_id, ");
		sql.append("m.id, m.categoria, m.descricao, m.fabricante, m.foto_path, m.nome, ");
		sql.append("m.preco, m.quantidade, m.tipo, m.validade, ");
		sql.append("v.CLIENTE_cpf, v.MEDICAMENTO_id, v.dataVenda, v.tipo_pagamento, v.quantidade, v.id, ");
		sql.append("l.id, l.cep, l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from VENDA as v ");
		sql.append("inner join MEDICAMENTO as m on m.id = v.MEDICAMENTO_id ");
		sql.append("inner join CLIENTE c on c.cpf = v.CLIENTE_cpf ");
		sql.append("inner join LOCALIZACAO as l on l.id = c.LOCALIZACAO_id ");
		sql.append("inner join LOGIN as lo on lo.id = c.LOGIN_id");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery()) {
			Collection<Venda> vendas = new ArrayList<>();
			while (rs.next()) 
				vendas.add(Util.getVenda(rs));
			return vendas;
		} catch (SQLException e) {
			System.out.println("Erro ao executar Query " + e);
			rollback(connection);
			return null;
		} finally {
			closeConn(connection);
		}
	}
	
}
