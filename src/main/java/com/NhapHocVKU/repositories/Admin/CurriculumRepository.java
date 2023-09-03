package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.NhapHocVKU.models.Admin.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer>{
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE tenchuontrinh LIKE %:keyword%", nativeQuery = true)
	List<Curriculum> searchByKeyword(@Param("keyword") String keyword);
	
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE id_khoa = :idKhoa", nativeQuery = true)
	List<Curriculum> searchByIdKhoa(@Param("idKhoa") int idKhoa);
	
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE id_nganh = :idNganh", nativeQuery = true)
	List<Curriculum> searchByIdNganh(@Param("idNganh") String idNganh);
	
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE id_khoa = :idKhoa AND id_nganh = :idNganh", nativeQuery = true)
	List<Curriculum> searchByIdKhoaAndIdNganh(@Param("idKhoa") int idKhoa, @Param("idNganh") String idNganh);
	
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE id_khoa = :idKhoa AND tenchuontrinh LIKE %:keyword%", nativeQuery = true)
	List<Curriculum> searchByIdKhoaAndKeyword(@Param("idKhoa") int idKhoa, @Param("keyword") String keyword);
	
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE id_nganh = :idNganh AND tenchuontrinh LIKE %:keyword%", nativeQuery = true)
	List<Curriculum> searchByIdNganhAndKeyword(@Param("idNganh") String idNganh, @Param("keyword") String keyword);
	
	@Query(value = "SELECT * FROM chuongtrinhhoc WHERE id_khoa = :idKhoa AND id_nganh = :idNganh AND tenchuontrinh LIKE %:keyword%", nativeQuery = true)
	List<Curriculum> searchByAll(@Param("idKhoa") int idKhoa, @Param("idNganh") String idNganh,  @Param("keyword") String keyword);
}
