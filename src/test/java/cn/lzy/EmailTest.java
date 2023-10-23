package cn.lzy;

import cn.lzy.email.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author 陈远翔
 * @date 2023/10/23 10:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {


        @Autowired
        private SendEmailService sendEmailService;
        //发送纯文本邮件
        @Test
        public void sendSimpleMailTest() {
            String to="2775254436@qq.com";
            String subject="【纯文本邮件】标题";
            String conten="Spring Boot纯文本邮件发送内容测试.....";
            sendEmailService.sendSimpleEmail(to,subject,conten);
        }

/* @param to  收件人地址
    @param subject 邮件标题
    @param text 邮件内容
    @param filePath 附件地址
    @param rscId 静态资源唯一标识
    @param rscPath 静态资源地址
    */
//单独发送附件邮件
    @Test
    public void sendComplexEmailTest2() {
        String to="2775254436@qq.com";
        String subject="【单独发送附件邮件】标题";
        StringBuilder text = new StringBuilder();
        String filePath="E:\\email\\元旦放假注意事项.txt";
        sendEmailService.sendComplexEmail2(to,subject,text.toString(),
                filePath);}



    //单独发送图片邮件
    @Test
    public void sendComplexEmailTest3() {
        String to="2775254436@qq.com";
        String subject="【单独发送图片邮件】标题";
        StringBuilder text = new StringBuilder();
        String rscId = "img001";
        text.append("<img src='cid:" +rscId+"'/></body>");text.append("</html>");
        String rscPath="E:\\email\\newyear.jpg";
        sendEmailService.sendComplexEmail3(to,subject,text.toString(),rscId,rscPath);}

    //发送附件、图片、文本邮件
    @Test
    public void sendComplexEmailTest4() {
        String to="2775254436@qq.com";
        String subject="【发送附件、图片、文本邮件】标题";
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>成功发送附件、图片、文本邮件</h1>");
        String rscId = "img001";
        text.append("<img src='cid:" +rscId+"'/></body>");text.append("</html>");
        String rscPath="E:\\email\\newyear.jpg";
        String filePath="E:\\email\\元旦放假注意事项.txt";
        sendEmailService.sendComplexEmail4(to,subject,text.toString(),
                filePath,rscId,rscPath);}


    //发送模板邮件
@Autowired
private TemplateEngine templateEngine;
    @Test
    public void sendTemplateEmailTest5() {
        String to="2775254436@qq.com";
        String subject="【模板邮件】标题";
        Context context = new Context();
        context.setVariable("username", "孤煞星");
        context.setVariable("code", "456123");
        String emailContent = templateEngine.process("emailTemplate_vercode", context);
        sendEmailService.sendTemplateEmail5(to,subject,emailContent);}


}


