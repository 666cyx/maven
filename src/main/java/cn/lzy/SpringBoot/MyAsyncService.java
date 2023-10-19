package cn.lzy.SpringBoot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author 陈远翔
 * @date 2023/10/19 17:23
 */
@Service//http://localhost:8080/sendSMS
//http://localhost:8080/statistics
public class MyAsyncService {

    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime)); }

    @Async
    public Future<Integer> processA() throws Exception {
        System.out.println("开始分析并统计业务A数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        //int count=123456;
        int al = 0;
        for(int i =1;i<1001;i++) {
            al+=i;
        }
        System.out.println("业务A数据异步统计结果："+al);
        Long endTime = System.currentTimeMillis();
        System.out.println("业务A数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(al);
    }
    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("开始分析并统计业务B数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(4000);
        //int count=654321;

        int all = 0;
        for(int i =1000;i<2001;i++) {
            all+=i;
        }
        System.out.println("业务B数据异步统计结果："+all);
        Long endTime = System.currentTimeMillis();
        System.out.println("业务B数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(all);
    }


}
