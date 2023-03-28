package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.entity.Teacher;

import java.util.ArrayList;

public interface TeacherRepo {
    public boolean saveTeacher(Teacher teacher);
    public Teacher findTeacher(String teacher_id);
    public String findTeacherLastId();
    public boolean updateTeacher(Teacher teacher);
    public ArrayList<Teacher> findaAllTeachers(String searchText);
    public boolean deleteTeacher(String teacher_id);
}
