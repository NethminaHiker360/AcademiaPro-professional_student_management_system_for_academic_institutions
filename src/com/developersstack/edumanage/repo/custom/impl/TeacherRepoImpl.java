package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.custom.TeacherRepo;

import java.util.ArrayList;

public class TeacherRepoImpl implements TeacherRepo {
    @Override
    public boolean saveTeacher(Teacher teacher) {
        return false;
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
