package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.custom.StudentRepo;

import java.util.ArrayList;

public class studentRepoImpl implements StudentRepo {
    @Override
    public boolean saveStudent(Student student) {
        return false;
    }

    @Override
    public String findStudentLastId() {
        return null;
    }

    @Override
    public Student findStudent(String studentId) {
        return null;
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }

    @Override
    public ArrayList<Student> findAllStudents(String searchText) {
        return null;
    }

    @Override
    public boolean deleteStudent(String studentId) {
        return false;
    }
}
