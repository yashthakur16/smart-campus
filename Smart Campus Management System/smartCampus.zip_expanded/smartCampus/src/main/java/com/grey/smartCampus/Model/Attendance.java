package com.grey.smartCampus.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendance_id;

    @ManyToOne
    @JoinColumn(name = "student_id") // Foreign key to Student
    private Student student;

    // Fields for each subject's attendance and total classes
    private int wt_attended;
    private int wt_total;

    private int dbms_attended;
    private int dbms_total;

    private int cn_attended;
    private int cn_total;

    private int ai_attended;
    private int ai_total;

    // Constructors
    public Attendance() {}

    public Attendance(Student student, int wt_attended, int wt_total, int dbms_attended, int dbms_total, int cn_attended, int cn_total, int ai_attended, int ai_total) {
        this.student = student;
        this.wt_attended = wt_attended;
        this.wt_total = wt_total;
        this.dbms_attended = dbms_attended;
        this.dbms_total = dbms_total;
        this.cn_attended = cn_attended;
        this.cn_total = cn_total;
        this.ai_attended = ai_attended;
        this.ai_total = ai_total;
    }

    // Getters and Setters

    public Long getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(Long attendance_id) {
        this.attendance_id = attendance_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getWt_attended() {
        return wt_attended;
    }

    public void setWt_attended(int wt_attended) {
        this.wt_attended = wt_attended;
    }

    public int getWt_total() {
        return wt_total;
    }

    public void setWt_total(int wt_total) {
        this.wt_total = wt_total;
    }

    public int getDbms_attended() {
        return dbms_attended;
    }

    public void setDbms_attended(int dbms_attended) {
        this.dbms_attended = dbms_attended;
    }

    public int getDbms_total() {
        return dbms_total;
    }

    public void setDbms_total(int dbms_total) {
        this.dbms_total = dbms_total;
    }

    public int getCn_attended() {
        return cn_attended;
    }

    public void setCn_attended(int cn_attended) {
        this.cn_attended = cn_attended;
    }

    public int getCn_total() {
        return cn_total;
    }

    public void setCn_total(int cn_total) {
        this.cn_total = cn_total;
    }

    public int getAi_attended() {
        return ai_attended;
    }

    public void setAi_attended(int ai_attended) {
        this.ai_attended = ai_attended;
    }

    public int getAi_total() {
        return ai_total;
    }

    public void setAi_total(int ai_total) {
        this.ai_total = ai_total;
    }

    // Method to calculate total attended classes for all subjects
    public int getAttendedTotal() {
        return wt_attended + dbms_attended + cn_attended + ai_attended;
    }

    // Method to calculate total classes for all subjects
    public int getTotalAll() {
        return wt_total + dbms_total + cn_total + ai_total;
    }

    // Method to calculate overall attendance percentage
    public double getOverallAttendancePercentage() {
        int totalAttended = getAttendedTotal();
        int totalClasses = getTotalAll();
        return totalClasses > 0 ? ((double) totalAttended / totalClasses) * 100 : 0;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendance_id=" + attendance_id +
                ", student=" + student +
                ", WT_attended=" + wt_attended +
                ", WT_total=" + wt_total +
                ", DBMS_attended=" + dbms_attended +
                ", DBMS_total=" + dbms_total +
                ", CN_attended=" + cn_attended +
                ", CN_total=" + cn_total +
                ", AI_attended=" + ai_attended +
                ", AI_total=" + ai_total +
                ", attendedTotal=" + getAttendedTotal() +
                ", totalAll=" + getTotalAll() +
                ", overallAttendancePercentage=" + getOverallAttendancePercentage() + "%" +
                '}';
    }
}

