package com.NhapHocVKU.models.Admin;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "danhmucgiayto")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class DocumentItems {
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
	@JoinColumn(name = "id_pttt", nullable = false, unique = true)
	private Method method;
	
	@Column(name = "loaigiayto", nullable = false)
	private String documentType;
	
	@Column(name = "soluong", nullable = false)
	private Integer soLuong;
	
	@Column(name = "ghi_chu", nullable = false)
	private String note;
	
	@Column(name = "status", columnDefinition = "tinyInt(1)", nullable = false)
	private Boolean status;
	
	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	private Timestamp createTime;
	
	@Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	private Timestamp updateTime;

}

