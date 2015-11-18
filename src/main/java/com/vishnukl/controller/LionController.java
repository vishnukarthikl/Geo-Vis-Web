package com.vishnukl.controller;

import com.vishnukl.model.Lion;
import com.vishnukl.repository.LionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LionController {

    private LionRepository lionRepository;

    @Autowired
    public LionController(LionRepository lionRepository) {
        this.lionRepository = lionRepository;
    }

    @RequestMapping("/lion")
    @ResponseBody
    List<Lion> index() throws Exception {
        return lionRepository.getAllLions();
    }
}
