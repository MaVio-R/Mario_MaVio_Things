package Model;

import static Model.LuggageStatus.*;

public class Luggage {

    private int luggageCode;
    private LuggageStatus luggageStatus;

    public Luggage(int luggageCode, String LuggageStatus){
        this.luggageCode=luggageCode;
        this.luggageStatus= NOT_INCLUDED;
    }
}
