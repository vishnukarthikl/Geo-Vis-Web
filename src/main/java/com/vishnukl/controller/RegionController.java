package com.vishnukl.controller;

import com.vishnukl.model.Region;
import com.vishnukl.repository.ConnectionManager;
import com.vishnukl.repository.RegionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
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
}
