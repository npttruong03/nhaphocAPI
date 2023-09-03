package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.NhapHocVKU.models.Admin.Student;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {

	Student findFirstByNumberCICAndBirthdayOrderByCreateTimeDesc(String numberCIC, String birthday);

	@Query("SELECT t FROM Student t JOIN Curriculum c ON t.curriculum.id = c.id WHERE c.name "
			+ "LIKE 'global%' AND t.majors.id = :idNganh AND c.majors.id = t.majors.id AND t.status = true AND c.status = true"
			+ " ORDER BY RIGHT(t.fullName, 1) ASC")
	List<Student> getStudentsClassGlobalForMajor(@Param("idNganh") String idNganh);

	@Query("SELECT t FROM Student t JOIN Curriculum c ON t.curriculum.id = c.id WHERE c.name "
			+ "LIKE 'normal%' AND t.majors.id = :idNganh AND c.majors.id = t.majors.id AND t.status = true AND c.status = true"
			+ " ORDER BY RIGHT(t.fullName, 1) ASC")
	List<Student> getStudentsClassNormalForMajor(@Param("idNganh") String idNganh);

	@Query("SELECT t FROM Student t JOIN Curriculum c ON t.curriculum.id = c.id WHERE c.name "
			+ "LIKE :keyword AND t.majors.id = :idNganh AND c.majors.id = t.majors.id AND t.status = true AND c.status = true"
			+ " ORDER BY RIGHT(t.fullName, 1) ASC")
	List<Student> getStudentsClassOtherForMajor(@Param("keyword") String keyword, @Param("idNganh") String idNganh);

	@Query("SELECT s FROM Student s "
			+ " WHERE (:majorId IS NULL OR s.majors.id = :majorId) AND (:khoaId IS NULL OR s.khoa.id = :khoaId) "
			+ "AND (:methodId IS NULL OR s.method.id = :methodId) AND (:curriculumId IS NULL OR s.curriculum.id = :curriculumId) "
			+ "AND (s.status = true)"
			+ "AND (:searchKeyword IS NULL OR LOWER(s.fullName) LIKE CONCAT('%', LOWER(:searchKeyword), '%') "
			+ "OR LOWER(s.numberCIC) LIKE CONCAT('%', LOWER(:searchKeyword), '%') "
			+ "OR LOWER(s.phoneNumber) LIKE CONCAT('%', LOWER(:searchKeyword), '%'))")
	List<Student> searchByOptions(@Param("majorId") String majorId, @Param("khoaId") Integer khoaId,
			@Param("methodId") Integer methodId, @Param("curriculumId") Integer curriculumId,
			@Param("searchKeyword") String searchKeyword);
//	List<Student> searchByOptions(Integer majorId, Integer khoaId, Integer methodId, Integer curriculumId, String searchKeyword);

	@Modifying
	@Query("UPDATE Student s SET s.documentItems = :documentItems WHERE s.id = :id")
	void updateDocumentItemsStudentForId(@Param("id") String id, @Param("documentItems") String documentItems);

	@Query("SELECT st FROM Student st WHERE st.status = true")
	List<Student> getStudentsByStatus();
}