package org.bank;

import java.math.BigDecimal;

public enum BankType {
    NEO("НеоКредит", new BigDecimal("0.01")),
    AUM("Арум Финтех", new BigDecimal("0.02")),
    VTA("Вектор Альянс", new BigDecimal("0.00"));

    private String name;
    private BigDecimal commission;

    public BigDecimal getCommission(){
        return commission;
    }
    public String getName(){
        return name;
    }

    BankType(String name, BigDecimal commission){
        this.name = name;
        this.commission = commission;
    }
}
