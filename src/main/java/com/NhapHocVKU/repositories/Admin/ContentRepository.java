package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.NhapHocVKU.models.Admin.Content;

public interface ContentRepository extends JpaRepository<Content, Integer>, JpaSpecificationExecutor<Content>{
	@Query("SELECT c FROM Content c WHERE c.content LIKE %:keyword% OR c.title LIKE %:keyword% ")
	List<Content> searchByKeyword(String keyword);

}
