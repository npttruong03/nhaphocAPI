package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.NhapHocVKU.models.Admin.DocumentItems;

public interface DocumentItemsRepository extends JpaRepository<DocumentItems, Integer>, JpaSpecificationExecutor<DocumentItems>{
	@Query(value = "SELECT * FROM danhmucgiayto WHERE status = 1", nativeQuery = true)
	List<DocumentItems> getAllDocumentsRequire();
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE loaigiayto LIKE %:keyword%", nativeQuery = true)
	List<DocumentItems> searchByKeyword(@Param("keyword") String keyword);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_khoa = :idKhoa", nativeQuery = true)
	List<DocumentItems> searchByIdKhoa(@Param("idKhoa") int idKhoa);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_nganh = :idNganh", nativeQuery = true)
	List<DocumentItems> searchByIdNganh(@Param("idNganh") String idNganh);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_pttt = :idPttt", nativeQuery = true)
	List<DocumentItems> searchByIdPttt(@Param("idPttt") int idPttt);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_khoa = :idKhoa AND id_nganh = :idNganh", nativeQuery = true)
	List<DocumentItems> searchByIdKhoaAndIdNganh(@Param("idKhoa") int idKhoa, @Param("idNganh") String idNganh);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_khoa = :idKhoa AND id_pttt = :idPttt", nativeQuery = true)
	List<DocumentItems> searchByIdKhoaAndIdPttt(@Param("idKhoa") int idKhoa, @Param("idPttt") int idPttt);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_nganh = :idNganh AND id_pttt = :idPttt", nativeQuery = true)
	List<DocumentItems> searchByIdNganhAndIdPttt(@Param("idNganh") String idNganh, @Param("idPttt") int idPttt);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_khoa = :idKhoa AND id_nganh = :idNganh AND id_pttt = :idPttt", nativeQuery = true)
	List<DocumentItems> searchByIdAll(@Param("idKhoa") int idKhoa, @Param("idNganh") String idNganh, @Param("idPttt") int idPttt);
	
	@Query(value = "SELECT * FROM danhmucgiayto WHERE id_khoa = :idKhoa AND id_nganh = :idNganh AND id_pttt = :idPttt AND loaigiayto LIKE '%:keyword%'", nativeQuery = true)
	List<DocumentItems> searchByAll(@Param("idKhoa") int idKhoa, @Param("idNganh") String idNganh, @Param("idPttt") int idPttt, @Param("keyword") String keyword);
}
