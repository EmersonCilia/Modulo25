package br.com.emerson;

import br.com.emerson.dao.ClienteDaoMock;
import br.com.emerson.dao.IClienteDAO;
import br.com.emerson.exceptions.TipoChaveNaoEncontradaException;
import br.com.emerson.services.ClienteService;
import br.com.emerson.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("emerson");
        cliente.setCidade("Londrina");
        cliente.setEnd("End");
        cliente.setEstado("PR");
        cliente.setNumero(999);
    }

    @Test
    public void pesquisarClient(){

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException{
        cliente.setNome("Cilia");
        clienteService.alterar(cliente);

        Assert.assertEquals("Cilia", cliente.getNome());
    }
}
