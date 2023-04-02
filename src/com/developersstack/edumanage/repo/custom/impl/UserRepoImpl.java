package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.dto.UserDto;
import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.repo.CrudUtil;
import com.developersstack.edumanage.repo.custom.UserRepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepoImpl implements UserRepo {

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO user VALUES (?,?,?,?)", user.getEmail(), user.getFirstName()
                , user.getLastName(), user.getPassword());
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(UserDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User find(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT user FROM user WHERE email=?", s);
        if (rst.next()){
            return new User(rst.getString(2),rst.getString(3),
                    rst.getString(1),rst.getString(4));
        }
        return null;
    }

    @Override
    public ArrayList<User> findAll() {
        return null;
    }

    @Override
    public boolean saveUser(UserDto dto) {
        return false;
    }

    @Override
    public UserDto findUser(String id) {
        return null;
    }
}
