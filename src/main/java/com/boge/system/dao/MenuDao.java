package com.boge.system.dao;

import com.boge.system.entity.Menu;
import com.boge.system.entity.ShowMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by boge on 2018/10/26.
 */
public interface MenuDao {

    /**
     * 获取权限
     *
     * @param conditionMap 条件集合
     * @return
     */
    List<Menu> findPermissions(Map<String, Object> conditionMap);

    /**
     * 根据用户名查找拥有的菜单
     *
     * @param conditionMap 条件集合
     * @return
     */
    List<ShowMenu> findUserMenus(Map<String, Object> conditionMap);

    /**
     * 查询所有菜单
     *
     * @param conditionMap 条件集合
     * @return
     */
    List<Menu> findMenus(Map<String, Object> conditionMap);
}
