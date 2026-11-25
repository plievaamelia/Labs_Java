package ru.plieva.main;

import ru.plieva.math.Fraction_3;
import ru.plieva.transport.City_3;
import ru.plieva.transport.Path_3;
import ru.plieva.transport.Route;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Lab3 {
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US); //чтобы в дробях ожидал точку, а не запятую

    public void run() {
        String input;
        System.out.println("Формат ввода задач - задание.задача");
        System.out.println("0 - выход");
        while (true) {
            System.out.println("Введите номер задачи (0 - для выхода): ");
            input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    return;
                case "1.4":
                    runTask1_4();
                    break;
                case "1.10":
                    runTask1_10();
                    break;
                case "2.5":
                    runTask2_5();
                    break;
                case "3.1":
                    runTask3_1();
                    break;
                case "4.2":
                    runTask4_2();
                    break;
                case "5.1":
                    runTask5_1();
                    break;
                case "6.5":
                    runTask6_5();
                    break;
                default:
                    System.out.println("Такой задачи нет!");
                    break;
            }
        }
    }

    public void runTask1_4(){
        System.out.println("Хотите ввести вручную(1) или посмотреть готовый пример(2)?");
        System.out.print("Ваш выбор: ");
        int choice;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Это не целое число! Повторите: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1 || choice == 2) break;
            System.out.print("Введите 1 или 2: ");
        }
        if (choice == 1) {
            Fraction_3 f1 = null;
            while (f1 == null) {//пока дробь не создастся
                System.out.print("Введите числитель первой дроби: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                int num = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите знаменатель первой дроби: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                int den = scanner.nextInt();
                scanner.nextLine();
                try {
                    f1 = new Fraction_3(num, den);
                } catch (IllegalArgumentException e) { // e - имя исключения, может называться и по другому
                    System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.\n");
                }
            }
            System.out.println("Создана дробь: " + f1);
            while (true) {
                System.out.println("\nВыберите операцию:");
                System.out.println("1 - сложение");
                System.out.println("2 - вычитание");
                System.out.println("3 - умножение");
                System.out.println("4 - деление");
                System.out.println("0 - выход");
                System.out.print("Ваш выбор: ");
                int op;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    op = scanner.nextInt();
                    scanner.nextLine();
                    if (op >= 0 && op <= 4) {
                        break;
                    }
                    System.out.print("Введите от 0 до 4: ");
                }
                if (op == 0) {
                    break; //выходим из цикла выбора операции, метод завершается, возвращается в меню с выбором задания
                }
                System.out.print("Операция с дробью(1) или с целым числом(2)? ");
                int type;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    type = scanner.nextInt();
                    scanner.nextLine();
                    if (type == 1 || type == 2) {
                        break;
                    }
                    System.out.print("Введите 1 или 2: ");
                }
                try { //чтобы не писать для каждой создаваемой дроби свой try catch, он здесь один на много сразу, тк реакция на все ошибки одинаковая - напечатать ошибку и продолжить
                    if (type == 1) {
                        System.out.print("Введите числитель второй дроби: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        int num2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Введите знаменатель второй дроби: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        int den2 = scanner.nextInt();
                        scanner.nextLine();
                        Fraction_3 f2 = new Fraction_3(num2, den2);
                        if (op == 1) {
                            System.out.println("Результат: " + f1 + " + " + f2 + " = " + f1.sum_fraction_3(f2));
                        } else if (op == 2) {
                            System.out.println("Результат: " + f1 + " - " + f2 + " = " + f1.minus_fraction_3(f2));
                        } else if (op == 3) {
                            System.out.println("Результат: " + f1 + " * " + f2 + " = " + f1.mult_fraction_3(f2));
                        } else {
                            System.out.println("Результат: " + f1 + " / " + f2 + " = " + f1.division_fraction_3(f2));
                        }
                    } else {
                        System.out.print("Введите целое число: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        int value = scanner.nextInt();
                        scanner.nextLine();
                        if (op == 1) {
                            System.out.println("Результат: " + f1 + " + " + value + " = " + f1.sum_value_3(value));
                        } else if (op == 2) {
                            System.out.println("Результат: " + f1 + " - " + value + " = " + f1.minus_value_3(value));
                        } else if (op == 3) {
                            System.out.println("Результат: " + f1 + " * " + value + " = " + f1.mult_value_3(value));
                        } else {
                            System.out.println("Результат: " + f1 + " / " + value + " = " + f1.division_value_3(value));
                        }
                    }
                    //читает catch сверху вниз и берет первый подходящий
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());// getMessage - метода во встроенном классе Throwable
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
        else {
            System.out.println("\nОбработка отрицательных значений:");
            Fraction_3 f_neg1 = new Fraction_3(1, -3);
            Fraction_3 f_neg2 = new Fraction_3(-1, -3);
            Fraction_3 f_neg3 = new Fraction_3(-1, 3);

            System.out.println("Создано из (1, -3): " + f_neg1 + "  (минус перенесен в числитель)");
            System.out.println("Создано из (-1, -3): " + f_neg2 + "  (минус на минус дает плюс)");
            System.out.println("Создано из (-1, 3): " + f_neg3);

            System.out.println("\nПроверка неизменяемости:");
            Fraction_3 f1 = new Fraction_3(1, 3);
            Fraction_3 f2 = new Fraction_3(2, 3);

            System.out.println("Исходные дроби: f1 = " + f1 + ", f2 = " + f2);

            Fraction_3 result = f1.sum_fraction_3(f2);
            System.out.println("Выполняем операцию сложения: f1 + f2");
            System.out.println("Результат: " + result + " (создался новый объект)");

            System.out.println("Проверяем исходные дроби после операции:");
            System.out.println("f1 = " + f1);
            System.out.println("f2 = " + f2);
            System.out.println("Исходные дроби остались прежними, их невозможно изменить.");

            System.out.println("\nОбработка ошибки (знаменатель = 0):");
            try {
                Fraction_3 bad = new Fraction_3(5, 0);
                System.out.println("Ошибка не поймана!");
            } catch (IllegalArgumentException e) {
                System.out.println("Поймано исключение: " + e.getMessage());
            }
            System.out.println("\n");
        }
    }


    public void runTask1_10() {
        System.out.println("Хотите ввести вручную(1) или посмотреть готовый пример(2)?");
        System.out.print("Ваш выбор: ");
        int choice;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Это не целое число! Повторите: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1 || choice == 2) break;
            System.out.print("Введите 1 или 2: ");
        }

        if (choice == 1) {//ручной ввод
            System.out.print("Сколько городов создать? (1-10): ");
            int n;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                n = scanner.nextInt();
                scanner.nextLine();
                if (n >= 1 && n <= 10) break;
                System.out.print("Число должно быть от 1 до 10, повторите: ");
            }

            City_3[] cities = new City_3[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Имя города №" + (i + 1) + ": ");
                String name = scanner.nextLine().trim();
                while (name.isEmpty()) {
                    System.out.print("Имя не может быть пустым, введите снова: ");
                    name = scanner.nextLine().trim();
                }
                cities[i] = new City_3(name);
            }

            while (true) {
                System.out.println("\nСписок городов:");
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " - " + cities[i].getName());
                }
                System.out.println("Действия:");
                System.out.println("1 - добавить дорогу");
                System.out.println("2 - удалить дорогу");
                System.out.println("0 - выход");
                System.out.print("Ваш выбор: ");

                int action;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    action = scanner.nextInt();
                    scanner.nextLine();
                    if (action >= 0 && action <= 2) break;
                    System.out.print("Введите от 0 до 2: ");
                }
                if (action == 0) break;

                System.out.print("Откуда (номер города): ");
                int from;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    from = scanner.nextInt();
                    scanner.nextLine();
                    if (from >= 1 && from <= n) break;
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                }

                System.out.print("Куда (номер города): ");
                int to;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    to = scanner.nextInt();
                    scanner.nextLine();
                    if (to >= 1 && to <= n) break;
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                }

                if (action == 1) {
                    System.out.print("Цена (целое положительное число): ");
                    int cost;
                    while (true) {
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        cost = scanner.nextInt();
                        scanner.nextLine();
                        if (cost >= 1) break;
                        System.out.print("Цена должна быть больше 0, повторите: ");
                    }
                    try {
                        cities[from - 1].addPath(cities[to - 1], cost);
                        System.out.println("Успешно добавлено.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                } else if (action == 2) {
                    try {
                        cities[from - 1].removePath(cities[to - 1]);
                        System.out.println("Успешно удалено.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }
            }

            System.out.println("\nИтоговая схема:");
            for (City_3 c : cities) {
                System.out.println(c);
            }

        } else {//готовый пример
            System.out.println("1. Создаем города A, B, C, D");
            City_3 a = new City_3("A");
            City_3 b = new City_3("B");
            City_3 c = new City_3("C");
            City_3 d = new City_3("D");

            System.out.println("2. Добавляем дорогу из A в B (цена 5)");
            a.addPath(b, 5);

            System.out.println("3. Создаем город E с заранее заданными путями (из E в A за 2, из E в D за 4)");
            List<Path_3> ePaths = new ArrayList<>();
            ePaths.add(new Path_3(a, 2));
            ePaths.add(new Path_3(d, 4));
            City_3 e = new City_3("E", ePaths);

            System.out.println("\nТекущее состояние:");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);

            System.out.println("\n4. Пробуем добавить дорогу из A в B еще раз (должна быть ошибка)");
            try {
                a.addPath(b, 10);
            } catch (IllegalArgumentException ex) {
                System.out.println("Поймана ошибка: " + ex.getMessage());
            }

            System.out.println("\n5. Удаляем дорогу из A в B");
            a.removePath(b);
            System.out.println("Состояние города A: " + a);

            System.out.println("\n6. Пробуем удалить несуществующую дорогу из A в C (должна быть ошибка)");
            try {
                a.removePath(c);
            } catch (IllegalArgumentException ex) {
                System.out.println("Поймана ошибка: " + ex.getMessage());
            }
        }
    }


    public void runTask2_5() {
        System.out.println("Хотите ввести вручную(1) или посмотреть готовый пример(2)?");
        System.out.print("Ваш выбор: ");
        int choice;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Это не целое число! Повторите: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1 || choice == 2) break;
            System.out.print("Введите 1 или 2: ");
        }

        if (choice == 1) { //ручной ввод
            System.out.print("Сколько городов создать? (1-10): ");
            int n;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                n = scanner.nextInt();
                scanner.nextLine();
                if (n >= 1 && n <= 10) break;
                System.out.print("Число должно быть от 1 до 10, повторите: ");
            }
            City_3[] cities = new City_3[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Имя города №" + (i + 1) + ": ");
                String name = scanner.nextLine().trim();
                while (name.isEmpty()) {
                    System.out.print("Имя не может быть пустым, введите снова: ");
                    name = scanner.nextLine().trim();
                }
                cities[i] = new City_3(name);
            }
            //цикл из 1.10
            while (true) {
                System.out.println("\nСписок городов:");
                for (int i = 0; i < n; i++) {
                    System.out.println("  " + (i + 1) + " - " + cities[i].getName());
                }
                System.out.println("Действия:");
                System.out.println("1 - добавить дорогу");
                System.out.println("2 - удалить дорогу");
                System.out.println("0 - закончить настройку графа");
                System.out.print("Ваш выбор: ");
                int action;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    action = scanner.nextInt();
                    scanner.nextLine();
                    if (action >= 0 && action <= 2) break;
                    System.out.print("Введите от 0 до 2: ");
                }
                if (action == 0) break;
                System.out.print("Откуда (номер города): ");
                int from;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    from = scanner.nextInt();
                    scanner.nextLine();
                    if (from >= 1 && from <= n) break;
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                }
                System.out.print("Куда (номер города): ");
                int to;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    to = scanner.nextInt();
                    scanner.nextLine();
                    if (to >= 1 && to <= n) break;
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                }
                if (action == 1) {
                    System.out.print("Цена (целое положительное число): ");
                    int cost;
                    while (true) {
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        cost = scanner.nextInt();
                        scanner.nextLine();
                        if (cost >= 1) break;
                        System.out.print("Цена должна быть больше 0, повторите: ");
                    }
                    try {
                        cities[from - 1].addPath(cities[to - 1], cost);
                        System.out.println("Успешно добавлено.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                } else if (action == 2) {
                    try {
                        cities[from - 1].removePath(cities[to - 1]);
                        System.out.println("Успешно удалено.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }
            }
            System.out.println("\nИтоговая схема графа:");
            for (City_3 c : cities) {
                System.out.println(c);
            }

            //ищем маршрут
            System.out.print("\nВведите номер города начала маршрута: ");
            int startIdx;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                startIdx = scanner.nextInt();
                scanner.nextLine();
                if (startIdx >= 1 && startIdx <= n) break;
                System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
            }

            System.out.print("Введите номер города конца маршрута: ");
            int endIdx;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                endIdx = scanner.nextInt();
                scanner.nextLine();
                if (endIdx >= 1 && endIdx <= n) break;
                System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
            }

            try {
                Route route = new Route(cities[startIdx - 1], cities[endIdx - 1]);
                System.out.println("Построенный маршрут: " + route);
                City_3[] arr = route.getRouteArray();
                System.out.println("Количество городов в пути: " + arr.length);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        } else { //готовый пример
            System.out.println("\nГотовый пример (граф из второй лабы)");
            City_3 a = new City_3("A");
            City_3 b = new City_3("B");
            City_3 c = new City_3("C");
            City_3 d = new City_3("D");
            City_3 e = new City_3("E");
            City_3 f = new City_3("F");

            a.addPath(b, 5);
            a.addPath(f, 1);
            a.addPath(d, 6);
            f.addPath(b, 1);
            f.addPath(e, 2);
            b.addPath(c, 3);
            b.addPath(a, 5);
            c.addPath(d, 4);
            c.addPath(b, 3);
            d.addPath(e, 2);
            d.addPath(a, 6);
            e.addPath(f, 2);

            System.out.println("Ищем маршрут из F в D");
            try {
                Route route = new Route(f, d);
                System.out.println("Результат: " + route);

                System.out.println("\nДемонстрация смены точки старта на A:");
                route.setStart(a);
                System.out.println("Новый маршрут из A в D: " + route);

                System.out.println("\nПроверка на null (должна быть ошибка):");
                try {
                    route.setEnd(null);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Поймана ошибка: " + ex.getMessage());
                }

            } catch (IllegalArgumentException ex) {
                System.out.println("Ошибка: " + ex.getMessage());
            }
        }
    }

    public void runTask3_1() {
        System.out.println("\nПри попытке создать подкласс Fraction_3, выйдет ошибка компиляции java: cannot inherit from final ru.plieva.math.Fraction_3");
//        класс MyFraction расширяет класс Fraction_3, то есть MyFraction — подкласс Fraction_3 и получает его доступные поля и методы.
//        class MyFraction extends Fraction_3 {}
    }

    public void runTask4_2() {
        Fraction_3 f = new Fraction_3(3, 4);
        System.out.println("Создана дробь: " + f);
        System.out.println("Вызов методов класса Number, переопределенных в дроби:");
        System.out.println("intValue() = " + f.intValue() + " (3/4 = 0 при целочисленном делении)");
        System.out.println("longValue() = " + f.longValue());
        System.out.println("floatValue() = " + f.floatValue());
        System.out.println("doubleValue() = " + f.doubleValue());
        System.out.println("Арифметика дробей работает:");
        Fraction_3 a = new Fraction_3(1, 2);
        Fraction_3 b = new Fraction_3(1, 3);
        System.out.println(a + " + " + b + " = " + a.sum_fraction_3(b));
        System.out.println();
    }

    public void runTask5_1() {System.out.println("Хотите ввести вручную(1) или посмотреть готовый пример(2)?");
        System.out.print("Ваш выбор: ");
        int choice;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Это не целое число! Повторите: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1 || choice == 2) break;
            System.out.print("Введите 1 или 2: ");
        }
        if (choice == 1) {
            System.out.print("Сколько чисел вы хотите сложить? (от 1 до 10): ");
            int n;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                n = scanner.nextInt();
                scanner.nextLine();
                if (n >= 1 && n <= 10) break;
                System.out.print("Число должно быть от 1 до 10, повторите: ");
            }
            Number[] numbers = new Number[n];
            for (int i = 0; i < n; i++) {
                System.out.println("\nЧисло " + (i + 1) + ":");
                System.out.println("1 - Целое число (int)");
                System.out.println("2 - Вещественное число (double)");
                System.out.println("3 - Дробь (Fraction_3)");
                System.out.print("Ваш выбор: ");
                int type;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    type = scanner.nextInt();
                    scanner.nextLine();
                    if (type >= 1 && type <= 3) break;
                    System.out.print("Введите от 1 до 3: ");
                }
                if (type == 1) {
                    System.out.print("Введите целое число: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    numbers[i] = scanner.nextInt();
                    scanner.nextLine();
                }
                else if (type == 2) {
                    System.out.print("Введите вещественное число (через точку): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Это не число! Повторите: ");
                        scanner.next();
                    }
                    numbers[i] = scanner.nextDouble();
                    scanner.nextLine();
                }
                else {
                    Fraction_3 f = null;
                    while (f == null) {
                        System.out.print("Введите числитель: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Введите знаменатель: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Это не целое число! Повторите: ");
                            scanner.next();
                        }
                        int den = scanner.nextInt();
                        scanner.nextLine();
                        try {
                            f = new Fraction_3(num, den);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.\n");
                        }
                    }
                    numbers[i] = f;
                }
            }
            System.out.println("\nРезультат сложения:" + Task5Methods.sumNumbers(numbers));
            System.out.println();
        }
        else {
            System.out.println("Метод принимает массив Number[] и суммирует их через doubleValue().\n");
            Number[] expr1 = { 2, new Fraction_3(3, 5), 2.3 };
            System.out.print("2 + 3/5 + 2.3 = ");
            System.out.println(Task5Methods.sumNumbers(expr1));
            Number[] expr2 = { 3.6, new Fraction_3(49, 12), 3, new Fraction_3(3, 2) };
            System.out.print("3.6 + 49/12 + 3 + 3/2 = ");
            System.out.println(Task5Methods.sumNumbers(expr2));
            Number[] expr3 = { new Fraction_3(1, 3), 1 };
            System.out.print("1/3 + 1 = ");
            System.out.println(Task5Methods.sumNumbers(expr3));
            System.out.println();
        }
    }

    //произошла путаница с нумерацией заданий. я второй вариант, в задании 6.5 требуют сравнить города из задания 3.3, но у меня нет в варианте задания 3.3 (только 3.1)
    //я сделала задание, без этого сравнения
    public void runTask6_5() {
        System.out.println("Хотите ввести вручную(1) или посмотреть готовый пример(2)?");
        System.out.print("Ваш выбор: ");
        int choice;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Это не целое число! Повторите: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1 || choice == 2) break;
            System.out.print("Введите 1 или 2: ");
        }

        if (choice == 1) { // Ручной ввод
            System.out.print("Сколько городов создать для сравнения? (2-10): ");
            int n;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                n = scanner.nextInt();
                scanner.nextLine();
                if (n >= 2 && n <= 10) break;
                System.out.print("Число должно быть от 2 до 10, повторите: ");
            }
            City_3[] cities = new City_3[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Имя города №" + (i + 1) + ": ");
                String name = scanner.nextLine().trim();
                while (name.isEmpty()) {
                    System.out.print("Имя не может быть пустым, введите снова: ");
                    name = scanner.nextLine().trim();
                }
                cities[i] = new City_3(name);
            }
            //цикл взят из 1.10
            System.out.println("\nТеперь настроим пути между городами (нажмите 0, чтобы закончить):");
            while (true) {
                System.out.println("\nСписок городов:");
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " - " + cities[i].getName());
                }
                System.out.println("1 - добавить дорогу");
                System.out.println("0 - закончить настройку и перейти к сравнению");
                System.out.print("Ваш выбор: ");
                int action;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    action = scanner.nextInt();
                    scanner.nextLine();
                    if (action == 0 || action == 1) break;
                    System.out.print("Введите 0 или 1: ");
                }
                if (action == 0) break;
                System.out.print("Откуда (номер города): ");
                int from;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    from = scanner.nextInt();
                    scanner.nextLine();
                    if (from >= 1 && from <= n) break;
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                }
                System.out.print("Куда (номер города): ");
                int to;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    to = scanner.nextInt();
                    scanner.nextLine();
                    if (to >= 1 && to <= n) break;
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                }
                System.out.print("Цена (целое положительное число): ");
                int cost;
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Это не целое число! Повторите: ");
                        scanner.next();
                    }
                    cost = scanner.nextInt();
                    scanner.nextLine();
                    if (cost >= 1) break;
                    System.out.print("Цена должна быть больше 0, повторите: ");
                }
                try {
                    cities[from - 1].addPath(cities[to - 1], cost);
                    System.out.println("Успешно добавлено.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
            System.out.println("\nИтоговая схема графа:");
            for (City_3 c : cities) {
                System.out.println(c);
            }
            //выбор городов для сравнения взят из 2.5
            System.out.println("\nВыберите два города для сравнения их путей:");
            System.out.print("Номер первого города: ");
            int city_num1;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                city_num1 = scanner.nextInt();
                scanner.nextLine();
                if (city_num1 >= 1 && city_num1 <= n) break;
                System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
            }
            System.out.print("Номер второго города: ");
            int city_num2;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.print("Это не целое число! Повторите: ");
                    scanner.next();
                }
                city_num2 = scanner.nextInt();
                scanner.nextLine();
                if (city_num2 >= 1 && city_num2 <= n) break;
                System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
            }
            City_3 c1 = cities[city_num1 - 1];
            City_3 c2 = cities[city_num2 - 1];
            System.out.println("\nГород 1: " + c1);
            System.out.println("Город 2: " + c2);
            System.out.println("Результат сравнения: " + c1.equals(c2));
            System.out.println();
        } else { //готовый пример
            System.out.println("Создаем два города с разными именами, но одинаковыми путями");
            City_3 city1 = new City_3("Москва");
            City_3 dest1 = new City_3("Тверь");
            city1.addPath(dest1, 500);
            City_3 city2 = new City_3("Питер");
            City_3 dest2 = new City_3("Тверь");
            city2.addPath(dest2, 500);
            System.out.println("Город 1: " + city1);
            System.out.println("Город 2: " + city2);
            System.out.println("Результат сравнения: " + city1.equals(city2) + " (ожидается true, так как пути одинаковые)\n");
            System.out.println("Поменяем цену дороги от второго города:");
            city2.removePath(dest2);
            city2.addPath(dest2, 600);
            System.out.println("Город 1: " + city1);
            System.out.println("Город 2: " + city2);
            System.out.println("Результат сравнения: " + city1.equals(city2) + " (ожидается false, так как цены разные)\n");
        }
    }

    //в 8.4 задании требуется изменить сущность Точка из задания 6.2, но этого задания у меня в варианте 2 нет.
    //если посмотреть на все задания 8 раздела, то можно увидеть, что они все ссылаются на задания, которых у меня нет в варианте
}
