package com.hrodriguesdev.soauth.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String rolename;
	private Set<User> user = new HashSet<>();	
	
	public Role(Long id, String roleName) {
		this.id = id;
		this.rolename = roleName;
	}
	
	public Role() {	}

	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rolename == null) ? 0 : rolename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (rolename == null) {
			if (other.rolename != null)
				return false;
		} else if (!rolename.equals(other.rolename))
			return false;
		return true;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
}
