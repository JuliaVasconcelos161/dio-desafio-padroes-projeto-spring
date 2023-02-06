package com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.service;

import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.entity.Cliente;
import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.entity.Endereco;
import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.repository.ClienteRepository;
import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        //Verificar no banco se o endereço do cliente já existe pelo cep
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //Caso não exista, integrar com ViaCep e persistir o retorno
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Salvar cliente com endereço no banco
        clienteRepository.save(cliente);
    }
}
