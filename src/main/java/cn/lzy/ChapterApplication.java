package cn.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:xmlproperties.xml")
public class ChapterApplication {
    public static void main(String[] args) {

        SpringApplication.run(ChapterApplication.class,args);
    }
}
