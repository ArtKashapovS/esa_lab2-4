package ru.ssau.esa_lab24.services;

import org.springframework.stereotype.Service;
import ru.ssau.esa_lab24.models.Product;
import ru.ssau.esa_lab24.models.Seller;
import ru.ssau.esa_lab24.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(int id){
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElse(null);
    }

    public List<Product> findBySeller(Seller seller) {
        return productRepository.findBySeller(seller);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
