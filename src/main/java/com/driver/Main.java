package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount acc=new BankAccount("Deepak",12000,1000);
        System.out.println(acc.generateAccountNumber(13,78));
        System.out.println("Total Balance: "+acc.getBalance());
        acc.deposit(2000);
        System.out.println("Total Balance: "+acc.getBalance());
        acc.withdraw(10000);
        System.out.println("Total Balance: "+acc.getBalance());
        acc.withdraw(3000);
        System.out.println("Total Balance: "+acc.getBalance());

    }
}