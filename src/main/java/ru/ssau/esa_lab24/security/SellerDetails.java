package ru.ssau.esa_lab24.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.ssau.esa_lab24.models.Seller;

import java.util.Collection;
import java.util.Collections;

public class SellerDetails implements UserDetails {
    private final Seller seller;

    public SellerDetails(Seller seller) {
        this.seller = seller;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // SHOW_ACCOUNT, WITHDRAW_MONEY, SEND_MONEY
        // ROLE_ADMIN, ROLE_USER - это роли
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));

    }

    @Override
    public String getPassword() {
        return this.seller.getPassword();
    }

    @Override
    public String getUsername() {
        return this.seller.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public Seller getSeller() {
        return this.seller;
    }
}
