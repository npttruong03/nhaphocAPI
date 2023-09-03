package com.NhapHocVKU.controllers.Admin;

import java.util.List;

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

import com.NhapHocVKU.dtos.Admin.KhoaDTO;
import com.NhapHocVKU.dtos.Admin.StudentTuitionDTO;
import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.StudentTuition;
import com.NhapHocVKU.services.Admin.StTuitionService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin/api/studentTuition")
public class StudentTuitionController {

	@Autowired
	private StTuitionService stTuitionService;

	@GetMapping
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.ok(stTuitionService.findAll());
	}

	@RequestMapping(method = RequestMethod.POST, path = "/create", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Object> createKhoa(@RequestBody @Valid StudentTuition studentTuition) {
		stTuitionService.save(studentTuition);
		return ResponseEntity.ok(studentTuition);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/edit/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Object> update(@RequestBody @Valid StudentTuitionDTO sTuitionDTO,
			@Valid @NotNull @PathVariable("id") int id) {
		this.stTuitionService.Update(id, sTuitionDTO);
		return ResponseEntity.ok().body(stTuitionService.getById(id));
	}

	@GetMapping("/searchOption")
	public ResponseEntity<List<StudentTuition>> search(@RequestParam(required = false) String idMajor,
			@RequestParam(required = false) Integer idKhoa, @RequestParam(required = false) Integer idCurriculum,
			@RequestParam(required = false) String keyWord) {
		List<StudentTuition> listSearched = stTuitionService.searchByOptions(idMajor, idKhoa, idCurriculum, keyWord);

		return ResponseEntity.ok(listSearched);
	}
}
