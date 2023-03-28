package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentRepo {
    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException;
    public String findStudentLastId();
    public Student findStudent(String studentId);
    public boolean updateStudent(Student student);
    public ArrayList<Student> findAllStudents(String searchText);

    public boolean deleteStudent(String studentId);
}
