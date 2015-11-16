package com.vishnukl.model;

public class Pond {
    private String name;
    private final double centerX;
    private final double centerY;
    private final double radius;

    public Pond(String name, double centerX, double centerY, double radius) {
        this.name = name;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return name + "(" + centerX + ", " + centerY + ")" + " r=" + radius;
    }

    public String getName() {
        return name;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }
}
