
/*
package cn.lzy.cache.JpaCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


*/
/**
 * @author 陈远翔
 * @date 2023/9/25 16:39
 *//*


@RestController
public class JpaController {
    @Autowired
    private DiscussRepository mDiscussRepository;
    @GetMapping ("/get/{id}")
    @Cacheable(cacheNames = "comment")
    public Discuss findById(@PathVariable("id") int comment_id){
        Optional<Discuss> moptional = mDiscussRepository.findById(1);
        if(moptional.isPresent()){
            return moptional.get();
        }
        return null;
    }



}

*/
