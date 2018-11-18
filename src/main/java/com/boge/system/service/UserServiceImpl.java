package com.boge.system.service;

import com.boge.system.dao.MenuDao;
import com.boge.system.dao.UserDao;
import com.boge.system.entity.Menu;
import com.boge.system.entity.Role;
import com.boge.system.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by boge on 2018/10/26.
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private MenuDao menuDao;

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找角色
     *
     * @param username 用户名
     * @return
     */
    @Override
    public Set<String> findHavingRoles(String username) {
        List<Role> roles = userDao.findHavingRoles(username);
        Set<String> roleSet = new HashSet<>();
        if (roles.size() > 0) {
            for (Role role : roles) {
                roleSet.add(role.getRole());
            }
        }
        return roleSet;
    }

    /**
     * 根据用户名查找拥有的权限名称
     *
     * @param username 用户名
     * @return
     */
    @Override
    public Set<String> findHavingPermissions(String username) {
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("username", username);
        List<Menu> menus = menuDao.findPermissions(conditionMap);
        Set<String> permissionSet = new HashSet<>();
        if (menus.size() > 0) {
            for (Menu menu : menus) {
                permissionSet.add(menu.getPermission());
                if (menu.getChildren().size() > 0) {
                    for (Menu menuChildren : menu.getChildren()) {
                        permissionSet.add(menuChildren.getPermission());
                    }
                }
            }
        }
        return permissionSet;
    }
}
