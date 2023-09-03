//package com.NhapHocVKU.controllers.Admin;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.NhapHocVKU.dtos.Admin.AccountsDTO;
//import com.NhapHocVKU.models.Admin.Account;
//import com.NhapHocVKU.services.Admin.AccountsService;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotNull;
//@Controller
//@RequestMapping("/admin/api")
//public class AccountAPIController {
//
//    @Autowired
//    private AccountsService accountsService;
//
//    
//    
//    @GetMapping("/account")
//	public ResponseEntity<Object> findAll(){
//		return ResponseEntity.ok(accountsService.findAll());
//	}
//
//	@RequestMapping(method = RequestMethod.POST, path = "/account/create", produces = "application/json; charset=utf-8")
//    @ResponseBody
//	public String createAccount(@RequestBody @Valid Account account){
//		
//		return accountsService.save(account)!=null ? "Thêm thành công":"Thêm thất bại" ;
//	}
//
//    @RequestMapping(method = RequestMethod.PUT, path = "/account/edit/{id}", produces = "application/json; charset=utf-8")
//	@ResponseBody
//	public String update (@RequestBody @Valid AccountsDTO accountsDTO, @Valid @NotNull @PathVariable("id") int id){
//		return accountsService.Update(id, accountsDTO)!=null?"Cập nhập thành công":"Cập nhập thất bại";
//	}
//
//}