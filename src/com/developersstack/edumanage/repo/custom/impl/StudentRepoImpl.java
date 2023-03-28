package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.custom.StudentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public String findStudentLastId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT student_id FROM student ORDER BY CAST(SUBSTRING(student_id,3) AS UNSIGNED) DESC LIMIT 1");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public Student findStudent(String studentId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT student FROM student WHERE student_id=?");
        pstm.setString(1,studentId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Student(rst.getString(1),rst.getString(2),
                    rst.getDate(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE student SET full_name=?, dob=?,address=? WHERE student_id=?");
        pstm.setString(1,student.getFullName());
        pstm.setObject(2,student.getDateOfBirth());
        pstm.setString(3,student.getAddress());
        pstm.setString(4,student.getStudentId());
        return pstm.executeUpdate()>0;
    }

    @Override
    public ArrayList<Student> findAllStudents(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentList= new ArrayList<>();
        searchText="%"+searchText+"%";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT student FROM student WHERE student_id=? LIKE ? OR full_name LIKE ?");
        pstm.setString(1,searchText);
        pstm.setString(2,searchText);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            studentList.add(new Student(rst.getString(1),rst.getString(2),
                    rst.getDate(3),rst.getString(4)));
        }
        return studentList;
    }

    @Override
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM student WHERE student_id=?");
        pstm.setString(1,studentId);
        return pstm.executeUpdate()>0;
    }
}
