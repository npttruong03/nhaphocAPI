package com.NhapHocVKU.controllers.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.models.Admin.Ethnic;
import com.NhapHocVKU.services.Admin.EthnicService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("admin/api/ethnic")
public class EthnicAPIController {
	@Autowired
	private EthnicService ethnicService;
	@GetMapping
	public ResponseEntity<Object> findAll(){
		return ResponseEntity.ok(ethnicService.findAll());
	}
	@PostMapping("/create")
	public String createEthnic(@RequestBody  @Valid Ethnic ethnic){
		ethnic.setId(0);
		return ethnicService.save(ethnic) != null ? "Thêm thành công":"Thêm thất bại" ;
	}
	@PutMapping("/edit/{id}")
	public String update (@RequestBody Ethnic ethnicDTO, @Valid @NotNull @PathVariable("id") int id){
		ethnicDTO.setId(id);
		ethnicService.Update(id, ethnicDTO);
		return ethnicService.getById(id) != null ? "Cập nhập thành công":"Cập nhập thất bại";
	}
}
