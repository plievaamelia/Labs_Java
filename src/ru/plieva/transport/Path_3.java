package ru.plieva.transport;

public class Path_3 {
    private City_3 destination;
    private int cost;

    public Path_3(City_3 destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public City_3 getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return destination.getName() + ":" + cost;
    }
}