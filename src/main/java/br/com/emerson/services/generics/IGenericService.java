/**
 * 
 */
package br.com.emerson.services.generics;

import java.io.Serializable;
import java.util.Collection;

import br.com.emerson.dao.Persistente;
import br.com.emerson.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente, E extends Serializable> {

    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    void excluir(E valor);

    void alterar(T entity) throws TipoChaveNaoEncontradaException;

    T consultar(E valor);

    Collection<T> buscarTodos();
}

