package com.akit.congnitivesite.service.impl;

import com.akit.congnitivesite.dao.RoleDAO;
import com.akit.congnitivesite.dao.UserDAO;
import com.akit.congnitivesite.domain.Role;
import com.akit.congnitivesite.domain.User;
import com.akit.congnitivesite.dto.UserInfo;
import com.akit.congnitivesite.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Transactional
    public void registerUser(UserInfo userInfo) {
        System.out.println(userInfo);

        User user = new User(userInfo.getLogin(),
                new Md5PasswordEncoder().encodePassword(userInfo.getPassword(), null),
                new Date(),
                userInfo.getEmail(),
                userInfo.getAddress(),
                userInfo.getPhone(),
                userInfo.getSex(),
                userInfo.getName(),
                userInfo.getSurname());

        List<Role> roleList = new ArrayList<Role>();
        if (userInfo.getRoles().equals("Role administrator")) {
            roleList.add(roleDAO.getByName("ROLE_ADMIN"));
            roleList.add(roleDAO.getByName("ROLE_USER"));
        } else {
            roleList.add(roleDAO.getByName("ROLE_USER"));
        }
        user.setRole(roleList);
        userDAO.create(user);
    }
}
