package ru.ssau.esa_lab24.services;

import org.springframework.stereotype.Service;
import ru.ssau.esa_lab24.repositories.SellerRepository;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;


    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    //TODO: реализовать метод поиска по username


}
