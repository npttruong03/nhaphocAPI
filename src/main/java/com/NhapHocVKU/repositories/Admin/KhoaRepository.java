package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.NhapHocVKU.models.Admin.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, Integer>, JpaSpecificationExecutor<Khoa>{
	@Query("SELECT k FROM Khoa k WHERE k.khoa LIKE %:keyword% OR k.namBatDau LIKE %:keyword% OR k.namKetThuc LIKE %:keyword%")
    List<Khoa> searchByKeyword(String keyword);
	@Query("SELECT k FROM Khoa k WHERE k.status = true")
	List<Khoa> getKhoaNameByStatus();
}
