package lab1;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class Lab1 {
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

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
                case "1.6":
                    runTask1_6();
                    break;
                case "1.7":
                    runTask1_7();
                    break;
                case "1.8":
                    runTask1_8();
                    break;
                case "1.9":
                    runTask1_9();
                    break;
                case "1.10":
                    runTask1_10();
                    break;
                case "2.6":
                    runTask2_6();
                    break;
                case "2.7":
                    runTask2_7();
                    break;
                case "2.8":
                    runTask2_8();
                    break;
                case "2.9":
                    runTask2_9();
                    break;
                case "2.10":
                    runTask2_10();
                    break;
                case "3.6":
                    runTask3_6();
                    break;
                case "3.7":
                    runTask3_7();
                    break;
                case "3.8":
                    runTask3_8();
                    break;
                case "3.9":
                    runTask3_9();
                    break;
                case "3.10":
                    runTask3_10();
                    break;
                case "4.6":
                    runTask4_6();
                    break;
                case "4.7":
                    runTask4_7();
                    break;
                case "4.8":
                    runTask4_8();
                    break;
                case "4.9":
                    runTask4_9();
                    break;
                case "4.10":
                    runTask4_10();
                    break;
                default:
                    System.out.println("Такой задачи нет!");
                    break;
            }
        }
    }

    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public void runTask1_6() {
        System.out.print("Введите символ из английского алфавита: ");
        String s = scanner.nextLine().trim();
        if (s.length() != 1) {
            System.out.println("Ошибка: нужно ввести ровно один символ.");
            return;
        }
        char x = s.charAt(0);
        boolean result = isUpperCase(x);
        System.out.println("Результат: " + result + "\n");
    }

    public boolean isInRange (int a, int b, int num) {
        if (a <= b) {
            if (num >= a && num <= b) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (num >= b && num <= a) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void runTask1_7() {
        System.out.print("Введите границу диапазона а (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int a = scanner.nextInt();
        System.out.print("Введите границу диапазона b (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int b = scanner.nextInt();
        System.out.print("Введите целое число: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int num = scanner.nextInt();
        boolean result = isInRange(a, b, num);
        System.out.println("Результат: " + result + "\n");
        scanner.nextLine();
    }

    public boolean isDivisor(int a, int b) {
        if (a % b == 0 || b % a == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void runTask1_8() {
        System.out.print("Введите a (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int a = scanner.nextInt();
        System.out.print("Введите b (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int b = scanner.nextInt();
        boolean result = isDivisor(a, b);
        System.out.println("Результат: " + result + "\n");
        scanner.nextLine();
    }

    public boolean isEqual(int a, int b, int c) {
        if (a == b && b == c) {
            return true;
        }
        else {
            return false;
        }
    }

    public void runTask1_9() {
        System.out.print("Введите а (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int a = scanner.nextInt();
        System.out.print("Введите b (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int b = scanner.nextInt();
        System.out.print("Введите c (целое число): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int c = scanner.nextInt();
        boolean result = isEqual(a, b, c);
        System.out.print("Результат: " + result + "\n");
        scanner.nextLine();
    }

    public int lastNumSum(int a, int b) {
        return a % 10 + b % 10;
    }

    public void runTask1_10(){
        System.out.print("Введите целое число: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int a = scanner.nextInt();
        System.out.print("Введите целое число: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int b = scanner.nextInt();
        int s = lastNumSum(a, b);
        for (int i = 0; i < 3; i++){
            System.out.print("Введите целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            a = scanner.nextInt();
            s = lastNumSum(s, a);
        }
        System.out.print("Итого " + s + "\n");
        scanner.nextLine();
    }

    public boolean sum3(int x, int y, int z) {
        if (x + y == z || x + z == y || z + y == x) {
            return true;
        }
        else {
            return false;
        }
    }

    public void runTask2_6() {
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.print("Введите целое число y: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int y = scanner.nextInt();
        System.out.print("Введите целое число z: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int z = scanner.nextInt();
        boolean result = sum3(x, y, z);
        System.out.print("Результат: " + result + "\n");
        scanner.nextLine();
    }

    public int sum2(int x, int y) {
        if ((x + y) >= 10 && (x + y) <= 19) {
            return 20;
        }
        else {
            return x + y;
        }
    }

    public void runTask2_7(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.print("Введите целое число y: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int y = scanner.nextInt();
        System.out.print(sum2(x, y) + "\n");
        scanner.nextLine();
    }

    public String age(int x) {
        if (x % 10 == 1 && x != 11) {
            return x + " год";
        }
        else if ((x % 10 == 2 || x % 10 == 3 || x % 10 == 4) && x != 12 && x != 13 && x != 14) {
            return x + " года";
        }
        else {
            return x + " лет";
        }
    }

    public void runTask2_8(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.print(age(x) + "\n");
        scanner.nextLine();
    }

    public String day(int x) {
        switch (x) {
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 7:
                return "Воскресенье";
            default:
                return "это не день недели";
        }
    }

    public void runTask2_9(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.print(day(x) + "\n");
        scanner.nextLine();
    }

    public String printDays(String x) {
        switch (x) {
            case "понедельник":
                return "понедельник" + "\n" + "вторник" + "\n" + "среда" + "\n" + "четверг" + "\n" + "пятница" + "\n" + "суббота" + "\n" + "воскресенье";
            case "вторник":
                return "вторник" + "\n" + "среда" + "\n" + "четверг" + "\n" + "пятница" + "\n" + "суббота" + "\n" + "воскресенье";
            case "среда":
                return "среда" + "\n" + "четверг" + "\n" + "пятница" + "\n" + "суббота" + "\n" + "воскресенье";
            case "четверг":
                return "четверг" + "\n" + "пятница" + "\n" + "суббота" + "\n" + "воскресенье";
            case "пятница":
                return "пятница" + "\n" + "суббота" + "\n" + "воскресенье";
            case "суббота":
                return "суббота" + "\n" + "воскресенье";
            case "воскресенье":
                return "воскресенье";
            default:
                return "Это не день недели или неправильный формат записи!";
        }
    }

    public void runTask2_10() {
        System.out.print("Введите день недели с маленькой буквы: ");
        String x = scanner.nextLine();
        System.out.print(printDays(x) + "\n");
        scanner.nextLine();
    }

    public boolean equalNum(int x) {
        while (x / 10 >= 1) {
            if ((x % 10) != ((x / 10) % 10)) {
                return false;
            }
            x = x / 10;
        }
        return true;
    }

    public void runTask3_6(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.print(equalNum(x) + "\n");
        scanner.nextLine();
    }

    public void square(int x) {
        for ( int i = 0; i < x; i++){
            System.out.print("*".repeat(x) + "\n");
        }
    }

    public void runTask3_7(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        square(x);
        scanner.nextLine();
    }

    public void leftTriangle (int x){
        for (int i = 1; i <= x; i++){
            System.out.print("*".repeat(i) + "\n");
        }
    }

    public void runTask3_8(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        leftTriangle(x);
        scanner.nextLine();
    }

    public void rightTriangle (int x){
        for (int i = 1; i <= x; i++){
            System.out.print(" ".repeat(x-i) + "*".repeat(i) + "\n");
        }
    }

    public void runTask3_9(){
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        rightTriangle(x);
        scanner.nextLine();
    }

    public void guessGame() {
        int number = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        int cnt = 0;
        while(cnt >= 0) {
            System.out.print("Введите число от 0 до 9: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            int x = scanner.nextInt();
            cnt++;
            if (x == number) {
                System.out.println("Вы отгадали число за " + cnt + " попыток!");
                cnt = -1;
            } else {
                System.out.println("Вы не угадали, введите число от 0 до 9: ");
            }
        }
        scanner.nextLine();
    }

    public void runTask3_10(){
        guessGame();
        scanner.nextLine();
    }

    public void reverse(int[] arr) {
        int[] new_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[arr.length - i - 1];
        }
        System.out.print("Результат: arr = { ");
        for (int i = 0; i < new_arr.length; i++){
            if (i == new_arr.length - 1) {
                System.out.print(new_arr[i] + " ");
            }
            else {
                System.out.print(new_arr[i] + ", ");
            }
        }
        System.out.print("}\n");
    }

    public void runTask4_6(){
        System.out.print("Введите целое число n размер массива: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Введите " + (i + 1) + "ое целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
        System.out.print("arr = { ");
        for (int i = 0; i < n; i++){
            if (i == n - 1) {
                System.out.print(arr[i] + " ");
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        reverse(arr);
        scanner.nextLine();
    }

    public int[] reverseBack (int[] arr) {
        int[] new_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[arr.length - i - 1];
        }
        return new_arr;
    }

    public void runTask4_7(){
        System.out.print("Введите целое число n размер массива: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Введите " + (i + 1) + "ое целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
        System.out.print("arr = { ");
        for (int i = 0; i < n; i++){
            if (i == n - 1) {
                System.out.print(arr[i] + " ");
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        int[] new_arr = reverseBack(arr);
        System.out.print("Результат: arr = { ");
        for (int i = 0; i < n; i++){
            if (i == n - 1) {
                System.out.print(new_arr[i] + " ");
            }
            else {
                System.out.print(new_arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        scanner.nextLine();
    }

    public int[] concat (int[] arr1,int[] arr2) {
        int[] new_arr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            new_arr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++){
            new_arr[i + arr1.length] = arr2[i];
        }
        return new_arr;
    }

    public void runTask4_8(){
        System.out.print("Введите целое число n1 размер первого массива arr1: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0; i < n1; i++){
            System.out.print("Введите " + (i + 1) + "ое целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            arr1[i] = scanner.nextInt();
        }
        System.out.print("Введите целое число n2 размер массива: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++){
            System.out.print("Введите " + (i + 1) + "ое целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            arr2[i] = scanner.nextInt();
        }
        System.out.print("arr1 = { ");
        for (int i = 0; i < n1; i++){
            if (i == n1 - 1) {
                System.out.print(arr1[i] + " ");
            }
            else {
                System.out.print(arr1[i] + ", ");
            }
        }
        System.out.print("}\n");
        System.out.print("arr2 = { ");
        for (int i = 0; i < n2; i++){
            if (i == n2 - 1) {
                System.out.print(arr2[i] + " ");
            }
            else {
                System.out.print(arr2[i] + ", ");
            }
        }
        System.out.print("}\n");
        int[] new_arr = concat(arr1, arr2);
        System.out.print("Результат: { ");
        for (int i = 0; i < new_arr.length; i++){
            if (i == new_arr.length - 1) {
                System.out.print(new_arr[i] + " ");
            }
            else {
                System.out.print(new_arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        scanner.nextLine();
    }

    public int[] findAll (int[] arr, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x) {
                list.add(i);
            }
        }
        int[] new_arr = list.stream().mapToInt(Integer::intValue).toArray();
        return new_arr;
    }

    public void runTask4_9(){
        System.out.print("Введите целое число n размер массива: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Введите " + (i + 1) + "ое целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
        System.out.print("Введите целое число x: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.print("arr = { ");
        for (int i = 0; i < n; i++){
            if (i == n - 1) {
                System.out.print(arr[i] + " ");
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        int[] new_arr = findAll(arr, x);
        System.out.print("Результат: { ");
        for (int i = 0; i < new_arr.length; i++){
            if (i == new_arr.length - 1) {
                System.out.print(new_arr[i] + " ");
            }
            else {
                System.out.print(new_arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        scanner.nextLine();
    }

    public int[] deleteNegative (int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] >= 0){
                list.add(arr[i]);
            }
        }
        int[] new_arr = list.stream().mapToInt(Integer::intValue).toArray();
        return new_arr;
    }

    public void runTask4_10() {
        System.out.print("Введите целое число n размер массива: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Это не целое число!");
            scanner.next();
        }
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите " + (i + 1) + "ое целое число: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не целое число!");
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
        System.out.print("arr = { ");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        int[] new_arr = deleteNegative(arr);
        System.out.print("Результат: { ");
        for (int i = 0; i < new_arr.length; i++) {
            if (i == new_arr.length - 1) {
                System.out.print(new_arr[i] + " ");
            } else {
                System.out.print(new_arr[i] + ", ");
            }
        }
        System.out.print("}\n");
        scanner.nextLine();
    }
}