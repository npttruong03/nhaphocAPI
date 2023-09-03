package com.NhapHocVKU.controllers.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.*;
import com.NhapHocVKU.models.Admin.*;
import com.NhapHocVKU.services.Admin.*;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/admin/api/area")
public class AreaAPIController {
	@Autowired
	private AreaService areaService;

	@GetMapping("/getAll")
	@PreAuthorize("hasRole('DAOTAO')")
	public ResponseEntity<List<AreaDTO>> getAll() {
		List<Area> list = areaService.getAllAreas();
		List<AreaDTO> listDTO = new ArrayList<>();
		for (Area area : list) {
			AreaDTO areaDTO = new AreaDTO();
			BeanUtils.copyProperties(area, areaDTO);
			listDTO.add(areaDTO);
		}

		return ResponseEntity.ok(listDTO);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save", produces = "application/json; charset=utf-8")
	public String save(@RequestBody @Valid AreaDTO areaDTO) {

		Area area = areaService.createArea(areaDTO);
		return area != null ? "Thêm thành công" : "Thêm thất bại";
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/update/{id}", produces = "application/json; charset=utf-8")
	public String update(@PathVariable int id, @RequestBody @Valid AreaDTO areaDTO) {
		Area area = areaService.updateArea(id, areaDTO);

		return area != null ? "Cập nhập thành công" : "Cập nhập thất bại";
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/deactive/{id}", produces = "application/json; charset=utf-8")
	public String deactive(@PathVariable @Valid int id) {
		Area area = areaService.deactiveArea(id);

		return area != null ? "Thành công" : "Thất bại";
	}

}
