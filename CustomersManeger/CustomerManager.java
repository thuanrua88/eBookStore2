package com.company.CustomersManeger;

import com.company.BookManager.Customers;
import com.company.BookManager.books;

import java.sql.*;
import java.util.Scanner;

public class CustomerManager {
    public static void insertCustorms() {
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
            com.company.BookManager.Customers customers = new Customers(0, 0, "", "", "");
            System.out.println("Enter id:");
            int id = scanner.nextInt();
            System.out.println("Enter level:");
            String level = scanner.next();
            System.out.println("Enter name:");
            String name = scanner.next();
            System.out.println("Enter phone:");
            String phone = scanner.next();
            System.out.println("Enter address:");
            String address = scanner.next();
            int count = statement.executeUpdate(
                    "insert into customermanagement values(" + id + ", '" + name + "', '" + phone + "','" + address + "'," + level +
                            ")");
            System.out.println(count + " records");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCustorms() {
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
            com.company.BookManager.Customers customers = new Customers(0, 0, "", "", "");
            System.out.println("Enter id need update:");
            customers.setId(scanner.nextInt());
            System.out.println("Enter email update:");
            customers.setName(scanner.next());
            System.out.println("Enter phone update:");
            customers.setPhone(scanner.next());
            System.out.println("Enter level update: (1,2 or 3)");
            customers.setLevel(scanner.nextInt());
            int count = statement.executeUpdate(
                    "update table customermanagement set Name = '" + customers.getName() + "', Phone='" +
                            customers.getPhone() + "', Level=" + customers.getLevel() + " where id=" + customers.getId());
            System.out.println(count + " records");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCustorms() {
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
                System.out.println("Không thể xóa vì người dùng đã có tên trong bảng order");
            } else {
                count = statement.executeUpdate(
                        "delete from customermanagement where CustomersID= " + id);
                System.out.println(count + " records");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void top100Custorms() {
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
            ResultSet resultSet = statement.executeQuery("select name from customermanagement limit 100");
            System.out.println("\t\t list of custormers top 100:");
            while (resultSet.next()) {
                String Name = resultSet.getString("name");
                System.out.println("\t\t    " + Name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
