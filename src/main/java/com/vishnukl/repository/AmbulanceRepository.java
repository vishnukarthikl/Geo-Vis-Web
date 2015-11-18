package com.vishnukl.repository;

import com.vishnukl.model.Ambulance;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AmbulanceRepository extends Repository {

    @Autowired
    public AmbulanceRepository(Connection connection) {
        this.connection = connection;
        this.TABLE_NAME = "ambulances";
    }

    public List<Ambulance> getAllAmbulances() throws SQLException {
        List<Ambulance> ambulances = new ArrayList<>();
        ResultSet resultSet = fetchQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            STRUCT position = (STRUCT) resultSet.getObject(2);
            JGeometry bounds = JGeometry.load(position);
            Rectangle2D bounds2D = bounds.createShape().getBounds2D();
            Ambulance ambulance = new Ambulance(name, bounds2D.getCenterX(), bounds2D.getCenterY(), bounds2D.getHeight() / 2);
            ambulances.add(ambulance);
        }
        resultSet.close();
        return ambulances;
    }
}
