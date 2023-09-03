package com.NhapHocVKU.services.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.DocumentItemsDTO;
import com.NhapHocVKU.models.Admin.DocumentItems;
import com.NhapHocVKU.repositories.repository;
import com.NhapHocVKU.repositories.Admin.DocumentItemsRepository;

@Service
public class DocumentItemsService {
	@Autowired
	private DocumentItemsRepository documentItemsRepository;
	
	public List<DocumentItems> getAllDocuments() {
		return documentItemsRepository.findAll();
	}
	
	public DocumentItems getDocument(int id) {
		return documentItemsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}
	
	public DocumentItems createDocument(DocumentItemsDTO documentItemsDTO) {
		DocumentItems document = new DocumentItems();
		BeanUtils.copyProperties(documentItemsDTO, document);
		System.out.println(document);
		return documentItemsRepository.save(document);
	}
	
	public DocumentItems updateDocument(int id, DocumentItemsDTO documentUpdate){
		DocumentItems document = getDocument(id);
		BeanUtils.copyProperties(documentUpdate, document);
		return documentItemsRepository.save(document);
	}
	
	public DocumentItems deactiveDocument(int id){
		DocumentItems document = getDocument(id);
		document.setStatus(false);
		
		return documentItemsRepository.save(document);
	}

	public List<DocumentItems> getAllDocumentsRequire() {
		return documentItemsRepository.getAllDocumentsRequire();
	}

	public List<DocumentItems> searchByParameters(Integer idKhoa, String idNganh, Integer idPttt, String keyword) {
		if (idKhoa != null && idNganh != null && idPttt != null && keyword != null) {
            return documentItemsRepository.searchByAll(idKhoa, idNganh, idPttt, keyword);
        } else if (idKhoa != null && idNganh != null && idPttt != null) {
            return documentItemsRepository.searchByIdAll(idKhoa, idNganh, idPttt);
        } else if (idKhoa != null && idNganh != null) {
            return documentItemsRepository.searchByIdKhoaAndIdNganh(idKhoa, idNganh);
        } else if (idKhoa != null && idPttt != null) {
            return documentItemsRepository.searchByIdKhoaAndIdPttt(idKhoa, idPttt);
        } else if (idNganh != null && idPttt != null) {
            return documentItemsRepository.searchByIdNganhAndIdPttt(idNganh, idPttt);
        } else if (idKhoa != null) {
            return documentItemsRepository.searchByIdKhoa(idKhoa);
        } else if (idNganh != null) {
            return documentItemsRepository.searchByIdNganh(idNganh);
        } else if (idPttt != null) {
            return documentItemsRepository.searchByIdPttt(idPttt);
        } else if (keyword != null) {
            return documentItemsRepository.searchByKeyword(keyword);
        } else {
            return documentItemsRepository.findAll();
        }
	}

	public List<DocumentItems> selectRequire(String[] listId) {
		List<DocumentItems> list = new ArrayList<DocumentItems>();
		for (int i = 0; i < listId.length; i++) {
			DocumentItems documentItems = getDocument(Integer.valueOf(listId[i]));
			documentItems.setStatus(true);
			documentItemsRepository.save(documentItems);
		}
		return list;
	}
	
	
}
