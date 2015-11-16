package com.vishnukl.controller;

import com.vishnukl.model.Ambulance;
import com.vishnukl.repository.AmbulanceRepository;
import com.vishnukl.repository.ConnectionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
public class AmbulanceController {

    @RequestMapping("/ambulance")
    @ResponseBody
    List<Ambulance> index() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        AmbulanceRepository ambulanceRepository = new AmbulanceRepository(connection);
        return ambulanceRepository.getAllAmbulances();
    }
}
