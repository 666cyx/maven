package cn.lzy.SpringBoot;

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
        Long startTime = System.currentTimeMillis();
        Future<Integer> futureA = myService.processA();
        Future<Integer> futureB = myService.processB();
        int total = futureA.get() + futureB.get();
        System.out.println("异步任务数据统计汇总结果： "+total);
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时： "+(endTime-startTime));
        return "success";}

}
