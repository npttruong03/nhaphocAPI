package com.NhapHocVKU.controllers.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/admin/api/object")
public class PriorityObjectAPIController {
	@Autowired
	private PriorityObjectService priorityObjectService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PriorityObjectDTO>> getAll() {
		List<PriorityObject> list = priorityObjectService.getAllObjects();
		List<PriorityObjectDTO> listDTO = new ArrayList<>();
		for (PriorityObject object : list) {
			PriorityObjectDTO dto = new PriorityObjectDTO();
			BeanUtils.copyProperties(object, dto);
			listDTO.add(dto);
		}
		
		return ResponseEntity.ok(listDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/save", produces = "application/json; charset=utf-8" )
	public ResponseEntity<PriorityObjectDTO> save(@RequestBody @Valid PriorityObjectDTO priorityObjectDTO) {
		PriorityObject priorityObject = priorityObjectService.createObject(priorityObjectDTO);
		PriorityObjectDTO objectDTOResponse = new PriorityObjectDTO();
		BeanUtils.copyProperties(priorityObject, objectDTOResponse);

		return ResponseEntity.ok().body(objectDTOResponse);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/update/{id}", produces = "application/json; charset=utf-8" )
	public ResponseEntity<PriorityObjectDTO> update(@PathVariable int id, @RequestBody @Valid PriorityObjectDTO priorityObjectDTO)
	{
		PriorityObject priorityObject = priorityObjectService.updateObject(id, priorityObjectDTO);
		
		PriorityObjectDTO objectDTOResponse = new PriorityObjectDTO();
		BeanUtils.copyProperties(priorityObject, objectDTOResponse);

		return ResponseEntity.ok().body(objectDTOResponse);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/deactive/{id}", produces = "application/json; charset=utf-8" )
	public ResponseEntity<PriorityObjectDTO> deactive(@PathVariable int id)
	{		
		PriorityObject priorityObject = priorityObjectService.deactiveArea(id);
		
		PriorityObjectDTO objectDTOResponse = new PriorityObjectDTO();
		BeanUtils.copyProperties(priorityObject, objectDTOResponse);

		return ResponseEntity.ok().body(objectDTOResponse);
	}
}
