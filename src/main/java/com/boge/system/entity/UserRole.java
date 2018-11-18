package com.boge.system.entity;

import java.io.Serializable;

/**
 * Created by boge on 2018/10/26.
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = -1019879089264197248L;
    private String userId;
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
