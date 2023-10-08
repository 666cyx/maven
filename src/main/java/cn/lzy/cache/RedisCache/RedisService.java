package cn.lzy.cache.RedisCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 陈远翔
 * @date 2023/9/26 12:03
 */
@Service
public class RedisService {

    @Autowired
    private DiscussRepository mDiscussRepository;


    // 根据评论id查询评论信息

    //@Cacheable(cacheNames = "comment")
    @Cacheable(cacheNames = "comment",unless = "#result=null")
    public Discuss findById(int comment_id){
        Optional<Discuss> Optional = mDiscussRepository.findById(comment_id);
        if (Optional.isPresent()){
            return Optional.get();
        }
        return null;
    }



    // 更新评论信息
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Discuss updateComment(Discuss comment){
        mDiscussRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }


    // 删除评论信息
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id){
        mDiscussRepository.deleteById(comment_id);
    }

}
