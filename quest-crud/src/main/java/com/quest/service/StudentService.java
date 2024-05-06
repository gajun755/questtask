package com.quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.entity.Student;
import com.quest.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

	
	
		@Autowired
		StudentRepository studentRepository;
	
		
	  public String saveStudent(Student student) {
		  	
		  studentRepository.save(student);
		  
		  return "Student records saved successfully";
		  
	  }


	public List<Student> getStudentList() {
		
			return studentRepository.findAll();
		
	}


	public String updateStudentInfo(Student student) {
		
			Student stu= studentRepository.getByRollNumber(student.getRollNumber());
			stu.setDivision(student.getDivision());
			stu.setfName(student.getfName());
			stu.setlName(student.getlName());
	
			studentRepository.save(stu);
			
			return "Student Record saved successufully of"+student.getRollNumber();
	}


	public void deleteRecord(Integer rollNumber) {
		
		studentRepository.deleteByRollNumber(rollNumber);
		
	} 
	
	
}
