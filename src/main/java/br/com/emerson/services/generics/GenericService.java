
package br.com.emerson.services.generics;

import java.io.Serializable;
import java.util.Collection;

import br.com.emerson.dao.IClienteDAO;
import br.com.emerson.dao.Persistente;
import br.com.emerson.dao.generics.IGenericDAO;
import br.com.emerson.exceptions.TipoChaveNaoEncontradaException;


public abstract class GenericService<T extends Persistente, E extends Serializable>
		implements IGenericService<T, E> {

	protected IGenericDAO<T, E> dao;

	public GenericService(IClienteDAO dao) {
		this.dao = (IGenericDAO<T, E>) dao;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(E valor) {
		this.dao.excluir((Long) valor);
	}

	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException {
		this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) {
		return this.dao.consultar((Long) valor);
	}

	@Override
	public Collection<T> buscarTodos() {
		return this.dao.buscarTodos();
	}
}
