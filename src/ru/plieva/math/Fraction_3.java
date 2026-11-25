package ru.plieva.math;

//добавили final перед классом, чтобы от него нельзя было наследоваться (3_1)
public final class Fraction_3 extends Number{ //класс Fraction_3 как дополнение (т.е. подкласс) класса Number
    private final int numerator; //поле final — дробь нельзя изменить после создания (1_4)
    private final int denominator;

    public Fraction_3(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулём!");
        }
        //если знаменатель отрицательный, переносим минус в числитель
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator_3() {
        return numerator;
    }

    public int getDenominator_3() {
        return denominator;
    }

    public Fraction_3 sum_fraction_3(Fraction_3 a) {
        int num = this.numerator * a.denominator + a.numerator * this.denominator;
        int den = this.denominator * a.denominator;
        return new Fraction_3(num, den);
    }

    public Fraction_3 sum_value_3(int value) {
        return sum_fraction_3(new Fraction_3(value, 1));
    }

    public Fraction_3 minus_fraction_3(Fraction_3 a) {
        int num = this.numerator * a.denominator - a.numerator * this.denominator;
        int den = this.denominator * a.denominator;
        return new Fraction_3(num, den);
    }

    public Fraction_3 minus_value_3(int value) {
        return minus_fraction_3(new Fraction_3(value, 1));
    }

    public Fraction_3 mult_fraction_3(Fraction_3 a) {
        int num = this.numerator * a.numerator;
        int den = this.denominator * a.denominator;
        return new Fraction_3(num, den);
    }

    public Fraction_3 mult_value_3(int value) {
        return mult_fraction_3(new Fraction_3(value, 1));
    }

    public Fraction_3 division_fraction_3(Fraction_3 a) {
        if (a.numerator == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        int num = this.numerator * a.denominator;
        int den = this.denominator * a.numerator;
        return new Fraction_3(num, den);
    }

    public Fraction_3 division_value_3(int value) {
        return division_fraction_3(new Fraction_3(value, 1));
    }

    //переопределяем методы класса Number так, чтобы они подходили для дробей
    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
