package com.company.CustomersManeger;

import GiftShop.insert.giftmodel.Gift;
import com.company.BookManager.books;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.Scanner;

public class BookController {
    public static void insert() {
        Scanner scanner = new Scanner(System.in);
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
            books books = new books(0, 0, "", "", 0);
            System.out.println("Enter id:");
            int id = scanner.nextInt();
            System.out.println("Enter title:");
            String title = scanner.next();
            System.out.println("Enter author:");
            String author = scanner.next();
            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            System.out.println("Enter quality:");
            int qty = scanner.nextInt();
            int count = statement.executeUpdate(
                    "insert into ebooks values(" + id + ", '" + title + "', '" + author + "'," + price + "," + qty +
                            ")");
            System.out.println(count + " records");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        Scanner scanner = new Scanner(System.in);
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
            books books = new books(0, 0, "", "", 0);
            System.out.println("Enter id need update:");
            int id = scanner.nextInt();
            System.out.println("Enter price update:");
            double price = scanner.nextDouble();
            System.out.println("Enter quality update:");
            int qty = scanner.nextInt();
            int count = statement.executeUpdate(
                    "update ebooks set price = " + price + ", " + "qty=" +
                            qty + " where id=" + id);
            System.out.println(count + " records");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Enter id need delete:");
            int id = scanner.nextInt();
            int count = 0;
            while (statement.executeQuery("select orderID from orderbook where orderID = " + id).next()
            ) {
                count++;break;
            }
            System.out.println(count);
            if (
                    count > 0
            ) {
                System.out.println("Không thể xóa vì sách đã có trong bảng order");
            } else {
                count = statement.executeUpdate(
                        "delete from ebooks where id= " + id);
                System.out.println(count + " records");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void top100Book() {
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
            ResultSet resultSet = statement.executeQuery("select title from ebooks limit 100");
            System.out.println("\t\t BookName top 100:");
            while (resultSet.next()) {
                String BookName = resultSet.getString("title");
                System.out.println("\t\t    " + BookName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
