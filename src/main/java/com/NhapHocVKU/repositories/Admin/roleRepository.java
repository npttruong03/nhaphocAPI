package com.NhapHocVKU.repositories.Admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.NhapHocVKU.models.Admin.ERole;
import com.NhapHocVKU.models.Admin.Majors;
import com.NhapHocVKU.models.Admin.Role;

public interface roleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
	Optional<Role> findByName(ERole name);

}

