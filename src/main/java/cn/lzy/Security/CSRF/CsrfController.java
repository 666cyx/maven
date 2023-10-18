package cn.lzy.Security.CSRF;

import cn.lzy.Security.redis.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 陈远翔
 * @date 2023/10/15 19:34
 */

    @Controller
    public class CsrfController {
        @Autowired
        private CustomerRepository customerRepository;
        @GetMapping("/toUpdate")
        public String toUpdate() { return "csrf/csrfTest";}
        @ResponseBody
        @PostMapping(value = "/updateUser")
        public String updateUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
            System.out.println(username);
            System.out.println(password);
            String csrf_token = request.getParameter("_csrf");
            System.out.println(csrf_token);
            //customerRepository.updateCache(username,1);/*查询修改*/
            //获取应用上下文
            SecurityContext context = SecurityContextHolder.getContext();
            //获取登录的用户信息
            Authentication authentication = context.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            //获取登录的用户id
            Integer updateId = customerRepository.findByUsername1(principal.getUsername());
            //更新用户表中对应id的用户名
            Integer result = customerRepository.updateCache(username, updateId);
            return "修改成功"; }


    }

