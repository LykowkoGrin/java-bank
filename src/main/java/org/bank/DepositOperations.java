package org.bank;

import java.math.BigDecimal;

public interface DepositOperations {
    public BigDecimal depositMoney(BigDecimal balance, BigDecimal money);
}
