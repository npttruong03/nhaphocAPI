package com.NhapHocVKU.repositories.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.NhapHocVKU.models.Admin.Ethnic;

public interface EthnicRepository extends JpaRepository<Ethnic, Integer>, JpaSpecificationExecutor<Ethnic>{

   
}
