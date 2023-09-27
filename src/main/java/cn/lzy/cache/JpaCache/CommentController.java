package cn.lzy.cache.JpaCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author 陈远翔
 * @date 2023/9/26 11:01
 */
@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

 @Cacheable(cacheNames = "article")/*缓存管理使只显示一条访问记录*/
    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id")int comment_id){
     Optional<Comment> mOptional= commentRepository.findById(comment_id);
     if (mOptional.isPresent()){
         return mOptional.get();
     }
     return null;
 }

 /*查comment表*/
     //http://localhost:8080/get/1
     //private DiscussRepository repository;
/*  @Cacheable(cacheNames = "comment")//缓存管理使只显示一条访问记录
    @GetMapping("/get/{id}")
    public Discuss findById(@PathVariable("id")int comment_id){
        Optional<Discuss> mOptional= repository.findById(comment_id);
        if (mOptional.isPresent()){
            return mOptional.get();
        }
        return null;
    }*/

}
