package br.com.emerson.dao;

import br.com.emerson.Cliente;
import br.com.emerson.dao.generics.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

        public ClienteDAO(){
            super();
        }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    @Override
    public void salvar(Cliente cliente) {

    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return null;
    }
}
