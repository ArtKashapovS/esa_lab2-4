package ru.ssau.esa_lab24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ssau.esa_lab24.models.Seller;
import ru.ssau.esa_lab24.repositories.SellerRepository;

@Service
public class RegistrationService {
    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(SellerRepository sellerRepository, PasswordEncoder passwordEncoder) {
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public void register(Seller seller) {
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        //seller.setRole("ROLE_USER"); //TODO: добавить роль
        sellerRepository.save(seller);
    }
}
