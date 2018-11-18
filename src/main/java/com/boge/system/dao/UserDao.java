package com.boge.system.dao;

import com.boge.system.entity.Role;
import com.boge.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by boge on 2018/10/26.
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    User findByUsername(@Param("username") String username);

    /**
     * 根据用户名查找拥有的角色
     *
     * @param username 用户名
     * @return
     */
    List<Role> findHavingRoles(@Param("username") String username);
}
