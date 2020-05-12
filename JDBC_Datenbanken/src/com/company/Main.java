package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private int anzahlProdukte = 0;
    private int anzahKunden = 0;
    private int anzahlGekauft =0;
    private int anzahlAngesehen =0;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        service.insertProdukt("",10.0,1);
        service.insertKategorie("");
    }
}
