package com.example.callbank.map;

public class MapItem {
    private String kind;
    private String name;
    private String address;
    private String tel;
    private double latitude;
    private double longitude;

    public MapItem(String kind, String name, String address, String tel, double latitude, double longitude) {
        this.kind = kind;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
