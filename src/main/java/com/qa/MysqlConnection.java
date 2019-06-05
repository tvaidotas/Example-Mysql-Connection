package com.qa;

import java.sql.*;

public class MysqlConnection {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/world?useLegacyDatetimeCode=false&serverTimezone=Europe/London";
    private final String user = "root";
    private final String password = "password";

    private Connection connection;

    public void tryConnection(){
        try{
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from city limit 10");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public Connection getConnection(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        try {
            connection.close();
        } catch (Error error) {
            System.out.println(error);
        }
    }



}
