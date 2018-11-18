package com.boge.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boge on 2018/10/26.
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -6227772629776345194L;
    private String id;
    private String pid;//父菜单ID
    private String permission;//权限标识
    private String title;//权限描述,UI界面显示使用
    private String href;//链接
    private String icon;//图标
    private Boolean available = Boolean.FALSE;//是否可用,如果不可用将不会添加给用户
    private Integer seqNo = 100;//序号
    private List<Menu> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
