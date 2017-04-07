package com.xiaozl.service;

import com.xiaozl.entity.User;

import java.util.List;

/**
 * Created by xiaozeli on 2017/3/31.
 */
public interface UserService {

    public List<User> getUserById(String uid);

}
