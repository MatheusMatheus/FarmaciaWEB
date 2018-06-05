package br.com.farmacia.modelo.dao;

import java.util.Optional;

public interface FiltroID<T> {

	public Optional<T> getBy(long id);

	public Optional<T> getBy(String... itens);

}
