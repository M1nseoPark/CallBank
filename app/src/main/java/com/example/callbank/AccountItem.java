package com.example.callbank;

public class AccountItem {
    private int id;
    private String bankName;
    private String accountNumber;

    public AccountItem(int id, String bankName, String accountNumber) {
        this.id = id;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
