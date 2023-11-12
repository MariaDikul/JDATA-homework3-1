package ru.netology.jdatahomework31.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdatahomework31.repository.SortingRepository;

import java.util.List;


@RestController
public class GetProductController {
    private SortingRepository sortingRepository;

    public GetProductController(SortingRepository sortingRepository) {
        this.sortingRepository = sortingRepository;
    }

    public GetProductController() {
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String customer) {
        return sortingRepository.getProductName(customer);
    }
}
