package com.boge.system.service;

import com.boge.system.dao.MenuDao;
import com.boge.system.entity.Menu;
import com.boge.system.entity.ShowMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by boge on 2018/11/13.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    /**
     * 获取用户菜单信息
     *
     * @param username 用户名
     * @return
     */
    @Override
    public List<ShowMenu> findUserMenus(String username) {
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("username", username);
        conditionMap.put("pid", null);
        return menuDao.findUserMenus(conditionMap);
    }

    /**
     * 查询菜单信息
     *
     * @param conditionMap
     * @return
     */
    @Override
    public List<Menu> findMenus(Map<String, Object> conditionMap) {
        return menuDao.findMenus(conditionMap);
    }
}
