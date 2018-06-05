package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.util.Util;

public class LoginDAO extends GenericDAO<Login> implements FiltroID<Login> {

	FiltroID<Login> filtro;

	public LoginDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void inserir(Login login) {
		String sql = "insert into LOGIN values(?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, login.getId());
			stmt.setString(2, login.getUsuario());
			stmt.setString(3, login.getSenha());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			
			rollback(connection);
		}
	}

	@Override
	public void alterar(Login login) {
		String sql = "update LOGIN set usuario = ?, senha = ? where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			stmt.setLong(3, login.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}
	}

	@Override
	public void excluir(Login login) {
		String sql = "delete from LOGIN where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, login.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}
	}

	@Override
	public Optional<Collection<Login>> listar() {
		String sql = "select lo.id, lo.usuario, lo.senha from LOGIN as lo";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			Collection<Login> logins = new ArrayList<>();
			while (rs.next())
				logins.add(Util.getLogin(rs));

			return Optional.of(logins);
		} catch (SQLException e) {
			rollback(connection);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Login> getBy(long id) {
		String sql = "select lo.id, lo.usuario, lo.senha from LOGIN as lo where lo.id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				return Optional.of(Util.getLogin(rs));
			}
		} catch (SQLException e) {
			return Optional.empty();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Login> getBy(String... itens) {
		if (itens.length != 2)
			return Optional.empty();;
		StringBuilder sql = new StringBuilder();
		sql.append("select lo.id, lo.usuario, lo.senha from LOGIN as lo where lo.usuario = ? and lo.senha = ? ");
		sql.append("or lo.usuario = ? and lo.senha = ?");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			stmt.setString(1, itens[0]);
			stmt.setString(2, itens[1]);
			stmt.setString(3, itens[1]);
			stmt.setString(4, itens[0]);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return Optional.of(Util.getLogin(rs));
			}
		} catch (SQLException e) {
			return Optional.empty();
		}
		return Optional.empty();
	}

}
