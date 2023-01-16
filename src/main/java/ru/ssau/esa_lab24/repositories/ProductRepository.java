package ru.ssau.esa_lab24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.esa_lab24.models.Order;
import ru.ssau.esa_lab24.models.Product;
import ru.ssau.esa_lab24.models.Seller;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySeller(Seller seller);
}
