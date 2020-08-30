package com.cuarentena.web.model;

public enum RoleName {
	
	ROLE_ADMIN("ROLE_ADMIN", "Administrador"),
	ROLE_USER("ROLE_USER","Cliente");
    
    private String role;
	private String name;

	RoleName(String role, String name) {
		this.role = role;
		this.name = name;
	}
	
	public String getRole() {
		return this.role;
	}
	public String getName() {
		return this.name;
	}
	
}
