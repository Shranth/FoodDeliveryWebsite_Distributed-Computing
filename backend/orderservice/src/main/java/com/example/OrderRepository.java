package com.example;
import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByEmail(String email);
    List<Order> findByServerId(int serverId);

}
