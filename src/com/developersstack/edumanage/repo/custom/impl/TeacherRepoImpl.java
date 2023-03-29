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
    public Teacher findTeacher(String teacher_id) {
        return null;
    }

    @Override
    public String findTeacherLastId() {
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public ArrayList<Teacher> findaAllTeachers(String searchText) {
        return null;
    }

    @Override
    public boolean deleteTeacher(String teacher_id) {
        return false;
    }
}
