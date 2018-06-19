package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Pessoa;
import br.com.farmacia.modelo.dao.util.Util;

public abstract class GenericDAO<T>{
	protected Connection connection;
	
	public abstract void inserir(T entidade);

	public abstract void alterar(T entidade);

	public abstract void excluir(T entidade);

	public abstract Optional<Collection<T>> listar();
	
	public Optional<? extends Pessoa> validaUsuario(Login login) {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.cnpj, f.email, f.logo_path, f.nome_fantasia, ");
		sql.append("f.perfil, f.razao_social, f.telefone, f.LOCALIZACAO_id, f.LOGIN_id, ");
		sql.append("l.id, l.cep, l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from FARMACIA as f inner join LOCALIZACAO as l on f.LOCALIZACAO_id = l.id ");
		sql.append("inner join LOGIN as lo on lo.usuario = ? and lo.senha = ?");
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return Optional.of(Util.getFarmacia(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(connection);
			return Optional.empty();
		} finally {
			closeResultSet(rs);
		}
		return Optional.empty();
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
