package com.zupedu.conta.conta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContaNovaProducer {

    Logger logger = LoggerFactory.getLogger(ContaNovaProducer.class);

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, NovaContaEvent> kafkaTemplate;


    @Async
    public void send(Conta conta){
        NovaContaEvent evento = new NovaContaEvent(conta.getId(),
                conta.getAgencia(), conta.getNumero(), conta.getSaldo());

        kafkaTemplate.send(topicName, evento);

        logger.info("Evento NOVA_CONTA gerado com sucesso : {} ", evento.toString());
    }
}
