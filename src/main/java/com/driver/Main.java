package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount account=new CurrentAccount("Ravi Ranjan",15000.0,"AASSDDFGHTY");
        account.validateLicenseId();
        System.out.println(account.getTradeLicenseId());

    }
}