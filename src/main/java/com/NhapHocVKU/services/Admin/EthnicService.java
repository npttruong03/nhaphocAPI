package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.models.Admin.Ethnic;
import com.NhapHocVKU.repositories.Admin.EthnicRepository;

@Service
public class EthnicService {
	@Autowired
	private EthnicRepository ethnicRepository;
	public List<Ethnic> findAll(){
		return ethnicRepository.findAll();
	}
	
	public Ethnic save(Ethnic ethnic) {
		ethnic = ethnicRepository.save(ethnic);
		return ethnic;
	}
	
	public void Update(Integer id, Ethnic ethnicDTO) {
		Ethnic updateEthnic = requireOne(id);
//		updateEthnic.setName(ethnicDTO.getName());
		BeanUtils.copyProperties(ethnicDTO, updateEthnic);
		ethnicRepository.save(updateEthnic);
	}
	
	 public Ethnic getById(Integer id) {
		 	Ethnic original = requireOne(id);
	        return original;
	    }
	 private Ethnic requireOne(Integer id) {
	        return ethnicRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	    }

}
