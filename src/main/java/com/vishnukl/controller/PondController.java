package com.vishnukl.controller;

import com.vishnukl.model.Pond;
import com.vishnukl.repository.ConnectionManager;
import com.vishnukl.repository.PondRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
public class PondController {

    @RequestMapping("/pond")
    @ResponseBody
    List<Pond> index() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        PondRepository pondRepository = new PondRepository(connection);
        return pondRepository.getAllPonds();
    }
}
