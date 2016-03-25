package com.epam;

import com.epam.domain.User;
import com.epam.domain.UserRole;

import org.springframework.stereotype.Component;

/**
 * Created by Olga Bogutska on 08.02.2016.
 */

/**
 * NOT THREAD-SAFE
 */
@Component
public class SecurityContext {
    private User user;

    public void login(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

	public boolean isAdmin() {
		return user != null && UserRole.ADMIN.equals(user.getRole());
	}

	public User getCurrentUser() {
		return user;
	}

}
