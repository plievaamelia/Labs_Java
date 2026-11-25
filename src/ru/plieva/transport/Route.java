package ru.plieva.transport;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private City_3 start;
    private City_3 end;

    public Route(City_3 start, City_3 end) {
        if (start == null) throw new IllegalArgumentException("Дорога не может быть без начала!");
        if (end == null) throw new IllegalArgumentException("Дорога не может быть без конца!");
        this.start = start;
        this.end = end;
    }

    public City_3 getStart() {
        return start;
    }

    public void setStart(City_3 start) {
        if (start == null) {
            throw new IllegalArgumentException("Начальный город не может быть null!");
        }
        this.start = start;
    }

    public City_3 getEnd() {
        return end;
    }

    public void setEnd(City_3 end) {
        if (end == null) {
            throw new IllegalArgumentException("Конечный город не может быть null!");
        }
        this.end = end;
    }

    //возвращает массив городов (маршрут)
    public City_3[] getRouteArray() {
        List<City_3> path = new ArrayList<>();
        List<City_3> visited = new ArrayList<>();
        if (findRoute(start, end, path, visited)) {
            City_3[] result = new City_3[path.size()];
            for (int i = 0; i < path.size(); i++) {
                result[i] = path.get(i);
            }
            return result;
        }
        return new City_3[0]; //пустой массив, если маршрута нет
    }

    //рекурсивный поиск
    private boolean findRoute(City_3 current, City_3 end, List<City_3> path, List<City_3> visited) {
        path.add(current);//добавляем текущий город в наш маршрут
        visited.add(current);//отмечаем текущий город как «посещенный», чтобы больше сюда не возвращаться

        if (current == end) {
            return true; //дошли до конца маршрута, маршрут готов
        }

        List<Path_3> currentPaths = current.getPaths();//берем список всех дорог, которые выходят из текущего города, чтобы понять, куда можно пойти дальше.
        for (int i = 0; i < currentPaths.size(); i++) {//проверяем все дороги из текущего города
            City_3 nextCity = currentPaths.get(i).getDestination();//город, в который ведет дорога из текущего города
            //проверяем по списку visited, были ли мы уже в городе nextCity
            boolean alreadyVisited = false;
            for (int j = 0; j < visited.size(); j++) {
                if (visited.get(j) == nextCity) {
                    alreadyVisited = true;
                    break;
                }
            }
            //если мы этот соседний город (nextCity) к текущему проверяемому городу (current) еще не проверяли входит ли он в маршрут, то ищем маршрут начиная с nextCity
            if (!alreadyVisited) {
                if (findRoute(nextCity, end, path, visited)) {
                    return true;
                }
            }
        }
        //если мы дошли до этой строки, значит цикл for завершился, и мы так и не нашли маршрут по всем доступным дорогам от current, значит, этот город — тупик
        path.remove(path.size() - 1); //если тупик, убираем город из маршрута
        return false;
    }

    @Override
    public String toString() {
        City_3[] route = getRouteArray();
        if (route.length == 0) {
            return "Маршрут не найден";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < route.length; i++) {
            sb.append(route[i].getName());
            if (i < route.length - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}