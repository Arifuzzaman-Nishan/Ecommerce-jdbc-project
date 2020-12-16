package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseOperation_For_UserAccount {


    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String query = null;
    private String psw;
    private String count ;
    private int cnt;


    public void signUp(User user) {


        try {
            connection = SqlConnector.getInstance();

            query = "INSERT INTO user(firstName,lastName,userEmail,userName,userPassword) values(?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, user.getFirstName());

            preparedStatement.setString(2, user.getLastName());

            preparedStatement.setString(3, user.getUserEmail());

            preparedStatement.setString(4, user.getUserName());

            preparedStatement.setString(5, user.getUserPassword());


            preparedStatement.executeUpdate();
            System.out.println("Signup Successfully...");

            Display_Method.menu();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Error to signUp");
        }
    }


    public void signIn(User user) throws IOException {

        try {

            connection = SqlConnector.getInstance();

            query = "SELECT userPassword FROM user WHERE userName = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getUserName());

            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                psw = resultSet.getString("userPassword"); ///78789899
            } else {
                System.out.println("Error! wrong userId");
                System.out.println();
                Display_Method.menu();
            }

            boolean b = user.getUserPassword().equals(psw);

            if (b) {
                System.out.println();
                System.out.println("Successfully login :)");
                System.out.println();
                Display_Method.category();
            } else {
                System.out.println("Error! Wrong Password");
                System.out.println();
                Display_Method.menu();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


   public void showCategory() {

        try {

            connection = SqlConnector.getInstance();
            query = "SELECT * FROM category";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            System.out.println("  categoryTitle    categoryDescription");
            System.out.println("  _____________     ___________________");


            while (resultSet.next()) {

                String categoryTitle = resultSet.getString(2);
                String categoryDescription = resultSet.getString(3);

                System.out.println("   " + categoryTitle + "           " + categoryDescription);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void categoryTitle(String categoryTitle) throws IOException {

        try {
            connection = SqlConnector.getInstance();
            query = "select * from product where productCategory = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,categoryTitle);

            resultSet = preparedStatement.executeQuery();


            while(resultSet.next())
            {
                ///String productCategory = resultSet.getString(2);
                String productTitle = resultSet.getString(3);
                String productPrice = resultSet.getString(4);
                String productQuantity = resultSet.getString(5);

                System.out.println();
                System.out.println("productTitle: "+productTitle);
                System.out.println("productPrice: "+productPrice);
                ///System.out.println("productCategory: "+productCategory);
                System.out.println("productQuantity: "+productQuantity);
                System.out.println();

            }

            System.out.println("1.Category");
            System.out.println("2.Menu");

            System.out.println("Please choose your option: ");
            int r = Integer.parseInt(reader.readLine());

            if(r == 1)
            {
                Display_Method.category();
            }
            else if(r == 2)
            {
                Display_Method.menu();
            }
            else
            {
                System.out.println("Wrong number input! please choose correct option ");
                categoryTitle(categoryTitle);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}



