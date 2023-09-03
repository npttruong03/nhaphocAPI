package com.NhapHocVKU.dtos.Admin;

import java.sql.Timestamp;

import com.NhapHocVKU.models.Admin.Role;

import jakarta.persistence.Access;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDTO {

//	private long id;

	@NotEmpty
	@NotNull(message = "Username must not be null")
	@Size(max = 255, message = "tối đa là 255 kí tự")
	private String username;
	@NotEmpty
	@NotNull(message = "Password must not be null")
	@Size(max = 255, message = " tối đa là 255 kí tự")
	private String password;
	
	private Role role;

	private boolean status;
}
