package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.custom.TeacherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT teacher_code FROM teacher WHERE teacher_code LIKE ?");
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO teacher VALUES (?,?,?,?)");
    }

    @Override
    public ArrayList<Teacher> findaAllTeachers(String searchText) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO teacher VALUES (?,?,?,?)");
    }

    @Override
    public boolean deleteTeacher(String teacher_id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO teacher VALUES (?,?,?,?)");
    }
}
