package com.brunols7.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class TaxaCalculavelFactory {

    @Autowired
    private Map<String, TaxaCalculavel> taxaCalculavelMap;

    public TaxaCalculavel getTaxaCalculavel(String tipoEmpresa) {
        return taxaCalculavelMap.get(tipoEmpresa);
    }
}
