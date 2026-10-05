package org.bank;


import java.io.BufferedReader;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static void main() {
        Account account = new Account(122,new BigDecimal("777.66"),12345,BankType.AUM);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Coffe Bank System!");
        System.out.print("Enter card number: ");
        if (scanner.hasNextInt()){
            int cardNumber = scanner.nextInt();
            if(cardNumber != account.getCardNumber()){
                System.out.println("Invalid card number!");
                return;
            }
        }
        else{
            System.out.println("Invalid card number!");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter pin: ");
        if (scanner.hasNextInt()){
            int pin = scanner.nextInt();
            if(pin != account.getPin()){
                System.out.println("Invalid pin!");
                return;
            }
        }
        else{
            System.out.println("Invalid pin!");
            scanner.nextLine();
            return;
        }

        CashMachine cashier = new CashMachine();
        System.out.print("Enter deposit: ");
        BigDecimal inputCash;
        if (scanner.hasNextBigDecimal()){
            inputCash = scanner.nextBigDecimal();
            if (inputCash.compareTo(BigDecimal.ZERO) < 0){
                System.out.println("Cash value must be >= 0!");
                return;
            }
        }
        else{
            System.out.println("Invalid cash value!");
            scanner.nextLine();
            return;
        }
        BigDecimal balance = account.getBalance();
        balance = cashier.depositMoney(balance,inputCash);
        System.out.println(balance);

        System.out.print("Enter funds: ");
        BigDecimal inputFunds;
        if (scanner.hasNextBigDecimal()){
            inputFunds = scanner.nextBigDecimal();
            if (inputFunds.compareTo(BigDecimal.ZERO) < 0){
                System.out.println("Funds value must be >= 0!");
                return;
            }
        }
        else{
            System.out.println("Invalid funds value!");
            scanner.nextLine();
            return;
        }
        balance = cashier.withdrawMoney(balance,inputFunds,account.getBank());
        System.out.println(balance);
    }
}
