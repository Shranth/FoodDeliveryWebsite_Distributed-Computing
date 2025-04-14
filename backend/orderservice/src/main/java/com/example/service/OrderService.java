package com.example.service;

import com.example.OrderRepository;
import com.example.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private static final int ORDER_THRESHOLD = 10;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public String placeOrder(Order order) {
        int serverId = getAvailableServer();


        order.setServerId(serverId);


        Order savedOrder = orderRepository.save(order);

        if (savedOrder.getId() != null) {
            updateServerLoad(serverId);
        } else {
            return "Order placement failed!";
        }

        return "Order placed successfully on Server " + serverId + "!";
    }


    public List<Order> getOrderHistory(String email) {
        return orderRepository.findByEmail(email);
    }

    private int getAvailableServer() {
        String query = "SELECT server_id, order_count FROM server_load ORDER BY order_count ASC LIMIT 1";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> rs.getInt("server_id"));
    }

    private void updateServerLoad(int serverId) {
        System.out.println("Updating server load for Server: " + serverId);
        jdbcTemplate.update("UPDATE server_load SET order_count = order_count + 1 WHERE server_id = ?", serverId);
    }
}
