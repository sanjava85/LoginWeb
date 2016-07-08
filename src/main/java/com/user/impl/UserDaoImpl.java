package com.user.impl;

import com.user.dao.UserDao;
import com.user.domain.User;
import com.user.exception.UserProfileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 * Created by m481262 on 12/22/15.
 */
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users"+
                "(email,username,password,firstName,lastName,line1,line2,city,stateCode,zip) VALUES(?,?,?,?,?,?,?,?,?,?)";
        //String encodePassword = base64Encode(user.getPassword());
        jdbcTemplate.update(sql, new Object[]{user.getEmail(),user.getUserName(),base64Encode(user.getPassword()),
            user.getFirstName(),user.getLastName(),user.getLine1(),user.getLine2(),user.getCity(),user.getStateCode(),user.getZip()});
    }

    @Override
    public User selectUser(String userName, String password) {
        User user;
        String sql = "SELECT * FROM users WHERE username = ?";
        try{
            user = (User) jdbcTemplate.queryForObject(
                    sql, new Object[] { userName }, new BeanPropertyRowMapper(User.class));
            user.setPassword(base64Decode(user.getPassword()));
        }
        catch (Exception ex){
            throw new UserProfileException("Error Occurred while getting user information", ex);
        }

        return user;

       /* user = jdbcTemplate.queryForObject("select * from user where id = ?",new Object[]{userName},new RowMapper<User>() {

            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return user;*/
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users set email=?,password=?,firstName=?,lastName=?,line1=?,line2=?,city=?,stateCode=?,zip=? where username=?";
        jdbcTemplate.update(sql,new Object[]{user.getEmail(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getLine1(),user.getLine2(),user.getCity(),user.getStateCode(),user.getZip(),user.getUserName()});
    }

    public static String base64Encode(String token) {
        byte[] encodedBytes = Base64.encode(token.getBytes());
        return new String(encodedBytes, Charset.forName("UTF-8"));
    }


    public static String base64Decode(String token) {
        byte[] decodedBytes = Base64.decode(token.getBytes());
        return new String(decodedBytes, Charset.forName("UTF-8"));
    }
}


