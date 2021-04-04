package user;

import database.Base;
import mail.SendEmail;
import token.Token_Generate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Register{

    Scanner scanner = new Scanner(System.in);
    Base base = new Base();
    Token_Generate tokenG = new Token_Generate();
    SendEmail sendemail = new SendEmail();

    public void register() throws SQLException, IOException {
        System.out.println("Register");
        System.out.print("Username : ");
        String username = scanner.next();
        System.out.print("Mail : ");
        String mail = scanner.next();
        if (username_control(username))
            System.out.println("Username is used");
        if (mail_control(mail))
            System.out.println("E-mail is used");
        else
            user_register(username,mail);
    }

    public boolean username_control(String username) throws SQLException {
        if (base.user_username(username))
            return true;
        else
            return false;
    }

    public boolean mail_control(String mail) throws SQLException {
        if (base.user_mail(mail))
            return true;
        return false;
    }

    public void user_register(String username,String mail) throws IOException {
        if (!isValid(mail))
            System.out.println("Please enter e-mail");
        if (isValid(mail) && mail_verified(mail)){
            base.user_insert(username,mail,1);
            System.out.println("You have successfully registered");
        }
        else {System.out.println("Not verified"); }

    }

    /* herkes mailleri alabailecek ama mail dogrulanırsa kimse alamıcak tekrar */

    public boolean mail_verified(String mail) throws IOException {
        String a = tokenG.token_generate();
        String[] sub = {"Verified", a};
        sendemail.send(mail, sub);
        System.out.print("key : ");
        String key = scanner.next();
        if (a.equals(key))
            return true;
        return false;
    }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


}
