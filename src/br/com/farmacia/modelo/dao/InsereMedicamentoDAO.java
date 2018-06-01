package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.farmacia.modelo.InsereMedicamento;
import br.com.farmacia.modelo.dao.util.Util;

public class InsereMedicamentoDAO extends GenericDAO<InsereMedicamento> {
	
	public InsereMedicamentoDAO(Connection connection) {
		super.connection = connection;
	}

	@Override
	public void inserir(InsereMedicamento medicamento) {
		String sql = "insert into INSERE values(?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, medicamento.getFarmacia().getCnpj());
			stmt.setLong(2, medicamento.getMedicamento().getId());
			stmt.setDate(3, java.sql.Date.valueOf(medicamento.getData()));
			stmt.setLong(4, medicamento.getId());
			stmt.setLong(5, medicamento.getQuantidade());
			stmt.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection);
		} 
	}

	@Override
	public void alterar(InsereMedicamento medicamento) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void excluir(InsereMedicamento entidade) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<InsereMedicamento> listar() {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.cnpj, f.email, f.logo_path, f.nome_fantasia, f.perfil, ");
		sql.append("f.razao_social, f.telefone, f.LOCALIZACAO_id, f.LOGIN_id, ");
		sql.append("m.id, m.nome, m.preco, m.categoria, m.descricao, m.fabricante, m.foto_path, ");
		sql.append("m.quantidade, m.tipo, m.validade, ");
		sql.append("i.id, i.FARMACIA_cnpj, i.MEDICAMENTO_id, i.dataInsercao, i.quantidade, ");
		sql.append("l.id, l.cep, l.endereco, l.cidade, l.estado, ");
		sql.append("lo.id, lo.senha, lo.usuario ");
		sql.append("from INSERE as i inner join FARMACIA as f on i.FARMACIA_cnpj = f.cnpj ");
		sql.append("inner join MEDICAMENTO as m on m.id = i.MEDICAMENTO_id ");
		sql.append("inner join LOCALIZACAO as l on l.id = f.LOCALIZACAO_id ");
		sql.append("inner join LOGIN as lo on lo.id = f.LOGIN_id");
		try (PreparedStatement stmt = connection.prepareStatement(sql.toString()); ResultSet rs = stmt.executeQuery()) {
			Collection<InsereMedicamento> medicamentosInseridos = new ArrayList<>();
			InsereMedicamento medicamento = null;
			while (rs.next()) {
				medicamento = new InsereMedicamento();
				medicamento.setId(rs.getInt("i.id"));
				medicamento.setQuantidade(rs.getInt("i.quantidade"));
				medicamento.setData(rs.getDate("i.dataInsercao").toLocalDate());
				medicamento.setFarmacia(Util.getFarmacia(rs));
				medicamento.setMedicamento(Util.getMedicamento(rs));
				medicamentosInseridos.add(medicamento);
			}
			return medicamentosInseridos;
		} catch (SQLException e) {
			rollback(connection);
			return null;
		} 
	}
}
