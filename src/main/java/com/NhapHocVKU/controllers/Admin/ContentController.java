package com.NhapHocVKU.controllers.Admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.ContentDTO;
import com.NhapHocVKU.models.Admin.Content;
import com.NhapHocVKU.services.Admin.ContentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin/api/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		return ResponseEntity.ok(contentService.getAll());
	}
	@RequestMapping(method = RequestMethod.POST, path = "/create", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String save(@RequestBody @Valid Content content){
		content.setId(null);
		contentService.save(content);
		return "Thêm thành công";
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, path = "/edit/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String edit(@RequestBody @Valid ContentDTO contentDTO, @Valid @NotNull @PathVariable("id") int id){
		contentService.update(id, contentDTO);
		
		return contentService.getById(id) !=null ? "Cập nhập thành công":"Cập nhập thất bại";
	}
	
	 @GetMapping("/search")
	 public ResponseEntity<Object> findByKey(@RequestParam(value = "keyword", required  = false) String Key){
			return ResponseEntity.ok(contentService.searchByKeyword(Key));
		}
}
