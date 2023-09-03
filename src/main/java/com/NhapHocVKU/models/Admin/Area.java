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

@Table(name="khuvuc")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private Integer id;
	
	@Column(name = "ma_khu_vuc", length = 10)
	private String idArea;
	

	@Column(name = "ten_khu_vuc", length = 255, nullable = false)
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

