package com.jane.springboot.todos.util;

import com.jane.springboot.todos.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Component
public class FindAuthenticatedUserImpl implements FindAuthenticatedUser{
    @Override
    public User getAuthenticatedUser() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")){
            throw new AccessDeniedException("Authntication is required");
        }

        return  (User) authentication.getPrincipal();
    }
}
