package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/server2/orders")
@CrossOrigin("*")
public class Server2Controller {

    @Autowired
    private RestTemplate restTemplate;

    private final String ORDER_SERVICE_URL = "http://localhost:8081/orders/server/2"; // Calls OrderService for Server 2

    @GetMapping
    public List<Object> getServer2Orders() {
        return restTemplate.getForObject(ORDER_SERVICE_URL, List.class);
    }
}
