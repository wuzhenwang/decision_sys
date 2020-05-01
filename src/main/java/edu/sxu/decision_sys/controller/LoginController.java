package edu.sxu.decision_sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzw
 * @version 1.0
 * @description 登录controller
 * @date 2020/5/1 14:16
 */
@Controller
public class LoginController {

    /**
     * 首次路径访问
     * @return
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    /**
     * 需要登录时
     * @return
     */
    @RequestMapping("/login")
    public String logi() {
        return "login";
    }

    /**
     * 登录失败时
     * @return
     */
    @RequestMapping("/login-error")
    public String error() {
        return "login-error";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}
