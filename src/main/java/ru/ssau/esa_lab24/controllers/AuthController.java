package ru.ssau.esa_lab24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ssau.esa_lab24.models.Seller;
import ru.ssau.esa_lab24.services.RegistrationService;
import ru.ssau.esa_lab24.util.SellerValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final SellerValidator sellerValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, SellerValidator sellerValidator) {
        this.registrationService = registrationService;
        this.sellerValidator = sellerValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Seller seller) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Seller seller,
                                      BindingResult bindingResult) {
        sellerValidator.validate(seller, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.register(seller);

        return "redirect:/auth/login";
    }
}
