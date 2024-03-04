package com.product_backend.productApi.Repository;

import com.product_backend.productApi.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_Repository extends JpaRepository<Product, Long> {
}
