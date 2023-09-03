package com.NhapHocVKU.dtos.Admin;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MajorsDTO {

	@NotNull
	@NotEmpty
	private String majorsID;
	
	@NotEmpty
	@NotNull
	private String majorsName;
	
	@NotEmpty
	@NotNull
	private String majorsNameStandFor;
	
	private boolean status;
	

}
