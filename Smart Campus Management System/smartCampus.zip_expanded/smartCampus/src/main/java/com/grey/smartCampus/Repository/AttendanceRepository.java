package com.grey.smartCampus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grey.smartCampus.Model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {


}
