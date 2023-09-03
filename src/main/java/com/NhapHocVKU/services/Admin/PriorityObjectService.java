package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.*;
import com.NhapHocVKU.models.Admin.*;
import com.NhapHocVKU.repositories.Admin.*;
import com.NhapHocVKU.repositories.Admin.*;

@Service
public class PriorityObjectService {
	@Autowired
	PriorityObjectRepository priorityObjectRepository;
	
	public PriorityObject getObject(int id) {
		return priorityObjectRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}
	public List<PriorityObject> getAllObjects() {
		return priorityObjectRepository.findAll();
	}
	
	public PriorityObject createObject(PriorityObjectDTO priorityObjectDTO) {
		PriorityObject priorityObject = new PriorityObject();
		BeanUtils.copyProperties(priorityObjectDTO, priorityObject);
		return priorityObjectRepository.save(priorityObject);
	}
//	public PriorityObject createObject(PriorityObject priorityObject) {
////		PriorityObject priorityObject = new PriorityObject();
////		BeanUtils.copyProperties(priorityObject, priorityObjectDTO);
//		return priorityObjectRepository.save(priorityObject);
//	}
	
	public PriorityObject updateObject(int id, PriorityObjectDTO priorityObjectDTO){
		PriorityObject priorityObject = getObject(id);
		BeanUtils.copyProperties(priorityObjectDTO, priorityObject);
		return priorityObjectRepository.save(priorityObject);
	}
	
	
	public PriorityObject deactiveArea(int id){
		PriorityObject priorityObject = getObject(id);
		priorityObject.setStatus(false);
		
		return priorityObjectRepository.save(priorityObject);
	}
}
