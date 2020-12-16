package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display_Method {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static DatabaseOperation_For_UserAccount databaseOperationForUserAccount = new DatabaseOperation_For_UserAccount();
    static Admin admin = new Admin();




    static void adminControlPanel() throws IOException {

        System.out.println();

        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Read");
        System.out.println("4. Delete");
        System.out.println("5. Menu");
        System.out.println("6. Exit");


        System.out.println("Choose any one: ");
        int a = Integer.parseInt(reader.readLine());

        switch (a)
        {
            case 1:
            {
                System.out.println("Enter the tableName: ");
                String tableName = reader.readLine();

                if(tableName.equals("category"))
                {
                    System.out.println("Enter the categoryTitle: ");
                    String categoryTitle = reader.readLine();

                    System.out.println("Enter the categoryDescription: ");
                    String categoryDescription = reader.readLine();

                    AdminInsert adminInsert = new AdminInsert(categoryTitle,categoryDescription);
                    admin.create(tableName,adminInsert);

                }
                else if(tableName.equals("product"))
                {
                    System.out.println("Enter the productCategory: ");
                    String productCategory = reader.readLine();

                    System.out.println("Enter the productTitle: ");
                    String productTitle = reader.readLine();

                    System.out.println("productPrice: ");
                    String productPrice = reader.readLine();

                    System.out.println("productQuantity");
                    String productQuantity = reader.readLine();

                    AdminInsert adminInsert = new AdminInsert(
                            productCategory,
                            productTitle,
                            productPrice,
                            productQuantity);

                    admin.create(tableName,adminInsert);

                }
                break;




            }
            case 2:
            {
                System.out.println("Enter the Table name: ");
                String tableName = reader.readLine();

                System.out.println("Enter the set column name: ");
                String setColumnName = reader.readLine();

                System.out.println("Enter the where column name: ");
                String whereColumnName = reader.readLine();

                System.out.println("Enter the set value: ");
                String setValue = reader.readLine();

                System.out.println("Enter the where value: ");
                String whereValue = reader.readLine();


                admin.update(tableName,setColumnName,whereColumnName,setValue,whereValue);
                break;
            }
            case 3:
            {
                System.out.println("Enter the tableName: ");
                String tableName = reader.readLine();;

                admin.read(tableName);
                break;
            }
            case 4:
            {
                System.out.println("Enter the table name :");
                String tableName = reader.readLine();


                admin.delete(tableName);
                break;
            }
            case 5:
            {
                menu();
                break;
            }
            case 6:
            {
                break;
            }

            default:
            {
                System.out.println("Please choose Correct Option!!");
                adminControlPanel();
            }
        }

    }











    static void admin() throws IOException {

        String username,password;

        System.out.println("Enter the username: ");
        username = reader.readLine();

        System.out.println("Enter the password: ");
        password = reader.readLine();

        admin.adminLogIn(username,password);

    }


    ///product
    static void product() throws IOException {
        System.out.println("Enter your category Title: (type all small letter)");
        String categoryTitle = reader.readLine();

        databaseOperationForUserAccount.categoryTitle(categoryTitle);
    }




    ///category...

    static void category() throws IOException {

        System.out.println("Welcome to our website "+ User.getUserName());
        System.out.println("__________________________________________");
        System.out.println();

        System.out.println("All Category: ");
        System.out.println("_____________");
        System.out.println();

        databaseOperationForUserAccount.showCategory();


        System.out.println();
        System.out.println("  1.menu");
        System.out.println("  2.Select category Title: ");
        System.out.println();

        System.out.println("  Choose anyone: ");


        String r = reader.readLine();
        int read = Integer.parseInt(r);


        if(read == 1)
        {
            menu();
        }
        else if(read == 2)
        {
            product();

        }


    }



    ///signIn...

    static void signIn() throws IOException {

        System.out.println("Enter your username: ");
        String username = reader.readLine();  ///Anishan

        System.out.println("Enter your password: ");
        String password = reader.readLine();  ///78789899

        User user = new User(username,password);
        databaseOperationForUserAccount.signIn(user);


    }




    //user account signup

    static void signup() throws IOException {

        System.out.println("Enter the firstName: ");
        String firstName = reader.readLine();

        System.out.println("Enter the lastName: ");
        String lastName = reader.readLine();

        System.out.println("Enter the userEmail: ");
        String userEmail = reader.readLine();

        System.out.println("Enter the userName: ");
        String userName = reader.readLine();

        System.out.println("Enter the userPassword: ");
        String userPassword = reader.readLine();


        User user = new User(firstName,lastName,userEmail,userName,userPassword);

        databaseOperationForUserAccount.signUp(user);


    }



    static void menu() throws IOException {

        System.out.println();

        System.out.println("1. SignUp");
        System.out.println("2. SignIn");
        System.out.println("3. Admin");
        System.out.println("4. Menu");
        System.out.println("5. Exit");
        System.out.println("Choose any one: ");
        int a = Integer.parseInt(reader.readLine());


        switch (a)
        {
            case 1:
            {
                signup();
                break;
            }
            case 2:
            {
                signIn();
                break;
            }
            case 3:
            {
                admin();
                break;
            }
            case 4:
            {
                menu();
            }
            case 5:
            {
                break;
            }
            default:
            {
                System.out.println("Please choose Correct Option!!");
                menu();
            }
        }
    }


}
