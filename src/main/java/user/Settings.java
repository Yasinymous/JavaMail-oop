package user;

import database.Base;

import java.sql.SQLException;
import java.util.Scanner;


public class Settings {

    Base base = new Base();
    Scanner scanner = new Scanner(System.in);

    public boolean settings(int uid) throws SQLException {
        System.out.print("Settings" +"\n"
                        + "Profile(0)" +"\n"
                        + "Update-Profile(1)" +"\n"
                        + "Exit(2)" +"\n"
                        + "Choice : ");
        try{
            int choice = Integer.parseInt(scanner.next());
            switch(choice) {
                case 0:
                    System.out.println("profile");
                    user_profile(uid);
                    break;
                case 1:
                    System.out.print("uptade profile\nnew username : ");
                    String new_username = scanner.next();
                    boolean test = user_profile_update(uid,new_username);
                    if (test)
                        user_profile(uid);
                    break;
                case 2:
                    System.out.println("exit");
                    return false;
                default:
                    System.out.println("wrong choice");
            }
        }catch (NumberFormatException nfe) {
            System.out.println("Please enter number!");
        }
        return true;
    }

    public boolean user_profile_update(int uid,String username){
        return base.update(uid,username);
    }
    public void user_profile(int uid){
        base.login_info(uid);
    }

}
