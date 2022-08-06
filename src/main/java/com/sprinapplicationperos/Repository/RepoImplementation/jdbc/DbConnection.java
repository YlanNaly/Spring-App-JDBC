package com.sprinapplicationperos.Repository.RepoImplementation.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class DbConnection {
    Connection connex ;
    public DbConnection() {
        try{
            connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinema_app", "postgres","nalisoarab");
            System.out.println("good connection detected");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Statement getStatement() throws SQLException {
        return (Statement) connex.createStatement();
    }

}
