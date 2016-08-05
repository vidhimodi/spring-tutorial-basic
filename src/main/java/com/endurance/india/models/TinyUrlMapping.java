package com.endurance.india.models;

public class TinyUrlMapping {

    private Integer id;
    private String shortKey;
    private String longUrl;

    private String tinyUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public String toString() {
        return "TinyUrlMapping{" +
                "id=" + id +
                ", shortKey='" + shortKey + '\'' +
                ", longUrl='" + longUrl + '\'' +
                '}';
    }
}