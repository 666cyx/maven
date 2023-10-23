package cn.lzy.SpringBoot;

import cn.lzy.utils.DataUtils;
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
        System.out.println("计算1-1000的值总和开始时间："+ DataUtils.getData(DataUtils.data1));
        System.out.println("开始计算1-1000的值总和..."+"\n");

        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        //int count=123456;
        int al = 0;
        for(int i =1;i<1001;i++) {
            al+=i;
        }
        System.out.println("计算1-1000的值总和统计结果为："+al);
        Long endTime = System.currentTimeMillis();
        System.out.println("计算1-1000的值总和统计耗时：" + (endTime - startTime));
        System.out.println("计算1-1000的值总和结束时间："+DataUtils.getData(DataUtils.data1+"\n"));
        return new AsyncResult<Integer>(al);
    }
    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("计算1000-2000的值总和开始时间："+DataUtils.getData(DataUtils.data1));
        System.out.println("开始计算1000-2000的值总和..."+"\n");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(0);
        //int count=654321;

        int all = 0;
        for(int i =1000;i<2001;i++) {
            all+=i;
        }
        System.out.println("计算1000-2000的值总和为："+all);
        Long endTime = System.currentTimeMillis();
        System.out.println("计算1000-2000的值总和统计耗时：" + (endTime - startTime));
        System.out.println("计算1000-2000的值总和结束时间："+DataUtils.getData(DataUtils.data1+"\n"));
        return new AsyncResult<Integer>(all);
    }


}
