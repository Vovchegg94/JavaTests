package ru.netology;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        User.validateUser(User.getUserByLoginAndPassword(login, password));

        System.out.println("Доступ предоставлен");
    }
}

