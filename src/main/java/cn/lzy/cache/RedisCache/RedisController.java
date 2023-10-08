package cn.lzy.cache.RedisCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 陈远翔
 * @date 2023/9/26 12:00
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    //  浏览器输入查询数据url：  http://localhost:8080/getRedis/1
    @GetMapping("/getRedis/{id}")
    public Discuss findById(@PathVariable("id") int comment_id){
        Discuss mDiscuss = redisService.findById(comment_id);
        return mDiscuss;
    }



    //  浏览器输入更新数据url：
    //  项目启动成功后，通过浏览器访问   http://localhost:8080/update/1/shitou
    //  接着，继续访问   http://localhost:8080/get/1
    @GetMapping("/update/{id}/{author}")
    public Discuss updateComment(@PathVariable("id") int comment_id,
                                 @PathVariable("author") String author){
        Discuss comment = redisService.findById(comment_id);
        comment.setAuthor(author);
        Discuss updateComment = redisService.updateComment(comment);
        return updateComment;
    }


    //  浏览器输入删除的url：  http://localhost:8090/delete/1
    @GetMapping("/delete/{id}")
    public void deletecomment(@PathVariable("id") int comment_id){
        redisService.deleteComment(comment_id);
    }

}
