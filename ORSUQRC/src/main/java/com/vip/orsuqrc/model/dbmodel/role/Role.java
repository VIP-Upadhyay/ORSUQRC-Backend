package com.vip.orsuqrc.model.dbmodel.role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
	@SequenceGenerator(name = "role_generator", sequenceName = "role_seq",allocationSize = 10)
	private Long roleId;
	private String name;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
