package com.NhapHocVKU.controllers.Admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.CurriculumDTO;
import com.NhapHocVKU.models.Admin.Curriculum;
import com.NhapHocVKU.services.Admin.CurriculumService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/api/curry")
public class CuriculumAPIController {
	@Autowired
	private CurriculumService curriculumService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(curriculumService.getAllCurry());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/save", produces = "application/json; charset=utf-8" )
	public String save(@RequestBody @Valid Curriculum curryDTO) {
		curryDTO.setId(null);
		return curriculumService.create(curryDTO) != null ? "Thêm thành công":"Thêm thất bại";
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/update/{id}", produces = "application/json; charset=utf-8")
	public String update(@PathVariable Integer id, @RequestBody @Valid CurriculumDTO curryDTO) {
		Curriculum curriculum = curriculumService.update(id, curryDTO);	
		return curriculum != null ? "Cập nhập thành công" : "Cập nhập thất bại";
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/deactive/{id}", produces = "application/json; charset=utf-8" )
	public String deactive(@PathVariable int id)
	{		
		Curriculum curriculum = curriculumService.deactive(id);
		
		return curriculum != null ? "Cập nhập thành công":"Cập nhập thất bại";
		
	}
	
	@GetMapping("/search")
	public  ResponseEntity<Object> search(@RequestParam(required = false) String keyword, @RequestParam(required = false) Integer idKhoa, 
			@RequestParam(required = false) String idNganh)
	{
		
		return ResponseEntity.ok(curriculumService.search(idKhoa, idNganh, keyword));
	}
	
}
