package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.farmacia.modelo.FarmaciaPJ;
import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.dao.util.Util;

public class FarmaciaDAO extends GenericDAO<FarmaciaPJ> implements FiltroID<Login, FarmaciaPJ> {
	
	public FarmaciaDAO(Connection connection) {
		super(connection);
	}

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
			stmt.setLong(7, farmacia.getLocalizacao().getId());
			stmt.setLong(8, farmacia.getLogin().getId());
			stmt.setString(9, farmacia.getPerfil());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 
		
	}

	@Override
	public void alterar(FarmaciaPJ farmacia) {
		StringBuilder sql = new StringBuilder();
		sql.append("update FARMACIA set razao_social = ?, nome_fantasia = ?, email = ?, telefone = ?, ");
		sql.append("logo_path = ?, LOCALIZACAO_id = ?, LOGIN_id = ?, perfil = ? where cnpj = ?");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
			stmt.setString(1, farmacia.getRazaoSocial());
			stmt.setString(2, farmacia.getNomeFantasia());
			stmt.setString(3, farmacia.getEmail());
			stmt.setString(4, farmacia.getTelefone());
			stmt.setString(5, farmacia.getLogoPath().toString());
			stmt.setLong(6, farmacia.getLocalizacao().getId());
			stmt.setLong(7, farmacia.getLogin().getId());
			stmt.setString(8, farmacia.getPerfil());
			stmt.setString(9, farmacia.getCnpj());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e);
			rollback(connection);
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
		} 
	}

	@Override
	public Optional<Collection<FarmaciaPJ>> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.cnpj, f.email, f.logo_path, f.nome_fantasia, f.LOGIN_id, ");
		sql.append("f.perfil, f.razao_social, f.telefone, f.LOCALIZACAO_id, ");
		sql.append("l.id, l.cep, l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from FARMACIA as f inner join LOCALIZACAO as l on f.LOCALIZACAO_id = l.id ");
		sql.append("inner join LOGIN as lo on lo.id = f.LOGIN_id");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery()){
			Collection<FarmaciaPJ> farmacias = new ArrayList<>();
			while(rs.next()) 
				farmacias.add(Util.getFarmacia(rs));
			return Optional.of(farmacias);
		} catch (SQLException e) {
			System.out.println(e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<FarmaciaPJ> getBy(Login id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.cnpj, f.email, f.logo_path, f.nome_fantasia, f.LOGIN_id, ");
		sql.append("f.perfil, f.razao_social, f.telefone, f.LOCALIZACAO_id, ");
		sql.append("l.id, l.cep, l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from FARMACIA as f inner join LOCALIZACAO as l on f.LOCALIZACAO_id = l.id ");
		sql.append("inner join LOGIN as lo on lo.usuario = ? and lo.senha = ?");
		
		ResultSet rs = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString())){
			rs = stmt.executeQuery();
			if(rs.next()) 
				return Optional.of(Util.getFarmacia(rs));
		} catch (SQLException e) {
			System.out.println(e);
			return Optional.empty();
		} finally {
			closeResultSet(rs);
		}
		return Optional.empty();
	}
}
