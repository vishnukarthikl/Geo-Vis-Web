package com.vishnukl.repository;

import com.vishnukl.helper.GeometryHelper;
import com.vishnukl.model.Region;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepository extends Repository {

    public RegionRepository(Connection connection) {
        this.connection = connection;
        this.TABLE_NAME = "regions";
    }

    public List<Region> getAllRegions() throws SQLException {
        List<Region> regions = new ArrayList<>();
        ResultSet resultSet = fetchQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            STRUCT position = (STRUCT) resultSet.getObject(2);
            JGeometry bounds = JGeometry.load(position);
            double[] points = bounds.getOrdinatesArray();
            regions.add(new Region(name, GeometryHelper.calculatePoints(points)));
        }
        return regions;
    }
}
