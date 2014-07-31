package com.akit.congnitivesite.controller;

import com.akit.congnitivesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginForm() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/main";
        }
        return "login";
    }


    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String fail(Model model) {
        model.addAttribute("fail", "Incorrect login or password");
        return "login";
    }
}

