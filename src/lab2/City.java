package lab2;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Path> paths;

    public City(String name) {
        this(name, new ArrayList<>());
    }

    public City(String name, List<Path> paths) {
        this.name = name;
        this.paths = paths;
    }

    public String getName() {
        return name;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void addPath(City destination, int cost) {
        paths.add(new Path(destination, cost));
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
}