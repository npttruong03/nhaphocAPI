package com.NhapHocVKU.dtos.Admin;


import java.util.Date;

import com.NhapHocVKU.models.Admin.Curriculum;
import com.NhapHocVKU.models.Admin.Khoa;
import com.NhapHocVKU.models.Admin.Majors;
import com.NhapHocVKU.models.Admin.Method;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
//	private String id;
	
	private String numberCIC;
	private Majors majors;
	private Khoa khoa;
	private Method method;
	private Curriculum curriculum;

	private String fullName;
	
	private String birthday;
	private String birthplace;
	private String gender;
	private String homeTown;
	private String ethnic;
	private String phoneNumber;
	private String email;
	private boolean unionMember;
	private String treatmentPolicy;
	private String documentItems;
	private String phoneNbHome;
	private String proofOfAdmission;
	private Byte registerSession;
	private Integer graduationYear;
	private String highSchool;
	private String idHighSchool;
	private String school10;
	private String school11;
	private String school12;
	private boolean status;
	private String className;
	private String idStudent;
	private String dateIssuanceCIC;
	private String placeIssuanceCIC;	

}