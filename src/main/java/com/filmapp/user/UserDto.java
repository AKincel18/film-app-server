package com.filmapp.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class UserDto implements UserDetails {

    @Getter private final Long id;
    private final String username;
    @Getter private final String email;
    private final String password;
    private final String role;
    private final GrantedAuthority authority;


    public static UserDto build(User user) {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),
                user.getRole().getName(), authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
}
