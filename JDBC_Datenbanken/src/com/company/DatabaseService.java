package com.company;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {



    public String insertKategorie(String name) throws SQLException, ClassNotFoundException{
        Connection connection = ConnectionUtils.createNewConnection();
        String sql = "select * from kat_kategorien" + " where kat_name= ?";
         //Prepered Statements vor https://bobby-tables.com/ schutz 
        PreparedStatement statement = connection.prepareStatement(sql); 
        statement.setString(1, name);
        //System.out.println(statement);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Kategorie: " + resultSet.getString("kat_name")+" existiert bereits");
        } else {
            sql = "INSERT INTO kat_kategorien (kat_name)" + "VALUES(?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Kategorie: " + name + " erstellt");
        }
        resultSet.close();
        statement.close();
        connection.close();
        return null;
    }

    public String insertProdukt(String name, Double preis, Integer kat_id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        // existiert bereits?
        String sql = "select * from pro_produkte" +  " where pro_name= ?  AND pro_preis= ? AND pro_kat_id= ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setDouble(2, preis);
        statement.setInt(3, kat_id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            //existiert
            System.out.println("Produkt: " + resultSet.getString("pro_name") + " existiert bereits");
        } else {
            //erstellen
             //sql = "Insert INTO pro_produkte (pro_name, pro_preis, pro_kat_id)" + "VALUES ( + ? + , \"" + preis + "\", \"" + kat_id + "\")";
        	sql = "Insert INTO pro_produkte (pro_name, pro_preis, pro_kat_id)"
                    + " VALUES ( ?  ,  ?  , ? )";
        	statement = connection.prepareStatement(sql);
        	statement.setString(1, name);
        	statement.setDouble(2, preis);
        	statement.setInt(3, kat_id);
            statement.executeUpdate();
            System.out.println("Produkt: " + name + " erstellt");

        }
        resultSet.close();
        statement.close();
        connection.close();
        return null;
    }
    
    public String insertKundenstamm(String name, String mail) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        String sql = "select * from kun_kundenstamm" + " where kun_name= ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            //existiert
            System.out.println("Kunde: " + resultSet.getString("kun_name") + " existiert bereits");
        } else {
            //erstellen
            sql = "Insert INTO kun_kundenstamm (kun_name, kun_email)"
                    + " VALUES (? , ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, mail);
            statement.executeUpdate();
            System.out.println("Kunde: " + name + " erstellt");

        }
        resultSet.close();
        statement.close();
        connection.close();
        return null;
    }

    public boolean existsKunden() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        String sql = "select * from kun_kundenstamm";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        boolean result;

        if (resultSet.next()) {
            //existiert
            result = true;
        } else {
            result = false;
        }

        resultSet.close();
        statement.close();
        connection.close();
        return result;
    }

    public boolean existsProdukte() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        String sql = "select * from pro_produkte";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        boolean result;

        if (resultSet.next()) {
            //existiert
            result = true;
        } else {
            result = false;
        }

        resultSet.close();
        statement.close();
        connection.close();
        return result;
    }

    public Integer getAnzahl(String tablename) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        String sql = "SELECT COUNT(*) as total FROM ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, tablename);
        ResultSet resultSet = statement.executeQuery();
        int result;

        if (resultSet.next()) {
            result = resultSet.getInt("total");
        } else {
            result = 0;
        }
        resultSet.close();
        statement.close();
        connection.close();
        return result;
    }

    public void insertHistorie(String status, Integer pro_id, Integer kun_id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.createNewConnection();
        //erstellen
       
        String sql = "Insert INTO his_historie (his_status, his_pro_id, his_kun_id)"
        	       + "VALUES (?, ?, ?)"; 
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, status);
        statement.setInt(2, pro_id);
        statement.setInt(2, kun_id);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("Neues" + status + "es in Historie erstellt");
        
        resultSet.close();
        statement.close();
        connection.close();
    }

}

