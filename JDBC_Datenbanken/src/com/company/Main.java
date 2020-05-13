package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        //service.insertProdukt("",10.0,1);
        //service.insertKategorie("");
        //Testdaten.TestdatenGenerieren();
        Testdaten.createProdukte(100);
    }
}
