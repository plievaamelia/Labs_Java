package ru.plieva.main;

//статический импорт, чтобы писать parseInt и pow без названий классов
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Power {
    public static double calculate(String strX, String strY) {
        //короткое имя parseInt вместо Integer.parseInt
        int x = parseInt(strX);
        int y = parseInt(strY);
        //короткое имя pow вместо Math.pow
        return pow(x, y);
    }
}

//javac -d out src/ru/plieva/main/*.java src/ru/plieva/math/*.java src/ru/plieva/transport/*.java src/ru/plieva/people/*.java
//javac - это команда компиляции, т.е. перевод кода джавы на компьютерный язык, -d - это directory направление куда этот перевод пойдет
//out - это название папки, где будет перевод, * - звездочка означает все файлы, .java - но только файлы написанные на джаве

//java -cp out ru.plieva.main.Main 2 5
//java - команда запуска готовой программы, -cp означает classpath (путь к классам), ищем путь к классам, откуда возьмем готовые файлы (из папки out)
//2 5 - аргументы X и Y