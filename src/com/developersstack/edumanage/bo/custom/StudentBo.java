package com.developersstack.edumanage.bo.custom;

import com.developersstack.edumanage.dto.StudentDto;

import java.util.ArrayList;

public interface StudentBo {
    public boolean saveStudent(StudentDto dto);
    public boolean updateStudent(StudentDto dto);
    public boolean deleteStudent(String id);
    public StudentDto findStudent(String id);
    public ArrayList<StudentDto> findAllStudents();
    public String findStudentLastId();
    public ArrayList<StudentDto> searchStudents(String searchText);
}
