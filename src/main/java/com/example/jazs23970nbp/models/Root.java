package com.example.jazs23970nbp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Root {
    public String table;
    public String currency;
    public ArrayList<Rate> rates;
    public String code;


    public String getCode() {
        return code;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }



}
