package com.developersstack.edumanage.bo.custom;

import java.util.ArrayList;

public interface StudentBo {
    public boolean save(StudentDto dto);
    public boolean update(StudentDto dto);
    public boolean delete(String id);
    public StudentDto find(String id);
    public ArrayList<StudentDto> findAll();
    public String findStudentLastId();
    public ArrayList<StudentDto> findAllStudents(String searchText);
}
