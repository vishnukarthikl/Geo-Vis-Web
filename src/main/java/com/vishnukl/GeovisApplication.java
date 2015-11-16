package com.vishnukl;

import com.vishnukl.model.Lion;
import com.vishnukl.repository.ConnectionManager;
import com.vishnukl.repository.LionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
@SpringBootApplication
public class GeovisApplication {

    @RequestMapping("/")
    @ResponseBody
    List<Lion> home() throws Exception {
        Connection connection = ConnectionManager.getConnection("localhost", "1521", "xe", "SYSTEM", "lviss");
        LionRepository lionRepository = new LionRepository(connection);
        return lionRepository.getAllLions();
    }

    public static void main(String[] args) {
        SpringApplication.run(GeovisApplication.class, args);
    }
}
