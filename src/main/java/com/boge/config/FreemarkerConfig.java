package com.boge.config;

import com.boge.freemarker.UserTemplateConfig;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by boge on 2018/11/10.
 */
@Component
public class FreemarkerConfig {
    @Autowired
    private Configuration configuration;

    @Autowired
    private UserTemplateConfig userTemplateConfig;

    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("user", userTemplateConfig);
    }
}
