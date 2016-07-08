package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by m481262 on 12/23/15.
 */
@Controller
public class RegisterController {
    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register","user","");
    }
}
