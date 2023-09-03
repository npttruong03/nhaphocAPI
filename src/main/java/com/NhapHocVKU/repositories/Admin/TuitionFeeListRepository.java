package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.NhapHocVKU.models.Admin.TuitionFeeList;

public interface TuitionFeeListRepository
		extends JpaRepository<TuitionFeeList, Integer>, JpaSpecificationExecutor<TuitionFeeList> {

	List<TuitionFeeList> findByKhoaId(Integer khoaId);

	List<TuitionFeeList> findByMajorsId(String majorsId);

	@Query(value = "SELECT * FROM danhmuchocphi WHERE id_chuongtrinhhoc = :curriculumId", nativeQuery = true)
	List<TuitionFeeList> findByCurriculumId(@Param("curriculumId") Integer curriculumId);

	@Query(value = "SELECT * FROM danhmuchocphi WHERE id_khoa=:khoaId and id_nganh=:majorsId", nativeQuery = true)
	List<TuitionFeeList> findByKhoaIdAndMajorsId(@Param("khoaId") Integer khoaId, @Param("majorsId") String majorsId);

	@Query(value = "SELECT * FROM danhmuchocphi WHERE id_chuongtrinhhoc = :curriculumId and id_khoa=:khoaId", nativeQuery = true)
	List<TuitionFeeList> findByKhoaIdAndCurriculumId(@Param("khoaId") Integer khoaId,
			@Param("curriculumId") Integer curriculumId);

	@Query(value = "SELECT * FROM danhmuchocphi WHERE id_chuongtrinhhoc = :curriculumId and id_nganh=:majorsId", nativeQuery = true)
	List<TuitionFeeList> findByMajorsIdAndCurriculumId(@Param("majorsId") String majorsId,
			@Param("curriculumId") Integer curriculumId);

	@Query(value = "SELECT * FROM danhmuchocphi WHERE id_chuongtrinhhoc = :curriculumId and id_nganh=:majorsId and id_khoa=:khoaId", nativeQuery = true)
	List<TuitionFeeList> findByKhoaIdAndMajorsIdAndCurriculumId(@Param("khoaId") Integer khoaId,
			@Param("majorsId") String majorsId, @Param("curriculumId") Integer curriculumId);

}
