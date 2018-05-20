package com.joizhang.imooc.controller;

import com.joizhang.imooc.util.SHAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@Slf4j
public class AccountController {

    /**
     * 转向登录界面
     *
     * @return 登录界面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    /**
     * 接收用户登录传参，判断是否登陆成功
     *
     * @param userName   用户名
     * @param password   密码
     * @param rememberMe 记住我
     * @param session    session
     * @param request    request
     * @return 跳转界面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam(value = "rememberMe", required = false) String rememberMe,
                        HttpSession session,
                        HttpServletRequest request) {
        UsernamePasswordToken token = null;
        try {
            Subject user = SecurityUtils.getSubject();
            token = new UsernamePasswordToken(userName.trim(), SHAUtils.getSHA256(password));
            if (rememberMe != null && rememberMe.equals("on")) {
                token.setRememberMe(true);
            }
            user.login(token);
            return "redirect:/";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if (token != null) {
                token.clear();
            }
            return "redirect:/login";
        }
    }

    /**
     * 退出登录
     *
     * @return 登录界面
     */
    @GetMapping("/logout")
    public String logOut() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }


}
