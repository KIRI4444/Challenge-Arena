package com.example.Challenge.Arena.web.security.expression;

import com.example.Challenge.Arena.domain.user.Role;
import com.example.Challenge.Arena.service.UserService;
import com.example.Challenge.Arena.web.security.JwtEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("CustomSecurityExpression")
@AllArgsConstructor
public class CustomSecurityExpression {

    private final UserService userService;

    public boolean isUserAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return hasAnyRole(authentication, Role.ROLE_ADMIN);
    }

    private boolean hasAnyRole(Authentication authentication, Role... roles) {
        for (Role role : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
            if (authentication.getAuthorities().contains(authority)) {
                return true;
            }
        }
        return false;
    }
}
