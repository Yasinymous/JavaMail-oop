package user;

import database.Base;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);
    Base base = new Base();
    Settings settings = new Settings();

    public void login() throws SQLException {
        System.out.print("Username : ");
        String username = scanner.next();
        System.out.print("Mail : ");
        String mail = scanner.next();
        boolean login_log = login_control(username,mail);
        if (login_log){
                System.out.println("login success");
            while(login_log) {
                int uid = base.get_uid(username);
                login_log = settings.settings(uid);
            }
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

