package user;

import database.Base;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    Base base = new Base();
    Settings settings = new Settings();
    Scanner scanner = new Scanner(System.in);

    public void login() throws SQLException {
        System.out.print("Username : ");
        String username = scanner.next();
        System.out.print("Mail : ");
        String mail = scanner.next();
        boolean test1 = login_control(username,mail);
        if (test1){
            System.out.println("login success");
            settings.settings();
        }
        else
            System.out.println("try-again");
    }


    public boolean login_control(String username, String mail) throws SQLException {
        String new_mail = base.user_loginname(username);
        if (new_mail.equals(mail))
            return true;
        return false;
    }
}

