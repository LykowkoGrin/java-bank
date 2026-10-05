package org.bank;

import java.math.BigDecimal;

public class Account {
    private int cardNumber;
    private int pin;
    private BigDecimal balance;
    private BankType bank;


    public Account(int pin, BigDecimal balance, int cardNumber, BankType bank) {
        if (pin < 100 || pin >= 1000){
            System.out.println("The PIN code consists of 3 digits!");
            return;
        }
        if (cardNumber < 10_000 || cardNumber >= 100_000){
            System.out.println("The card number consists of 5 digits!");
            return;
        }
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("The balance must be >= 0!");
            return;
        }
        this.pin = pin;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.bank = bank;

        if (bank == null){
            this.bank = BankType.NEO;
        }
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BankType getBank() {
        return bank;
    }

    @Override
    public String toString(){
        return bank.getName() + " Карта: " + String.valueOf(cardNumber) + ", Баланс: " + balance.toString() + "руб.";
    }
}
