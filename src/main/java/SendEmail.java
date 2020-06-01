import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static void main(String[] args) throws AddressException {
        //authentication info
        final String username = "optionstrading610@gmail.com";
        final String password = "Kkroal@5334";
        String fromEmail = "optionstrading610@gmail.com";
//        String toEmail = "karureddy27@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        InternetAddress[] addresses = new InternetAddress[3];
        addresses[0]=new InternetAddress("karureddy27@gmail.com");
        addresses[1]=new InternetAddress("kkr5334@gmail.com");
        addresses[2]=new InternetAddress("kkatasani@miraclesoft.com");

        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, addresses );
            msg.setSubject("Test message arrived");
            msg.setText("Test in progress");
            Transport.send(msg);
            System.out.println("Sent message");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}