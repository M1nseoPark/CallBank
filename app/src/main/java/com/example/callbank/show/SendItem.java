package com.example.callbank.show;

public class SendItem {
    private String sendName;
    private String sendDate;
    private int sendMoney;
    private int sendBalance;

    public SendItem(String sendName, String sendDate, int sendMoney, int sendBalance) {
        this.sendName = sendName;
        this.sendDate = sendDate;
        this.sendMoney = sendMoney;
        this.sendBalance = sendBalance;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public int getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(int sendMoney) {
        this.sendMoney = sendMoney;
    }

    public int getSendBalance() {
        return sendBalance;
    }

    public void setSendBalance(int sendBalance) {
        this.sendBalance = sendBalance;
    }
}
