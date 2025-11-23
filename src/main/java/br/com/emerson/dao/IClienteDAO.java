package br.com.emerson.dao;

import br.com.emerson.Cliente;
import br.com.emerson.dao.generics.IGenericDAO;
import br.com.emerson.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;

public interface IClienteDAO extends IGenericDAO<Cliente, Serializable> {
    void excluir(Long valor);

    Cliente consultar(Long valor);

    void salvar(Cliente cliente);

    Cliente buscarPorCPF(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
