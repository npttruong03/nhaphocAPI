package com.NhapHocVKU.controllers.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.DocumentItemsDTO;
import com.NhapHocVKU.models.Admin.DocumentItems;
import com.NhapHocVKU.services.Admin.DocumentItemsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/api/document")
public class DocumentItemsAPIController {
	@Autowired
	private DocumentItemsService documentItemsService;
	
	public List<DocumentItemsDTO> convertToDTO(List<DocumentItems> list)
	{
		List<DocumentItemsDTO> listDTO = new ArrayList<>();
		for (DocumentItems curry : list) {
			DocumentItemsDTO curryDTO = new DocumentItemsDTO();
			BeanUtils.copyProperties(curry, curryDTO);
			listDTO.add(curryDTO);
		}
		
		return listDTO;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DocumentItemsDTO>> getAll() {
		List<DocumentItems> list = documentItemsService.getAllDocuments();
		
		return ResponseEntity.ok(convertToDTO(list));
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/save", produces = "application/json; charset=utf-8" )
	public String save(@RequestBody @Valid DocumentItemsDTO documentItemsDTO) {
		DocumentItems documentItems = documentItemsService.createDocument(documentItemsDTO);
		
		return documentItems != null ? "Thêm thành công":"Thêm thất bại";
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/update/{id}", produces = "application/json; charset=utf-8")
	public String update(@PathVariable Integer id, @RequestBody @Valid DocumentItemsDTO documentItemsDTO) {
		DocumentItems documentItems = documentItemsService.updateDocument(id, documentItemsDTO);
	
		
		return documentItems != null ? "Cập nhập thành công":"Cập nhập thất bại";
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/deactive/{id}", produces = "application/json; charset=utf-8" )
	public String deactive(@PathVariable int id)
	{		
		DocumentItems documentItems = documentItemsService.deactiveDocument(id);
		
		DocumentItemsDTO documentItemsDTO = new DocumentItemsDTO();
		BeanUtils.copyProperties(documentItems, documentItemsDTO);

		return documentItems != null ? "Thao tác thành công":"Thao tác thất bại";
	}
	
	@GetMapping("/getAllRequire")
	public ResponseEntity<List<DocumentItemsDTO>> getAllRequire() {
		List<DocumentItems> list = documentItemsService.getAllDocumentsRequire();
		
		return ResponseEntity.ok(convertToDTO(list));
	}
	
	@GetMapping("/search")
	public  ResponseEntity<List<DocumentItemsDTO>> search(@RequestParam(required = false) String keyword, @RequestParam(required = false) Integer idKhoa, 
			@RequestParam(required = false) String idNganh, @RequestParam(required = false) Integer idPttt)
	{
		List<DocumentItems> list = documentItemsService.searchByParameters(idKhoa, idNganh, idPttt, keyword);
		
		return ResponseEntity.ok(convertToDTO(list));
	}
	
	// hàm này là để chọn các danh mục giấy tờ cần nộp. Cần truyền vào 1 chuỗi các id của các danh mục giấy tờ, ngăn cách nhau bởi dấy phẩy, rồi
	// trong này sẽ tách ra thành chuỗi, gửi qua service để xử lý. Dùng javascript để post chứ ko dùng form nghen.
	@PostMapping("/selectRequire")
	public ResponseEntity<List<DocumentItemsDTO>> selectRequire(@RequestBody String selected)
	{
		selected = selected.replace('"', ' ').trim();
		String[] listId = selected.split(",");
		
		List<DocumentItems> list = documentItemsService.selectRequire(listId);
		return ResponseEntity.ok(convertToDTO(list));
	}
	
	
}
