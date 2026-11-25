package ru.plieva.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println("Задача 7.3. Возведение в степень");
            try {
                // Вызываем метод из класса Power
                double result = Power.calculate(args[0], args[1]);
                System.out.println("Результат " + args[0] + " в степени " + args[1] + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы командной строки должны быть целыми числами!");
            }
            return; //завершаем работу, чтобы не запустилось меню
        }
        Scanner scanner = new Scanner(System.in);
        Lab1 lab1 = new Lab1();
        Lab2 lab2 = new Lab2();
        Lab3 lab3 = new Lab3();
        while (true) {
            System.out.println("1 - Лабораторная №1");
            System.out.println("2 - Лабораторная №2");
            System.out.println("3 - Лабораторная №3");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Это не целое число! Повторите: ");
                scanner.next();
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                case 1:
                    lab1.run();
                    break;
                case 2:
                    lab2.run();
                    break;
                case 3:
                    lab3.run();
                    break;
                default:
                    System.out.println("Нет такого пункта. Введите 0 - 3.");
                    break;
            }
        }
    }
}