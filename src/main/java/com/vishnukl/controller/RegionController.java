package com.vishnukl.controller;

import com.vishnukl.model.Region;
import com.vishnukl.repository.ConnectionManager;
import com.vishnukl.repository.RegionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
public class RegionController {

    @RequestMapping("/region")
    @ResponseBody
    List<Region> index() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        RegionRepository regionRepository = new RegionRepository(connection);
        return regionRepository.getAllRegions();
    }

    @RequestMapping("/items-in-region")
    @ResponseBody
    List<String> getItemsInRegion(@RequestParam String region) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        RegionRepository regionRepository = new RegionRepository(connection);
        return regionRepository.getItemsInside(region);
    }
}
