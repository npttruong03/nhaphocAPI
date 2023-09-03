package com.NhapHocVKU.models.Admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "thisinh_hocphi")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class StudentTuition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_thisinh", nullable = false)
	@NotNull
	private Student idStudent;
	
	@Column(name = "tennguoithu")
	@NotNull
	private String nameCashier;
	
	@Column(name = "tongtien")
	private Integer total;
	
	@Column(name = "minhchungnophocphi")
	private String proofOfTuitionPay;
	
	@Column(name = "id_dmhocphi")
	private String tuitionFeeList;
	
	@Column(name = "status")
	private boolean status;
	@Column(name = "id_ngaythu")
	private String TuitionDay;

}
