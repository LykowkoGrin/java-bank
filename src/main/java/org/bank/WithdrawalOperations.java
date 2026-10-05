package org.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface WithdrawalOperations {
    public BigDecimal withdrawMoney(BigDecimal balance, BigDecimal money, BankType bankType);
    default BigDecimal applyCommission(BigDecimal money, BankType bankType){
        if (money == null || bankType == null){
            return BigDecimal.ZERO;
        }
        return money.multiply(bankType.getCommission()).setScale(2, RoundingMode.HALF_UP);
    }

}
