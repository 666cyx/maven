package cn.lzy.Security.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}

