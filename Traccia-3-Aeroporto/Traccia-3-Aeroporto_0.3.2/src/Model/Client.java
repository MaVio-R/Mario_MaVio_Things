package Model;

public class Client extends User {
    private String name;
    private String surname;
    private String DOB; // Date of Birth
    private String SSN; // Social Security Number
    private String email;
    private String phoneNumber;

    public Client(String username, String password, String name, String surname, String DOB, String SSN, String email, String phoneNumber) {
        super(username, password);
        this.name = name;
        this.surname = surname;
        this.DOB = DOB;
        this.SSN = SSN;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void newBooking() {
        System.out.println("Metodo per creare una nuova prenotazione.");
    }

    public void deleteBooking() {
        System.out.println("Metodo per eliminare una prenotazione.");
    }

    public void updateBooking() {
        System.out.println("Metodo per aggiornare una prenotazione.");
    }

    public void viewBooked() {
        System.out.println("Metodo per visualizzare le prenotazioni.");
    }

    public void reportLostLuggage() {
        System.out.println("Metodo per segnalare un bagaglio smarrito.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
