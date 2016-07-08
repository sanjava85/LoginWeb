package com.user.impl;

import com.user.api.UserService;
import com.user.dao.UserDao;
import com.user.domain.User;
import com.user.exception.UserProfileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by m481262 on 12/22/15.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    //User user;

    @Override
    public void createUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User validateUser(String userName, String password) {
        try{
            User user = userDao.selectUser(userName,password);
            if(user.getUserName().equals(userName) && user.getPassword().equals(password))
            {
                return user;
            }
            else {
                return null;
            }
        }
        catch (Exception ex){
            throw new UserProfileException("Error Occurred while getting user information", ex);
        }
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
