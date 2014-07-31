package com.akit.congnitivesite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.akit.congnitivesite.dao.impl.UserDAOimpl;
import com.akit.congnitivesite.domain.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A custom {@link UserDetailsService} where user information
 * is retrieved from a JPA repository
 */
@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAOimpl userDAO;

    /**
     * Returns a populated {@link UserDetails} object.
     * The username is first retrieved from the database and then mapped to
     * a {@link UserDetails} object.
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            com.akit.congnitivesite.domain.User domainUser = userDAO.getByLogin(username);

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new User(
                    domainUser.getLogin(),
                    domainUser.getPassword().toLowerCase(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(domainUser.getRole())
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
     * @param roles
     * @return a collection of {@link GrantedAuthority
     */
    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
}