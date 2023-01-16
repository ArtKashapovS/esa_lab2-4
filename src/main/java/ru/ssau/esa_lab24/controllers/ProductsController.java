package ru.ssau.esa_lab24.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ssau.esa_lab24.models.Product;
import ru.ssau.esa_lab24.security.SellerDetails;
import ru.ssau.esa_lab24.services.CategoryService;
import ru.ssau.esa_lab24.services.ProductService;
import ru.ssau.esa_lab24.services.SellerService;

@Controller
public class ProductsController {
    private final CategoryService categoryService;
    private final ProductService productService;

    private final SellerService sellerService;

    @Autowired
    public ProductsController(CategoryService categoryService, ProductService productService, SellerService sellerService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.sellerService = sellerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SellerDetails sellerDetails = (SellerDetails) authentication.getPrincipal();

        model.addAttribute("products", productService.findBySeller(sellerDetails.getSeller()));
        return "index";
    }

    @GetMapping("/products/new")
    public String newPerson(Model model, @ModelAttribute("product") Product product) {
        model.addAttribute("categories", categoryService.findAll());
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "products/new";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SellerDetails sellerDetails = (SellerDetails) authentication.getPrincipal();

        product.setSeller(sellerDetails.getSeller());
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/products/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productService.findById(id));
        return "products/edit";
    }


}
