package cn.lzy.Security.CSRF;

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
        @GetMapping("/toUpdate")
        public String toUpdate() { return "csrf/csrfTest";}
        @ResponseBody
        @PostMapping(value = "/updateUser")
        public String updateUser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
            System.out.println(username);
            System.out.println(password);
            String csrf_token = request.getParameter("_csrf");
            System.out.println(csrf_token);return "修改成功"; }
    }

