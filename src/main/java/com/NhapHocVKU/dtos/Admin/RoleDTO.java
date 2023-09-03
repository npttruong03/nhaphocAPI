package com.NhapHocVKU.dtos.Admin;

import java.sql.Timestamp;
import java.util.List;

import com.NhapHocVKU.models.Admin.Account;
import com.NhapHocVKU.models.Admin.Role;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class RoleDTO {

	
	private String name;
	    private boolean status;

}
