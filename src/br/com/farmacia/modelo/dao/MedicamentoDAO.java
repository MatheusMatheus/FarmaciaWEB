package br.com.farmacia.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.farmacia.modelo.Medicamento;
import br.com.farmacia.modelo.dao.util.Util;

public class MedicamentoDAO extends GenericDAO<Medicamento> {

	@Override
	public void inserir(Medicamento medicamento) {
		String sql = "insert into MEDICAMENTO values(?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, medicamento.getId());;
			stmt.setDouble(2, medicamento.getPreco().doubleValue());
			stmt.setString(3, medicamento.getNome());
			stmt.setDate(4, java.sql.Date.valueOf(medicamento.getValidade()));
			stmt.setString(5, medicamento.getDescricao());
			stmt.setString(6, medicamento.getFotoPath().toString());
			stmt.setString(7, medicamento.getFabricante());
			stmt.setInt(8, medicamento.getQuantidade());
			stmt.setString(9, medicamento.getCategoria());
			stmt.setString(10, medicamento.getTipo());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}	
	}

	@Override
	public void alterar(Medicamento medicamento) {
		String sql = "update MEDICAMENTO set preco = ?, nome = ?, validade = ?, descricao = ?, foto_path = ?";
		sql += "fabricante = ?, quantidade = ?, categoria = ? tipo = ? where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setDouble(1, medicamento.getPreco().doubleValue());
			stmt.setString(2, medicamento.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(medicamento.getValidade()));
			stmt.setString(4, medicamento.getDescricao());
			stmt.setString(5, medicamento.getFotoPath().toString());
			stmt.setString(6, medicamento.getFabricante());
			stmt.setInt(7, medicamento.getQuantidade());
			stmt.setString(8, medicamento.getCategoria());
			stmt.setString(9, medicamento.getTipo());
			stmt.setInt(10, medicamento.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}	
		
	}

	@Override
	public void excluir(Medicamento medicamento) {
		String sql = "delete from MEDICAMENTO where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, medicamento.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}			
	}

	@Override
	public Collection<Medicamento> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, preco, nome, ");
		sql.append("validade, descricao, foto_path ");
		sql.append("fabricante, quantidade, tipo, categoria from MEDICAMENTO");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			Collection<Medicamento> medicamentos = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) 
				medicamentos.add(Util.getMedicamento(rs));
			
			return medicamentos;
		} catch (SQLException e) {
			rollback(connection);
			return null;
		} finally {
			closeConn(connection);
		}
	}
}
