package com.grey.smartCampus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grey.smartCampus.Model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
