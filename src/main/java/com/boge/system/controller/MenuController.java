package com.boge.system.controller;

import com.boge.system.service.MenuService;
import com.boge.util.RestResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boge on 2018/11/13.
 */
@Controller
@RequestMapping("system/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @GetMapping("menuManage")
    public String menuManage() {
        return "system/menu/menuManage";
    }

    @RequiresPermissions("sys:menu:menuList")
    @PostMapping("menuList")
    @ResponseBody
    public RestResponse menuList() {
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("pid", null);
        return RestResponse.success().setData(menuService.findMenus(conditionMap));
    }
}
