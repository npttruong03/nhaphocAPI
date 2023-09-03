package com.NhapHocVKU.dtos.Admin;

import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.Majors;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumDTO {
	@NotEmpty
	@NotNull
	private String name;
	
	@NotNull
	private Khoa khoa;
	
	@NotNull
	private Majors majors;
	
	@NotNull
	private Boolean status;
}
