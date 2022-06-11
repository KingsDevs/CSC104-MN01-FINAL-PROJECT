package com.csc104oop.shelves;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb 
{
    
    private static Connection conn;
    private static Statement statement;

    public static Statement getStatement() throws SQLException, IOException 
    {
        if(statement == null)
        {
            statement = getConnection().createStatement();
        }

        return statement;
    }

    public static Connection getConnection() throws IOException 
    {
        if(conn == null)
        {
            String dbUrl = App.getApplicationPath() + "/db/database.db";
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:/" + dbUrl);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    
        return conn;
    }
}
