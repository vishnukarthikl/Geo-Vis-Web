package com.vishnukl.repository;

import com.vishnukl.model.Pond;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PondRepository extends Repository {

    public PondRepository(Connection connection) {
        this.connection = connection;
        this.TABLE_NAME = "ponds";
    }

    public List<Pond> getAllPonds() throws SQLException {
        List<Pond> ponds = new ArrayList<>();
        ResultSet resultSet = fetchQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            STRUCT position = (STRUCT) resultSet.getObject(2);
            JGeometry bounds = JGeometry.load(position);
            Rectangle2D bounds2D = bounds.createShape().getBounds2D();
            Pond pond = new Pond(name, bounds2D.getCenterX(), bounds2D.getCenterY(), bounds2D.getHeight() / 2);
            ponds.add(pond);
        }
        resultSet.close();
        return ponds;
    }
}
