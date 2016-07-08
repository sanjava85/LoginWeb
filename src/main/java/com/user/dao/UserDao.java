package com.user.dao;

import com.user.domain.User;

import java.sql.SQLException;

/**
 * Created by m481262 on 12/22/15.
 */
public interface UserDao {
    public void insertUser(User user);
    public User selectUser(String userName, String password);
    public void updateUser(User user);
}
