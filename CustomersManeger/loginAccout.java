package com.company.CustomersManeger;

import GiftShop.insert.giftController.GiftController;

import java.sql.*;
import java.util.Scanner;

public class loginAccout {
    public void login() {
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
            System.out.println("Enter your user name:");
            String name = scanner.next();
            System.out.println("Enter your pass:");
            String pass = scanner.next();
            ResultSet resultSet = statement.executeQuery("select User, Pass from customers");
//            ResultSet pass = statement.executeQuery("Select Pass from customers");
//            ResultSet urname = statement.executeQuery("select User from customers where User ='" + customers.getUserName() + "'");
//            ResultSet urpass = statement.executeQuery("Select Pass from customers where pass ='" + customers.getPassWord() + "'");

            while (resultSet.next()) {
                if (name.equals(resultSet.getString("User")) && pass.equals(resultSet.getString("Pass"))) {
//                    System.out.println("Loggin\n Enter menu:" +
//                            "\n 1: Add book" +
//                            "\n 2: Update book" +
//                            "\n 3: Delete book" +
//                            "\n 4: Select top 100 books");
//
                    int i = 1, y = 1;

                    while (y > 0) {
                        System.out.println("1: Quản lý sản phẩm\t" +
                                "2: Quản lý khách hàng" +
                                "\n 3: end");
                        int numtow = scanner.nextInt();
                        switch (numtow) {
                            case 1:
                                System.out.println("Quản lý sản phẩm");
                                while (i > 0) {
                                    System.out.println("\n Enter menu:" +
                                            "\n 1: Add book" +
                                            "\n 2: Update book" +
                                            "\n 3: Delete book" +
                                            "\n 4: Select top 100 books" +
                                            "\n 5: end");
                                    int num = scanner.nextInt();
                                    switch (num) {
                                        case 1:
                                            System.out.println("");
                                            BookController.insert();

                                            break;
                                        case 2:
                                            BookController.update();

                                            break;
                                        case 3:
                                            BookController.delete();

                                            break;
                                        case 4:
                                            BookController.top100Book();
                                            break;
                                        case 5:
                                            System.out.println("end");
                                            i = -1; y = -1;
                                            break;
                                        default:
                                            System.out.println("Error");
                                            break;

                                    }
                                };
                                break;

                            case 2:
                                System.out.println("Quản lý khách hàng");
                                while (i > 0) {
                                    System.out.println(" Enter menu:" +
                                            "\n 1: Add Custormers" +
                                            "\n 2: Update Custormers" +
                                            "\n 3: Delete Custormers" +
                                            "\n 4: Select top 100 Custormers" +
                                            "\n 5: end");
                                    int num = scanner.nextInt();
                                    switch (num) {
                                        case 1:
                                            System.out.println("Insert");
                                            CustomerManager.insertCustorms();

                                            break;
                                        case 2:
                                            System.out.println("update");
                                            CustomerManager.updateCustorms();

                                            break;
                                        case 3:
                                            System.out.println("Delete");
                                            CustomerManager.deleteCustorms();

                                            break;
                                        case 4:
                                            System.out.println("Top 100:\n");
                                            CustomerManager.top100Custorms();

                                            break;
                                        case 5:
                                            System.out.println("end");
                                            i = -1; y = -1;
                                            break;
                                        default:
                                            System.out.println("Error");
                                            break;

                                    }
                                }
                                ;
                                break;
                            case 3:
                                System.out.println("end");
                                y = -1;
                                break;
                            default:
                                System.out.println("end");
                                y = -1;
                                break;
                        }
                    }
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
