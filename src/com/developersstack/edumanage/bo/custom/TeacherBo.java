package com.developersstack.edumanage.bo.custom;

import com.developersstack.edumanage.dto.TeacherDto;

import java.util.ArrayList;

public interface TeacherBo {
    public boolean saveTeacher(TeacherDto dto);
    public boolean updateTeacher(TeacherDto dto);
    public boolean deleteTeacher(String id);
    public TeacherDto findTeacher(String id);
    public ArrayList<TeacherDto> findAllTeachers();
    public String findTeacherLastId();
    public ArrayList<TeacherDto> searchTeachers(String searchText);
}
