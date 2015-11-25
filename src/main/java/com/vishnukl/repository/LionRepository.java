package com.vishnukl.repository;

import com.vishnukl.model.Lion;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
public class LionRepository extends Repository {

    @Autowired
    public LionRepository(Connection connection) {
        this.connection = connection;
        this.TABLE_NAME = "lions";
    }

    public List<Lion> getAllLions() throws SQLException {
        return (List<Lion>) populate((resultSet, collector) -> {
            String name = resultSet.getString(1);
            STRUCT position = (STRUCT) resultSet.getObject(2);
            JGeometry pointGeom = JGeometry.load(position);
            collector.add(new Lion(name, pointGeom.getJavaPoint().getX(), pointGeom.getJavaPoint().getY()));
        });
    }
}
