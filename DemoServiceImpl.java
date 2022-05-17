package com.ex.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.demo.dao.DemoDao;
import com.ex.demo.dao.DemoDaoImpl;
import com.ex.demo.model.Student;
import com.ex.demo.repository.StudentRepository;

@Service
public class DemoServiceImpl implements DemoService {

	public DemoDao demoDao;
	
	@Autowired
	StudentRepository repository;
	
	@Override
	public String saveNameService() {
		Student s = new Student();
//		s.setId(1);
		s.setAge(12);
		s.setEmailAddress("email@gmail.com");
		s.setName("Raju");
		repository.save(s);
		return "names saved";
	}
	
	@Override
	public List<Student> getAll() {
        final List<Student> students = new ArrayList<>();
        //can be done with iterator as well
        repository.findAll().forEach(student -> students.add(student));
        return students;
    }
	
	

}
