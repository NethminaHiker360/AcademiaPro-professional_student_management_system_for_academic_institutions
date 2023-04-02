package com.developersstack.edumanage.bo.custom.impl;

import com.developersstack.edumanage.bo.custom.UserBo;
import com.developersstack.edumanage.dto.UserDto;

public class UserBoImpl implements UserBo{
    @Override
    public boolean saveUser(UserDto dto) {
        return false;
    }

    @Override
    public UserDto findUser(String id) {
        return null;
    }
}
