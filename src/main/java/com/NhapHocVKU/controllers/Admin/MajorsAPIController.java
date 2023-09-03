package com.NhapHocVKU.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.KhoaDTO;
import com.NhapHocVKU.dtos.Admin.MajorsDTO;
import com.NhapHocVKU.models.Admin.Majors;
import com.NhapHocVKU.services.Admin.MajorsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin/api")
public class MajorsAPIController {
	@Autowired
	private MajorsService majorsService;
	
	@GetMapping("/majors")
	@PreAuthorize("hasRole('TAIVU') or hasRole('DAOTAO') or hasRole('ADMIN') or hasRole('CTSV')")
	public ResponseEntity<Object> findAll(){
		return ResponseEntity.ok(majorsService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "majors/create", produces = "application/json; charset=utf-8")
    @ResponseBody
	public ResponseEntity<Object> create(@RequestBody @Valid Majors majors){
		majorsService.save(majors);
		return ResponseEntity.ok(majors);
	}
	@RequestMapping(method = RequestMethod.PUT, path = "majors/edit/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Object> update (@RequestBody @Valid MajorsDTO majorsDTO, @Valid @NotNull @PathVariable("id") String id){
		this.majorsService.Update(id, majorsDTO);
		return ResponseEntity.ok().body(majorsService.getById(id));
	}
	@GetMapping("/majors/search")
	public ResponseEntity<Object> findByKey(@RequestParam(value = "keyword", required  = false) String Key){
		return ResponseEntity.ok(majorsService.searchByKeyword(Key));
	}

}
