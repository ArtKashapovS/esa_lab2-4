package ru.ssau.esa_lab24.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ssau.esa_lab24.models.Seller;
import ru.ssau.esa_lab24.services.SellerDetailsService;

@Component
public class SellerValidator implements Validator {

    private final SellerDetailsService sellerDetailsService;

    @Autowired
    public SellerValidator(SellerDetailsService sellerDetailsService) {
        this.sellerDetailsService = sellerDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Seller.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Seller person = (Seller) o;

        try {
            sellerDetailsService.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return; // все ок, пользователь не найден
        }

        errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }
}
