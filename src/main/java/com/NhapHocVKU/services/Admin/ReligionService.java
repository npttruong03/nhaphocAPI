package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.models.Admin.Religion;
import com.NhapHocVKU.models.Admin.Religion;
import com.NhapHocVKU.repositories.Admin.ReligionRepository;

@Service
public class ReligionService {
	@Autowired
	private ReligionRepository religionRepository;
	public List<Religion> findAll(){
		return religionRepository.findAll();
	}
	
	public Religion save(Religion religion) {
		religion.setId(0);
		religion = religionRepository.save(religion);
		return religion;
	}
	
	public void Update(Integer id, Religion religionDTO) {
		Religion updatereligion = requireOne(id);
		
		BeanUtils.copyProperties(religionDTO, updatereligion);
		religionRepository.save(updatereligion);
	}
	
	 public Religion getById(Integer id) {
		 	Religion original = requireOne(id);
	        return original;
	    }
	 private Religion requireOne(Integer id) {
	        return religionRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	    }

}
