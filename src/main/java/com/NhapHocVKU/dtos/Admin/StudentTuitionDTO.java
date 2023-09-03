package com.NhapHocVKU.dtos.Admin;

import java.io.Serializable;

import com.NhapHocVKU.models.Admin.Student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTuitionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Student idStudent;
	
	private String nameCashier;
	
	private Integer total;

	private String proofOfTuitionPay;
	
	private String tuitionFeeList;

	private boolean status;
}