package br.com.farmacia.modelo.dao;

import java.util.Optional;

public interface FiltroID<T, R> {

	Optional<R> getBy(T id);

}
