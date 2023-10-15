package cn.lzy.Security.base;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author 陈远翔
 * @date 2023/10/9 9:51
 */
@Controller
public class FilmeController {
    private String TAG="FileController";
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type,
                           @PathVariable("path") String path) {
        String value = "detail/" + type + "/" + path;
        System.out.println(TAG+"==toDetail=="+value);
        return value;
    }

    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }
    @GetMapping("/getuserBySession")//http://localhost:8080/getuserBySession
    @ResponseBody
    public void getUser(HttpSession session) {
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()){
            String element = names.nextElement();SecurityContextImpl attribute =
                    (SecurityContextImpl) session.getAttribute(element);
            System.out.println("element: "+element);System.out.println("attribute: "+attribute);
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails)authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username: "+principal.getUsername());}}
    @GetMapping("/getuserByContext")////http://localhost:8080/getuserByContext
    @ResponseBody
    public void getUser2() {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("userDetails: "+context);
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails)authentication.getPrincipal();
        System.out.println(principal);
        System.out.println("username: "+principal.getUsername());
    }


}

