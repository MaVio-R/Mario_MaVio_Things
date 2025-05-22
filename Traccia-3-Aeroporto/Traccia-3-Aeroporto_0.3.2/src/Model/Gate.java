package Model;

public class Gate {
    private String gateNumber;
    private String terminal;

    public Gate(String gateNumber, String terminal) {
        this.gateNumber = gateNumber;
        this.terminal = terminal;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
