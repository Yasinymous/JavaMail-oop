package main;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    static Settings settings = new Settings();
    public static void send(String target,String[] sub) {

        String to = target;
        String from = "verification@yasinymous.com";
        String host = settings.host;
        System.out.println(settings.host);

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(settings.mail, settings.pass);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(sub[0]);
            msg.setText(sub[1]);
            System.out.println("sending...");
            Transport.send(msg);
            System.out.println("Send message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}