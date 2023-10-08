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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

