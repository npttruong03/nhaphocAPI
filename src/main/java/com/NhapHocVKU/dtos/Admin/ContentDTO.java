package com.NhapHocVKU.dtos.Admin;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	private String title;
	@NotNull
	@NotEmpty
	private String content;
	
	private boolean status;
	
}
