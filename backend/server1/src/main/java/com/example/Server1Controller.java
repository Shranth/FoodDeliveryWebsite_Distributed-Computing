package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/server1/orders")
@CrossOrigin("*")
public class Server1Controller {

    @Autowired
    private RestTemplate restTemplate;

    private final String ORDER_SERVICE_URL = "http://localhost:8081/orders/server/1";



    @GetMapping
    public List<Object> getServer1Orders() {
        return restTemplate.getForObject(ORDER_SERVICE_URL, List.class);
    }
}
