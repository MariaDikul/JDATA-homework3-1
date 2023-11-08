package ru.netology.jdatahomework31.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String script = read("sorting.sql");

    public Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerName", name);
        List<String> productNameList = namedParameterJdbcTemplate.query(script, params, (rs, rowNum) -> {
            String product = rs.getString("product_name");
            return product;
        });
        String productName = null;
        for (String s : productNameList) {
            productName = s;
        }
        return productName;
    }
}
