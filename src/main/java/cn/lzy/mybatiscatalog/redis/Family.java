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

    public Family(String type, String username) {
        this.type = type;
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Family{" +
                "type='" + type + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
