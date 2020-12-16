package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Admin {

    private  String username = "arifuzzaman";
    private  String password = "1234";

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String query = null;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




    void adminLogIn(String username,String password) throws IOException {

        if(this.username.equals(username) && this.password.equals(password))
        {
            System.out.println("Successfully login :)");
            System.out.println();
            Display_Method.adminControlPanel();
        }
        else
        {
            System.err.println("Error! Invalid username or password");
            Display_Method.menu();
        }
    }





    public void create(String tableName,AdminInsert adminInsert) throws IOException {
        try {

            connection = SqlConnector.getInstance();

            if (tableName.equals("category")) {
                query = "INSERT INTO " + tableName + "(categoryTitle,categoryDescription)" +
                        "values(?,?)";

                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, adminInsert.getCategoryTitle());
                preparedStatement.setString(2, adminInsert.getCategoryDescription());

                preparedStatement.executeUpdate();

                System.out.println("Successfully Inserted");

                Display_Method.adminControlPanel();


            }

            else if (tableName.equals("product")) {
                query = "INSERT INTO " + tableName + "(productCategory,productTitle,productPrice,productQuantity)" +
                        "values(?,?,?,?)";



                    preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, adminInsert.getProductCategory());
                    preparedStatement.setString(2, adminInsert.getProductTitle());
                    preparedStatement.setString(3, adminInsert.getProductPrice());
                    preparedStatement.setString(4, adminInsert.getProductQuantity());

                    preparedStatement.executeUpdate();
                    System.out.println("Successfully Inserted");
                    System.out.println();

                    Display_Method.adminControlPanel();




            }

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Error! to insert database");
            System.out.println();
            Display_Method.adminControlPanel();

        }
    }





    public void read(String tableName) throws IOException {

        try
        {
             connection = SqlConnector.getInstance();

             System.out.println("1.Show all information");
             System.out.println("2.Show selected information");
             System.out.println("Choose any one ");

             int n = Integer.parseInt(reader.readLine());

             if(n == 1 && tableName.equals("category"))
             {
                 query = "SELECT * FROM "+tableName;

                 statement = connection.createStatement();
                 resultSet = statement.executeQuery(query);


                 while (resultSet.next())
                 {
                     System.out.println("categoryTitle: "+resultSet.getString(2));
                     System.out.println("categoryDescription: "+resultSet.getString(3));
                     System.out.println();
                 }
                 Display_Method.adminControlPanel();
             }
             else if(n == 1 && tableName.equals("product"))
             {
                 query = "SELECT * FROM "+tableName;

                 statement = connection.createStatement();
                 resultSet = statement.executeQuery(query);

                 while (resultSet.next())
                 {
                     String productId = resultSet.getString(1);
                     String productCategory = resultSet.getString(2);
                     String productTitle = resultSet.getString(3);
                     String productPrice = resultSet.getString(4);
                     String productQuantity = resultSet.getString(5);

                     System.out.println("ProductId: "+productId);
                     System.out.println("productTitle: "+productTitle);
                     System.out.println("productCategory: "+productCategory);
                     System.out.println("productPrice: "+productPrice);
                     System.out.println("productQuantity: "+productQuantity);
                     System.out.println();
                 }
                 Display_Method.adminControlPanel();

             }
             else if(n == 2)
             {
                 System.out.println("Enter the column name: ");
                 String colName = reader.readLine();

                 query = "SELECT * FROM  product WHERE "+colName+" = ?";
                 preparedStatement = connection.prepareStatement(query);

                 System.out.println("Enter the column value: ");

                 preparedStatement.setString(1,reader.readLine());

                 resultSet = preparedStatement.executeQuery();

                 while(resultSet.next())
                 {
                     String productId = resultSet.getString(1);
                     String productCategory = resultSet.getString(2);
                     String productTitle = resultSet.getString(3);
                     String productPrice = resultSet.getString(4);
                     String productQuantity = resultSet.getString(5);

                     System.out.println("ProductId: "+productId);
                     System.out.println("productTitle: "+productTitle);
                     System.out.println("productCategory: "+productCategory);
                     System.out.println("productPrice: "+productPrice);
                     System.out.println("productQuantity: "+productQuantity);
                     System.out.println();

                 }
                 Display_Method.adminControlPanel();

             }



        }catch (SQLException e) {
            e.printStackTrace();

            System.err.println("Error! to insert database");
            Display_Method.adminControlPanel();

        }


    }


    public void update(String tableName,String setColumnName,String whereColumnName,String setValue , String whereValue) throws IOException {

        try {

            connection = SqlConnector.getInstance();

            query = "UPDATE "+tableName+" SET "+setColumnName+" = ? WHERE "+whereColumnName+" = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,setValue);
            preparedStatement.setString(2,whereValue);

            preparedStatement.executeUpdate();

            System.out.println("Successfully updated :)...");
            Display_Method.adminControlPanel();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error! to update database...Try again..");
            Display_Method.adminControlPanel();
        }

    }


    public void delete(String tableName) throws IOException {
        try {
            connection = SqlConnector.getInstance();

            System.out.println("1.Delete Table");
            System.out.println("2.Delete Table all information");
            System.out.println("3.Delete Table specific information");
            System.out.println("choose any one: ");
            int n = Integer.parseInt(reader.readLine());

            if(n == 1)
            {
                query = "DROP TABLE "+tableName;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("Successfully Delete");
                Display_Method.adminControlPanel();
            }
            else if(n == 2)
            {
                query = "DELETE FROM "+tableName;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("Successfully Delete");
                Display_Method.adminControlPanel();
            }
            else if(n == 3)
            {
                System.out.println("Enter the column name: ex:(always type unique column)");
                String colName = reader.readLine();

                query = "DELETE FROM "+tableName+" WHERE "+colName +"= ?";
                preparedStatement = connection.prepareStatement(query);

                System.out.println("Enter the column value: ex:(unique value)");
                //int value = Integer.parseInt(reader.readLine());
                String value = reader.readLine();

                preparedStatement.setString(1, value);
                preparedStatement.executeUpdate();
                System.out.println("Successfully Delete");
                Display_Method.adminControlPanel();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error!...Try again..");
            Display_Method.adminControlPanel();
        }

    }



}

