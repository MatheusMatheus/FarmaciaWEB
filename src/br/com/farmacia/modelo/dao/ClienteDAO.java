package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.util.Util;

public class ClienteDAO extends GenericDAO<ClientePF> implements FiltroID<Login, ClientePF>  {

	public ClienteDAO(Connection connection) {
		super(connection);
	}

	public void inserir(ClientePF cliente) {
		String sql = "insert into CLIENTE values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getTelefone());
			stmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
			stmt.setString(5, cliente.getSexo());
			stmt.setLong(6, cliente.getLocalizacao().getId());
			stmt.setLong(7, cliente.getLogin().getId());
			stmt.setString(8, cliente.getPerfil().toString());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(connection);
		}
	}

	public void alterar(ClientePF cliente) {
		String sql = "update CLIENTE set nome = ?, telefone = ?, dataNascimento = ?"
				+ "sexo = ?, perfil = ?, LOCALIZACAO_id = ? where cpf = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNascimento()));
			stmt.setString(4, cliente.getSexo());
			stmt.setString(5, cliente.getPerfil().toString());
			stmt.setLong(6, cliente.getLocalizacao().getId());
			stmt.setString(7, cliente.getCpf());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}
	}

	public void excluir(ClientePF cliente) {
		String sql = "delete from CLIENTE where cpf = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getCpf());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		}
	}

	public Optional<Collection<ClientePF>> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select c.cpf, c.nome, c.telefone, ");
		sql.append("c.dataNascimento, c.sexo, c.perfil, c.LOCALIZACAO_id, ");
		sql.append("c.LOGIN_id, l.id, l.cep, ");
		sql.append("l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from CLIENTE as c inner join LOCALIZACAO as l on l.id = c.LOCALIZACAO_id ");
		sql.append("inner join LOGIN as lo on lo.id = c.LOGIN_id;");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString()); 
				ResultSet rs = stmt.executeQuery()) {
			Collection<ClientePF> clientes = new ArrayList<>();
			while (rs.next())
				clientes.add(Util.getCliente(rs));
			return Optional.of(clientes);
		} catch (SQLException e) {
			System.out.println("Deu merda");
			rollback(connection);
			return Optional.empty();
		}
	}

	@Override
	public Optional<ClientePF> getBy(Login login) {
		StringBuilder sql = new StringBuilder();
		sql.append("select c.cpf, c.nome, c.telefone, ");
		sql.append("c.dataNascimento, c.sexo, c.perfil, c.LOCALIZACAO_id, ");
		sql.append("c.LOGIN_id, l.id, l.cep, ");
		sql.append("l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from CLIENTE as c inner join LOCALIZACAO as l on l.id = c.LOCALIZACAO_id ");
		sql.append("inner join LOGIN as lo on lo.usuario = ? and lo.senha = ?");
		
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())){
			stmt.setString(1, login.getUsuario());
			stmt.setString(2, login.getSenha());
			rs = stmt.executeQuery();
			if(rs.next()) {
				return Optional.of(Util.getCliente(rs));
			}
		} catch (SQLException e) {
			return Optional.empty();
		} finally {
			closeResultSet(rs);
		}
		return Optional.empty();
	}
}
