package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.MethodDTO;
import com.NhapHocVKU.models.Admin.Method;
import com.NhapHocVKU.repositories.Admin.MethodRepository;

@Service
public class MethodService {
	@Autowired
	private MethodRepository methodRepository;

	public List<Method> findAll() {
		return methodRepository.findAll();
	}
	
//	public List<Method> findAll(Integer limit) {
//        return Optional.ofNullable(limit)
//                       .map(value -> methodRepository.findAll(PageRequest.of(0, value)).getContent())
//                       .orElseGet(() -> methodRepository.findAll());
//    }

	public Method save(Method method) {
		method.setId(null);
		return methodRepository.save(method);
	}
	

//	public Method findById(Integer id) {
//		Method method = methodRepository.getById(id);
//		if (method == null) {
//			ResponseEntity.notFound().build();
//		}
//		return method;
//	}



	public Method Update(Integer id, MethodDTO methodDTO) {
		Method bean = requireOne(id);
		BeanUtils.copyProperties(methodDTO, bean);
		return methodRepository.save(bean);
	}

	public Method getById(Integer id) {
		Method original = requireOne(id);
		return original;
	}

	private Method requireOne(Integer id) {
		return methodRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

}
