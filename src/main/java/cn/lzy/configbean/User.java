package cn.lzy.configbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component
@ConfigurationProperties(prefix = "user")
@Validated
public class User {
    @Email
    String email;
    String url;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
