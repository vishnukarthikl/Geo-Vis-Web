package com.vishnukl.helper;

import com.vishnukl.model.Point;

import java.util.ArrayList;
import java.util.List;

public class GeometryHelper {
    public static List<Point> calculatePoints(double[] ordinates) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < ordinates.length; i = i + 2) {
            Point point = new Point((int) ordinates[i], (int) ordinates[i + 1]);
            points.add(point);
        }
        return points;
    }
}
