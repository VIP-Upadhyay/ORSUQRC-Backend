package com.vip.orsuqrc.model.projection.role;

public class RoleProjection {

	private Long roleID;
	private String name;
	
	
	
	public RoleProjection(Long roleID, String name) {
		super();
		this.roleID = roleID;
		this.name = name;
	}
	public Long getRoleID() {
		return roleID;
	}
	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
