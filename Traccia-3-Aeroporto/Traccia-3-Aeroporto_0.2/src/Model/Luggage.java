package Model;

import static Model.LuggageStatus.*;

public class Luggage {

    private String luggageNumber;
    private LuggageStatus luggageStatus;

    public Luggage(String luggageNumber, LuggageStatus luggageStatus) {
        this.luggageNumber = luggageNumber;
        this.luggageStatus = luggageStatus;
    }

    public String getLuggageNumber() {
        return luggageNumber;
    }

    public void setLuggageNumber(String luggageNumber) {
        this.luggageNumber = luggageNumber;
    }

    public LuggageStatus getLuggageStatus() {
        return luggageStatus;
    }

    public void setLuggageStatus(LuggageStatus luggageStatus) {
        this.luggageStatus = luggageStatus;
    }
}
