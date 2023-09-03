package com.NhapHocVKU.services.Admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.AccountsDTO;
import com.NhapHocVKU.models.Admin.Account;
import com.NhapHocVKU.repositories.Admin.AccountRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountsService {

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Autowired
	private AccountRepository  accountRepository;

	// Lấy danh sách tất cả các Accounts
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	// Lấy Accounts theo Id
	public Account findById(int id) {
		return accountRepository.findById(id).orElse(null);
	}


	// Lưu Accounts
//	public void save(Account account) {
//	    String encodedPassword = encoder.encode(account.getPassword());
//	    account.setPassword(encodedPassword);
//	    accountRepository.save(account);
//	}

	//update accounts
	

//	public Account save(Account account) {
//		// TODO Auto-generated method stub
//		account.setId(0);
//		return accountRepository.save(account);
//	}
	public Account getById(Integer id) {
	 	Account original = requireOne(id);
        return original;
    }
	 private Account requireOne(Integer id) {
	        return accountRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	    }

	public Account Update(@Valid @NotNull int id, AccountsDTO accountsDTO) {
		// TODO Auto-generated method stub
		Account account = requireOne(id);
		BeanUtils.copyProperties(accountsDTO, account);
		return accountRepository.save(account);
	}
	
}