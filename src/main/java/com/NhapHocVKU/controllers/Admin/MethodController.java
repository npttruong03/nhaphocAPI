package com.NhapHocVKU.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.MethodDTO;
import com.NhapHocVKU.models.Admin.Method;
import com.NhapHocVKU.services.Admin.MethodService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/api")
public class MethodController {
	@Autowired
	private MethodService methodService;

	
	@GetMapping("/method")
	public ResponseEntity<Object> findAlls() {
		return ResponseEntity.ok(methodService.findAll());
	}
	
//	 @GetMapping("/listMethod")
//	    public String index(Model model, @RequestParam(required = false) Integer limit) {
//	        // Trả về đối tượng methodList.
//	        model.addAttribute("methodList", methodService.findAll(limit));
//	        // Trả về template "listTodo.html"
//	        return "Method";
//	    }
//	
	@RequestMapping(method = RequestMethod.POST, path = "/addMethod", produces = "application/json; charset=utf-8")
    @ResponseBody
	public ResponseEntity<Method> insert(@RequestBody @Valid Method method){
		methodService.save(method);
		return ResponseEntity.ok(method);
	}
	
//	@RequestMapping(method = RequestMethod.POST, path = "/addMethod", produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public String addMethod(Model model) {
//        model.addAttribute("method", new Method());
//        return "addMethod";
//    }
	 



	@PutMapping("/method/update/{id}")
	public ResponseEntity<Method> update(@PathVariable @Valid Integer id, @RequestBody @Valid MethodDTO methodDTO) {
		Method editMethod = methodService.Update(id, methodDTO);
		return ResponseEntity.ok().body(editMethod);
	}
	
//	@PutMapping("/method/update/{id}")
//	public String editMethod(@PathVariable Integer id, Model model) {
//		model.addAttribute("editMethod", methodService.getById(id));
//		return "EditMethod";
//	}
}
