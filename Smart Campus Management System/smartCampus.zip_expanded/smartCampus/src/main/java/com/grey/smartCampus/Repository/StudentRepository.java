package com.grey.smartCampus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grey.smartCampus.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{



}
