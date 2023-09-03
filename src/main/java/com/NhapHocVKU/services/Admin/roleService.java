package com.NhapHocVKU.services.Admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.RoleDTO;
import com.NhapHocVKU.models.Admin.Role;
import com.NhapHocVKU.repositories.Admin.roleRepository;


@Service
public class roleService {
	@Autowired
	private roleRepository roleRepositories;
	
	public List<Role> findAll() {
		return roleRepositories.findAll();
	}
	
	public Role save(Role role) {
		role.setId(null);
        return roleRepositories.save(role);
	}
	
	public Role findById(Integer id) {
			Role role = roleRepositories.getOne(id);
			if(role == null) {
				ResponseEntity.notFound().build();
			}
			return role;
	}
	
	public void update(Integer id, RoleDTO roleDTO) {
		Role bean = roleRepositories.getOne(id);
		BeanUtils.copyProperties(roleDTO, bean);
		roleRepositories.save(bean);
	}
	

}