package com.epam.domain;

/**
 * @author Olga_Bogutska.
 */

public enum UserRole {
	ADMIN("Admin"),
	CLIENT("Admin"),
	ANONYM("Anonym");


	public String getDescription() {
		return description;
	}

	private String description;

	private UserRole(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}

