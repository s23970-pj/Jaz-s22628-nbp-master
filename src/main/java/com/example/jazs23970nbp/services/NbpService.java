package com.example.jazs23970nbp.services;


import com.example.jazs23970nbp.models.Currency;
import com.example.jazs23970nbp.models.Root;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.jazs23970nbp.repository.NbpRepository;

import java.util.Objects;


@Service
public class NbpService {
    private final RestTemplate restTemplate;
    private final CurrencyFactory currencyFactory;
    private final NbpRepository nbpRepository;

    private static final String NPB_URL = "http://api.nbp.pl/api/exchangerates/rates/";
    private static final String table = "a";

    public NbpService(RestTemplate restTemplate, CurrencyFactory currencyFactory, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.currencyFactory = currencyFactory;
        this.nbpRepository = nbpRepository;
    }

    public Currency getCurrency(String code, String startDate, String endDate){
        Root response = restTemplate.getForObject(NPB_URL+table+"/{code}/{startDate}/{endDate}//",Root.class,code,startDate,endDate);
        Currency currency = currencyFactory.getMeanCurrency(Objects.requireNonNull(response),startDate,endDate);
        return nbpRepository.save(currency);
    }

}
