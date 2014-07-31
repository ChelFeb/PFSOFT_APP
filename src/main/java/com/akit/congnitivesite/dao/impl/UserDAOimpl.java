package com.akit.congnitivesite.dao.impl;

import com.akit.congnitivesite.dao.UserDAO;
import com.akit.congnitivesite.domain.Role;
import com.akit.congnitivesite.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAOimpl implements UserDAO {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAOimpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user){
        entityManager.persist(user);
    }

    @Override
    public void create(String login, String password, Date date) {
        Role role = (Role) entityManager.createQuery("SELECT r FROM Role r where r.role = :role")
                .setParameter("role", "ROLE_USER")
                .getSingleResult();
        entityManager.persist(new User(login, password, new Date(), role));
    }

    @Override
    public User getById(Integer id){
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByLogin(String login){
        try {
        return (User) entityManager.createQuery("SELECT t FROM User t where t.login = :login")
            .setParameter("login", login)
            .getSingleResult();
        } catch (NoResultException e) {
           LOG.info("context", e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> searchUsersByLogin(String login, int page) {
        return entityManager.createQuery("SELECT u FROM User AS u WHERE u.login LIKE :searchSymbol")
                .setParameter("searchSymbol", "%"+login+"%")
                .setMaxResults(25)
                .setFirstResult(page * 25)
                .getResultList();
    }

    @Override
    public List<User> searchUsersByPhone(String phone, int page) {
        return entityManager.createQuery("SELECT u FROM User AS u WHERE u.phone LIKE :searchSymbol")
                .setParameter("searchSymbol", "%"+phone+"%")
                .setMaxResults(25)
                .setFirstResult(page * 25)
                .getResultList();
    }

    @Override
    public List<User> getAllUsers(){
        return entityManager.createQuery("SELECT u FROM User AS u").getResultList();
    }

    @Override
    public void update(User user){
            entityManager.merge(user);
    }

    @Override
    public void delete(User user){
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void deleteById(Integer id){
        entityManager.remove(entityManager.find(User.class, id));
    }
}
