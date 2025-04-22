package Model;

import java.util.Scanner;

public class User {

    private String username;
    private String password;

    Scanner scanner = new Scanner(System.in);

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void deleteUser() {
        this.username = null;
        this.password = null;
        System.out.println("The user has been deleted.");
    }

    public void viewFlight() {
        System.out.println("Flight details will be displayed here.");
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void changeCredential() {

        String Response;
        boolean flag = true;

       do {
           System.out.println("Quali dati vuoi cambiare? username / password");
           Response = scanner.nextLine();

           Response = Response.toLowerCase();

           if(Response.equals("username")) {
               resetUsername();
               flag = false;
           }
           else if(Response.equals("password")) {
               resetPassword();
               flag = false;
           }
           else {
               System.out.println("\u001B[31m Inserire un valore valido! \u001B[0m");
           }
       } while (flag);


    }

    private void resetUsername() {
        System.out.println(" Inserisci il tuo username: ");
        username = scanner.nextLine();
        this.username = username;
    }

    private void resetPassword() {
        System.out.println(" Inserisci la tua password: ");
        password = scanner.nextLine();
        this.password = password;
    }

}
