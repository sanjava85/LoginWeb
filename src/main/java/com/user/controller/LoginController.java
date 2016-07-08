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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by m481262 on 12/21/15.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView verifyUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse respnse){
       /* user = new User();
        user.setEmail(request.getParameter("email"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLine1(request.getParameter("line1"));
        user.setLine2(request.getParameter("line2"));
        user.setCity(request.getParameter("city"));
        user.setStateCd(request.getParameter("state"));
        user.setZipCd(Integer.parseInt(request.getParameter("zip")));*/

        userService.createUser(user);
        HttpSession userSession = request.getSession(true);
        userSession.setAttribute("sessionUser", user);

        return new ModelAndView("success");
    }
}
