package com.tippers.containment.live.repository.postgres;

import com.tippers.containment.live.repository.model.postgres.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
