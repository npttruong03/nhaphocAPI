package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.NhapHocVKU.models.Admin.StudentTuition;

public interface StudentTuitionRepository 
extends JpaRepository<StudentTuition, Integer>, JpaSpecificationExecutor<StudentTuition>{

	@Query(value = "SELECT thisinh_hocphi.id, thisinh_hocphi.id_thisinh, thisinh_hocphi.tennguoithu"
			+ ",thisinh_hocphi.tongtien, thisinh_hocphi.minhchungnophocphi,"
			+ "thisinh_hocphi.id_dmhocphi, thisinh_hocphi.status"
			+ ",thisinh_hocphi.id_ngaythu FROM thisinh_hocphi, thisinh WHERE thisinh.id = thisinh_hocphi.id_thisinh "
			+ "and (thisinh.idnganh = :majorId OR :majorId IS NULL) AND (:khoaId IS NULL OR thisinh.id_khoa = :khoaId)"
            + "AND (:curriculumId IS NULL OR thisinh.id_cth = :curriculumId)"
           	+ "AND (:searchKeyword IS NULL OR LOWER(thisinh.ho_ten) LIKE CONCAT('%', LOWER(:searchKeyword), '%') "
			+ "OR LOWER(thisinh.cccd) LIKE CONCAT('%', LOWER(:searchKeyword), '%') "
			+ "OR LOWER(thisinh_hocphi.tennguoithu) LIKE CONCAT('%', LOWER(:searchKeyword), '%') "
			+ "OR LOWER(thisinh.dien_thoai) LIKE CONCAT('%', LOWER(:searchKeyword), '%'))", nativeQuery = true)
	List<StudentTuition> searchByOptions(@Param("majorId") String majorId, @Param("khoaId") Integer khoaId,
			@Param("curriculumId") Integer curriculumId,
			@Param("searchKeyword") String searchKeyword);
}
