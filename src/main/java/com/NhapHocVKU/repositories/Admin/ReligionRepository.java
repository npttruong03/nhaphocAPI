package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.NhapHocVKU.models.Admin.Religion;

public interface ReligionRepository extends JpaRepository<Religion, Integer>, JpaSpecificationExecutor<Religion>{

   
}
