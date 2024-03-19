package com.brunols7.demo.dto;


public class TransacaoDTO {
    private ClienteDTO cliente;
    private EmpresaDTO empresa;
    private double valor;

    public TransacaoDTO() {
        this.cliente = new ClienteDTO();
        this.empresa = new EmpresaDTO();
    }

    public TransacaoDTO(ClienteDTO cliente, EmpresaDTO empresa, double valor) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.valor = valor;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}