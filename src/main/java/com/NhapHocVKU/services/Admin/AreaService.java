package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.*;
import com.NhapHocVKU.models.Admin.*;
import com.NhapHocVKU.repositories.Admin.*;

@Service
public class AreaService {
	@Autowired
	AreaRepository areaRepository;
	
	public Area getArea(int id) {
		return areaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}
	public List<Area> getAllAreas() {
		return areaRepository.findAll();
	}
	
	public Area createArea(AreaDTO areaDTO) {
		Area area = new Area();
		BeanUtils.copyProperties(areaDTO, area);
		return areaRepository.save(area);
	}
	
	public Area updateArea(int id, AreaDTO areaUpdate){
		Area area = getArea(id);
		BeanUtils.copyProperties(areaUpdate, area);
		return areaRepository.save(area);
	}
	
	
	public Area deactiveArea(int id){
		Area area = getArea(id);
		area.setStatus(false);
		
		return areaRepository.save(area);
	}
}
