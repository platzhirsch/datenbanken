package com.company;

import java.sql.SQLException;
import java.util.Random;

public class Testdaten {


    public static void createProdukte(Integer anzahlProdukte) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        Random random = new Random();
        String size[] = {"","Unisize","Onsize","XXS kurz", "16/22","XXS lang", "64", "XS kurz", "17/23"," XS lang", "68", "S kurz","18/24","S lang", "72/90",
                "M kurz", "19/25", "M lang", "76/94",
                "L kurz","20/26","L lang","80/98",
                "XL kurz","21/27","XL lang","84	102",
                "XXL kurz","22/28","XXL lang","88/106",
                "3XL kurz","23/29","3XL lang","92/110",
                "4XL kurz","24/30","4XL lang","96/114",
                "5XL kurz","25/31","5XL lang","100/118",
                "6XL kurz","6/32","6XL lang","104/12"};
        String[] gender = {"", "Herren", "Damen", "Unisex", "Buben", "Mädchen", "Frauen", };
        String[] farbe = {"", "Blau", "Schwarz", "Grün","Gelb"};
        String[] produkte = {"Hose", "Schuhe", "Bluse", "Kette", "Pulli", "Basecap", "Socken", "Unterhemd", "Rucksack", "Unterwäsche", "Corthose"};
        String[] adjektiv = {"Superfancy","Megalit","Übelstgeil", "Brigitte", "Felix","Simon","JP", "Phill"};
        for (int i=0; i <= anzahlProdukte; i++){
            double preis = 1;
            String name = gender[random.nextInt(gender.length)] + " " + produkte[random.nextInt(produkte.length)] + " " + farbe[random.nextInt(farbe.length)] + " " + size[random.nextInt(size.length)] + " " + adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis,1);
        }

    }
    public void createKundenstamm(Integer anzahKunden, Integer anzahlGekauft, Integer anzahlGesehen){

    }
}
