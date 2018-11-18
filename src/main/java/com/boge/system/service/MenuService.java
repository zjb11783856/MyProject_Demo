package com.boge.system.service;

import com.boge.system.entity.Menu;
import com.boge.system.entity.ShowMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by boge on 2018/11/13.
 */
public interface MenuService {

    List<ShowMenu> findUserMenus(String username);

    List<Menu> findMenus(Map<String, Object> conditionMap);
}
