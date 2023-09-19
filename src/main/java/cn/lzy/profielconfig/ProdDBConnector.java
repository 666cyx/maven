package cn.lzy.profielconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public  class ProdDBConnector implements DBConnector{
    @Override
    public String config() {
        return "这个是生产环境";
    }
}
