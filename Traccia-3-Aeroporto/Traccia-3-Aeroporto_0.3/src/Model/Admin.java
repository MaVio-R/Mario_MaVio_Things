package Model;

public class Admin extends User {

    private String opCode;

    public Admin(String username, String password, String opCode) {
        super(username, password);
        this.opCode = opCode;
    }
    
    public void insertFlight() {
        System.out.println("Metodo per inserire un nuovo volo.");
    }

    public String getOpCode() {
        return opCode;
    }

    public void viewAllFlights() {
        System.out.println("Metodo per visualizzare tutti i voli disponibili.");
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public void updateFlight() {
        System.out.println("Metodo per aggiornare un volo esistente.");
    }

    public void deleteFlight() {
        System.out.println("Metodo per eliminare un volo.");
    }

    public void viewLost() {
        System.out.println("Metodo per visualizzare i bagagli smarriti.");
    }

    public void updateLostLuggage() {
        System.out.println("Metodo per aggiornare lo stato di un bagaglio smarrito.");
    }

}
