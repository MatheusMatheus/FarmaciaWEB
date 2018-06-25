package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.util.Util;

public class LoginDAO extends GenericDAO<Login> implements FiltroID<Login, Login> {

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
	public Optional<Login> getBy(Login login) {
		StringBuilder sql = new StringBuilder();
		sql.append("select lo.id, lo.usuario, lo.senha from LOGIN as lo where lo.usuario = ? and lo.senha = ? ");
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return Optional.of(Util.getLogin(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		} finally {
			closeResultSet(rs);
		}
		return Optional.empty();
	}

	public boolean validaUsuario(Login login, Supplier<String> query) {
		boolean clienteExiste;
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(query.get())) {
			stmt.setString(1, login.getUsuario());
			rs = stmt.executeQuery();
			
			clienteExiste = rs.next() ? true : false;
			closeResultSet(rs);
			stmt.close();

			return clienteExiste;
	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu merda");
			rollback(connection);
			return false;
		} finally {
			closeResultSet(rs);
		}
	}
	
	public static String clienteQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select c.cpf, lo.usuario ");
		sql.append("from CLIENTE as c ");
		sql.append("inner join LOGIN as lo on c.LOGIN_id = lo.id and lo.usuario = ? ");
		return sql.toString();
	}

	public static String farmaciaQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.cnpj, lo.usuario ");
		sql.append("from FARMACIA as f ");
		sql.append("inner join LOGIN as lo on f.LOGIN_id = lo.id and lo.usuario = ? ");	
		return sql.toString();
	}

}
