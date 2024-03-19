package com.brunols7.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunols7.demo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
}

