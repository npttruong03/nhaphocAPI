package com.NhapHocVKU.models.Admin;



import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "thisinh")
public class Student {
	@Id
	private String id;
	
	@Column(name = "cccd", nullable = false)
	@NotNull(message = "CCCD must not be null")
	private String numberCIC;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idnganh")
	private Majors majors;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_khoa")
	private Khoa khoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cth")
	private Curriculum curriculum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pttt")
	private Method method;
	
	@Column(name = "ho_ten", nullable = false)
	
	private String fullName;
	
	@Column(name = "ngay_sinh", nullable = false)
	@NotNull(message = "Birthday must not be null")
	private String birthday;
	
	@Column(name = "noi_sinh")
	private String birthplace;
	
	@Column(name = "gioi_tinh")
	private String gender;
	
	@Column(name = "que_quan")
	private String homeTown;
	
	@Column(name = "dan_toc")
	private String ethnic;
	
	@Column(name = "dien_thoai")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "doan_vien")
	private boolean unionMember;
	
	@Column(name = "dien_chinh_sach", nullable = true)
	private String treatmentPolicy;
	
	@Column(name = "id_giayto", nullable = true)
	private String documentItems;
	
	@Column(name = "dien_thoai_gia_dinh")
	private String phoneNbHome;
	
	@Column(name = "minh_chung_nhap_hoc")
	private String proofOfAdmission;
	
	@Column(name = "buoi_dang_ky")
	private Byte registerSession;
	
	@Column(name = "namtotnghiep")
	private Integer graduationYear;
	
	@Column(name = "truongthpttotnghiep")
	private String highSchool;
	
	@Column(name = "matruongthpt")
	private String idHighSchool;
	
	@Column(name = "school10")
	private String school10;
	
	@Column(name = "school11")
	private String school11;
	
	@Column(name = "school12")
	private String school12;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
    private Timestamp createTime;
@Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", updatable = true, nullable = false)
    private Timestamp updateTime;
	
	@Column(name = "ngaycapcccd")
	private String dateIssuanceCIC;
	
	@Column(name = "noicapcccd")
	private String placeIssuanceCIC;
	
	@Column(name = "id_student")
	private String idStudent;
	
	@JsonIgnore
	@OneToOne(mappedBy = "idStudent")
	private StudentTuition studentTuition;
	
	@Column(name = "class")
	private String className;
//	@JsonIgnore
//	@OneToOne(mappedBy = "idStudent")
//	private StudentCurriculum studentCurriculum;
	
}