package com.akit.congnitivesite.controller;

import com.akit.congnitivesite.dao.RoleDAO;
import com.akit.congnitivesite.dao.UserDAO;
import com.akit.congnitivesite.domain.Role;
import com.akit.congnitivesite.domain.User;
import com.akit.congnitivesite.dto.UserInfo;
import com.akit.congnitivesite.dto.validator.UserInfoValidator;
import com.akit.congnitivesite.service.RegistrationService;
import com.akit.congnitivesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(ModelMap model) {
        UserInfo userInfo = new UserInfo();
        model.put("userInfo", userInfo);
        return "registration";
    }

    @Autowired
    UserInfoValidator userInfoValidator;

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("userInfo") @Valid UserInfo userInfo,
                             BindingResult bindingResult,
                             Model model) {

        userInfoValidator.validate(userInfo, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        try {
            registrationService.registerUser(userInfo);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/main";
    }

    @RequestMapping(value = {"/editUser/{userId}"}, method = RequestMethod.GET)
    public String editUser(ModelMap map, @PathVariable("userId") Integer userId) {
        User user = userService.getUserById(userId);
        UserInfo userInfo = new UserInfo(
                user.getLogin(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone(),
                user.getSex(),
                user.getName(),
                user.getSurname());

        for (Role r : user.getRole()) {
            if (r.getRole().equals("ROLE_USER")) {
                userInfo.setRoles("Role user");
            }

            if (r.getRole().equals("ROLE_ADMIN")) {
                userInfo.setRoles("Role administrator");
            }

        }
        map.addAttribute("userId", userId);
        map.addAttribute("userInfo", userInfo);
        return "edit";
    }

    @RequestMapping(value = {"/deleteUser/{userId}"}, method = RequestMethod.POST)
    public String deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println(userId);
        User user = userDAO.getById(userId);
        System.out.println(user);
        userService.deleteUser(user);
        return "redirect:/main";
    }

    @RequestMapping(value = {"/searchUsers"}, method = RequestMethod.GET)
    public String searchUsers(ModelMap map, @RequestParam("searchInput") String input) {
        map.addAttribute("searchingResult", userService.searchUsersByLoginOrPhone(input, 0));
        return "main";
    }

    @RequestMapping(value = {"/updateUser/{userId}"}, method = RequestMethod.POST)
    public String updateUser(ModelMap map,
                             @PathVariable("userId") Integer userId,
                             @ModelAttribute("userInfo") UserInfo userInfo) {
        System.out.println("update user info: " + userInfo);
        User user = userDAO.getById(userId);
        user.setName(userInfo.getName());
        user.setSurname(userInfo.getSurname());
        user.setAddress(userInfo.getAddress());
        user.setEmail(userInfo.getEmail());
        user.setPhone(userInfo.getPhone());
        user.setSex(userInfo.getSex());

        if (userInfo.getRoles().equals("Role user")) {
            ArrayList<Role> roles = new ArrayList<Role>();
            roles.add(roleDAO.getByName("ROLE_USER"));
            user.setRole(roles);
        }

        if (userInfo.getRoles().equals("Role administrator")) {
            user.getRole().add(roleDAO.getByName("ROLE_ADMIN"));
        }

        System.out.println(user.getRole());

        userService.updateUser(user);
        return "redirect:/editUser/" + userId;
    }

}