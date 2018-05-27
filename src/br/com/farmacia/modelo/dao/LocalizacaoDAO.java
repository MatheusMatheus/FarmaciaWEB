package br.com.farmacia.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.dao.util.Util;

public class LocalizacaoDAO extends GenericDAO<Localizacao> {

	@Override
	public void inserir(Localizacao localizacao) {
		String sql = "insert into LOCALIZACAO values(?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, localizacao.getId());
			stmt.setString(2, localizacao.getCep());
			stmt.setString(3, localizacao.getEndereco());
			stmt.setString(4, localizacao.getCidade());
			stmt.setString(5, localizacao.getEstado());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}

	}

	@Override
	public void alterar(Localizacao localizacao) {
		String sql = "update LOCALIZACAO set cep = ?, endereco = ?, cidade = ?, estado = ? where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, localizacao.getCep());
			stmt.setString(2, localizacao.getEndereco());
			stmt.setString(3, localizacao.getCidade());
			stmt.setString(4, localizacao.getEstado());
			stmt.setInt(5, localizacao.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}
	}

	@Override
	public void excluir(Localizacao localizacao) {
		String sql = "delete from LOCALIZACAO where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, localizacao.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}
	}

	@Override
	public Collection<Localizacao> listar() {
		String sql = "select LOCALIZACAO.id, LOCALIZACAO.cep, LOCALIZACAO.endereco,"
				+ " LOCALIZACAO.cidade, LOCALIZACAO.estado from LOCALIZACAO";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Collection<Localizacao> localizacoes = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				localizacoes.add(Util.getLocalizacao(rs));

			return localizacoes;
		} catch (SQLException e) {
			rollback(connection);
			return null;
		} finally {
			closeConn(connection);
		}
	}
}
