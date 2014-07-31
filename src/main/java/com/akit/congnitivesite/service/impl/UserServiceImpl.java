package com.akit.congnitivesite.service.impl;

import com.akit.congnitivesite.dao.UserDAO;
import com.akit.congnitivesite.domain.Role;
import com.akit.congnitivesite.domain.User;
import com.akit.congnitivesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        final String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userDAO.getByLogin(email);
    }

    @Transactional
    public User getUserById(int userId) {
        return userDAO.getById(userId);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public List<User> searchUsersByLogin(String login, int page) {
        return userDAO.searchUsersByLogin(login, page);
    }

    @Transactional
    public Set<User> searchUsersByLoginOrPhone(String input, int page) {
        HashSet<User> set = new HashSet<User>();
        set.addAll(userDAO.searchUsersByLogin(input, page));
        set.addAll(userDAO.searchUsersByPhone(input, page));
        return set;
    }

    @Transactional
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.update(user);
    };
}
