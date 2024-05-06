package com.quest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quest.entity.Student;
import com.quest.service.StudentService;

@RestController
public class HomeController {
	
	@Autowired
	StudentService studentService;
	
	
	
	@GetMapping("/")
	public String test() {
	
		
		return "Home";
	}
	
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		
		
		return studentService.saveStudent(student);
		
		
	}
	
	@GetMapping("/studentList")
	public List<Student> getStudentList(){
		
		 return studentService.getStudentList();
	}
	

	@PutMapping("/updateStudentInfo")
	public String updateStudentInfo(@RequestBody Student student) {
		
		return studentService.updateStudentInfo(student);
	}
	
	
	@DeleteMapping("/deletestudentRecord/{rollNumber}")
	public String deleteStudentInfo(@PathVariable Integer rollNumber) {
		
		System.out.println("inside controller"+rollNumber);
		studentService.deleteRecord(rollNumber);
		return "Deleted Record successfully";		
	}
}
