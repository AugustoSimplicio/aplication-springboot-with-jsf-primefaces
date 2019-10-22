package br.com.augusto.dao;

import java.util.List;

public interface Repository<T>{
	public List<T> listar();
	public T salvar(T t);
	public T buscar(T t);
	public boolean remover(T t);
}
