package com.akit.congnitivesite.dao;

import com.akit.congnitivesite.domain.*;

import java.util.Date;
import java.util.List;

public interface UserDAO {

    /**
     * Get User by id
     *
     * @param id identifier
     */
    User getById(Integer id);

    /**
     * Get User by login
     *
     * @param login identifier
     */
    User getByLogin(String login);

    /**
     * Get List of Users
     */
    List<User> getAllUsers();

    /**
     * Create new User
     *
     * @param user
     */
    void create(User user);

    /**
     *
     * @param email    by user
     * @param password by user
     */
    void create(String email, String password, Date date);

    /**
     * Update User parameters
     *
     *
     * @param user
     */
    void update(User user);

    /**
     * Delete User
     *
     *
     * @param user
     */
    void delete(User user);

    /**
     * Delete User by his Id
     *
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * Search Users by their login
     *
     *  @param login
     * @param page - amount of pages which will be load.
     */
    public List<User> searchUsersByLogin(String login, int page);


    /**
     * Search Users by their phone
     *
     * @param phone
     * @param page - amount of pages which will be load.
     */
    public List<User> searchUsersByPhone(String phone, int page);
}
