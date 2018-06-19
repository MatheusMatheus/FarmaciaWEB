package br.com.farmacia.modelo.dao;

import java.sql.Connection;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import br.com.farmacia.modelo.Login;
import br.com.farmacia.modelo.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> implements Function<Login, Optional<? extends Pessoa>>{
	public PessoaDAO(Connection connection) {
		super(connection);
	}
	@Override
	public Optional<? extends Pessoa> apply(Login login) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void inserir(Pessoa entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void alterar(Pessoa entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excluir(Pessoa entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Optional<Collection<Pessoa>> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
