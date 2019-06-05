package com.qa;

import java.sql.*;

public class Main
{
    public static void main( String[] args ) throws SQLException
    {
        // try connection
        MysqlConnection mysqlConnection = new MysqlConnection();
        mysqlConnection.tryConnection();
        System.out.println("-------------------------------------------------");

        // try a statement execution
        Connection connection = mysqlConnection.getConnection();
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery("select * from city limit 10");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));


        // close connection
        mysqlConnection.closeConnection();
    }
}
