package user;

import database.Base;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainUser {

    Scanner scanner = new Scanner(System.in);
    Base base = new Base();
    Register r = new Register();
    Login l = new Login();


    public void main() throws IOException, SQLException, ClassNotFoundException {

        String filename = "user.db";
        base.createNewTable(filename);

        base.connect(filename);
        boolean x = true;
        while(x) {
        System.out.print("Sign In/Sign Up" +"\n"
                + "Register(0)" +"\n"
                + "Login(1)" +"\n"
                + "Exit(2)" +"\n"
                + "Choice : ");
            try{
                int choice = Integer.parseInt(scanner.next());
                switch (choice) {
                    case 0:
                        r.register();
                        break;
                    case 1:
                        l.login();
                        break;
                    case 2:
                        System.out.println("exit");
                        x = false;
                        break;
                    default:
                        System.out.println("wrong choice");
                }
            }catch (NumberFormatException nfe) {
                System.out.println("Please enter number!");
            }
        }
    }

}
