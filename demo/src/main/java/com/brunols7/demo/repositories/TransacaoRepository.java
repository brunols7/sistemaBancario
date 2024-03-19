package com.brunols7.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunols7.demo.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
