package com.brunols7.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brunols7.demo.dto.ClienteDTO;
import com.brunols7.demo.dto.EmpresaDTO;
import com.brunols7.demo.dto.TransacaoDTO;
import com.brunols7.demo.entities.Cliente;
import com.brunols7.demo.entities.Empresa;
import com.brunols7.demo.entities.Transacao;
import com.brunols7.demo.repositories.ClienteRepository;
import com.brunols7.demo.repositories.EmpresaRepository;
import com.brunols7.demo.repositories.TransacaoRepository;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, EmpresaRepository empresaRepository, ClienteRepository clienteRepository) {
        this.transacaoRepository = transacaoRepository;
        this.empresaRepository = empresaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void realizarTransacao(TransacaoDTO transacaoDTO) {
        ClienteDTO clienteDTO = transacaoDTO.getCliente();
        EmpresaDTO empresaDTO = transacaoDTO.getEmpresa();

        Cliente cliente = clienteRepository.findByCpf(clienteDTO.getCpf());
        Empresa empresa = empresaRepository.findByCnpj(empresaDTO.getCnpj());

        if (cliente == null || empresa == null) {
            throw new IllegalArgumentException("Cliente ou empresa não encontrados");
        }

        if (transacaoDTO.getValor() <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        double taxa = calcularTaxa(empresa);
        double valorComTaxa = transacaoDTO.getValor() * (1 - taxa);

        if (empresa.getSaldo() < valorComTaxa) {
            throw new IllegalArgumentException("Saldo insuficiente na empresa");
        }

        Transacao transacao = new Transacao();
        transacao.setCliente(cliente);
        transacao.setEmpresa(empresa);
        transacao.setValor(transacaoDTO.getValor());
        transacaoRepository.save(transacao);

        empresa.setSaldo(empresa.getSaldo() - valorComTaxa);
        empresaRepository.save(empresa);
        
        
        notificarEmpresa(transacaoDTO, empresa);

        notificarCliente(transacaoDTO, cliente);
    }

    private double calcularTaxa(Empresa empresa) {
        return 0.05;
    }

    private void notificarEmpresa(TransacaoDTO transacaoDTO, Empresa empresa) {
        System.out.println("Notificação para a empresa: Transação realizada - Valor: " + transacaoDTO.getValor());
    }

    private void notificarCliente(TransacaoDTO transacaoDTO, Cliente cliente) {
        System.out.println("Notificação para o cliente: Transação realizada - Valor: " + transacaoDTO.getValor());
    }
}
