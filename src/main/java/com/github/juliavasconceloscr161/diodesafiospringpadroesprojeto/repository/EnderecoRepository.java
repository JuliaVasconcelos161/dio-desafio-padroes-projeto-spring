package com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.repository;

import com.github.juliavasconceloscr161.diodesafiospringpadroesprojeto.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
