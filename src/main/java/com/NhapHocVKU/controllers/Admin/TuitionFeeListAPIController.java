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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.TuitionFeeListDTO;
import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.TuitionFeeList;
import com.NhapHocVKU.services.Admin.TuitionFeeListService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin/api/tuitionFeeList")
public class TuitionFeeListAPIController {
	
	@Autowired
	private TuitionFeeListService tuitionFeeListService;
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		return ResponseEntity.ok(tuitionFeeListService.getAll()) ;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/create", produces = "application/json; charset=utf-8")
    @ResponseBody
	public ResponseEntity<Object> createKhoa(@RequestBody @Valid TuitionFeeList tuitionFeeList){
		tuitionFeeListService.save(tuitionFeeList);
		return ResponseEntity.ok(tuitionFeeList);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/edit/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Object> update (@RequestBody @Valid TuitionFeeListDTO tuitionFeeListDTO, @Valid @NotNull @PathVariable("id") int id){
		this.tuitionFeeListService.update(id, tuitionFeeListDTO);
		return ResponseEntity.ok().body(tuitionFeeListService.getById(id));
	}
	
	@GetMapping("/searchByKey")
    public ResponseEntity<Object> searchTuitionFeeList(
            @RequestParam(required = false) Integer khoaId,
            @RequestParam(required = false) String majorsId,
            @RequestParam(required = false) Integer curriculumId) {
		return ResponseEntity.ok
				(tuitionFeeListService.searchTuitionFeeList
						(khoaId, majorsId, curriculumId));
    }
	
	
}
