package com.example.jazs23970nbp.services;

import com.example.jazs23970nbp.models.Currency;
import com.example.jazs23970nbp.models.Rate;
import com.example.jazs23970nbp.models.Root;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CurrencyFactory {

    public Currency getMeanCurrency(Root rootCurency, String startDate, String endDate){
        return Currency.builder()
                .code(rootCurency.getCode())
                .startDate(startDate)
                .endDate(endDate)
                .requestDateTime(LocalDateTime.now())
                .meanCurrency(calculateMean(rootCurency))
                .build();
    }

    private Double calculateMean(Root rootCurrency){
        return getSum(rootCurrency) / rootCurrency.getRates().size();
    }

    private double getSum(Root rootCurrency){
        return rootCurrency.getRates().stream()
                .map(Rate::getMid)
                .mapToDouble(d -> d)
                .sum();
    }
}
