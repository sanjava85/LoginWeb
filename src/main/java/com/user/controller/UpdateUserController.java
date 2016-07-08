package com.user.controller;

import com.user.api.UserService;
import com.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by m481262 on 12/29/15.
 */

@Controller
public class UpdateUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/editUser")
    public ModelAndView editUser(HttpServletRequest request){
        HttpSession sessionUser = request.getSession(false);
        if(sessionUser!=null){
            return new ModelAndView("updateUser");
        }else{
            return new ModelAndView("login");
        }

    }
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute User user, HttpServletRequest request){
        HttpSession sessionUser = request.getSession(false);
        user.setUserName(((User)sessionUser.getAttribute("sessionUser")).getUserName());
        userService.updateUser(user);
        sessionUser.setAttribute("sessionUser",user);
        return new ModelAndView("success");
    }
}
