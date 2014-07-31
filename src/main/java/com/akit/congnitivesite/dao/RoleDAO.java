package com.akit.congnitivesite.dao;

import com.akit.congnitivesite.domain.*;

public interface RoleDAO {

    /**
     * Get Role by id
     *
     * @param id identifier
     */
    Role getById(Integer id);

    /**
     * Get Role by name
     *
     * @param name identifier
     */
    Role getByName(String name);
}
