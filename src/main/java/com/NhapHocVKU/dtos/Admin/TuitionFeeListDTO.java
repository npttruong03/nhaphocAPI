package com.NhapHocVKU.dtos.Admin;


import com.NhapHocVKU.models.Admin.Curriculum;
import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.Majors;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TuitionFeeListDTO {
	@NotNull
	private Khoa khoa;
	
	@NotNull
	private Majors majors;
	
	@NotNull
	private Curriculum curriculum;
	
	@NotNull
	@Min(value = 10000)
	private Integer tuition;
	
	@NotNull
	@NotEmpty
	private String name;
	
	private Boolean status;
}
