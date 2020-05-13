package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //service.insertProdukt("",10.0,1);
        //service.insertKategorie("");
        //Testdaten.TestdatenGenerieren();
        /*
        Testdaten.createKat();
        Testdaten.createProdukte(200);

        Testdaten.createKundenstamm(1000);
        Testdaten.createHistorie(10000,1000);*/
        Testdaten.testdatenGenerieren(10, 10, 100, 0.39);
    }
}
