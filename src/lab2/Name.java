package lab2;

public class Name {
    private String surname;
    private String name;
    private String lastname;

    public Name(String surname, String name, String lastname) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
    }

    public Name(String surname, String name) {
        this(surname, name, null);
    }

    public Name(String name) {
        this(null, name, null);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return lastname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.lastname = patronymic;
    }

    @Override
    public String toString() {
        if (surname != null && lastname != null) {
            return surname + " " + name + " " + lastname;
        }
        else if (surname != null) {
            return surname + " " + name;
        }
        else {
            return name;
        }
    }
}
