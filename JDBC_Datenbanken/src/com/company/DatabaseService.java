package com.company;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {



    public String insertKategorie(String name) throws SQLException, ClassNotFoundException{
        Connection connection = ConnectionUtils.createNewConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from kat_kategorien where kat_name=\"" + name + "\"");

        if (resultSet.next()) {
            System.out.println("Kategorie: " + resultSet.getString("kat_name")+" existiert bereits");
        } else {
            String sql = "INSERT INTO kat_kategorien (kat_name)"
                    + "VALUES(\"" + name + "\")";
            statement.executeUpdate(sql);
            System.out.println("Kategorie: " + name + " erstellt");
        }

        return null;
    }

    public String insertProdukt(String name, Double preis, Integer kat_id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        // existiert bereits?
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from pro_produkte where pro_name=\"" + name + "\" AND pro_preis=\"" + preis + "\" AND pro_kat_id=\"" + kat_id + "\"");

        if (resultSet.next()) {
            //existiert
            System.out.println("Produkt: " + resultSet.getString("pro_name") + " existiert bereits");
        } else {
            //erstellen
            String sql = "Insert INTO pro_produkte (pro_name, pro_preis, pro_kat_id)"
                    + "VALUES (\"" + name + "\", \"" + preis + "\", \"" + kat_id + "\")";
            statement.executeUpdate(sql);
            System.out.println("Produkt: " + name + " erstellt");

        }
        resultSet.close();
        statement.close();
        connection.close();
        return null;
    }
}

