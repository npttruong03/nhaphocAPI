package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.CurriculumDTO;
import com.NhapHocVKU.models.Admin.Curriculum;
import com.NhapHocVKU.repositories.Admin.CurriculumRepository;

@Service
public class CurriculumService {
	@Autowired
	private CurriculumRepository curriculumRepository;
	
	public List<Curriculum> getAllCurry() {
		return curriculumRepository.findAll();
	}
	
	public Curriculum getCurriculum(int id) {
		return curriculumRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}
	
	public Curriculum create(Curriculum curriculum) {
		curriculum =curriculumRepository.save(curriculum);
		return curriculum;
	}
	
	public Curriculum update(Integer id, CurriculumDTO dto)
	{
		Curriculum curriculum = getCurriculum(id);
		BeanUtils.copyProperties(dto, curriculum);
		
		return curriculumRepository.save(curriculum);
	}
	
	public Curriculum deactive(int id) {
		Curriculum curriculum = getCurriculum(id);
		curriculum.setStatus(false);
		
		return curriculumRepository.save(curriculum);
	}
	
	public List<Curriculum> search(Integer idKhoa, String idNganh, String keyword) {
		if (idKhoa != null && idNganh != null && keyword != null) {
            return curriculumRepository.searchByAll(idKhoa, idNganh, keyword);
        } else if (idKhoa != null && idNganh != null) {
            return curriculumRepository.searchByIdKhoaAndIdNganh(idKhoa, idNganh);
        } else if (idKhoa != null && keyword != null) {
            return curriculumRepository.searchByIdKhoaAndKeyword(idKhoa, keyword);
        } else if (idNganh != null && keyword != null) {
            return curriculumRepository.searchByIdNganhAndKeyword(idNganh, keyword);
        } else if (idKhoa != null) {
            return curriculumRepository.searchByIdKhoa(idKhoa);
        } else if (idNganh != null) {
            return curriculumRepository.searchByIdNganh(idNganh);
        } else if (keyword != null) {
            return curriculumRepository.searchByKeyword(keyword);
        } else {
            return curriculumRepository.findAll();
        }
	}
}
