package com.example.controller;

import com.example.OrderRepository;
import com.example.model.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }
    @GetMapping("/history")
    public List<Order> getOrderHistory(@RequestParam String email) {
        return orderService.getOrderHistory(email);
    }
    @GetMapping("/server-load")
    public List<Map<String, Object>> getServerLoad() {
        String query = "SELECT * FROM server_load";
        return jdbcTemplate.queryForList(query);
    }

    @GetMapping("/admin/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    

    @PutMapping("/admin/reset-load")
    public ResponseEntity<String> resetServerLoad() {
        jdbcTemplate.update("UPDATE server_load SET order_count = 0");
        return ResponseEntity.ok("Server load reset successfully!");
    }

    @GetMapping("/server/{serverId}")
    public List<Order> getOrdersByServer(@PathVariable int serverId) {
        return orderRepository.findByServerId(serverId);
    }





}
