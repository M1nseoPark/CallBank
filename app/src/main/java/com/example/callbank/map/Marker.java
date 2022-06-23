package com.example.callbank.map;

public class Marker {
    private String kind;
    private String name;
    private Double latitude;
    private Double longitude;

    public Marker(String kind, String name, Double latitude, Double longitude) {
        this.kind = kind;
        this.name = name;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
