package com.NhapHocVKU.services.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.models.Admin.Account;
import com.NhapHocVKU.repositories.Admin.AccountRepository;

@Service
public class UserService {


	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
}
