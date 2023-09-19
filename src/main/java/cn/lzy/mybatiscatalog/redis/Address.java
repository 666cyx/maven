package cn.lzy.mybatiscatalog.redis;

import org.springframework.data.redis.core.index.Indexed;

/**
 * @author 孤煞星
 * @date 2023/9/5 11:43
 */
public class Address {
    @Indexed
    private String city;
    @Indexed
    private String country;


}
