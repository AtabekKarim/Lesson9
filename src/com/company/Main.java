package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int method = -1;
        while (method != 0) {
            System.out.println("1. Create user");
            System.out.println("2. Read user");
            System.out.println("0. Exit");
            method = scanner.nextInt();
            if (method == 1) {
                try {
                    FileWriter myWriter = new FileWriter("filename.txt", true);
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    while (name.length() < 3) {
                        System.out.println("This name could not be real. Please, write your real name: ");
                        name = scanner.next();
                    }
                    System.out.print("Enter your surname: ");
                    String surname = scanner.next();
                    while (surname.length() < 3) {
                        System.out.println("This surname could not be real. Please, write your real name: ");
                        surname = scanner.next();
                    }
                    System.out.print("Enter your age: ");
                    String age = scanner.next();
                    System.out.print("Write your email address: ");
                    String email = scanner.next();

                    myWriter.write(name + ", " + surname + ", " + age + ", " + email + "; " + "\n");
                    myWriter.close();
                    System.out.println("Successfully created new account.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            } else if (method == 2) {
                String data = "";
                try {
                    File myObj = new File("filename.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        data = data + myReader.nextLine();
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                System.out.println(data);
                String[] arr = data.split("[;]", 0);
                System.out.println("-----------------");
                for (int i=0;i< arr.length-1; i++){
                    String[] user = arr[i].split("[,]", 0);
                    System.out.println("Name: " + user[0]);
                    System.out.println("Surname: " + user[1]);
                    System.out.println("Age: " + user[2]);
                    System.out.println("Email: " + user[3]);
                    System.out.println("-----------------");
                }
            }
        }

    }

}
