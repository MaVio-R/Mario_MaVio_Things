package org.example;

public class Client extends User {
    private String name;
    private String surname;
    private String DOB;
    private String SSN;
    private String phoneNumber;
    private String email;

    public Client(String username, String password, String name, String surname, String DOB, String phoneNumber, String email) {
        super(username, password);
        this.name = name;
        this.surname = surname;
        this.DOB = DOB;
        this.SSN = SSN;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void book(){

    }

    public void updateBooking(){

    }

    public void viewBooking(){

    }

    public void reportLostLuggage(){

    }
}
