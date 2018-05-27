package br.com.farmacia.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import br.com.farmacia.modelo.FarmaciaPJ;

public class FarmaciaDAO extends GenericDAO<FarmaciaPJ>{

	@Override
	public void inserir(FarmaciaPJ farmacia) {
		String sql = "insert into FARMACIA values(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, farmacia.getCnpj());
			stmt.setString(2, farmacia.getRazaoSocial());
			stmt.setString(3, farmacia.getNomeFantasia());
			stmt.setString(4, farmacia.getEmail());
			stmt.setString(5, farmacia.getTelefone());
			stmt.setString(6, farmacia.getLogoPath().toString());
			stmt.setInt(7, farmacia.getLocalizacao().getId());
			stmt.setInt(8, farmacia.getLogin().getId());
			stmt.setString(9, farmacia.getPerfil());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}	
		
	}

	@Override
	public void alterar(FarmaciaPJ farmacia) {
		String sql = "update FARMACIA set razao_social = ?, nome_fantasia = ?, email = ?, telefone = ?";
		sql += "logo_path = ?, LOCALIZACAO_id = ?, LOGIN_id = ? perfil = ? where cnpj = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, farmacia.getRazaoSocial());
			stmt.setString(2, farmacia.getNomeFantasia());
			stmt.setString(3, farmacia.getEmail());
			stmt.setString(4, farmacia.getTelefone());
			stmt.setString(5, farmacia.getLogoPath().toString());
			stmt.setInt(6, farmacia.getLocalizacao().getId());
			stmt.setInt(7, farmacia.getLogin().getId());
			stmt.setString(8, farmacia.getPerfil());
			stmt.setString(9, farmacia.getCnpj());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}	
	}

	@Override
	public void excluir(FarmaciaPJ farmacia) {
		String sql = "delete from FARMACIA where cnpj = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, farmacia.getCnpj());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} finally {
			closeConn(connection);
		}	
	}

	@Override
	public Collection<FarmaciaPJ> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.cnpj, f.email, f.logo_path, f.nome_fantasia, ");
		sql.append("f.perfil, f.razao_social, f.telefone, f.LOCALIZACAO_id, ");
		sql.append("f.LOGIN_id, l.id, l.cep, l.endereco,  ");
		sql.append("l.cidade, l.estado, lo.id, lo.senha, lo.usuario ");
		sql.append("from FARMACIA f inner join LOCALIZACAO l on f.LOCALIZACAO_id = l.id ");
		sql.append("inner join LOGIN lo on lo.id = l.id");
		return null;
	}

}
