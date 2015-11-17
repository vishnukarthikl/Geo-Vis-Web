package com.vishnukl.controller;

import com.vishnukl.model.Items;
import com.vishnukl.repository.AllItemsRepository;
import com.vishnukl.repository.ConnectionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
public class MainController {
    @RequestMapping("/all")
    @ResponseBody
    Items index() throws Exception {
        Connection connection = ConnectionManager.getConnection();
        AllItemsRepository allItemsRepository = new AllItemsRepository();
        return allItemsRepository.getAllItems(connection);
    }

}
