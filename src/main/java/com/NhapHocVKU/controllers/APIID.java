package com.NhapHocVKU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.services.Admin.MajorsService;

@RestController
@RequestMapping("/api")
public class APIID {
	@Autowired
	private MajorsService majorsService;
	@GetMapping("/Uid")
	public ResponseEntity<Object> generateUniqueId(){
		return ResponseEntity.ok(majorsService.generateUniqueId());
	}
	

}
