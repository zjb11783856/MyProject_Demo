package com.boge.freemarker;

import com.boge.system.service.UserService;
import freemarker.template.TemplateMethodModelEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by boge on 2018/11/10.
 */
@Component
public class UserTemplateConfig implements TemplateMethodModelEx {
    @Autowired
    private UserService userService;

    @Override
    public Object exec(List list) {
        if (list == null || list.size() == 0) {
            throw new RuntimeException("参数为空");
        }
        String username = String.valueOf(list.get(0));
        if (null == username) {
            return null;
        }

        return userService.findByUsername(username);
    }
}
