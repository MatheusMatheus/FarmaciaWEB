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

public class MedicamentoDAO extends GenericDAO<Medicamento> implements FiltroID<Medicamento, Medicamento>{
	
	public MedicamentoDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void inserir(Medicamento medicamento) {
		String sql = "insert into MEDICAMENTO values(?,?,?,?,?,?,?,?,?,?)";
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
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(connection);
		} 	
	}

	@Override
	public void alterar(Medicamento medicamento) {
		String sql = "update MEDICAMENTO set preco = ?, nome = ?, validade = ?, descricao = ?, foto_path = ?, ";
		sql += "fabricante = ?, quantidade = ?, categoria = ?, tipo = ? where id = ?";
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
			stmt.setLong(10, medicamento.getId());
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
		sql.append("m.fabricante, m.quantidade, m.tipo, m.categoria from MEDICAMENTO as m");
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

	@Override
	public Optional<Medicamento> getBy(Medicamento medicamento){
		StringBuilder sql = new StringBuilder();
		sql.append("select m.id, m.preco, m.nome, ");
		sql.append("m.validade, m.descricao, m.foto_path, ");
		sql.append("m.fabricante, m.quantidade, m.tipo, m.categoria from MEDICAMENTO as m ");
		sql.append("where m.nome = ? and m.categoria = ? and m.tipo = ?");
		
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())){
			stmt.setString(1, medicamento.getNome());
			stmt.setString(2, medicamento.getCategoria());
			stmt.setString(3, medicamento.getTipo().name());
			
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next())
				return Optional.of(Util.getMedicamento(resultSet));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
