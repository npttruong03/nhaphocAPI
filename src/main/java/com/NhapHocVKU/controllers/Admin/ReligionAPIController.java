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

import com.NhapHocVKU.models.Admin.Religion;
import com.NhapHocVKU.services.Admin.ReligionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("admin/api/religion")
public class ReligionAPIController {
	@Autowired
	private ReligionService religionService;
	@GetMapping
	public ResponseEntity<Object> findAll(){
		return ResponseEntity.ok(religionService.findAll());
	}
	@PostMapping("/")
	public ResponseEntity<Object> createreligion(@RequestBody @Valid Religion religion){
		religionService.save(religion);
		return ResponseEntity.ok(religion);
	}
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> update (@RequestBody @Valid Religion religionDTO, @Valid @NotNull @PathVariable("id") int id){
		religionDTO.setId(id);
		this.religionService.Update(id, religionDTO);
		return ResponseEntity.ok().body(religionService.getById(id));
	}

	


}
