package com.NhapHocVKU.dtos.Admin;


import java.sql.Timestamp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MethodDTO {
	@NotNull
	@NotEmpty
	private String ma_phuong_thuc;
	@NotNull
	@NotEmpty
	private String ten_phuong_thuc;
	
    private Timestamp createTime;
	
    private Timestamp updateTime;
	
	private boolean status;
	

}
