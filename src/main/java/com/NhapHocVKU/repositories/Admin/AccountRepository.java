package com.NhapHocVKU.repositories.Admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.NhapHocVKU.models.Admin.Account;
import com.NhapHocVKU.models.Admin.Majors;



@Repository 	
public interface AccountRepository extends JpaRepository<Account,Integer>, JpaSpecificationExecutor<Account>{
	Optional<Account> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}