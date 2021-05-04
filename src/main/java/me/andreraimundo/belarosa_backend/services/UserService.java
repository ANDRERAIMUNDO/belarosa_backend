package me.andreraimundo.belarosa_backend.services;

import org.springframework.security.core.context.SecurityContextHolder;

import me.andreraimundo.belarosa_backend.security.UserSS;

public class UserService {
    public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
