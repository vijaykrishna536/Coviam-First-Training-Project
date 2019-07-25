package utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class SendingMail implements CommandLineRunner {

    private String email;
    private String message;
    private String subject;

    public SendingMail(String email,String message,String subject)
    {
        this.email=email;
        this.message =message;
        this.subject=subject;
    }


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void run(String... args) {

        System.out.println("Sending Email...");

        try {

            sendEmail();
            //sendEmailWithAttachment();

//		} catch (IOException e) {
//			e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }

    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sidana1997@gmail.com");

        msg.setSubject("hal");
        msg.setText("taad");
        try {
            javaMailSender.send(msg);
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }


}

