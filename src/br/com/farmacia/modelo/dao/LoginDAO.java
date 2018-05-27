package br.com.farmacia.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.farmacia.modelo.Login;

public class LoginDAO extends GenericDAO<Login>{

	@Override
	public void inserir(Login login) {
		String sql = "insert into LOGIN values(?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, login.getId());
			stmt.setString(2, login.getUsuario());
			stmt.setString(3, login.getSenha());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}		
	}

	@Override
	public void alterar(Login login) {
		String sql = "update LOGIN set usuario = ?, senha = ? where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			stmt.setInt(3, login.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}				
	}

	@Override
	public void excluir(Login login) {
		String sql = "delete from LOGIN where id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, login.getId());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}		
	}

	@Override
	public Collection<Login> listar() {
		String sql = "select id, usuario, senha from LOGIN";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Collection<Login> logins = new ArrayList<>();
			Login login = null;
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				login = new Login();
				login.setUsuario(rs.getString("usuario"));;
				login.setSenha(rs.getString("senha"));
				login.setId(rs.getInt("id"));
				logins.add(login);
			}
			return logins;
		} catch (SQLException e) {
			rollback(connection);
			return null;
		} finally {
			closeConn(connection);
		}
	}

}
