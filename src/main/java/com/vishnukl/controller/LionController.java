package com.vishnukl.controller;

import com.vishnukl.model.Lion;
import com.vishnukl.repository.ConnectionManager;
import com.vishnukl.repository.LionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
public class LionController {

    @RequestMapping("/lion")
    @ResponseBody
    List<Lion> index() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        LionRepository lionRepository = new LionRepository(connection);
        return lionRepository.getAllLions();
    }
}
