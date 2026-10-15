package lab2;

public class Person {
    private String name;
    private int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override //переопределяем встроенный toString для классов Object (если бы не переопределяли, то вышло бы что то такое lab2.Person@1b6d3586)
    public String toString() {
        return name + ", рост: " + height;
    }
}
