package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.StudentBo;
import com.developersstack.edumanage.dto.StudentDto;

import java.util.ArrayList;

public class StudentBoImpl implements StudentBo {
    @Override
    public boolean saveStudent(StudentDto dto) {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDto dto) {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        return false;
    }

    @Override
    public StudentDto findStudent(String id) {
        return null;
    }

    @Override
    public ArrayList<StudentDto> findAllStudents() {
        return null;
    }

    @Override
    public String findStudentLastId() {
        return null;
    }

    @Override
    public ArrayList<StudentDto> searchStudents(String searchText) {
        return null;
    }
}
