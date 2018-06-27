package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.dao.util.Util;

public class MedicamentoDAO extends GenericDAO<Medicamento> {
	
	public MedicamentoDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void inserir(Medicamento medicamento) {
		String sql = "insert into MEDICAMENTO values(?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, medicamento.getId());;
			stmt.setDouble(2, medicamento.getPreco().doubleValue());
			stmt.setString(3, medicamento.getNome());
			stmt.setDate(4, java.sql.Date.valueOf(medicamento.getValidade()));
			stmt.setString(5, medicamento.getDescricao());
			stmt.setString(6, medicamento.getFotoPath().toString());
			stmt.setString(7, medicamento.getFabricante());
			stmt.setLong(8, medicamento.getQuantidade());
			stmt.setString(9, medicamento.getTipo().name());
			stmt.setString(10, medicamento.getCategoria());
			stmt.setString(11, medicamento.getIdentificador());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 	
	}

	@Override
	public void alterar(Medicamento medicamento) {
		String sql = "update MEDICAMENTO set preco = ?, nome = ?, validade = ?, descricao = ?, foto_path = ?, ";
		sql += "fabricante = ?, quantidade = ?, categoria = ?, tipo = ?, identificador = ? where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setDouble(1, medicamento.getPreco().doubleValue());
			stmt.setString(2, medicamento.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(medicamento.getValidade()));
			stmt.setString(4, medicamento.getDescricao());
			stmt.setString(5, medicamento.getFotoPath().toString());
			stmt.setString(6, medicamento.getFabricante());
			stmt.setLong(7, medicamento.getQuantidade());
			stmt.setString(8, medicamento.getCategoria());
			stmt.setString(9, medicamento.getTipo().toString());
			stmt.setString(10, medicamento.getIdentificador());
			stmt.setLong(11, medicamento.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 	
	}

	@Override
	public void excluir(Medicamento medicamento) {
		String sql = "delete from MEDICAMENTO where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, medicamento.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 			
	}

	@Override
	public Optional<Collection<Medicamento>> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select m.id, m.preco, m.nome, ");
		sql.append("m.validade, m.descricao, m.foto_path, ");
		sql.append("m.fabricante, m.quantidade, m.tipo, m.categoria, m.identificador from MEDICAMENTO as m");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery()) {
			Collection<Medicamento> medicamentos = new ArrayList<>();
			while (rs.next()) 
				medicamentos.add(Util.getMedicamento(rs));
			
			return Optional.of(medicamentos);
		} catch (SQLException e) {
			rollback(connection);
			return Optional.empty();
		}
	}
}
