package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by m481262 on 12/29/15.
 */
@Controller
public class SignoutController {
    @RequestMapping(value = "/signout")
    public ModelAndView signoutUser(HttpServletRequest request){
        HttpSession sessionUser = request.getSession(false);
        sessionUser.invalidate();
        return new ModelAndView("login");
    }
}
