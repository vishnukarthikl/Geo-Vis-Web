package com.vishnukl.model;

public class Lion {
    private final String name;
    private final double x;
    private final double y;

    public Lion(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return name + " (" + x + ", " + y + ")";
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
