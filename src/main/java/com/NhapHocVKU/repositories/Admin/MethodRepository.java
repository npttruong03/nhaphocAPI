package com.NhapHocVKU.repositories.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.models.Admin.Method;
import com.NhapHocVKU.services.Admin.MethodService;

public interface MethodRepository extends JpaRepository<Method, Integer> {
}
