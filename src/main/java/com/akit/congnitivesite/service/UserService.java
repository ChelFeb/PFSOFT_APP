package com.akit.congnitivesite.service;

import com.akit.congnitivesite.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    public User getCurrentUser();

    List<User> searchUsersByLogin(String login, int page);

    Set<User> searchUsersByLoginOrPhone(String input, int page);

    void deleteUser(User user);

    public User getUserById(int userId);

    public void updateUser(User user);
}
