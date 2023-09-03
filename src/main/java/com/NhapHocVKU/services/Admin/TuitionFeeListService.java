package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.TuitionFeeListDTO;
import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.TuitionFeeList;
import com.NhapHocVKU.repositories.Admin.TuitionFeeListRepository;

@Service
public class TuitionFeeListService {

	@Autowired
	private TuitionFeeListRepository tuitionFeeRepository;

	public List<TuitionFeeList> getAll() {
		return tuitionFeeRepository.findAll();
	}

	public TuitionFeeList save(TuitionFeeList tuitionFee) {
		tuitionFee = tuitionFeeRepository.save(tuitionFee);
		return tuitionFee;
	}

	public void update(Integer id, TuitionFeeListDTO tuitionFeeListDTO) {
		TuitionFeeList tuitionFeeList = requireOne(id);
		BeanUtils.copyProperties(tuitionFeeListDTO, tuitionFeeList);
		tuitionFeeRepository.save(tuitionFeeList);
	}

	public TuitionFeeList getById(Integer id) {
		TuitionFeeList original = requireOne(id);
		return original;
	}

	private TuitionFeeList requireOne(Integer id) {
		return tuitionFeeRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public List<TuitionFeeList> searchTuitionFeeList(Integer khoaId,
    		String majorsId,
         Integer curriculumId){
        if (khoaId != null && majorsId != null && curriculumId != null) {
            return tuitionFeeRepository.findByKhoaIdAndMajorsIdAndCurriculumId(khoaId, majorsId, curriculumId);
        } else if (khoaId != null && majorsId != null) {
            return tuitionFeeRepository.findByKhoaIdAndMajorsId(khoaId, majorsId);
        } else if (khoaId != null && curriculumId != null) {
            return tuitionFeeRepository.findByKhoaIdAndCurriculumId(khoaId, curriculumId);
        } else if (majorsId != null && curriculumId != null) {
            return tuitionFeeRepository.findByMajorsIdAndCurriculumId(majorsId, curriculumId);
        } else if (khoaId != null) {
            return tuitionFeeRepository.findByKhoaId(khoaId);
        } else if (majorsId != null) {
            return tuitionFeeRepository.findByMajorsId(majorsId);
        } else if (curriculumId != null) {
            return tuitionFeeRepository.findByCurriculumId(curriculumId);
        } else if (khoaId == null && majorsId == null && curriculumId == null)
        	return tuitionFeeRepository.findAll(); 
        else {
        	return tuitionFeeRepository.findAll();
		}
        
    }

}
