package com.vip.orsuqrc.service.hibernate.role;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vip.orsuqrc.model.projection.role.RoleProjection;
import com.vip.orsuqrc.repository.role.RoleRepository;

@Service
@Transactional
public class RoleHibernateService {
	private final RoleRepository repository;

	public RoleHibernateService(RoleRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<RoleProjection> getRoleList() {
		return repository.findRoleList();
	}
	
}
