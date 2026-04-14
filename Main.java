/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstname, lastname, username, password, phone;

        // Registration
        System.out.print("Enter first name: ");
        firstname = input.nextLine();

        System.out.print("Enter last name: ");
        lastname = input.nextLine();

        System.out.print("Enter username: ");
        username = input.nextLine();

        System.out.print("Enter password: ");
        password = input.nextLine();

        System.out.print("Enter phone Number (starting with SA international code (+27)): ");
        phone = input.nextLine();

        Login login = new Login();

        boolean validatePhone = login.checkCellphoneNumber(phone);
        boolean validateUsername = login.checkUsername(username);
        boolean validatePassword = login.checkPasswordComplexity(password);

        if (validateUsername) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted.");
        }

        if (validatePhone) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted.");
        }

        if (validatePassword) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password must be at least 8 characters long.");
        }

        // If registration successful → allow login
        if (validatePhone && validateUsername && validatePassword) {
            System.out.println("User successfully registered");

            // LOGIN SECTION
            System.out.println("\n--- LOGIN ---");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            if (login.loginUser(username, password, loginUsername, loginPassword)) {
                System.out.println("Login successful! Welcome " + firstname);
            } else {
                System.out.println("Login failed. Incorrect username or password.");
            }

        } else {
            System.out.println("User registration failed");
        }

        input.close();
    }
}

// Login class
class Login {

    public boolean checkCellphoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() >= 12;
    }

    public boolean checkUsername(String username) {
        return username.length() >= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8;
    }

    // NEW METHOD
    public boolean loginUser(String storedUsername, String storedPassword,
                             String enteredUsername, String enteredPassword) {
        return storedUsername.equals(enteredUsername) &&
               storedPassword.equals(enteredPassword);
    }
}
