package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.KhoaDTO;
import com.NhapHocVKU.dtos.Admin.StudentTuitionDTO;
import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.StudentTuition;
import com.NhapHocVKU.repositories.Admin.StudentTuitionRepository;

@Service
public class StTuitionService {

	@Autowired
	private StudentTuitionRepository studentTuitionRepository;

	public List<StudentTuition> findAll() {
		return studentTuitionRepository.findAll();
	}

	public StudentTuition save(StudentTuition stTuition) {
		stTuition = studentTuitionRepository.save(stTuition);
		return stTuition;
	}

	public void Update(Integer id, StudentTuitionDTO stTuitionDTO) {
		StudentTuition studentTuition = requireOne(id);
		BeanUtils.copyProperties(stTuitionDTO, studentTuition);
		studentTuitionRepository.save(studentTuition);
	}

	public StudentTuition getById(Integer id) {
		StudentTuition original = requireOne(id);
		return original;
	}

	private StudentTuition requireOne(Integer id) {
		return studentTuitionRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public List<StudentTuition> searchByOptions(String majorId, Integer khoaId, Integer curriculumId,
			String searchKeyword) {
		return studentTuitionRepository.searchByOptions(majorId, khoaId, curriculumId, searchKeyword);
	}
}
