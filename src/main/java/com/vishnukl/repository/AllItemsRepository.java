package com.vishnukl.repository;

import com.vishnukl.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AllItemsRepository {
    public Items getAllItems(Connection connection) throws SQLException {
        PondRepository pondRepository = new PondRepository(connection);
        AmbulanceRepository ambulanceRepository = new AmbulanceRepository(connection);
        LionRepository lionRepository = new LionRepository(connection);
        RegionRepository regionRepository = new RegionRepository(connection);
        List<Ambulance> allAmbulances = ambulanceRepository.getAllAmbulances();
        List<Pond> allPonds = pondRepository.getAllPonds();
        List<Lion> allLions = lionRepository.getAllLions();
        List<Region> allRegions = regionRepository.getAllRegions();
        return new Items(allLions, allRegions, allPonds, allAmbulances);
    }
}
