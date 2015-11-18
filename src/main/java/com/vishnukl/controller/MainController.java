package com.vishnukl.controller;

import com.vishnukl.model.Items;
import com.vishnukl.repository.AllItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private AllItemsRepository allItemsRepository;

    @Autowired
    public MainController(AllItemsRepository allItemsRepository) {
        this.allItemsRepository = allItemsRepository;
    }

    @RequestMapping("/all")
    @ResponseBody
    Items index() throws Exception {
        return allItemsRepository.getAllItems();
    }

}
