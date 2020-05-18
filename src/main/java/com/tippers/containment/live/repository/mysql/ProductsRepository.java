package com.tippers.containment.live.repository.mysql;

import com.tippers.containment.live.repository.model.mysql.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
