package br.com.emerson.services;

import br.com.emerson.Cliente;
import br.com.emerson.dao.IClienteDAO;
import br.com.emerson.exceptions.TipoChaveNaoEncontradaException;
import br.com.emerson.services.generics.GenericService;

public class ClienteService extends GenericService implements IClienteService {


    public ClienteService(IClienteDAO clienteDAO){
        super(clienteDAO);
    }

    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return (Cliente) this.dao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        this.dao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
        this.dao.alterar(cliente);
    }
}
