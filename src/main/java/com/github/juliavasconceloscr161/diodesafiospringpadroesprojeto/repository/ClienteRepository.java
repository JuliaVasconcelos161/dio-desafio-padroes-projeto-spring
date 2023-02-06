package com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.repository;

import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
