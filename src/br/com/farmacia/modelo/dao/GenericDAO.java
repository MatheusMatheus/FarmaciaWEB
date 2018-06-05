package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public abstract class GenericDAO<T> {
	protected Connection connection;
	
	public abstract void inserir(T entidade);

	public abstract void alterar(T entidade);

	public abstract void excluir(T entidade);

	public abstract Optional<Collection<T>> listar();
	
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
