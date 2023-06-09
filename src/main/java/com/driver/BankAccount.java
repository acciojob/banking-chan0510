package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String accountNumber;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
        this.accountNumber="";

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        if(sum>9*digits){
            //If it is not possible, throw "Account Number can not be generated" exception
            throw new Exception("Account Number can not be generated");
        }
        while(sum>9){
            this.accountNumber+="9";
            sum-=9;
        }
        this.accountNumber+=sum;
        while(this.accountNumber.length()<digits){
            this.accountNumber+="0";
        }
        return this.accountNumber;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
            if(this.minBalance>(this.balance-amount)) throw new Exception("Insufficient Balance");
            else
            this.balance-=amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}