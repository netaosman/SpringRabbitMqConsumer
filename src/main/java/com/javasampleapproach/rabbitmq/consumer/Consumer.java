package com.javasampleapproach.rabbitmq.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasampleapproach.rabbitmq.db.ConsumerRepository;
import com.javasampleapproach.rabbitmq.db.CurrencyDetails;
import com.javasampleapproach.rabbitmq.model.Currency;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * The main process in the Consumer service.
 * Getting the rabbitMq config details
 * and recivig the currencies list from the Rabbit queue.
 */
@Component
public class Consumer {

    //BD intializing
    @Autowired
    private ConsumerRepository repository;

    @RabbitListener(queues = "${jsa.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(List<Currency> currenciesArray) {

        System.out.println("Recieved Message: " + currenciesArray);
        Long d1 = new Date().getTime();

        //Building and saving the mongoDB schema
        List<CurrencyDetails> currencies = new ArrayList<>();
        for (int i = 0; i < currenciesArray.size(); i++) {
            CurrencyDetails coin = new CurrencyDetails(
                    currenciesArray.get(i).getCode(),
                    currenciesArray.get(i).getAmountToBuy(),
                    d1,
                    currenciesArray.get(i).getCountryName(),
                    currenciesArray.get(i).getExchangeRate()

            );
            currencies.add(coin);
        }
        repository.insert(currencies);

    }

}
