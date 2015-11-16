package com.vishnukl.model;

public class Ambulance {
    private final String name;
    private final double centerX;
    private final double centerY;
    private final double coverage;

    public Ambulance(String name, double centerX, double centerY, double coverage) {
        this.name = name;
        this.centerX = centerX;
        this.centerY = centerY;
        this.coverage = coverage;
    }

    @Override
    public String toString() {
        return name + "(" + centerX + ", " + centerY + ")" + " r=" + coverage;
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

    public double getCoverage() {
        return coverage;
    }
}
