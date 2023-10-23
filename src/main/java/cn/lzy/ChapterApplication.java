package cn.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.Serializable;

@EnableScheduling
@EnableAsync


@SpringBootApplication
@ImportResource("classpath:xmlproperties.xml")
@EnableCaching
public class ChapterApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ChapterApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ChapterApplication.class, args);
    }
}
