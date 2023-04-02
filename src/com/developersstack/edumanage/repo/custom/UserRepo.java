package com.developersstack.edumanage.repo.custom;

import com.developersstack.edumanage.dto.UserDto;
import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.repo.CrudRepo;

import java.sql.SQLException;

public interface UserRepo extends CrudRepo<UserDto,String> {
    public boolean saveUser(UserDto dto);
    public UserDto findUser(String id);
}
