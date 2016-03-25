package com.epam.command.impl;

import com.epam.command.Command;
import com.epam.domain.User;
import com.epam.domain.UserRole;
import com.epam.exception.MovieException;
import com.epam.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Olga Bogutska on 09.02.2016.
 */
@Component
public class RegisterNewUser implements Command {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public String getName() {
        return "registerUser";
    }

    @Override
    public String getDescription() {
        return "Register new user";
    }

    @Override
    public UserRole getAllowedRole() {
        return UserRole.ANONYM;
    }

    @Override
    public void apply(BufferedReader reader, PrintStream outputStream) {
        try {
            outputStream.println("Enter user name: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            outputStream.println("Enter user role (ADMIN/CLIENT): ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String role = reader.readLine();
            outputStream.println("Enter user email: ");
            reader = new BufferedReader(new InputStreamReader(System.in));
            String email = reader.readLine();
            outputStream.println("Enter user birth date (dd-MM-yyyyyy):");

            String date = reader.readLine();
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyyyy");

            Date birthDate = formatter.parse(date);
            User user = new User(name, birthDate, UserRole.valueOf(role.toUpperCase()), email);
            userService.register(user);
            outputStream.println("User registered successfully ");

        } catch (IOException | MovieException e) {
            outputStream.println("Register new user produce an error " + e.getMessage());
        } catch (ParseException e) {
            outputStream.println("Invalid Date Format " + e.getMessage());
        }
    }
}
