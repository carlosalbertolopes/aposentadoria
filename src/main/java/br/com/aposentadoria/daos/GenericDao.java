package br.com.aposentadoria.daos;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {

	public T pesquisarPorId(Serializable id);

	public List<T> getAll();

	public void persistirEntidade(T entity);

	public void excluirEntidade(T entity);

	public void updateEntidade(T entity);

}
