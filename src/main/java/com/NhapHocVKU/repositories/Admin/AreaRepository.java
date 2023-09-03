package com.NhapHocVKU.repositories.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NhapHocVKU.models.Admin.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
	

}
