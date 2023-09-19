package cn.lzy.mybatiscatalog.redis;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @author 孤煞星
 * @date 2023/9/5 11:48
 */
public class Family {
    @Indexed
    private String type;
    @Indexed
    private String username;
}
