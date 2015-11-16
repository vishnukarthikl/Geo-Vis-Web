package com.vishnukl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GeovisApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() throws Exception {
        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(GeovisApplication.class, args);
    }
}
