package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.db.DbConnection;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.CrudUtil;
import com.developersstack.edumanage.repo.custom.TeacherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRepoImpl implements TeacherRepo {
    @Override
    public boolean saveTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO teacher VALUES (?,?,?,?)",teacher.getCode(),teacher.getName()
                ,teacher.getAddress(),teacher.getCode());
    }

    @Override
    public Teacher findTeacher(String teacher_id) throws SQLException, ClassNotFoundException {
        ResultSet rst =CrudUtil.execute("SELECT teacher FROM teacher WHERE teacher_code=?",teacher_id);
        if (rst.next()){
            return new Teacher(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT teacher_code FROM teacher ORDER BY CAST(SUBSTRING(student_id,3) AS UNSIGNED) DESC LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }
        return null;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE teacher SET name=?,address=?,contact=? WHERE teacher_code=?",
                teacher.getName(), teacher.getAddress(), teacher.getContact(), teacher.getCode());
    }

    @Override
    public ArrayList<Teacher> findaAllTeachers(String searchText) throws SQLException, ClassNotFoundException {
        searchText="%"+searchText+"%";
        ArrayList<Teacher> teacherArrayList=new ArrayList<>();
        Connection connection = DbConnection.getInstance().getConnection();
        ResultSet rst = CrudUtil.execute("SELECT teacher FROM teacher WHERE teacher_code=? OR name=?)",searchText);
        if (rst.next()){
            teacherArrayList.add(new Teacher(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4)));
        }
        return teacherArrayList;
    }

    @Override
    public boolean deleteTeacher(String teacher_id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM teacher WHERE teacher_code=?",teacher_id);
    }
}
