package ru.ssau.esa_lab24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ssau.esa_lab24.models.Seller;
import ru.ssau.esa_lab24.repositories.SellerRepository;
import ru.ssau.esa_lab24.security.SellerDetails;

import java.util.Optional;

@Service
public class SellerDetailsService implements UserDetailsService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerDetailsService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Seller> seller = sellerRepository.findByUsername(s);

        if (seller.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new SellerDetails(seller.get());
    }
}
