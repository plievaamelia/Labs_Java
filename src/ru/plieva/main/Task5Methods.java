package ru.plieva.main;

public class Task5Methods {
    public static double sumNumbers(Number[] numbers) {
        double total = 0;
        for (Number n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }
}
