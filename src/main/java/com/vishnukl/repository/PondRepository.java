package com.vishnukl.repository;

import com.vishnukl.model.Pond;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
public class PondRepository extends Repository {

    @Autowired
    public PondRepository(Connection connection) {
        this.connection = connection;
        this.TABLE_NAME = "ponds";
    }

    public List<Pond> getAllPonds() throws SQLException {
        return (List<Pond>) populate((resultSet, collector) -> {
            String name = resultSet.getString(1);
            STRUCT position = (STRUCT) resultSet.getObject(2);
            JGeometry bounds = JGeometry.load(position);
            Rectangle2D bounds2D = bounds.createShape().getBounds2D();
            Pond pond = new Pond(name, bounds2D.getCenterX(), bounds2D.getCenterY(), bounds2D.getHeight() / 2);
            collector.add(pond);
        });
    }
}
