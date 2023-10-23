package cn.lzy.Scheduled;

import cn.lzy.utils.DataUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈远翔
 * @date 2023/10/21 14:44
 */
@Service
public class ScheduledTaskService {
   /* @Scheduled(fixedRate = 5000)//开始5秒后再执行一次
    public void fixedRate() throws InterruptedException{
        System.out.println("fixedRate====="+cn.lzy.utils.DataUtils.getData(DataUtils.data1));
        Thread.sleep(10*1000);//代码等待10秒执行
    }
        @Scheduled(fixedRate = 15000)//开始15秒后再执行一次
        public void fixedRate1() throws InterruptedException{
            System.out.println("fixedRate-----"+cn.lzy.utils.DataUtils.getData(DataUtils.data1));
            Thread.sleep(15*1000);//代码等待15秒执行
        }



    @Scheduled(fixedDelay = 5000)//开始5秒后再执行一次
    public void fixedDelay() throws InterruptedException{
        System.out.println("fixedDelay====="+DataUtils.getData(DataUtils.data1));
        Thread.sleep(10*1000);//代码等待10秒执行
    }
    @Scheduled(fixedDelay = 5000)//开始5秒后再执行一次
    public void fixedDelay1() throws InterruptedException{
        System.out.println("fixedDelay------"+DataUtils.getData(DataUtils.data1));
        Thread.sleep(5*1000);//代码等待5秒执行
    }





    //Delay第一次执行延迟10秒
@Scheduled(initialDelay = 10000,fixedRate = 5000)
public void initialDelay() throws InterruptedException {
    System.out.println("initialDelay===="+DataUtils.getData(DataUtils.data1));
    Thread.sleep(10*1000);//10秒之后重复执行任务
}
    //Delay第一次执行延迟0秒
    @Scheduled(initialDelay = 0,fixedRate = 10000)
    public void initialDelay1() throws InterruptedException {
        System.out.println("initialDelay-----"+DataUtils.getData(DataUtils.data1));
        Thread.sleep(5*1000);//5秒之后重复执行任务
    }*/

   /* private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count1 = 1;
    private Integer count2 = 1;
    private Integer count3 = 1;
    @Scheduled(fixedRate = 60000)
    public void scheduledTaskImmediately() {
        System.out.println(String.format("fixedRate第%s次执行，当前时间为：%s",
                count1++, dateFormat.format(new Date())));
    }

    @Scheduled(fixedDelay = 60000)
    public void scheduledTaskAfterSleep() throws InterruptedException {
        System.out.println(String.format("fixedDelay第%s次执行，当前时间为：%s",
                count2++, dateFormat.format(new Date())));
        Thread.sleep(10000);
    }
    @Scheduled(cron = "0 * * * * *")
    public void scheduledTaskCron(){
        System.out.println(String.format("cron第%s次执行，当前时间为：%s",
                count3++, dateFormat.format(new Date())));
    }*/

}
