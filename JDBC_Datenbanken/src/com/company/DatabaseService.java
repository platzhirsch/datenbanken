package com.company;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<Double> preisList = new ArrayList<Double>();
    private ArrayList<Integer> kat_idList = new ArrayList<Integer>();

    public String insertProdukt(String name, Double preis, Integer kat_id) throws SQLException, ClassNotFoundException {
        nameList.add(name);
        preisList.add(preis);
        kat_idList.add(kat_id);
        Integer produkteQuery = 100;
        if (nameList.size() == produkteQuery) {
            String sqlinsertignore = "INSERT IGNORE INTO pro_produkte (pro_name, pro_preis, pro_kat_id) VALUES ";

            for (int i = 0; i < produkteQuery - 1; i++) {
                sqlinsertignore = sqlinsertignore + "(? , ? , ?), ";
            }
            Connection connection = ConnectionUtils.createNewConnection();
            sqlinsertignore = sqlinsertignore + " (? , ? , ?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlinsertignore);
            Integer a = 4;
            for (int i = 0; i < produkteQuery; i++) {
                if (i == 0) {
                    preparedStatement.setString(1, nameList.get(i));
                    preparedStatement.setDouble(2, preisList.get(i));
                    preparedStatement.setInt(3, kat_idList.get(i));
                } else {
                    preparedStatement.setString(0 + a, nameList.get(i));
                    preparedStatement.setDouble(1 + a, preisList.get(i));
                    preparedStatement.setInt(2 + a, kat_idList.get(i));
                    a = a + 3;
                }
            }
            nameList.clear();
            preisList.clear();
            kat_idList.clear();
            System.out.println(preparedStatement);
            preparedStatement.executeQuery();
            preparedStatement.close();
            connection.close();
        }
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
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) as total FROM "+ tablename);
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
    
    private ArrayList<String> statusList = new ArrayList<String>();
    private ArrayList<Integer> pro_idList = new ArrayList<Integer>();
    private ArrayList<Integer> kun_idList = new ArrayList<Integer>();
    private Integer statusQuery = 100;

    public void insertHistorie(String status, Integer pro_id, Integer kun_id) throws SQLException, ClassNotFoundException {
    	statusList.add(status);
    	pro_idList.add(pro_id);
    	kun_idList.add(kun_id);
        

        if (statusList.size() == statusQuery) {
            String sqlinsertignore = "INSERT IGNORE INTO his_historie (his_status, his_pro_id, his_kun_id) VALUES ";

            for (int i = 0; i < statusQuery - 1; i++) {
            	
                sqlinsertignore = sqlinsertignore + "(? , ? , ?), ";
            }
            Connection connection = ConnectionUtils.createNewConnection();
            sqlinsertignore = sqlinsertignore + " (? , ? , ?); ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlinsertignore);
            Integer a = 4;
            for (int i = 0; i < statusQuery; i++) {
                if (i == 0) {
                    preparedStatement.setString(1, statusList.get(i));
                    preparedStatement.setDouble(2, pro_idList.get(i));
                    preparedStatement.setInt(3, kun_idList.get(i));
                } else {
                    preparedStatement.setString(0 + a, statusList.get(i));
                    preparedStatement.setDouble(1 + a, pro_idList.get(i));
                    preparedStatement.setInt(2 + a, kun_idList.get(i));
                    a = a + 3;
                }
            }
            System.out.println("Die Historie wurde erweitert");
            statusList.clear();
            pro_idList.clear();
            kun_idList.clear();
            System.out.println(preparedStatement);
            preparedStatement.executeQuery();
            preparedStatement.close();
            connection.close();
        }
    	
    	
    	
    	
    }

}

