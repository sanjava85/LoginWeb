package com.user.controller;

import com.user.api.UserService;
import com.user.domain.User;
import com.user.exception.UserProfileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by m481262 on 12/23/15.
 */
@Controller
public class ValidateUserController {
    private final Logger log = LoggerFactory.getLogger(ValidateUserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView validateUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
        String userName = user.getUserName();
        String password = user.getPassword();
        try{
            user = userService.validateUser(userName,password);
        }
        catch (UserProfileException ex){
            log.error(ex.getMessage(), ex);
        }

        if(user!=null && user.getEmail()!= null)
        {
            HttpSession userSession = request.getSession(true);
            userSession.setAttribute("sessionUser", user);
            return new ModelAndView("success");
        }
        else{
            log.error("Invalid Username and Password");
            return new ModelAndView("login","","");
        }
    }
}
