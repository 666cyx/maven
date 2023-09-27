package cn.lzy.cache.JpaCache;

import cn.lzy.cache.JpaCache.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

}
