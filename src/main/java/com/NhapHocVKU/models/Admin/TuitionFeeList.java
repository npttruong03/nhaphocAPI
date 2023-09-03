package com.NhapHocVKU.models.Admin;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name = "danhmuchocphi")
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class TuitionFeeList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_khoa")
	private Khoa khoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nganh")
	private Majors majors;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chuongtrinhhoc")
	private Curriculum curriculum;
	
	@Column(name = "hocphi", nullable = false)
	@Min(value = 0)
	private Integer tuition;
	
	@Column(name = "tenhocphi", nullable = false)
	@NotNull
	private String name;
	
	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	private Timestamp createTime;
	
	
	@Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	private Timestamp updateTime;
	
	@Column(name = "status", nullable = false)
	private Boolean status;

}
