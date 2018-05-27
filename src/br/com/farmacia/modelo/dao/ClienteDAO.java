package br.com.farmacia.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.farmacia.modelo.ClientePF;
import br.com.farmacia.modelo.Localizacao;
import br.com.farmacia.modelo.dao.util.Util;

public class ClienteDAO extends GenericDAO<ClientePF> {

	@Override
	public void inserir(ClientePF cliente) {
		String sql = "insert into CLIENTE values(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			stmt.setDate(5, java.sql.Date.valueOf(cliente.getDataNascimento()));
			stmt.setString(6, cliente.getSexo());
			stmt.setInt(7, cliente.getLocalizacao().getId());
			stmt.setInt(8, cliente.getLogin().getId());
			stmt.setString(9, cliente.getPerfil().toString());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}
	}

	@Override
	public void alterar(ClientePF cliente) {
		String sql = "update CLIENTE set nome = ?, telefone = ?, email = ? dataNascimento = ?"
				+ "sexo = ?, perfil = ?, LOCALIZACAO_id = ? where cpf = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEmail());
			stmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
			stmt.setString(5, cliente.getSexo());
			stmt.setString(6, cliente.getPerfil().toString());
			stmt.setInt(7, cliente.getLocalizacao().getId());
			stmt.setString(8, cliente.getCpf());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}
	}

	@Override
	public void excluir(ClientePF cliente) {
		String sql = "delete from CLIENTE where cpf = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getCpf());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}

	}

	@Override
	public Collection<ClientePF> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select CLIENTE.cpf, CLIENTE.nome, CLIENTE.telefone, CLIENTE.email ");
		sql.append("CLIENTE.dataNascimento, CLIENTE.sexo, CLIENTE.perfil, CLIENTE.LOCALIZACAO_id ");
		sql.append("CLIENTE.LOGIN_id, LOCALIZACAO.id, LOCALIZACAO.cep, ");
		sql.append("LOCALIZACAO.endereco, LOCALIZACAO.cidade, LOCALIZACAO.estado  ");
		sql.append("from CLIENTE inner join LOCALIZACAO on LOCALIZACAO.id = CLIENTE.LOCALIZACAO_id");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			Collection<ClientePF> clientes = new ArrayList<>();
			ClientePF cliente = null;
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente = new ClientePF();
				cliente.setCpf(rs.getString("CLIENTE.cpf"));
				cliente.setNome(rs.getString("CLIENTE.nome"));
				cliente.setEmail(rs.getString("CLIENTE.email"));
				cliente.setDataNascimento(rs.getDate("CLIENTE.dataNascimento").toLocalDate());
				cliente.setSexo(rs.getString("CLIENTE.sexo"));
				cliente.setPerfil(rs.getString("CLIENTE.perfil"));
				cliente.setLocalizacao(Util.getLocalizacao(rs));
				clientes.add(cliente);
			}

			return clientes;
		} catch (SQLException e) {
			rollback(connection);
			return null;
		} finally {
			closeConn(connection);
		}
	}

}
