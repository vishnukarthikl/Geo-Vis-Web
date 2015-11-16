package com.vishnukl.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Region {

    private final String name;
    private final List<Point> points;

    public Region(String name, List<Point> points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    @Override
    public String toString() {
        String str = "";
        for (Point point : points) {
            str += String.format("(%s,%s) ", point.getX(), point.getY());
        }
        return name + " " + str;
    }
}
