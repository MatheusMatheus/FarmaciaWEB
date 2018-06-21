package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Login;

public abstract class GenericDAO<T> {
	protected Connection connection;
	private boolean clienteExiste;
	
	public abstract void inserir(T entidade);

	public abstract void alterar(T entidade);

	public abstract void excluir(T entidade);

	public abstract Optional<Collection<T>> listar();
	
	public Optional<?> validaUsuario(Login login) {
		StringBuilder sql = new StringBuilder();
		sql.append("select c.cpf, lo.usuario ");
		sql.append("from CLIENTE as c ");
		sql.append("inner join LOGIN as lo on c.LOGIN_id = lo.id and lo.usuario = ? ");
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {

			stmt.setString(1, login.getUsuario());
			rs = stmt.executeQuery();
			
			clienteExiste = rs.next() ? true : false;
			closeResultSet(rs);
			stmt.close();

			return clienteExiste ? new ClienteDAO(connection).getBy(login) : new FarmaciaDAO(connection).getBy(login);
	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu merda");
			rollback(connection);
			return Optional.empty();
		} finally {
			closeResultSet(rs);
		}
	}
	

	public GenericDAO(Connection connection) {
		this.connection = connection;
		setAutoCommit();
	}
	
	protected void setAutoCommit() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void rollback(Connection connection) {
		try {
			connection.rollback();
			System.out.println("Rollback");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
