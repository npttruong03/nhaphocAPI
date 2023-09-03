package com.NhapHocVKU.dtos.Admin;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String khoa;
	
	private Integer namBatDau;

	private Integer namKetThuc;
	
	private Timestamp thoiGianBatDau ;
	
	private Timestamp thoiGianKetThuc;
	
	private boolean status;
}
