package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.custom.TeacherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepoImpl implements TeacherRepo {
    @Override
    public boolean saveTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO teacher VALUES (?,?,?,?)");
        pstm.setString(1,teacher.getCode());
        pstm.setString(2,teacher.getName());
        pstm.setString(3,teacher.getAddress());
        pstm.setString(4,teacher.getCode());
        return pstm.executeUpdate()>0;
    }

    @Override
    public Teacher findTeacher(String teacher_id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT teacher FROM teacher WHERE teacher_code=?");
        pstm.setString(1,teacher_id);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Teacher(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT teacher_code FROM teacher ORDER BY CAST(SUBSTRING(student_id,3) AS UNSIGNED) DESC LIMIT 1");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE teacher SET name=?,address=?,contact=? WHERE teacher_code=?");
        pstm.setString(1,teacher.getName());
        pstm.setString(2, teacher.getAddress());
        pstm.setString(3, teacher.getContact());
        pstm.setString(4, teacher.getCode());
        return pstm.executeUpdate()>0;
    }

    @Override
    public ArrayList<Teacher> findaAllTeachers(String searchText) throws SQLException, ClassNotFoundException {
        searchText="%"+searchText+"%";
        ArrayList<Teacher> teacherArrayList=new ArrayList<>();
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT teacher FROM teacher WHERE teacher_code=? OR name=?)");
        pstm.setString(1,searchText);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            teacherArrayList.add(new Teacher(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4)));
        }
        return teacherArrayList;
    }

    @Override
    public boolean deleteTeacher(String teacher_id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM teacher WHERE teacher_code=?");
        pstm.setString(1,teacher_id);
        return pstm.executeUpdate()>0;
    }
}
