package cn.lzy.mybatiscatalog.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

/**
 * @author 孤煞星
 * @date 2023/9/5 11:43
 */
    @RedisHash("persons")
    public class Person {
        @Id
        private String id;
        @Indexed
        private String firstname;
        @Indexed
        private String lastname;
        private Address address;
        private List<Family> familyList;
    }

