package com.vip.orsuqrc.repository.role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vip.orsuqrc.model.dbmodel.role.Role;
import com.vip.orsuqrc.model.projection.role.RoleProjection;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query(value = "SELECT new com.vip.orsuqrc.model.projection.role.RoleProjection("
			+ "r.roleId,r.name)"
			+ "FROM Role r")
	List<RoleProjection> findRoleList();
	
}
