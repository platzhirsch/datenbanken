package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseService service = new DatabaseService();
        service.insertProdukt("dildo",12.99,1);

    }
}
