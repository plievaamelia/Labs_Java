package lab2;

public class PersonName {
    private Name name;
    private int height;

    public PersonName(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}
