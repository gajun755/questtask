package com.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
			Student getByRollNumber(int rollNumber);

			void deleteByRollNumber(Integer rollNumber);
				
}
