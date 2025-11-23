package br.com.emerson;

import br.com.emerson.dao.ClienteDaoMock;
import br.com.emerson.dao.IClienteDAO;
import br.com.emerson.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("emerson");
        cliente.setCidade("Londrina");
        cliente.setEnd("Rua Tremembés");
        cliente.setEstado("PR");
        cliente.setNumero(463);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarClient(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Cilia");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Cilia", cliente.getNome());
    }

}
