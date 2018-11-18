package com.boge.system.controller;

import com.boge.system.entity.User;
import com.boge.system.service.UserService;
import com.boge.util.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by boge on 2018/11/10.
 */
public class BaseController {
    @Autowired
    private UserService userService;

    public User getUser() {
        String username = ShiroUtils.getUsername();
        if (StringUtils.isBlank(username)) return null;
        return userService.findByUsername(username);
    }
}
