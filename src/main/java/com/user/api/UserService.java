package com.user.api;
import com.user.domain.User;

/**
 * Created by m481262 on 12/22/15.
 */
public interface UserService {
    public void createUser(User user);
    public User validateUser(String userName, String password);
    public void updateUser(User user);
}
