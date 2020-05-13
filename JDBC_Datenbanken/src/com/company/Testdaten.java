package com.company;

import java.sql.SQLException;
import java.util.Random;

public class Testdaten {


    public static void TestdatenGenerieren(Integer anzahlKunden, Integer anzahlDaten, Integer prozentGekauft, Integer prozentGesehen) throws SQLException, ClassNotFoundException {
       int anzahlGekauft = (anzahlDaten * (prozentGekauft/100));
       int anzahlGesehen = (anzahlDaten * (prozentGesehen/100));
        createKat();
        createProdukte(anzahlDaten);
        createKundenstamm(anzahlKunden);
        createHistorie(anzahlGesehen, anzahlGekauft);
    }

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
        String[] farbe = {"", "Blau", "Schwarz", "Grün","Gelb", "Orange", "Khaki", "Sandfarben", "Bordeaux"};
        String[] produkte = {"Hose", "Schuhe", "Bluse", "Kette", "Pulli", "Basecap", "Socken", "Unterhemd", "Rucksack", "Unterwäsche", "Corthose"};
        String[] adjektiv = {"Superfancy","Megalit","Übelstgeil", "Brigitte", "Felix","Simon","JP", "Phill"};
        for (int i=0; i <= anzahlProdukte; i++){
            double preis = 1;
            String name = gender[random.nextInt(gender.length)] + " " + produkte[random.nextInt(produkte.length)] + " " + farbe[random.nextInt(farbe.length)] + " " + size[random.nextInt(size.length)] + " " + adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis,1000000);

            //TODO Kategorie zurodnen
        }

    }
    
    public static void createKundenstamm(Integer anzahKunden) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        Random random = new Random();
        String Vname[] = {"David", "Elvis", "Ciaran", "Melvin", "Aaron", "Rahim", "Paki", "Matthew", "Rudyard", "Lance", "Ralph", "Raymond", "Aidan", "Lee", "Alan", "Randall", "Ciaram", "Quinn", "Lysandra", "Natalie", "Leilani", "Alana", "Karleigh", "Felix", "Jan-Patrick", "Philipp", "Simon",  "Britanni", "Camilla", "Charissa", "Yen", "Constance", "Vielka", "Kyla", "Simone", "Cherokee", "Gwendolyn", "Katelyn", "Brenna", "Ivory", "Clementine", "Willow", "Rina", "Adara", "Vivien", "Rowan", "Astra", "Lael", "Xantha", "Moana", "Azalia", "Camilla", "Priscilla", "Maisie", "Cora", "Lavinia", "Blair", "Ruby", "Virginia", };
        String[] Nname = {"Bowman", "Patterson", "Landry", "Rojas", "Watson", "Burton", "Jhonston", "Barron", "Watts", "Estrada", "Patterson", "Blanchard", "Perez", "Pena", "Henderson", "Frazier", "Donovan", "Rogers", "Eberett", "Logan", "Rivas", "Montoya", "Rose", "Howe", "Wilson", "Dunn", "Good", "Mcclain", "Tailey", "Compton", "Allen", "Evans", "Whitaker", "Schwartz", "Munoz", "Ford", "Strecker", "Flassak", "Straub", "Bäurle", "Franco", "Hendrix", "Macias", "Hancock", "Guy", "Larson", "Sherman", "Newton", "Carter", "Joyner", "Mills", "Baxter", "Lynn", "Lee", "Randall", "Foreman", "Fields", "Mccarthy", "Johnson", "Gallegos", "Christensen"};
        String[] domain = {"gmail", "outlook", "dhbw-stuttgart", "web", "online", "gmx", "info", "private", "localhost", "lost"};
        for (int i=0; i<= anzahKunden; i++){
            String vorname = Vname[random.nextInt(Vname.length)];
            String nachname = Nname[random.nextInt(Nname.length)];
            String name = vorname + " " + nachname;
            String mail = vorname + "." + nachname + "@" + domain[random.nextInt(domain.length)] + ".de";
            service.insertKundenstamm(name, mail);
        }
    }

    public static void createKat() throws SQLException, ClassNotFoundException{
        //TODO Kategorien anlegen
        DatabaseService serv = new DatabaseService();
        String proKat[] = {"Werkzeuge","Gaming","Motorrad","Fahrräder","Helme","Laufschuhe","Tiernahrung","Körperpflege","Getränke","Homöopathie","Tierprodukte","Frauenklamotten"};
        for (int i=0; i< proKat.length; i++){

            String proKatName = proKat[i];
            serv.insertKategorie(proKatName);
        }
       
    }

    public static void createHistorie(Integer anzahlAngesehen, Integer anzahlGekauft) throws SQLException, ClassNotFoundException{
        try {
            DatabaseService service = new DatabaseService();
            //Prüfen ob Kunden exisitieren
            if (service.existsKunden()) {
                //Prüfen ob Produkte exitieren
                if (service.existsProdukte()) {

                    int anzProdukte = service.getAnzahl("pro_produkte");
                    int anzKunden = service.getAnzahl("kun_kundenstamm");

                    for (int i = 0; i <= anzahlAngesehen; i++) {
                        //Random Zahl mit max Anzahlkunden
                        int idKunde = (int) (Math.random() * anzKunden) + 1000000;
                        //Random Zahl mit max Anzahl Produkte
                        int idProdukt = (int) (Math.random() * anzProdukte) + 1000000;

                        //Historie-Element erzeugen
                        service.insertHistorie("Angesehen", idProdukt, idKunde);
                    }

                    for (int i = 0; i <= anzahlGekauft; i++) {
                        //Random Zahl mit max Anzahlkunden
                        int idKunde = (int) (Math.random() * anzKunden) + 1000000;
                        //Random Zahl mit max Anzahl Produkte
                        int idProdukt = (int) (Math.random() * anzProdukte) + 1000000;

                        //Historie-Element erzeugen
                        service.insertHistorie("Gekauft", idProdukt, idKunde);
                    }

                } else {
                    //Throw new Exception
                    throw new RuntimeException("Historie kann nicht erstellt werden. Keine Produkte vorhanden.");
                }
            } else {
                //Throw new Exception
                throw new RuntimeException("Historie kann nicht erstellt werden. Keine Kunden vorhanden.");
            }
        } catch(RuntimeException e){
            System.out.println(e);
        }
    }
}
