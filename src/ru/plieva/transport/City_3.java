package ru.plieva.transport;

import java.util.ArrayList;
import java.util.List;

public class City_3 {
    private String name;
    private List<Path_3> paths;

    public City_3(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public City_3(String name, List<Path_3> paths) {
        this.name = name;
        this.paths = new ArrayList<>(paths);
    }

    public String getName() {
        return name;
    }

    public List<Path_3> getPaths() {
        return paths;
    }

    //добавление дороги с проверкой на дубликат
    public void addPath(City_3 destination, int cost) {
        for (int i = 0; i < paths.size(); i++) {
            Path_3 p = paths.get(i);
            if (p.getDestination().getName().equals(destination.getName())) {
                throw new IllegalArgumentException("Дорога из " + name + " в " + destination.getName() + " уже существует!");
            }
        }
        paths.add(new Path_3(destination, cost));
    }

    //удаление дороги
    public void removePath(City_3 destination) {
        boolean removed = false;
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).getDestination().getName().equals(destination.getName())) {
                paths.remove(i);
                removed = true;
                break; //выходим из цикла, так как дорога может быть только одна
            }
        }
        if (!removed) {
            throw new IllegalArgumentException("Дороги из " + name + " в " + destination.getName() + " не существует!");
        }
    }

    @Override
    public String toString() {
        if (paths.isEmpty()) return name;
        StringBuilder sb = new StringBuilder(name).append(": ");
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i));
            if (i < paths.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //если вдруг мы сравниваем один и тот же город сам с собой, то возвращаем true сразу, не сравнивая пути
        if (!(obj instanceof City_3)) return false; //если переданный объект городом не является, то false
        City_3 other_city = (City_3) obj; //так как мы убедились что этот объект это город, то переопределяем его в город, чтобы иметь доступ к его полям. (City_3) - уточняет тип данных
        if (this.paths.size() != other_city.paths.size()) return false;//сравниваем количество дорог каждого города, если оно разное, то смысла их проверять дальше нет
        for (Path_3 p : this.paths) {//проходимся по списку путей города, с которым сравниваем
            boolean found = false;
            for (Path_3 otherP : other_city.paths) {//проходимся по списку путей города, который сравниваем
                if (p.getDestination().getName().equals(otherP.getDestination().getName()) && p.getCost() == otherP.getCost()) {//сравниваем названия городов "назначения" и стоимость дороги туда
                    found = true;
                    break;//нашли пару - выходим из внутреннего цикла
                }
            }
            if (!found) return false;
        }
        return true;
    }

    //если переопределять equals, то нужен новый хэшкод
    //хэш-код это то, что должно совпадать у двух объектов если они одинаковы,
    //в данном случае взяла количество путей, потому что по заданию не сказано, что города должны называться одинаково,
    //а у равных городов (с одинаковыми путями) размер списков будет одинаковым
    @Override
    public int hashCode() {
        return paths.size();
    }
}
