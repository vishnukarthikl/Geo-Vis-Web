package com.vishnukl.controller;

import com.vishnukl.model.Ambulance;
import com.vishnukl.repository.AmbulanceRepository;
import com.vishnukl.repository.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
public class AmbulanceController {
    private AmbulanceRepository ambulanceRepository;

    @Autowired
    public AmbulanceController(AmbulanceRepository ambulanceRepository) {
        this.ambulanceRepository = ambulanceRepository;
    }

    @RequestMapping("/ambulance")
    @ResponseBody
    List<Ambulance> index() throws Exception {
        return ambulanceRepository.getAllAmbulances();
    }
}
