
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
        //Testdaten.testdatenGenerieren(10000, 10000, 10000, 0.3);
    	

    	//Wie ist die Ansehen/Kaufen Ratio bei Kunde mit Email X?
    	System.out.println("Wie ist die Ansehen/Kaufen Ratio bei Kunde mit Email X?");
    	DatabaseService.queryTime("select count(his_status), his_status from his_historie hh join kun_kundenstamm on hh.his_kun_id = kun_id where kun_email =\"Moana.Blanchard@droptable.de\" group by his_status ");
    	
    	//Wie teuer sind Produkte die ein Kunde kauft/ansieht durchschnittlich?
    	System.out.println("Wie teuer sind Produkte die ein Kunde kauft/ansieht durchschnittlich?");
    	DatabaseService.queryTime("select avg(pro_preis), kun_name from his_historie hh join pro_produkte on hh.his_pro_id = pro_id join kun_kundenstamm on hh.his_kun_id = kun_id where kun_name = \"Alana Joyner\"");
    	
    	//Welche Produktkategorien hat Kunde mit Email X angesehen?
    	System.out.println("Welche Produktkategorien hat Kunde mit Email X angesehen?");
    	DatabaseService.queryTime("select kat_name, kun_email from his_historie hh join pro_produkte on hh.his_pro_id = pro_id join kat_kategorien on pro_kat_id = kat_id join kun_kundenstamm on hh.his_kun_id = kun_id where kun_email = \"Moana.Blanchard@droptable.de\" and his_status =\"Angesehen\" group by kat_name ");
    	
    	//Für welche Produkte X interessiert sich Kunde Y?
    	System.out.println("Für welche Produkte X interessiert sich Kunde Y?");
    	DatabaseService.queryTime("select pro_name, kun_name from his_historie hh join pro_produkte on hh.his_pro_id = pro_id join kun_kundenstamm on hh.his_kun_id = kun_id where kun_name = \"Azalia Larson\" and his_status = \"Angesehen\" group by pro_name");
    	
    	//Wie groß ist unser Kundenstamm?
    	System.out.println("Wie groß ist unser Kundenstamm?");
    	DatabaseService.queryTime("select count(*) from kun_kundenstamm kk");
    	
    	//Wieviele Produkte wurden am Tag X gekauft?
    	System.out.println("Wieviele Produkte wurden am Tag X gekauft?");
    	DatabaseService.queryTime("select count(*) from his_historie hh where his_status = \"Gekauft\" and his_zeitstempel like '%2020-05-20%'");
    	
    	//Wie oft wird ein Produkt X angesehen?
    	System.out.println("Wie oft wird ein Produkt X angesehen?");
    	DatabaseService.queryTime("select count (*), his_status from his_historie hh join pro_produkte on hh.his_pro_id = pro_id where his_status = \"Angesehen\" and pro_name = \"Unisex Rucksack Sandfarben 24/30 Adult\"");
    	   		
    	//Welche Kategorie läuft am besten?
    	System.out.println("Welche Kategorie läuft am besten?");
    	DatabaseService.queryTime("select kat_name, count(his_status) from his_historie hh join pro_produkte on hh.his_pro_id = pro_id join kat_kategorien on pro_produkte.pro_kat_id = kat_id group by kat_name order by count(his_status) desc");
    		 
    	//Wie ist das Angesehen/Verkauft Verhältnis bei Kategorie X?
    	System.out.println("Wie ist das Angesehen/Verkauft Verhältnis bei Kategorie X?");
    	DatabaseService.queryTime("select kat_name, count(his_status), his_status from his_historie hh join pro_produkte on hh.his_pro_id = pro_id join kat_kategorien on pro_produkte.pro_kat_id = kat_id where kat_name =\"Gaming\" group by his_status");
    	
        //Important: Um zu gewährleisten, dass Historie immer erstellt werden kann sollte DB vor jeder erneuten Testedatengenerierung gedroppt werden
    }
}