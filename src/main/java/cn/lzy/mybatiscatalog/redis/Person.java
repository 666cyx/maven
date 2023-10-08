package cn.lzy.mybatiscatalog.redis;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;



import javax.persistence.Id;
import java.util.List;
/**
 * @author 孤煞星
 * @date 2023/9/5 11:43
 */
@RedisHash("persons")
public class Person {

    @Id //用于标识实体类主键
    private String id;
    @Indexed //用于标识该属性会在redis数据库中生成二级索引
    private String firstname;
    @Indexed
    private String lastname;
    private Address address;
    private List<Family> familyList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }
}


