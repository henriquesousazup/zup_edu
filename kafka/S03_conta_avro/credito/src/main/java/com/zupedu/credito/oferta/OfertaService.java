package com.zupedu.credito.oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OfertaService {

    private static final BigDecimal VALOR_CREDITO = new BigDecimal(1000);
    private static final BigDecimal VALOR_CARTAO = new BigDecimal(500);
    public static final int TRUE = 1;

    @Autowired
    private OfertaRepository ofertaRepository;

    public void incluirNovaOferta(int agencia, long numero, BigDecimal saldo){
        Oferta oferta = null;

        if(saldo.compareTo(VALOR_CREDITO) == TRUE){
            oferta = new Oferta(Tipo.EMPRESTIMO, agencia, numero, saldo);
        }else if(saldo.compareTo(VALOR_CARTAO) == TRUE){
            oferta = new Oferta(Tipo.CARTAO, agencia, numero, saldo);
        }

        if(oferta != null ){ofertaRepository.save(oferta);}
    }
}
