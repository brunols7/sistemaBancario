package com.brunols7.demo.services.calculo;

import org.springframework.stereotype.Component;

import com.brunols7.demo.entities.Empresa;
import com.brunols7.demo.services.TaxaCalculavel;

@Component
public class TaxaB implements TaxaCalculavel{
	
	private static final double taxa_fixa = 0.04;
	private static final double porcentagem_saldo = 0.02;
	
	@Override
	public double calcularTaxa(Empresa empresa) {
		
		double taxaFixa = taxa_fixa;
		double porcentagemSaldo = empresa.getSaldo() * porcentagem_saldo;
		
		return taxaFixa + porcentagemSaldo;
	}

}
