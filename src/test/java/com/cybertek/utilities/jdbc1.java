package com.cybertek.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc1 {
    public static void main(String[] args) {

        String connectionStr ="jdbc:oracle:thin:@3.86.114.200:1521:XE";
        String username ="hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("Connection SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("Connection FAILED");
        }
    }
}
