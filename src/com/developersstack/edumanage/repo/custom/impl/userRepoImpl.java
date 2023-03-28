package com.developersstack.edumanage.repo.custom.impl;

import com.developersstack.edumanage.entity.User;
import com.developersstack.edumanage.repo.custom.UserRepo;

public class userRepoImpl implements UserRepo {
    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public User loginUser(String email) {
        return null;
    }
}
