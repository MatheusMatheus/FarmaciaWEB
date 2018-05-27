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
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConn(Connection connection) {
		try {
			if (!connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void closeResultSet(ResultSet rs) {
		try {
			if (!rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void rollback(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
