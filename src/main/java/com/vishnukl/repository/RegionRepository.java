package com.vishnukl.repository;

import com.vishnukl.helper.GeometryHelper;
import com.vishnukl.model.Region;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RegionRepository extends Repository {

    @Autowired
    public RegionRepository(Connection connection) {
        this.connection = connection;
        this.TABLE_NAME = "regions";
    }

    public List<Region> getAllRegions() throws SQLException {
        return (List<Region>) populate((resultSet, collector) -> {
            String name = resultSet.getString(1);
            STRUCT position = (STRUCT) resultSet.getObject(2);
            JGeometry bounds = JGeometry.load(position);
            double[] points = bounds.getOrdinatesArray();
            collector.add(new Region(name, GeometryHelper.calculatePoints(points)));
        });
    }

    public List<String> getItemsInside(String region) throws SQLException {
        String query = "SELECT l.lion_id as region_has_lion FROM regions r, lions l, TABLE ( SDO_JOIN ('lions', 'coordinate','regions', 'bounds','mask=inside' ) ) lions_in_region WHERE l.rowid=lions_in_region.rowid1 and  r.rowid = lions_in_region.rowid2 and r.region_id= ? UNION select p.pond_id from ponds p, regions r, TABLE ( SDO_JOIN('ponds','bounds',   'regions','bounds',   'mask=inside' )) ponds_in_region where p.rowid=ponds_in_region.rowid1 and  r.rowid = ponds_in_region.rowid2 and r.region_id=?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, region);
        stmt.setString(2, region);
        List<String> items = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            items.add(resultSet.getString(1));
        }
        return items;
    }
}
