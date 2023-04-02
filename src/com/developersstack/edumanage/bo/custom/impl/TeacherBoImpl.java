package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.TeacherBo;
import com.developersstack.edumanage.dto.TeacherDto;
import com.developersstack.edumanage.entity.Teacher;
import com.developersstack.edumanage.repo.custom.TeacherRepo;
import com.developersstack.edumanage.repo.custom.impl.TeacherRepoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherBoImpl implements TeacherBo {

    private final TeacherRepo teacherRepo=new TeacherRepoImpl();
    @Override
    public boolean saveTeacher(TeacherDto dto) throws SQLException, ClassNotFoundException {
        return teacherRepo.save(new Teacher(dto.getCode(),dto.getName(),
                dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean updateTeacher(TeacherDto dto) throws SQLException, ClassNotFoundException {
        return teacherRepo.update(new Teacher(dto.getCode(),dto.getName(),
                dto.getAddress(),dto.getContact()));
    }

    @Override
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException {
        return teacherRepo.delete(id);
    }

    @Override
    public TeacherDto findTeacher(String id) throws SQLException, ClassNotFoundException {
        Teacher teacher = teacherRepo.find(id);
        if (null!=teacher){
            return new TeacherDto(teacher.getCode(),teacher.getName(),
                    teacher.getAddress(),teacher.getContact());
        }
        return null;
    }

    @Override
    public ArrayList<TeacherDto> findAllTeachers() {
        ArrayList<Teacher> teacherList = teacherRepo.findAll();
        ArrayList<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher teacher:teacherList) {
            teacherDtos.add(new TeacherDto(teacher.getCode(),teacher.getName(),
                    teacher.getAddress(),teacher.getContact()));
        }
        return teacherDtos;
    }

    @Override
    public String findTeacherLastId() throws SQLException, ClassNotFoundException {
        return teacherRepo.findTeacherLastId();
    }

    @Override
    public ArrayList<TeacherDto> searchTeachers(String searchText) throws SQLException, ClassNotFoundException {
        Teacher teacher = teacherRepo.find(searchText);
    }
}
