package com.boge.system.entity;

import java.io.Serializable;

/**
 * Created by boge on 2018/10/26.
 */
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 593548846595947416L;
    private String roleId;
    private String menuId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
