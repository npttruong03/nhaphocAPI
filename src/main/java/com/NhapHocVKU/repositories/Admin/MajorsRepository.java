package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.NhapHocVKU.models.Admin.Majors;

public interface MajorsRepository extends JpaRepository<Majors, String>, JpaSpecificationExecutor<Majors>{
	@Query("SELECT m FROM Majors m WHERE m.majorsID LIKE %:keyword% OR m.majorsName LIKE %:keyword%")
	List<Majors> searchByKeyword(String keyword);
	
}
