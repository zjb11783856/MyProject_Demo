package com.boge.system.service;

import com.boge.system.entity.Menu;
import com.boge.system.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by boge on 2018/10/26.
 */
public interface UserService {
    List<User> findAllUsers();

    User findByUsername(String username);

    Set<String> findHavingRoles(String username);

    Set<String> findHavingPermissions(String username);
}
