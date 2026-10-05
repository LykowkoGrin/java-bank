package org.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashMachine implements WithdrawalOperations, DepositOperations{
    @Override
    public BigDecimal depositMoney(BigDecimal balance, BigDecimal money) {
        if (balance == null || money == null || money.compareTo(BigDecimal.ZERO) <= 0){
            return balance;
        }
        return balance.add(money);
    }

    @Override
    public BigDecimal withdrawMoney(BigDecimal balance, BigDecimal money, BankType bankType) {
        if (balance == null || money == null || money.compareTo(BigDecimal.ZERO) < 0){
            return balance;
        }
        BigDecimal commission = applyCommission(money,bankType);
        BigDecimal finalCost = money.add(commission);
        if (balance.compareTo(finalCost) < 0){
            System.out.println("insufficient funds");
            return balance;
        }
        return balance.add(finalCost.negate()).setScale(2, RoundingMode.HALF_UP);
    }
}
