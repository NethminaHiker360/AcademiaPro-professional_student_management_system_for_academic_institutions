package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Student;
import com.developersstack.edumanage.repo.CrudUtil;
import com.developersstack.edumanage.repo.custom.StudentRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepoImpl implements StudentRepo {
    @Override
    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?)",student.getStudentId()
                ,student.getFullName(),student.getDateOfBirth(),student.getAddress());
    }

    @Override
    public String findStudentLastId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT student_id FROM student ORDER BY CAST(SUBSTRING(student_id,3) AS UNSIGNED) DESC LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public Student findStudent(String studentId) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT student FROM student WHERE student_id=?",studentId);
        if (rst.next()){
            return new Student(rst.getString(1),rst.getString(2),
                    rst.getDate(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE student SET full_name=?, dob=?,address=? WHERE student_id=?",
                student.getFullName(),student.getDateOfBirth(),student.getAddress(),student.getStudentId());
    }

    @Override
    public ArrayList<Student> findAllStudents(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentList= new ArrayList<>();
        searchText="%"+searchText+"%";
        ResultSet rst = CrudUtil.execute("SELECT student FROM student WHERE student_id=? LIKE ? OR full_name LIKE ?",searchText,searchText);
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
