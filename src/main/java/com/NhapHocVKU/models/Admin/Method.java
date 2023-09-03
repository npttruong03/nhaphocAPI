package com.NhapHocVKU.models.Admin;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "phuongthuctrungtuyen")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Method {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ma_phuong_thuc", nullable = false)
	@NotNull
	@NotEmpty
	private String ma_phuong_thuc;
	
	@Column(name = "ten_phuong_thuc", nullable = false)
	@NotNull
	@NotEmpty
	private String ten_phuong_thuc;
	
	@Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, nullable = false)
    private Timestamp createTime;
	
	@Column(name = "update_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", updatable = true, nullable = false)
    private Timestamp updateTime;
	
	 @Column(nullable = false)
	    private boolean status;
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "method")
	 private List<Student> student;
	 
	 @OneToMany(mappedBy = "method")
	 @JsonIgnore
	 private List<DocumentItems> documentItems;
}
