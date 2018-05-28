package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import br.com.farmacia.modelo.dao.util.ConnectionFactory;

public abstract class GenericDAO<T> {
	protected Connection connection;
	
	public abstract void inserir(T entidade);

	public abstract void alterar(T entidade);

	public abstract void excluir(T entidade);

	public abstract Collection<T> listar();
	
	public GenericDAO() {
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void closeConn(Connection connection) {
		try {
			if (connection != null && !connection.isClosed())
				connection.close();
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
