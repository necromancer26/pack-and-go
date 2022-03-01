package com.company.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataSource {
    private Connection cnx;

    private String user = "root";
    private String password = "admin";
    private String url = "jdbc:mysql://localhost:3306/pack_and_go";

    private static DataSource instance;

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if(instance == null)
            instance = new DataSource();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
