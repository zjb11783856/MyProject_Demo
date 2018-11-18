package com.boge.system.controller;

import com.boge.system.service.UserService;
import com.boge.util.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by boge on 2018/10/26
 */
@Controller
public class LoginController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    /**
     * 打开登录界面
     *
     * @param request
     * @return
     */
    @GetMapping("login")
    public String login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) return "redirect:index";
        return "login";
    }

    @PostMapping("login/doLogin")
    @ResponseBody
    public RestResponse doLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) return RestResponse.failure("用户名或密码错误");
        if (StringUtils.isBlank(rememberMe)) return RestResponse.failure("记住我不能为空");
        if (null == request.getSession()) return RestResponse.failure("session超时");

        String error = "";
        Map<String, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, Boolean.valueOf(rememberMe));
        try {
            subject.login(token);
            if (subject.isAuthenticated()) map.put("url", "index");
        } catch (IncorrectCredentialsException e) {
            error = "用户名或密码错误";
        } catch (ExcessiveAttemptsException e) {
            error = "登录失败次数过多";
        } catch (LockedAccountException e) {
            error = "帐号已被锁定";
        } catch (DisabledAccountException e) {
            error = "帐号已被禁用";
        } catch (ExpiredCredentialsException e) {
            error = "帐号已过期";
        } catch (UnknownAccountException e) {
            error = "帐号不存在";
        } catch (Exception e) {
            error = "发生了未知错误";
        }
        if (StringUtils.isBlank(error)) return RestResponse.success("登录成功").setData(map);

        return RestResponse.failure(error);
    }

    @GetMapping("index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("main")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("logOut")
    public String logOut() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}