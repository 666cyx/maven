package cn.lzy;

import cn.lzy.configbean.Person;
import cn.lzy.configbean.Student;
import cn.lzy.configbean.User;
import cn.lzy.controller.ChapterController;
import cn.lzy.customconfig.CustomProperties;
import cn.lzy.customconfig.MyProperties;
import cn.lzy.mybatiscatalog.Article;
import cn.lzy.mybatiscatalog.ArticleMapper;
import cn.lzy.mybatiscatalog.Comment;
import cn.lzy.mybatiscatalog.CommentMapper;
import cn.lzy.mybatiscatalog.redis.Address;
import cn.lzy.mybatiscatalog.redis.Family;
import cn.lzy.profielconfig.DBConnector;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
//import sun.java2d.cmm.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterTestApplication {
    //    private  String TAG="ChapterTestApplication";
    @Autowired
    ChapterController chapterController;
    @Autowired
    Student student;

   @Value("${student.id}")
    int id;
    @Autowired
    User user;

    @Autowired
    Person person;

    @Autowired
    CustomProperties customProperties;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DBConnector dbConnector;

    @Autowired
   CommentMapper commentMapper;

    /*@Autowired
    private DruidDataSource dataSource;

    @Test
    public void testDruidDataSource() {

        System.out.println(dataSource.getMaxActive());
    }

    @Autowired
   private ArticleMapper articleMapper;

    @Test
    public void selectArticle() {

        Article article = articleMapper.selectArticle(1);

        System.out.println(article);

    }*/
    @Test
    public void contextLoads() {
        System.out.println("单元测试返回的数据--" + chapterController.sayHello());
        System.out.println("单元测试返回的student数据--" + student);
        System.out.println("单元测试返回的id数据--" + id);
        System.out.println("单元测试返回的user数据--" + user);
        System.out.println("单元测试返回的person数据--" + person);
    System.out.println("单元测试返回的customproperties数据--" +customProperties);
        System.out.println("单元测试返回的profile环境--" + dbConnector.config());
        System.out.println("查询数据库" + commentMapper.findById(1));
//        System.out.println("删除数据成功" + commentMapper.deleteComment(1));
//        System.out.println("插入数据" + commentMapper.insertComment(id='1', "很全、很详细", "狂奔的蜗牛", '1'));
//'1', '很全、很详细', '狂奔的蜗牛', '1'
        /*MyProperties myProperties=(MyProperties) applicationContext.getBean("myProperties");
        if (myProperties!=null){
            System.out.println("MyPropertie类注入不成功");
        }else {
            myProperties.getResult();
        }*/
    }
//    public void  getHello(){
//        String result=chapterController.sayHello();
//        System.out.println(TAG+"单元测试返回==="+result);
//    }
/*@Test
    public void saveRedisPerson(){
        cn.lzy.mybatiscatalog.redis.Person personRedis=new cn.lzy.mybatiscatalog.redis.Person();
        personRedis.setFirstname("张");
        personRedis.setLastname("三");
    Address address=new Address();
    address.setCity("柳州");
    address.setCountry("中国");
personRedis.setAddress(address);
    List<Family> list=new ArrayList<>();
    Family dad=new Family("父亲","刘");
    Family mom=new Family("母亲","王");
    list.add(dad);
    list.add(mom);
    personRedis.setFamilyList(list);
    cn.lzy.mybatiscatalog.redis.Person personResult=repository.save(personRedis);
    System.out.println(personResult);
    }*/

}