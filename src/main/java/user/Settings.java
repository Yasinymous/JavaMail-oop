package user;


import java.util.Scanner;

public class Settings {

    Scanner scanner = new Scanner(System.in);
    public void settings(){
        System.out.print("Settings" +"\n"
                        + "Profile(0)" +"\n"
                        + "Update-Profile(1)" +"\n"
                        + "Choice : ");
        int choice = Integer.parseInt(scanner.next());
        switch(choice) {
            case 0:
                System.out.println("profile");
                break;
            case 1:
                System.out.println("uptade profile");
                break;
            default:
                System.out.println("wrong choice");
        }
    }

    public boolean user_update(){


        

        return false;
    }

}
