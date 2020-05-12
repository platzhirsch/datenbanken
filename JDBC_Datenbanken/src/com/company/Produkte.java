package com.company;

public class Produkte {
    Integer id;
    Integer katId;

    String name;
    Double preis;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getKatId() {
        return katId;
    }
    public void setKatId(Integer katId) {
        this.katId = katId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPreis() {
        return preis;
    }
    public void setPreis(Double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return "Produkte{" +
                "id=" + id +
                ", katId=" + katId +
                ", name='" + name + '\'' +
                ", preis=" + preis +
                '}';
    }
}
