package br.com.farmacia.modelo.dao;

public interface FiltroID<T> {

	public T getBy(int id);

	public T getBy(String id);

}
