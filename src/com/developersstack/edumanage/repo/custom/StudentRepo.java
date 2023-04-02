package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentRepo {
    public String findStudentLastId() throws SQLException, ClassNotFoundException; // Unique
    public ArrayList<Student> findAllStudents(String searchText) throws SQLException, ClassNotFoundException; // Unoque

}
