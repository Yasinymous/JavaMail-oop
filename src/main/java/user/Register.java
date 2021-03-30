package user;

import database.Base;
import main.SendEmail;
import token.Token_Generate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class Register{

    Base base = new Base();
    Token_Generate token_generate = new Token_Generate();
    Scanner scanner = new Scanner(System.in);
    SendEmail sendemail = new SendEmail();

    public int username_control(String username) throws SQLException {
        if (!base.user_username(username))
            return 0;
        else
            return 1;
    }

    public int mail_control(String mail) throws SQLException {
        if (!base.user_mail(mail))
            return 0;
        else
            return 1;
    }

    public void user_register(String username,String mail) throws IOException {
        if (mail_verified(mail)){
            base.user_insert(username,mail,1);
            System.out.println("Basariyla kayit oldunuz...");
        }
        else {System.out.println("Dogrulanamadi"); }

    }

    /* herkes mailleri alabailecek ama mail dogrulanırsa kimse alamıcak tekrar */

    public boolean mail_verified(String mail) throws IOException {
        String a = token_generate.token_generate();
        String[] sub = {"doğrulama", a};
        sendemail.send(mail, sub);
        System.out.print("key :");
        String key = scanner.nextLine();
        if (a.equals(key))
            return true;
        return false;
    }





}
