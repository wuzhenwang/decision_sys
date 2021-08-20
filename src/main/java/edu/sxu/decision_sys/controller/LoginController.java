package edu.sxu.decision_sys.controller;

import edu.sxu.decision_sys.entity.Menu;
import edu.sxu.decision_sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzw
 * @version 1.0
 * @description 登录controller
 * @date 2020/5/1 14:16
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

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
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User)principal;
        Map map = new HashMap();
        map.put("user", user);
        Menu menu01 = new Menu("01","信息管理","#","glyphicon-book","0",1);
        Menu menu0101 = new Menu("0101","专家管理","#","glyphicon-record","01",1);
        Menu menu0102 = new Menu("0102","方案管理","#","glyphicon-record","01",2);
        Menu menu02 = new Menu("02","用户管理","#","glyphicon-cog","0",2);
        Menu menu0201 = new Menu("0201","用户管理","#","glyphicon-record","02",1);
        Menu menu0202 = new Menu("0202","测试2","#","glyphicon-record","02",2);
        List<Menu> menuListOne = new ArrayList<>();
        List<Menu> menuListTwo = new ArrayList<>();
        menuListOne.add(menu01);
        menuListTwo.add(menu0101);
        menuListTwo.add(menu0102);
        menuListOne.add(menu02);
        menuListTwo.add(menu0201);
        menuListTwo.add(menu0202);
        map.put("oneMenuAll",menuListOne);
        map.put("twoMenuAll",menuListTwo);
        map.put("notice", 0);
        map.put("mail", 0);
        map.put("task", 0);
        model.addAllAttributes(map);
        return "index";
    }


}
