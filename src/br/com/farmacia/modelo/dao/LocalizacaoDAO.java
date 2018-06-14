package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.dao.util.Util;

public class LocalizacaoDAO extends GenericDAO<Localizacao> {
	
	public LocalizacaoDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void inserir(Localizacao localizacao) {
		String sql = "insert into LOCALIZACAO values(?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, localizacao.getId());
			stmt.setString(2, localizacao.getCep());
			stmt.setString(3, localizacao.getEndereco());
			stmt.setString(4, localizacao.getCidade());
			stmt.setString(5, localizacao.getEstado());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(connection);
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
			stmt.setLong(5, localizacao.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 
	}

	@Override
	public void excluir(Localizacao localizacao) {
		String sql = "delete from LOCALIZACAO where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, localizacao.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 
	}

	@Override
	public Optional<Collection<Localizacao>> listar() {
		String sql = "select l.id, l.cep, l.endereco,"
				+ " l.cidade, l.estado from LOCALIZACAO l";
		try (PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			Collection<Localizacao> localizacoes = new ArrayList<>();
			while (rs.next())
				localizacoes.add(Util.getLocalizacao(rs));

			return Optional.of(localizacoes);
		} catch (SQLException e) {
			rollback(connection);
			return Optional.empty();
		} 
	}
}
