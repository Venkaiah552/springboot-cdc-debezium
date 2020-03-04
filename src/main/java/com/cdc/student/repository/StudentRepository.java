package com.cdc.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdc.student.model.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
