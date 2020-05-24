package com.company;

import java.sql.SQLException;
import java.util.Random;

public class Testdaten {


    public static void testdatenGenerieren(Integer anzahlKunden, Integer anzahlDaten, Integer anzahlHistorie, Double prozentGekauft) throws SQLException, ClassNotFoundException {
       int anzahlGekauft = (int) (anzahlHistorie * prozentGekauft);
       int anzahlGesehen = anzahlHistorie-anzahlGekauft;

       System.out.println(anzahlGekauft);
       System.out.println(anzahlGesehen);
       createKat();
	   createProdukte(anzahlDaten);
	   createKundenstamm(anzahlKunden);
	   createHistorie(anzahlGesehen, anzahlGekauft);
    }

    public static void createProdukte(Integer anzahlProdukte) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        Random random = new Random();
        int iterationen = anzahlProdukte / 7;
        int anzahlProdukt1 = iterationen;   //PcProdukte     1000001
        int anzahlProdukte2 = iterationen;  //Mode           1000002
        int anzahlProdukte3 = iterationen;  //Werkzeug       1000003
        int anzahlProdukte4 = iterationen;  //Motrad         1000004
        int anzahlProdukte5 = iterationen;  //Fahrad         1000005
        int anzahlProdukte6 = iterationen;  //Sport          1000006
        int anzahlProdukte7 = iterationen;  //Tierprodukte   1000007


        //Allgemein
        String[] adjektiv = {"", "Adult", "Splash", "Best", "Outdoor", "Dreamteam", "Fresh", "Serios", "SuperFast", "SuperHot", "Solo", "Universal", "Advanced", "Home", "FullControll", "Ioxo", "X-Charge", "EuroPower", "Superfancy", "Megalit", "Übelstgeil", "Outdoor"};
        String[] farbe = {"", "Blau", "Schwarz", "Clear", "Grün", "Gelb", "Orange", "Khaki", "Sandfarben", "Bordeaux", "Black", "Kieferholz-Optik"};
        String[] produktnr = {"", "D500-" + "GK-" + "A-26", "DDR-2", "H298-", "RR29", "KK-", "DAL-", "SUJ-", "SAM-", "SGN-", "WQ-", "LAKA", "SAMA-", "ATHO-", "SAMs-", "B1", "U4", "N1"};
        String[] goetter = {"", "Spirit", "Jupiter", "Neptun", "Juno", "Ceres", "Apollo", "Diana", "Minerva", "Mars", "Venus", "Mercurius", "Vulcanus", "Vesta", "Bacchus", "Pluto", "Proserpina", "Herkules", "Iuventas", "Brigitte", "Felix", "Simon", "JP", "Phill", "Ultrasharp", "Classic"};

        //Pc Produkte
        String[] komponenten = {"Gaming Lightstip", "Gaming Ram", "RAM", "Gaming Arbeitsspeicher", "Gaming Motherboard", "Gaming Bildschirm", "Lüfter", "Netzteil", "Headset", "Gaming Headset", "Maus", "USB-Stick", "Festplatte", "Steckdosenleiste"};
        for (int i = 0; i < anzahlProdukt1; i++) {
            String nummer = "" + ((int) (Math.random() * 9000) + 1000);
            double preis = (int) ((Math.random() * 900) + 100) / 100.0;
            String name = komponenten[random.nextInt(komponenten.length)] + " " +
                    goetter[random.nextInt(goetter.length)] + " " +
                    produktnr[random.nextInt(produktnr.length)] + nummer + "  " +
                    farbe[random.nextInt(farbe.length)];
            service.insertProdukt(name, preis, 1000001);
        }

