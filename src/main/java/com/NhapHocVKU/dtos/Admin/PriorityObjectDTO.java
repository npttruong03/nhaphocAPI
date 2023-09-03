package com.NhapHocVKU.dtos.Admin;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriorityObjectDTO {
	
	@NotEmpty
	@NotNull
	@Size(max = 10, message = "Mã đối tượng tối đa là 10 kí tự")
	private String idObject;
	
	@NotEmpty
	@NotNull
	@Size(max = 255, message = "Tên đối tượng tối đa là 255 kí tự")
	private String name;
	
	@NotNull
	@Max(value = 2)
	@Min(value = 0)
	private Double scoreAdd; 
	
	private Boolean status;
}