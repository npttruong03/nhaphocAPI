package com.NhapHocVKU.controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.NhapHocVKU.dtos.Admin.StudentDTO;
import com.NhapHocVKU.models.Admin.Student;
import com.NhapHocVKU.services.Admin.StudentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
public class StudentAPIController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/admin/list")
	@PreAuthorize("hasRole('TAIVU') or hasRole('DAOTAO') or hasRole('ADMIN') or hasRole('CTSV')")
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.ok(studentService.findAll());
	}

	@GetMapping("/admin/currentAdmissionStudents")
	@PreAuthorize("hasRole('TAIVU') or hasRole('DAOTAO') or hasRole('ADMIN') or hasRole('CTSV')")
	public ResponseEntity<Object> getCurrentAdmissionStudents() {
		return ResponseEntity.ok(studentService.getStudentsByStatus());
	}

	@GetMapping("/admin/list/{id}")
	public ResponseEntity<Object> findStudentById(@PathVariable("id") @Valid String id) {
		return ResponseEntity.ok(studentService.getById(id));
	}

	// Kiểm tra thông tin CCCD và ngày sinh thí sinh đăng ký nhập học
	@PostMapping("/students/login")
	public ResponseEntity<Student> getStudentByCICandBirthday(@RequestBody Student student) {
		String CIC = student.getNumberCIC();
		String birthday = student.getBirthday();
		return ResponseEntity.ok(studentService.findStudentByCICandBirthday(CIC, birthday));
	}

	@GetMapping("admin/list/search")
	public ResponseEntity<List<Student>> search(@RequestParam(required = false) String idMajor,
			@RequestParam(required = false) Integer idKhoa, @RequestParam(required = false) Integer idMethod,
			@RequestParam(required = false) Integer idCurriculum, @RequestParam(required = false) String keyWord) {
		if (idMajor == "") {
			idMajor = null;
		}
		List<Student> listSearched = studentService.searchByOptions(idMajor, idKhoa, idMethod, idCurriculum, keyWord);

		return ResponseEntity.ok(listSearched);
	}

	@PutMapping("/admin/studentDocumentManagement/{id}")
	@ResponseBody
	public String updateDocumentItemsStudentForId(@Valid @NotNull @PathVariable("id") String id,
			@RequestBody String documentItemsJson) {
		String documentItems = documentItemsJson.split(":")[1];
		int startIndex = documentItems.indexOf("\"");
		int endIndex = documentItems.indexOf("\"", startIndex + 1);
		String result = documentItems.substring(startIndex + 1, endIndex);
		studentService.updateDocumentItemsStudentForId(id, result);
		String message = "success";
		return message;
	}

	@PutMapping("admin/placement")
	public String sortClass(@RequestParam(name = "idNganh", required = true) String idNganh,
			@RequestParam(required = false) String nameMajor, @RequestParam(required = false) String nameClass) {
		studentService.setStudentsClassNormalForMajor(idNganh);

		studentService.setStudentsClassGlobalForMajor(idNganh);

		if (nameMajor != null)
			studentService.setStudentsClassOtherForMajor(nameMajor, idNganh);

		return "Đã hoàn thành xếp lớp";
	}

	@PostMapping("/students/add")
	public ResponseEntity<Object> add(@RequestBody @Valid Student student) {
		return ResponseEntity.ok(studentService.save(student));
	}

	@PutMapping("/students/{id}")
	@ResponseBody
	public String update(@RequestBody @Valid StudentDTO studentDTO, @Valid @NotNull @PathVariable("id") String id) {
		boolean studentUpdated = studentService.Update(id, studentDTO);
		String message = "";
		if (studentUpdated) {
			message = "Đăng ký nhập học thành công";
		} else {
			message = "Lỗi";

		}
		return message;
	}

//	@GetMapping("/search")
//    public ResponseEntity<List<Student>> searchSinhvienByKeyword(
//            @RequestParam("keyword") String keyword
//    ) {
//        List<Student> StudentList = StudentService.searchByKeyword(keyword);
//        return ResponseEntity.ok(StudentList);
//    }

}