        //Mode
        String[] size = {"", "Slim", "Superslim", "Unisize", "Onsize", "XXS kurz", "16/22", "XXS lang", "64", "XS kurz", "17/23", " XS lang", "68", "S kurz", "18/24", "S lang", "72/90", "M kurz", "19/25", "M lang", "76/94", "L kurz", "20/26", "L lang", "80/98", "XL kurz", "21/27", "XL lang", "84	102", "XXL kurz", "22/28", "XXL lang", "88/106", "3XL kurz", "23/29", "3XL lang", "92/110", "4XL kurz", "24/30", "4XL lang", "96/114", "5XL kurz", "25/31", "5XL lang", "100/118", "6XL kurz", "6/32", "6XL lang", "104/12"};
        String[] gender = {"", "Herren", "Damen", "Unisex", "Buben", "Mädchen", "Frauen",};
        String[] produkte = {"Hose", "Schuhe", "Bluse", "Kette", "Pulli", "Basecap", "Socken", "Unterhemd", "Rucksack", "Unterwäsche", "Corthose"};
        for (int i = 0; i <= anzahlProdukte2; i++) {
            double preis = (int) ((Math.random() * 900) + 100) / 100.0;
            String name = gender[random.nextInt(gender.length)] + " " +
                    produkte[random.nextInt(produkte.length)] + " " +
                    farbe[random.nextInt(farbe.length)] + " " +
                    size[random.nextInt(size.length)] + " " +
                    adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis, 1000002);
        }

        //Werkzeuge
        String[] werkzeuge = {"Hammer", "Motorsäge", "Schlagbohrhammer", "Bewährungsstahl", "Werkbank", "Schraubendreher Kreuzschlitz", "Schraubenzieher Kreuzschlitz", "Polierwerkzeug", "Rasenmäher", "Hochbeet", "Mährobotter", "Hochdruckreiniger", "Kettensäge"};
        for (int i = 0; i < anzahlProdukte3; i++) {
            String nummer = "" + random.nextInt(900) + 100;
            double preis = (int) ((Math.random() * 900) + 100) / 100.0;
            String name = werkzeuge[random.nextInt(werkzeuge.length)] + " " +
                    produktnr[random.nextInt(produktnr.length)] + nummer + " " +
                    goetter[random.nextInt(goetter.length)] + " " +
                    adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis, 1000003);
        }

        //Motrad
        String[] motorad = {"Lederkombi", "Helm", "Handschuhe", "Lederhose", "Motoradbrille", "Funktionswäsche", "Motoradvisier", "Nierengurt", "Protektor", "Motoradstiefel", "Motoradschuhe", "Motoradsocke", "Sturmhaube", "Halswärmer"};
        for (int i = 0; i < anzahlProdukte4; i++) {
            double preis = (int) ((Math.random() * 9000) + 1000) / 100.0;
            String name = gender[random.nextInt(gender.length)] + " " +
                    motorad[random.nextInt(motorad.length)] + " " +
                    farbe[random.nextInt(farbe.length)] + " " +
                    size[random.nextInt(size.length)] + " " +
                    adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis, 1000004);
        }

        //Fahrräder
        String[] typfahrad = {"Mountenbike", "Rennrad", "Tracking", "Cityrad", "Dreirad", "Hardtail", "E-Bike", "Fixie"};
        for (int i = 0; i < anzahlProdukte5; i++) {
            double preis = (int) ((Math.random() * 9000) + 1000) / 100.0;
            String zoll = " Zoll " + random.nextInt((40 - 8) + 1) + 8;
            String name = gender[random.nextInt(gender.length)] + " " +
                    typfahrad[random.nextInt(typfahrad.length)] + " " +
                    zoll + " " + farbe[random.nextInt(farbe.length)] + " " +
                    adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis, 1000005);
        }

        //Sport
        String[] sport = {"Laufschuh", "Laufjacke", "Laufsocken", "Judo-Mantel", "Boxsack", "Boxhandschuhe", "Gymnastikanzug", "Turnanzug", "Badehose", "Speedo"};
        for (int i = 0; i < anzahlProdukte6; i++) {
            double preis = (int) ((Math.random() * 8000) + 2000) / 100.0;
            String name = gender[random.nextInt(gender.length)] + " " +
                    sport[random.nextInt(sport.length)] + " " +
                    size[random.nextInt(size.length)] + " " +
                    farbe[random.nextInt(farbe.length)] + " " +
                    adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis, 1000006);
        }

        //Tierprodukte
        String[] tiere = {"Elefanten", "Giraffen", "Tauben", "Schildkröten", "Alligatoren", "Kadsen", "Schlangen", "Streifenhörnchen", "Kugelfisch", "Goldfisch", "Raben", "Kapuzineräffchen", "Quacka", "Frosch", "Seelachs", "Wildlachs", "Hasen", "Windvogel"};
        String[] dinge = {"Futter", "Trockennahrung", "Nassfutter", "Lebendnahrung", "Käfig", "Bayby", "Mama", "Kind", "Mann", "Leckmatte", "Fressnapf", "Autotransportbox", "Decke", "Trinkbrunnen", "Stall", "Pflegeset", "Freilaufgehege", "Kuschelbett", "Ergänzungsfutter", "Tränke", "Futternapf"};
        for (int i = 0; i < anzahlProdukte7; i++) {
            double preis = (int) ((Math.random() * 900) + 100) / 10.0;
            String name = tiere[random.nextInt(tiere.length)] + " " +
                    dinge[random.nextInt(dinge.length)] + " " +
                    farbe[random.nextInt(farbe.length)] + " " +
                    adjektiv[random.nextInt(adjektiv.length)];
            service.insertProdukt(name, preis, 1000007);
        }
    }

    public static void createKundenstamm(Integer anzahKunden) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        Random random = new Random();
        String Vname[] = {"David", "lvis", "Ciaran", "Melvin", "Aaron", "Rahim", "Paki", "Matthew", "Rudyard", "Lance", "Ralph", "Raymond", "Aidan", "Lee", "Alan", "Han","Hannes","Randall", "Ciaram", "Quinn", "Lysandra", "Natalie", "Leilani", "Alana", "Karleigh", "Felix", "Jan-Patrick", "Philipp", "Simon",  "Britanni", "Camilla", "Charissa", "Yen", "Constance", "Vielka", "Kyla", "Simone", "Cherokee", "Gwendolyn", "Katelyn", "Brenna", "Ivory", "Clementine", "Willow", "Rina", "Adara", "Vivien", "Rowan", "Astra", "Lael", "Xantha", "Moana", "Azalia", "Camilla", "Priscilla", "Maisie", "Cora", "Lavinia", "Blair", "Ruby", "Virginia", "Hans", "Huber", "Simon", "Max", "Leonder", "Tim", "Steffi", "Carole", "Rhonda", "Ray", "Boba","Leia", "Bryce", "Francesca", "Luke", "Alfi", "Enfy", "Haley","Chloe","Oolav", "Winfried", "Samuel", "G�nther", "Alf", "Alan", "Michael", "Dieter", "Frank", "Anselm", "Urs", "Benedikt", "Tobias", "Nico", "Laura", "Lisa", "Isabell", "Anakin", "Obi-Wan", "Mace", "Osiris", "Ludwig", "Anna", "Lea", "Miriam", "Caroline", "Celina", "Luisa", "Luis", "Sebastian", "Marc", "Ahsoka", "Boba", "Padme", "Ivana", "Samira", "Muriel", "Angelika", "Sabrina", "Maxine", "Lina", "Denise", "Celine", "Pia", "Pedro", "Aaron", "Aurelian","Cosmo","Wanda","Gideon","Damian","Janne","Joel","Jonas","Josuha","Jeldrik","Kian","Silvian","Bodo","Fridolin","Gandalf"};
        String[] Nname = {"Bowman", "Patterson", "Landry", "Rojas", "Watson", "Burton", "Jhonston", "Barron", "Watts", "Estrada", "Patterson", "Blanchard", "Perez", "Pena", "Henderson", "Frazier", "Donovan", "Rogers", "Eberett", "Logan", "Rivas", "Montoya", "Rose", "Howe", "Wilson", "Dunn", "Good", "Mcclain", "Tailey", "Compton", "Allen", "Evans", "Whitaker", "Schwartz", "Munoz", "Ford", "Strecker", "Flassak", "Straub", "Bäurle", "Franco", "Hendrix", "Macias", "Hancock", "Guy", "Larson", "Sherman", "Newton", "Carter", "Joyner", "Mills", "Baxter", "Lynn", "Lee", "Randall", "Foreman", "Fields", "Mccarthy", "Johnson", "Gallegos", "Christensen", "Baskin", "Straub", "Baeuler", "Rosenhuber","Rebo", "Salacious", "Skywalker"};
        String[] domain = {
        		 /* Default domains included */
        		  "aol.com", "att.net", "comcast.net", "facebook.com", "gmail.com", "gmx.com", "googlemail.com",
        		  "google.com", "hotmail.com", "hotmail.co.uk", "mac.com", "me.com", "mail.com", "msn.com",
        		  "live.com", "sbcglobal.net", "verizon.net", "yahoo.com", "yahoo.co.uk",

        		  /* Other global domains */
        		  "email.com", "fastmail.fm", "games.com" /* AOL */, "gmx.net", "hush.com", "hushmail.com", "icloud.com",
        		  "iname.com", "inbox.com", "lavabit.com", "love.com" /* AOL */, "outlook.com", "pobox.com", "protonmail.ch", "protonmail.com", "tutanota.de", "tutanota.com", "tutamail.com", "tuta.io",
        		 "keemail.me", "rocketmail.com" /* Yahoo */, "safe-mail.net", "wow.com" /* AOL */, "ygm.com" /* AOL */,
        		  "ymail.com" /* Yahoo */, "zoho.com", "yandex.com",

        		  /* United States ISP domains */
        		  "bellsouth.net", "charter.net", "cox.net", "earthlink.net", "juno.com",

        		  /* British ISP domains */
        		  "btinternet.com", "virginmedia.com", "blueyonder.co.uk", "freeserve.co.uk", "live.co.uk",
        		  "ntlworld.com", "o2.co.uk", "orange.net", "sky.com", "talktalk.co.uk", "tiscali.co.uk",
        		  "virgin.net", "wanadoo.co.uk", "bt.com",

        		  /* Domains used in Asia */
        		  "sina.com", "sina.cn", "qq.com", "naver.com", "hanmail.net", "daum.net", "nate.com", "yahoo.co.jp", "yahoo.co.kr", "yahoo.co.id", "yahoo.co.in", "yahoo.com.sg", "yahoo.com.ph", "163.com", "yeah.net", "126.com", "21cn.com", "aliyun.com", "foxmail.com",

        		  /* French ISP domains */
        		  "hotmail.fr", "live.fr", "laposte.net", "yahoo.fr", "wanadoo.fr", "orange.fr", "gmx.fr", "sfr.fr", "neuf.fr", "free.fr",

        		  /* German ISP domains */
        		  "gmx.de", "hotmail.de", "live.de", "online.de", "t-online.de" /* T-Mobile */, "web.de", "yahoo.de",

        		  /* Italian ISP domains */
        		  "libero.it", "virgilio.it", "hotmail.it", "aol.it", "tiscali.it", "alice.it", "live.it", "yahoo.it", "email.it", "tin.it", "poste.it", "teletu.it",

        		  /* Russian ISP domains */
        		  "mail.ru", "rambler.ru", "yandex.ru", "ya.ru", "list.ru",

        		  /* Belgian ISP domains */
        		  "hotmail.be", "live.be", "skynet.be", "voo.be", "tvcablenet.be", "telenet.be",

        		  /* Argentinian ISP domains */
        		  "hotmail.com.ar", "live.com.ar", "yahoo.com.ar", "fibertel.com.ar", "speedy.com.ar", "arnet.com.ar",

        		  /* Domains used in Mexico */
        		  "yahoo.com.mx", "live.com.mx", "hotmail.es", "hotmail.com.mx", "prodigy.net.mx",

        		  /* Domains used in Canada */
        		  "yahoo.ca", "hotmail.ca", "bell.net", "shaw.ca", "sympatico.ca", "rogers.com",

        		  /* Domains used in Brazil */
        		  "yahoo.com.br", "hotmail.com.br", "outlook.com.br", "uol.com.br", "bol.com.br", "terra.com.br", "ig.com.br", "itelefonica.com.br", "r7.com", "zipmail.com.br", "globo.com", "globomail.com", "oi.com.br"
        };
        for (int i=0; i<= anzahKunden; i++){
            String vorname = Vname[random.nextInt(Vname.length)];
            String nachname = Nname[random.nextInt(Nname.length)];
            String name = vorname + " " + nachname;
            String mail = vorname + "." + nachname + "@" + domain[random.nextInt(domain.length)];
            service.insertKundenstamm(name, mail);
        }
    }

    public static void createKat() throws SQLException, ClassNotFoundException{
        //TODO Kategorien anlegen
        DatabaseService service = new DatabaseService();
        String proKat[] = {"Werkzeuge","Gaming","Motorrad","Fahrräder","Helme","Laufschuhe","Tiernahrung","Körperpflege","Getränke","Homöopathie","Tierprodukte","Frauenklamotten"};
        for (int i=0; i< proKat.length; i++){
            String proKatName = proKat[i];
            service.insertKategorie(proKatName);
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

                    for (int i = 0; i < anzahlAngesehen; i++) {
                        //Random Zahl mit max Anzahlkunden
                        int idKunde = (int) (Math.random() * anzKunden) + 1000000;
                        //Random Zahl mit max Anzahl Produkte
                        int idProdukt = (int) (Math.random() * anzProdukte) + 1000000;

                        //Historie-Element erzeugen
                        System.out.println("Kunde: " + idKunde + ", Produkt: " + idProdukt);
                        service.insertHistorie("Angesehen", idProdukt, idKunde);
                    }

                    for (int i = 0; i < anzahlGekauft; i++) {
                        //Random Zahl mit max Anzahlkunden
                        int idKunde = (int) (Math.random() * anzKunden) + 1000000;
                        //Random Zahl mit max Anzahl Produkte
                        int idProdukt = (int) (Math.random() * anzProdukte) + 1000000;

                        //Historie-Element erzeugen
                        System.out.println("Kunde: " + idKunde + ", Produkt: " + idProdukt);
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
