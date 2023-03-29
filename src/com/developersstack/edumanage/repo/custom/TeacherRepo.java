package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherRepo {
    public boolean saveTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;
    public Teacher findTeacher(String teacher_id) throws SQLException, ClassNotFoundException;
    public String findTeacherLastId() throws SQLException, ClassNotFoundException;
    public boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;
    public ArrayList<Teacher> findaAllTeachers(String searchText) throws SQLException, ClassNotFoundException;
    public boolean deleteTeacher(String teacher_id) throws SQLException, ClassNotFoundException;
}
