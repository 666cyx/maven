package cn.lzy.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author 陈远翔
 * @date 2023/10/23 9:57
 */
@Service
public class SendEmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.username}")
    private String from;
    //发送纯文本邮件
    public void sendSimpleEmail(String to,String subject,String conten){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);  message.setTo(to);
        message.setSubject(subject); message.setText(conten);
        try { mailSender.send(message);System.out.println("纯文本邮件发送成功");
        } catch (MailException e) {
            System.out.println("纯文本邮件发送失败 "+e.getMessage());e.printStackTrace();}
    }

    //单独发送附件邮件
    public void sendComplexEmail2(String to,String subject,String text,String filePath){
        MimeMessage message = mailSender.createMimeMessage();try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);helper.setTo(to);
            helper.setSubject(subject);helper.setText(text, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);mailSender.send(message);
            System.out.println("单独发送附件邮件成功");
        } catch (MessagingException e) {
            System.out.println("单独发送附件邮件失败 "+e.getMessage());e.printStackTrace();}}




    //单独发送图片邮件
   public void sendComplexEmail3(String to,String subject,String text,String rscId,String rscPath){MimeMessage message = mailSender.createMimeMessage();try {
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);helper.setTo(to);
        helper.setSubject(subject);helper.setText(text, true);
       FileSystemResource res = new FileSystemResource(new File(rscPath));
       helper.addInline(rscId, res);
       mailSender.send(message);
        System.out.println("单独发送图片邮件成功");
    } catch (MessagingException e) {
        System.out.println("单独发送图片邮件失败 "+e.getMessage());e.printStackTrace();}}


    //发送附件、图片、文本邮件
    public void sendComplexEmail4(String to,String subject,String text,String filePath,String rscId,
                                 String rscPath){

        MimeMessage message = mailSender.createMimeMessage();



        try {MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);helper.setTo(to);
        helper.setSubject(subject);helper.setText(text, true);
        FileSystemResource res = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId, res);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);mailSender.send(message);
        System.out.println("发送附件、图片、文本邮件成功");
    } catch (MessagingException e) {
        System.out.println("发送附件、图片、文本邮件失败 "+e.getMessage());e.printStackTrace();}}



    //发送模板邮件
    public void sendTemplateEmail5(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);helper.setTo(to);
            helper.setSubject(subject);helper.setText(content, true);
            mailSender.send(message);System.out.println("模板邮件发送成功");
        } catch (MessagingException e)
        {System.out.println("模板邮件发送失败 "+e.getMessage());
            e.printStackTrace();}}


}


