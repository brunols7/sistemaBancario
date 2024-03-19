package com.brunols7.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brunols7.demo.dto.TransacaoDTO;
import com.brunols7.demo.services.TransacaoService;

@RestController
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<?> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            transacaoService.realizarTransacao(transacaoDTO);
            return ResponseEntity.ok("Transação realizada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
