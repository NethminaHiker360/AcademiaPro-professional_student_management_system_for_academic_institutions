package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.custom.StudentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepoImpl implements StudentRepo {
    @Override
    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");
        pstm.setString(1,student.getStudentId());
        pstm.setString(2,student.getFullName());
        pstm.setObject(3,student.getDateOfBirth());
        pstm.setString(4,student.getAddress());
        return pstm.executeUpdate()>0;
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
