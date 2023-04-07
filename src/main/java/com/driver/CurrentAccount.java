package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class CurrentAccount extends BankAccount{
    private  String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {

        super(name,balance,5000);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance<5000) throw new Exception("Insufficient Balance");

        this.tradeLicenseId=tradeLicenseId;


    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        int n=this.tradeLicenseId.length();
        if(!isValidTradeLicenseId(tradeLicenseId)) {
            tradeLicenseId = reArrangeTradeLicenseId(tradeLicenseId);
            if(tradeLicenseId.length()==0) throw new Exception("Valid License can not be generated");
        }
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
            //System.out.println("vvvv");
    }
    public boolean isValidTradeLicenseId(String tradeLicenseId){
        int n=this.tradeLicenseId.length();
        for(int i=1; i<n; i++){
            if(tradeLicenseId.charAt(i-1)==tradeLicenseId.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public String reArrangeTradeLicenseId(String S){
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'A']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        //System.out.println(String.valueOf(res));
        return String.valueOf(res);
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
