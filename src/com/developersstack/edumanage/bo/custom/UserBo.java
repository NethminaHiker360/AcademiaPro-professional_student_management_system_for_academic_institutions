package com.developersstack.edumanage.bo.custom;

import com.developersstack.edumanage.dto.UserDto;

public interface UserBo {
    public boolean saveUser(UserDto dto);
    public UserDto findUser(String id);
}
