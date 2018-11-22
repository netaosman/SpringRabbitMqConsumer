package com.javasampleapproach.rabbitmq.db;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * MongoDB interface
 */
public interface ConsumerRepository extends MongoRepository<CurrencyDetails, String> {

//    public CurrencyDetails findByFirstName(String code);
//    public List<CurrencyDetails> findByLastName(String code);

}