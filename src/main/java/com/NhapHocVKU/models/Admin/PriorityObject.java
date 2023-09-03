package com.NhapHocVKU.models.Admin;

import java.sql.Timestamp;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "doituonguutien")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriorityObject {
	@Id
	@Column(length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ma_doi_tuong", length = 10, nullable = false)
	private String idObject;
	
	@Column(name = "ten_doi_tuong", length = 255, nullable = false)
	private String name;
	
	@Column(name = "diem_cong", columnDefinition = "double(3,2) NOT NULL")
	private Double scoreAdd;
	
	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
	private Timestamp createTime;
	
	@Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", updatable = true, nullable = false)
	private Timestamp updateTime;
	
	@Column(columnDefinition = "tinyInt(1)")
	private Boolean status;
	
}