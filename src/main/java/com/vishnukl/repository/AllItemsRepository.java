package com.vishnukl.repository;

import com.vishnukl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class AllItemsRepository {

    private PondRepository pondRepository;
    private AmbulanceRepository ambulanceRepository;
    private LionRepository lionRepository;
    private RegionRepository regionRepository;

    @Autowired
    public AllItemsRepository(PondRepository pondRepository, AmbulanceRepository ambulanceRepository, LionRepository lionRepository, RegionRepository regionRepository) {
        this.pondRepository = pondRepository;
        this.ambulanceRepository = ambulanceRepository;
        this.lionRepository = lionRepository;
        this.regionRepository = regionRepository;
    }

    public Items getAllItems() throws SQLException {
        List<Ambulance> allAmbulances = ambulanceRepository.getAllAmbulances();
        List<Pond> allPonds = pondRepository.getAllPonds();
        List<Lion> allLions = lionRepository.getAllLions();
        List<Region> allRegions = regionRepository.getAllRegions();
        return new Items(allLions, allRegions, allPonds, allAmbulances);
    }
}
