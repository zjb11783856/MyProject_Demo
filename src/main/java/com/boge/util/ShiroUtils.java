package com.boge.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by boge on 2018/11/11.
 */
public class ShiroUtils {
    public static String getUsername() {
        Subject subject = SecurityUtils.getSubject();
        return String.valueOf(subject.getPrincipal());
    }
}
