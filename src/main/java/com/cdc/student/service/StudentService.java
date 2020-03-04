package com.cdc.student.service;

import com.cdc.student.model.Student;
import com.cdc.student.repository.StudentRepository;
import com.cdc.student.utils.Operation;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	
	public void maintainReadModel(Map<String, Object> studentData, Operation operation) {
		final ObjectMapper mapper = new ObjectMapper();
		final Student student = mapper.convertValue(studentData, Student.class);

		if (Operation.DELETE.name().equals(operation.name())) {
			studentRepository.deleteById(student.getId());
		} else {
			studentRepository.save(student);
		}
	}
}
