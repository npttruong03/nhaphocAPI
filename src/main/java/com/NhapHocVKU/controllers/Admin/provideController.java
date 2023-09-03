package com.NhapHocVKU.controllers.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.AreaDTO;
import com.NhapHocVKU.models.Admin.Area;
import com.NhapHocVKU.services.Admin.AccountsService;
import com.NhapHocVKU.services.Admin.AreaService;
import com.NhapHocVKU.services.Admin.MethodService;


@RestController
@RequestMapping("/api/test")
public class provideController {
		
	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private AreaService areaService;
		
	  @GetMapping("/all")
	  public ResponseEntity<Object> findAll() {
		  return ResponseEntity.ok(accountsService.findAll());
	  }
	  
//		@GetMapping("/getAll")
//		@PreAuthorize("hasRole('DAOTAO')")
//		public ResponseEntity<List<AreaDTO>> getAll() {
//			System.out.println("vai o");
//			List<Area> list = areaService.getAllAreas();
//			List<AreaDTO> listDTO = new ArrayList<>();
//			for (Area area : list) {
//				AreaDTO areaDTO = new AreaDTO();
//				BeanUtils.copyProperties(area, areaDTO);
//				listDTO.add(areaDTO);
//			}
//
//			return ResponseEntity.ok(listDTO);
//		}

	  @GetMapping("/user")
	  @PreAuthorize("hasRole('TAIVU') or hasRole('DAOTAO') or hasRole('ADMIN') or hasRole('CTSV')")
	  public String userAccess() {
	    return "User Content.";
	  }

	  @GetMapping("/taivu")
	  @PreAuthorize("hasRole('TAIVU')")
	  public String moderatorAccess() {
	    return "taivu Board.";
	  }
	  
	  @GetMapping("/daotao")
	  @PreAuthorize("hasRole('DAOTAO')")
	  public String daotaoAccess() {
	    return "daotao Board.";
	  }

	  @GetMapping("/admin")
	  @PreAuthorize("hasRole('ADMIN')")
	  public String adminAccess() {
	    return "Admin Board.";
	  }
	  
	  @GetMapping("/ctsv")
	  @PreAuthorize("hasRole('CTSV')")
	  public String ctsvAccess() {
	    return "ctsv Board.";
	  }
	}

