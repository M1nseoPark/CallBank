package com.example.callbank.send;

public class FavoriteItem {
    private int id;
    private String fName;
    private String fAlias;
    private String fAccount;

    public FavoriteItem(int id, String fName, String fAlias, String fAccount) {
        this.id = id;
        this.fName = fName;
        this.fAlias = fAlias;
        this.fAccount = fAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfAlias() {
        return fAlias;
    }

    public void setfAlias(String fAlias) {
        this.fAlias = fAlias;
    }

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
    }
}
