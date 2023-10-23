package cn.lzy.SpringBoot;

import cn.lzy.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author 陈远翔
 * @date 2023/10/19 17:23
 */
@RestController
public class MyAsyncController {
    @Autowired
    private MyAsyncService myService;
    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {
        Long startTime = System.currentTimeMillis();
        myService.sendSMS();
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时： "+(endTime-startTime));

        return "success";}


    @GetMapping("/statistics")
    public String statistics() throws Exception {
        System.out.println("计算异步任务数据统计汇总结果开始时间："+ DataUtils.getData(DataUtils.data1));
        Long startTime = System.currentTimeMillis();
        Future<Integer> futureA = myService.processA();//异步
        Future<Integer> futureB = myService.processB();//异步
        int total = futureA.get() + futureB.get();//同步
        System.out.println("异步步任务数据统计汇总结果为： "+total);
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时： "+(endTime-startTime));
        System.out.println("计算异步任务数据统计汇总结果结束时间："+DataUtils.getData(DataUtils.data1));
        return "success";}

}
