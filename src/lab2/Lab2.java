package lab2;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Lab2 {
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
                case "1.2":
                    runTask1_2();
                    break;
                case "1.3":
                    runTask1_3();
                    break;
                case "2.2":
                    runTask2_2();
                    break;
                case "3.3":
                    runTask3_3();
                    break;
                case "4.8":
                    runTask4_8();
                    break;
                case "5.5":
                    runTask5_5();
                    break;
                default:
                    System.out.println("Такой задачи нет!");
                    break;
            }
        }
    }

    public void runTask1_2() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите рост (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int height = scanner.nextInt();
        Person person = new Person(name, height);
        System.out.println(person);
        scanner.nextLine();
    }

    public void runTask1_3() {
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine().trim();
        System.out.println("Введите имя");
        String name = scanner.nextLine().trim();
        System.out.println("Введите отчество");
        String lastname = scanner.nextLine().trim();
        if (name.isEmpty()){
            System.out.println("Имя обязательно!");
            return;
        }
        else if (surname.isEmpty() && !(lastname.isEmpty())) {
            System.out.println("При указании отчества, фамилия обязательна!");
            return;
        }
        else if (surname.isEmpty()) {
            surname = null;
            lastname = null;
        }
        else if(lastname.isEmpty()) {
            lastname = null;
        }
        Name person = new Name(surname, name, lastname);
        System.out.println(person);
    }

    public void runTask2_2() {
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine().trim();
        System.out.println("Введите имя");
        String name = scanner.nextLine().trim();
        System.out.println("Введите отчество");
        String lastname = scanner.nextLine().trim();
        if (name.isEmpty()){
            System.out.println("Имя обязательно!");
            return;
        }
        else if (surname.isEmpty() && !(lastname.isEmpty())) {
            System.out.println("При указании отчества, фамилия обязательна!");
            return;
        }
        else if (surname.isEmpty()) {
            surname = null;
            lastname = null;
        }
        else if(lastname.isEmpty()) {
            lastname = null;
        }
        Name person = new Name(surname, name, lastname);
        System.out.print("Введите рост (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int height = scanner.nextInt();
        PersonName person_name = new PersonName(person, height);
        System.out.println(person_name);
        scanner.nextLine();
    }

    public void runTask3_3() {
        System.out.print("Хотите ввести вручную(1) или посмотреть готовый пример(2)? ");
        System.out.print("\nВаш выбор: ");
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
            System.out.print("Сколько городов? (от 1 до 20): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            int n = scanner.nextInt();
            scanner.nextLine();
            while (n < 1 || n > 20) {
                System.out.print("Число должно быть от 1 до 20, повторите: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Это не целое число!");
                    scanner.next();
                }
                n = scanner.nextInt();
                scanner.nextLine();
            }
            City[] cities = new City[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Имя города №" + (i + 1) + ": ");
                String name = scanner.nextLine().trim();
                while (name.isEmpty()) {
                    System.out.print("Имя не может быть пустым, введите снова: ");
                    name = scanner.nextLine().trim();
                }
                cities[i] = new City(name);
            }
            System.out.println("\nЗадайте пути. Формат: откуда, куда, цена.");
            while (true) {
                System.out.print("Откуда (0 — выход): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Это не целое число!");
                    scanner.next();
                }
                int from = scanner.nextInt();
                scanner.nextLine();
                if (from == 0) break;
                while (from < 1 || from > n) {
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Это не целое число!");
                        scanner.next();
                    }
                    from = scanner.nextInt();
                    scanner.nextLine();
                }
                System.out.print("Куда: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Это не целое число!");
                    scanner.next();
                }
                int to = scanner.nextInt();
                scanner.nextLine();
                while (to < 1 || to > n) {
                    System.out.print("Число должно быть от 1 до " + n + ", повторите: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Это не целое число!");
                        scanner.next();
                    }
                    to = scanner.nextInt();
                    scanner.nextLine();
                }
                System.out.print("Цена (натуральное число): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Это не целое число!");
                    scanner.next();
                }
                int cost = scanner.nextInt();
                scanner.nextLine();
                while (cost < 1) {
                    System.out.print("Цена должна быть натуральны числом от 1, повторите: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Это не целое число!");
                        scanner.next();
                    }
                    cost = scanner.nextInt();
                    scanner.nextLine();
                }
                cities[from - 1].addPath(cities[to - 1], cost);
            }
            System.out.println("\nИтоговая схема:");
            for (City c : cities) {
                System.out.println(c);
            }
        }
        else {
            City a = new City("A");
            City b = new City("B");
            City c = new City("C");
            City d = new City("D");
            City e = new City("E");
            City f = new City("F");

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

            System.out.println("Схема из рисунка 2:");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
            System.out.println(f);
        }

    }

    public void runTask4_8() {
        System.out.print("Хотите ввести вручную(1) или посмотреть готовый пример(2)? ");
        System.out.print("\nВаш выбор: ");
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
            System.out.println("Введите название города ");
            String name1 = scanner.nextLine().trim();
            City name_only = new City(name1);
            System.out.println("Город, созданный только с именем " + name_only);
            System.out.println("Введите название города ");
            String name2 = scanner.nextLine().trim();
            System.out.println("Введите связанные города ");
            System.out.println("Введите название первого города ");
            String city_path_1 = scanner.nextLine().trim();
            System.out.println("Введите название второго города ");
            String city_path_2 = scanner.nextLine().trim();
            City b = new City(city_path_1);
            City c = new City(city_path_2);
            List<Path> name2_Paths = new ArrayList<>();
            System.out.print("\nВведите стоимость дороги к первому городу: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            int cost1 = scanner.nextInt();
            name2_Paths.add(new Path(b, cost1));
            System.out.print("\nВведите стоимость дороги к второму городу: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            int cost2 = scanner.nextInt();
            name2_Paths.add(new Path(c, cost2));
            City a = new City(name2, name2_Paths);
            System.out.println("Город, созданный с именем и набором связей и стоимостей " + a);
        }
        else {
            City name_only = new City("N");
            System.out.println("Город, созданный только с именем " + name_only);
            City b = new City("B");
            City c = new City("C");
            List<Path> aPaths = new ArrayList<>();
            aPaths.add(new Path(b, 5));
            aPaths.add(new Path(c, 7));
            City a = new City("A", aPaths);
            System.out.println("Город, созданный с именем и набором связей и стоимостей " + a);
        }
    }

    public void runTask5_5() {
        System.out.print("Хотите ввести вручную(1) или посмотреть готовый пример(2)? ");
        System.out.print("\nВаш выбор: ");
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
            Fraction f1 = null;
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
                    f1 = new Fraction(num, den);
                } catch (IllegalArgumentException e) { // e - имя исключения, может называться и по другому
                    System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.\n");
                }
            }
            System.out.println("Создана дробь: " + f1);
            while (true) {
                System.out.println("\nВыберите операцию:");
                System.out.println("  1 - сложение");
                System.out.println("  2 - вычитание");
                System.out.println("  3 - умножение");
                System.out.println("  4 - деление");
                System.out.println("  0 - выход");
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
                        Fraction f2 = new Fraction(num2, den2);
                        if (op == 1) {
                            System.out.println("Результат: " + f1 + " + " + f2 + " = " + f1.sum_fraction(f2));
                        } else if (op == 2) {
                            System.out.println("Результат: " + f1 + " - " + f2 + " = " + f1.minus_fraction(f2));
                        } else if (op == 3) {
                            System.out.println("Результат: " + f1 + " * " + f2 + " = " + f1.mult_fraction(f2));
                        } else {
                            System.out.println("Результат: " + f1 + " / " + f2 + " = " + f1.division_fraction(f2));
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
                            System.out.println("Результат: " + f1 + " + " + value + " = " + f1.sum_value(value));
                        } else if (op == 2) {
                            System.out.println("Результат: " + f1 + " - " + value + " = " + f1.minus_value(value));
                        } else if (op == 3) {
                            System.out.println("Результат: " + f1 + " * " + value + " = " + f1.mult_value(value));
                        } else {
                            System.out.println("Результат: " + f1 + " / " + value + " = " + f1.division_value(value));
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
            Fraction f1 = new Fraction(1, 3);
            Fraction f2 = new Fraction(2, 3);
            Fraction f3 = new Fraction(3, 4);
            System.out.println("Созданные дроби:");
            System.out.println("  f1 = " + f1);
            System.out.println("  f2 = " + f2);
            System.out.println("  f3 = " + f3);
            System.out.println("\nПримеры операций:");
            System.out.println("  " + f1 + " + " + f2 + " = " + f1.sum_fraction(f2));
            System.out.println("  " + f1 + " - " + f2 + " = " + f1.minus_fraction(f2));
            System.out.println("  " + f1 + " * " + f2 + " = " + f1.mult_fraction(f2));
            System.out.println("  " + f1 + " / " + f2 + " = " + f1.division_fraction(f2));
            System.out.println("\nОперации с целым числом:");
            System.out.println("  " + f1 + " + 5 = " + f1.sum_value(5));
            System.out.println("  " + f1 + " - 5 = " + f1.minus_value(5));
            System.out.println("  " + f1 + " * 3 = " + f1.mult_value(3));
            System.out.println("  " + f1 + " / 3 = " + f1.division_value(3));
            Fraction expected = new Fraction(2, 9);
            Fraction actual = f1.mult_fraction(f2);
            System.out.println("\nПроверка 1/3 * 2/3 = 2/9:");
            System.out.println("  Результат: " + actual);
            System.out.println("  Совпадает: " + (actual.getNumerator() == expected.getNumerator() && actual.getDenominator() == expected.getDenominator()));
            System.out.println("\nЦепочка f1.sum(f2).div(f3).minus(5):");
            Fraction result = f1.sum_fraction(f2).division_fraction(f3).minus_value(5);
            System.out.println("  Результат: " + result);
        }
    }
}


