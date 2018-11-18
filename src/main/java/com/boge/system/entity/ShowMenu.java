package com.boge.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boge on 2018/11/13.
 */
public class ShowMenu implements Serializable {
    private static final long serialVersionUID = -3593208264481288529L;
    private String id;
    private String pid;//父菜单ID
    private String title;//标题
    private String icon;//图标
    private String href;//链接
    private Boolean spread = false;
    private List<ShowMenu> children = new ArrayList<>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<ShowMenu> getChildren() {
        return children;
    }

    public void setChildren(List<ShowMenu> children) {
        this.children = children;
    }
}
