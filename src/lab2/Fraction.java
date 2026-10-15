package lab2;

public class Fraction {
    private int numerator; //числитель
    private int denominator; //знаменатель

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулём!"); //throw - команда (такая же, как if, for и тд) прерывает выполнение метода, new создаёт новый объект класса исключения. IllegalArgumentException - тип исключения, когда неверно задан аргумент (встроенный класс в стандартную библиотеку)
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator()   {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction sum_fraction(Fraction a) {
        int num = this.numerator * a.denominator + a.numerator * this.denominator;
        int den = this.denominator * a.denominator;
        return new Fraction(num, den);
    }

    public Fraction sum_value(int value) {
        return sum_fraction(new Fraction(value, 1));
    }

    public Fraction minus_fraction(Fraction a) {
        int num = this.numerator * a.denominator - a.numerator * this.denominator;
        int den = this.denominator * a.denominator;
        return new Fraction(num, den);
    }

    public Fraction minus_value(int value) {
        return minus_fraction(new Fraction(value, 1));
    }

    public Fraction mult_fraction(Fraction a) {
        int num = this.numerator * a.numerator;
        int den = this.denominator * a.denominator;
        return new Fraction(num, den);
    }

    public Fraction mult_value(int value) {
        return mult_fraction(new Fraction(value, 1));
    }

    public Fraction division_fraction(Fraction a) {
        if (a.numerator == 0) {
            throw new ArithmeticException("Деление на ноль!"); // ArithmeticException - тип исключения, когда ломается арифметика
        }
        int num = this.numerator * a.denominator;
        int den = this.denominator * a.numerator;
        return new Fraction(num, den);
    }

    public Fraction division_value(int value) {
        return division_fraction(new Fraction(value, 1));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

