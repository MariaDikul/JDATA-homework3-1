package ru.netology.jdatahomework31.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.jdatahomework31.repository.Repository;


@org.springframework.stereotype.Controller
public class Controller {
    Repository repository;

    @Autowired
    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String customer) {
        return repository.getProductName(customer);
    }
}
