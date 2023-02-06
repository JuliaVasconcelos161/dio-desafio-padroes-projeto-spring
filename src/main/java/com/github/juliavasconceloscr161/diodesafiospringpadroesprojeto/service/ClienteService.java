package com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.service;

import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.entity.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
