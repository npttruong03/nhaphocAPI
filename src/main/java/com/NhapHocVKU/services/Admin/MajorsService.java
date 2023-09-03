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

import com.NhapHocVKU.dtos.Admin.MajorsDTO;
import com.NhapHocVKU.models.Admin.Majors;
import com.NhapHocVKU.repositories.Admin.MajorsRepository;

@Service
public class MajorsService {
	@Autowired
	private MajorsRepository majorsRepository;
	
	private static Set<String> usedIds = new HashSet<>();
	
	public List<Majors> findAll(){
		return majorsRepository.findAll();
	}
	
	public Majors save(Majors majors) {
		String id;
	    do {
	        id = generateUniqueId();
	    } while (usedIds.contains(id));

		majors.setId(id);
		majors = majorsRepository.save(majors);
		usedIds.add(id);
		return majors;
	}
	
	public String generateUniqueId() {
		 Random random = new Random();
		 UUID uuid = UUID.randomUUID();
	        String uniqueId = uuid.toString();
	     int randomNumber = random.nextInt(1000) + 1;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String timeString = timestamp.toString();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String timestampString = timestamp.toLocalDateTime().format(formatter);
        String uid = timeString.replaceAll("[-:. ]",Integer.toString(randomNumber));
        uid = uid+uniqueId;
	    return uid.toString();
	}

	public void Update(String id, MajorsDTO majorsDTO) {
		Majors bean = requireOne(id);
		BeanUtils.copyProperties(majorsDTO, bean);
		majorsRepository.save(bean);
	}
	
	 public Majors getById(String id) {
		 Majors original = requireOne(id);
        return original;
    }
	private Majors requireOne(String id) {
        return majorsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

	public List<Majors> searchByKeyword(String Keyword) {
		 return majorsRepository.searchByKeyword(Keyword);
	 }

}
