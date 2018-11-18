package com.boge.system.controller;

import com.boge.system.entity.ShowMenu;
import com.boge.system.service.MenuService;
import com.boge.system.service.UserService;
import com.boge.util.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by boge on 2018/11/12.
 */
@Controller
@RequestMapping("system/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @GetMapping("findUserMenus")
    @ResponseBody
    public List<ShowMenu> findUserMenus() {
        String username = ShiroUtils.getUsername();
        return menuService.findUserMenus(username);
    }
}
