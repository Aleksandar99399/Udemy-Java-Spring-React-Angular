package com.Aleksandar.student.dal.repos;

import com.Aleksandar.student.dal.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
