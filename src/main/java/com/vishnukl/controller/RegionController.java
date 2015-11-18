package com.vishnukl.controller;

import com.vishnukl.model.Region;
import com.vishnukl.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping("/region")
    @ResponseBody
    List<Region> index() throws Exception {
        return regionRepository.getAllRegions();
    }

    @RequestMapping("/items-in-region")
    @ResponseBody
    List<String> getItemsInRegion(@RequestParam String region) throws SQLException {
        return regionRepository.getItemsInside(region);
    }
}
