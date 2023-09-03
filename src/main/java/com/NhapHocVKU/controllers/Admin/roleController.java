package com.NhapHocVKU.controllers.Admin;


import java.awt.Robot;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.RoleDTO;
import com.NhapHocVKU.models.Admin.Role;
import com.NhapHocVKU.repositories.Admin.roleRepository;
import com.NhapHocVKU.services.Admin.roleService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/admin/api")
public class roleController {

	@Autowired
	private roleService roleService;
	
	@GetMapping("/role")
	public ResponseEntity<Object> allRole() {
		return ResponseEntity.ok(roleService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "role/create", produces = "application/json; charset=utf-8")
    @ResponseBody
	public ResponseEntity<Role> insert(@RequestBody @Valid Role roles){
		roleService.save(roles);
		return ResponseEntity.ok(roles);
	}
	@RequestMapping(value = "/searchQuyen/{id}", method = RequestMethod.GET)
	public ResponseEntity<Role> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Role>(roleService.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "role/edit/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Role> update(@PathVariable Integer id, @RequestBody @Valid RoleDTO role) {
		this.roleService.update(id, role);
		return ResponseEntity.ok().body(this.roleService.findById(id));
	}
	
//	@PostMapping("/addQuyen")
//	public String addQuyen(@ModelAttribute Role role) {
//		return Optional.ofNullable(quyen_Service.save(role))
//				.map(t -> "success")
//				.orElse("failed");
//	}
}
