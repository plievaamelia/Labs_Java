import lab1.Lab1;
import lab2.Lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab1 lab1 = new Lab1();
        Lab2 lab2 = new Lab2();

        while (true) {
            System.out.println("1 - Лабораторная №1");
            System.out.println("2 - Лабораторная №2");
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
                default:
                    System.out.println("Нет такого пункта. Введите 0, 1 или 2.");
                    break;
            }
        }
    }
}