package com.NhapHocVKU.services.Admin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.ContentDTO;
import com.NhapHocVKU.models.Admin.Content;
import com.NhapHocVKU.repositories.Admin.ContentRepository;

@Service
public class ContentService {
	
	@Autowired
	private ContentRepository contentRepository;
	
	public List<Content> getAll(){
		return contentRepository.findAll();
	}
	
	public Content save(Content content) {
		content = contentRepository.save(content);
		return content;
	}
	
	public void update(Integer id, ContentDTO contentDTO) {
		Content content = requireOne(id);
		BeanUtils.copyProperties(contentDTO, content);
		contentRepository.save(content);
	}
	
	public Content getById(Integer id) {
		Content original = requireOne(id);
        return original;
    }
	 private Content requireOne(Integer id) {
	        return contentRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	 }

	 public List<Content> searchByKeyword(String Keyword) {
		 return contentRepository.searchByKeyword(Keyword);
	 }
	

}
