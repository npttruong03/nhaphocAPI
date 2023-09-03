package com.NhapHocVKU.dtos.Admin;

import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.Majors;
import com.NhapHocVKU.models.Admin.Method;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentItemsDTO {
	Integer id;
	@NotNull
	private Khoa khoa;
	
	@NotNull
	private Majors majors;
	
	@NotNull
	private Method method;
	
	@NotNull
	@NotEmpty
	private String documentType;
	
	@NotNull
	@Min(value = 1)
	private Integer soLuong;
	
	@NotNull
	@NotEmpty
	private String note;
	
	private Boolean status;
}
