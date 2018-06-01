package br.com.farmacia.modelo.dao;

public interface FiltroID<T> {

	public T getBy(long id);

	public T getBy(String id);

}
