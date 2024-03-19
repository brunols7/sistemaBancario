package com.brunols7.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunols7.demo.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByCnpj(String cnpj);
}
