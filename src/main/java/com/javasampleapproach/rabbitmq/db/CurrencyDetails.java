package com.javasampleapproach.rabbitmq.db;

import org.springframework.data.annotation.Id;

/**
 * MongoDB Schema
 */
public class CurrencyDetails {

    @Id
    public String id;

    public String code;
    public Float amountToBuy;
    public Long transactionTime;
    public String countryName;
    public Float exchangeRate;

    public CurrencyDetails() {
    }

    public CurrencyDetails(String code, Float amountToBuy, Long transactionTime, String countryName, Float exchangeRate) {
        this.code = code;
        this.amountToBuy = amountToBuy;
        this.transactionTime = transactionTime;
        this.countryName = countryName;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return String.format(
                "CurrencyDetails[id=%s, code='%s', amountToBuy='%s', transactionTime='%s', countryName='%s', exchangeRate='%s']",
                id, code, amountToBuy, transactionTime, transactionTime, countryName, exchangeRate);
    }
}
