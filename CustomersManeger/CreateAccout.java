package com.company.CustomersManeger;

import java.sql.*;
import java.util.Scanner;

public class CreateAccout {
    public void CreatAcc() {
        Scanner scanner = new Scanner(System.in);
        Customers customers = new Customers();
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement statement = connection.createStatement();
        ) {
            System.out.println("Enter your user name:\n");
            customers.setUserName(scanner.next());
            System.out.println("Enter your password:");
            customers.setPassWord(scanner.next());
            System.out.println(customers.getPassWord() + customers.getUserName());
            statement.executeUpdate("insert into customers(User, Pass, Role) values('" + customers.getUserName() + "', '" + customers.getPassWord() + "', 30)");
            System.out.println("Creat Accout success");
            ResultSet resultSet = statement.executeQuery("select * from customers");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID") + "\t\t" +
                        resultSet.getString("User") + "\t\t" +
                        resultSet.getString("Pass") + "\t\t" +
                        "Member");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
