package com.NhapHocVKU.services.Admin;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NhapHocVKU.dtos.Admin.StudentDTO;
import com.NhapHocVKU.models.Admin.Student;
import com.NhapHocVKU.repositories.Admin.KhoaRepository;
import com.NhapHocVKU.repositories.Admin.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private MajorsService majorsService;
	@Autowired
	private KhoaRepository khoaRepository;

	private static Set<String> usedIds = new HashSet<>();

	public Student save(Student student) {

		String id;
		do {
			id = generateUniqueId();
		} while (usedIds.contains(id));
		student.setId(id);
		usedIds.add(id);
		return studentRepository.save(student);
	}

	private String generateUniqueId() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000) + 1;
		UUID uuid = UUID.randomUUID();
		String uniqueId = uuid.toString();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String timeString = timestamp.toString();
		String uid = timeString.replaceAll("[-:. ]", Integer.toString(randomNumber));
		uid = uid + uniqueId;
		return uid.toString();
	}

	public List<Student> findAll() {

		return studentRepository.findAll();
	}

	public boolean Update(String id, StudentDTO studentDTO) {
		Student student = this.requireOne(id);
		BeanUtils.copyProperties(studentDTO, student);

		return studentRepository.save(student).getClass() == Student.class;
	}

	public void updateDocumentItemsStudentForId(String id, String documentItems) {
		 studentRepository.updateDocumentItemsStudentForId(id, documentItems);
		}

	public Student getById(String id) {
		Student original = requireOne(id);
		return original;
	}

	private Student requireOne(String id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}
	// Lấy danh sách sinh viên status =1( sinh nhập học hiện tại)
	public List<Student> getStudentsByStatus() {

		return studentRepository.getStudentsByStatus();
	}
	public Student findStudentByCICandBirthday(String numberCIC, String birthday) {
		return studentRepository.findFirstByNumberCICAndBirthdayOrderByCreateTimeDesc(numberCIC, birthday);
	}
		
	
	// Tìm kiếm theo options
	public List<Student> searchByOptions(String majorId, Integer khoaId, Integer methodId, Integer curriculumId,
			String searchKeyword) {
		return studentRepository.searchByOptions(majorId, khoaId, methodId, curriculumId, searchKeyword);
	}
	public List<Student> getStudentsClassOtherForMajor(String majorName, String idNganh) {

		return studentRepository.getStudentsClassOtherForMajor(majorName, idNganh);
	}


	// Xếp lớp

	public void setStudentsClassGlobalForMajor(String idNganh) {

		List<Student> listStudentsGlobalClass = studentRepository.getStudentsClassGlobalForMajor(idNganh);
		int quantityStudents = listStudentsGlobalClass.size();

		if (quantityStudents >= 60 && quantityStudents <= 70) {
			for (int i = 0; i < quantityStudents; i++) {
				Student student = requireOne(listStudentsGlobalClass.get(i).getId());
				student.setClassName(getKhoaName() + "G" + getMajornameStandFor(idNganh));
				studentRepository.save(student);
			}
		} else if (quantityStudents > 70 && quantityStudents <= 130) {
			int numberClass = 2;
			for (int i = 0; i < quantityStudents; i++) {
				Student student = requireOne(listStudentsGlobalClass.get(i).getId());
				int m = i % numberClass;
				if (m == 2)
					m = 0;
				student.setClassName(getKhoaName() + "G" + getMajornameStandFor(idNganh) + String.valueOf(m + 1));
				studentRepository.save(student);
			}
		}
	}

	public void setStudentsClassNormalForMajor(String idNganh) {
		List<Student> listStudentsNormalClass = studentRepository.getStudentsClassNormalForMajor(idNganh);
		int quatityStudents = listStudentsNormalClass.size();
		int classNumber = quatityStudents / 60;
		if (quatityStudents % 60 != 0) {
			classNumber = classNumber + 1;
		}

		for (int i = 0; i < quatityStudents; i++) {
			Student student = requireOne(listStudentsNormalClass.get(i).getId());
			int m = i % classNumber;
			if (m == classNumber)
				m = classNumber;

			student.setClassName(getKhoaName() + getMajornameStandFor(idNganh) + String.valueOf(m + 1));
			studentRepository.save(student);
		}
	}

	public void setStudentsClassOtherForMajor(String majorName, String idNganh) {

		List<Student> listStudentsOtherClass = getStudentsClassOtherForMajor(majorName, idNganh);
		int quantityStudents = listStudentsOtherClass.size();
		for (int i = 0; i < quantityStudents; i++) {
			Student student = requireOne(listStudentsOtherClass.get(i).getId());
			student.setClassName(getKhoaName() + getMajornameStandFor(idNganh));
			studentRepository.save(student);
		}
	}

	private String getMajornameStandFor(String idNganh) {
		return majorsService.getById(idNganh).getMajorsNameStandFor();
	}

	private String getKhoaName() {
		return khoaRepository.getKhoaNameByStatus().get(0).getKhoa().replaceAll("[^\\d]", "");
	}

}
