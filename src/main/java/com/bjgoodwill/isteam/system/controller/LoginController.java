package com.bjgoodwill.isteam.system.controller;

import com.bjgoodwill.isteam.common.annotation.Log;
import com.bjgoodwill.isteam.common.config.IsteamProperties;
import com.bjgoodwill.isteam.common.controller.BaseController;
import com.bjgoodwill.isteam.common.domain.ResponseBo;
import com.bjgoodwill.isteam.common.util.MD5Utils;
import com.bjgoodwill.isteam.common.util.vcode.Captcha;
import com.bjgoodwill.isteam.common.util.vcode.GifCaptcha;
import com.bjgoodwill.isteam.system.domain.User;
import com.bjgoodwill.isteam.system.domain.UserOnline;
import com.bjgoodwill.isteam.system.service.SessionService;
import com.bjgoodwill.isteam.system.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
@Controller
public class LoginController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String CODE_KEY = "_code";

    @Autowired
    private IsteamProperties isteamProperties;

    @Autowired
    private UserService userService;
    @Autowired
    SessionService sessionService;

    @Value("${isteam.validateCode.enableValidateCode}")
    private Boolean enableValidateCode;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("enableValidateCode", enableValidateCode);
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password, String code, Boolean rememberMe) {
        // 启用验证码验证功能
        if (enableValidateCode) {
            if (!StringUtils.isNotBlank(code)) {
                return ResponseBo.warn("验证码不能为空！");
            }
            Session session = super.getSession();
            String sessionCode = (String) session.getAttribute(CODE_KEY);
            if (!code.equalsIgnoreCase(sessionCode)) {
                return ResponseBo.warn("验证码错误！");
            }
        }
        // 密码 MD5 加密
        password = MD5Utils.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 同名用户强制退出，同一个用户只允许在一个客户端登录
        List<UserOnline> list = sessionService.list();
        for (UserOnline userOnline : list) {
            if (userOnline.getUsername().equals("admin")) {
                sessionService.forceLogout(userOnline.getId());
            }
        }
        try {
            Subject subject = getSubject();
            if (subject != null)
                subject.logout();
            super.login(token);
            this.userService.updateLoginTime(username);
            return ResponseBo.ok();
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }

    @GetMapping(value = "gifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");

            Captcha captcha = new GifCaptcha(
                    isteamProperties.getValidateCode().getWidth(),
                    isteamProperties.getValidateCode().getHeight(),
                    isteamProperties.getValidateCode().getLength());
            HttpSession session = request.getSession(true);
            captcha.out(response.getOutputStream());
            session.removeAttribute(CODE_KEY);
            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
        } catch (Exception e) {
            log.error("图形验证码生成失败", e);
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }

    @Log("访问系统")
    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过 Subject 获取登录的用户信息
        User user = super.getCurrentUser();
        model.addAttribute("user", user);
        return "index";
    }
}
