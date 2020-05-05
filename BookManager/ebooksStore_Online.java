package com.company.BookManager;

import java.sql.*;

public class ebooksStore_Online {
    public static void myTable() {
        String myTable = "id(INT) \t title(VARCHAR) \t author(VARCHAR) \t price(FLOAT) \t qty(INT)";
        System.out.println(myTable);
    }

    public static void exercises0() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        "");
                Statement statement = connection.createStatement();
        ) {
            String strSelect = "select title, price, qty from ebooks";
//            Incho for debugging
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet resultSet = statement.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records  = " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exercises1_1() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement statement = connection.createStatement();
        ) {
            String strSelect = "select * from ebooks";
//            Phuc vu cho debug:
            System.out.println("The SQl statement is: " + strSelect);
            ResultSet resultSet = statement.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int i = 0;
            myTable();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                int id = resultSet.getInt("id");
                String author = resultSet.getString("author");
                System.out.println(id +
                        "\t \t  " + title + "\t\t" +
                        "\t \t  " + author + "\t" +
                        "\t \t" + price + "\t" +
                        "\t \t" + qty);
                ++i;
            }
            System.out.println("Total numer of records = " + i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exercises1_2() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement statement = connection.createStatement();
        ) {
            String strSelect = "select title, price from ebooks WHERE author = 'Dang Kim thi'";
            ResultSet resultSet = statement.executeQuery(strSelect);
            int i = 0;
            System.out.println("title \t author");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                System.out.println(title + "\t  " + price);
                i++;
            }
            System.out.println("Total number of records = " + i);
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    public static void exercise1_3() {
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
            String strSelect = "select title, author, price, qty FROM ebooks WHERE author = 'Kim Thi Dang' OR price >= 5" +
                    " ORDER BY price DESC, id ASC";

            System.out.println("The SQL statement is: " + strSelect);
            ResultSet resultSet = statement.executeQuery(strSelect);
            int i = 0;
            System.out.println("title \t\t author \t\t\t price \t\t qty ");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int qty = resultSet.getInt("qty");
                double price = resultSet.getDouble("price");
                System.out.println(title +
                        "\t\t " + author +
                        "\t\t  " + price +
                        "\t\t  " + qty);
                i++;
            }
            System.out.println("Total numer of records = " + i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exercises0();
        System.out.println("1.1:");
        exercises1_1();
        System.out.println("1.2:");
        exercises1_2();
        System.out.println("1.3:");
        exercise1_3();
    }
}

