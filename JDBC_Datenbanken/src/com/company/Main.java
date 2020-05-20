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
    	// Diese Funktion erzeugt unsere Testdaten
    	//Übergabeparameter sind: zahlKunden, anzahlDaten,  anzahlHistorie,  prozentGekauft
        Testdaten.testdatenGenerieren(1000000, 1000, 100, 0.11);
        
        //Important: Um zu gewährleisten, dass Historie immer erstellt werden kann sollte DB vor jeder erneuten Testedatengenerierung gedroppt werden
    }
}
