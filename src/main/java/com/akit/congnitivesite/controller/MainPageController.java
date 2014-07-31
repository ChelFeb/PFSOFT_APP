package com.akit.congnitivesite.controller;

import com.akit.congnitivesite.dao.UserDAO;
import com.akit.congnitivesite.domain.User;
import com.akit.congnitivesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/main"}, method = RequestMethod.GET)
    public String showMainPage(ModelMap map) {
        String userName = userService.getCurrentUser().getLogin();
        map.put("userName", userName);
        return "main";
    }

}
