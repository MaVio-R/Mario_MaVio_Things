package Model;

/**
 * The {@code Airport} class represents an airport with its associated details
 * such as codes, location, and name.
 */
public class Airport {
    /**
     * The unique IATA (International Air Transport Association) code for the airport.
     */
    private String IATA_Code;

    /**
     * The unique IACA (International Civil Aviation Organization) code for the airport.
     */
    private String IACA_Code;

    /**
     * The city where the airport is located.
     */
    private String city;

    /**
     * The nation or country in which the airport is located.
     */
    private String nation;

    /**
     * The full name of the airport.
     */
    private String airportName;

    /**
     * Constructs an {@code Airport} instance with specified airport codes, location, and name.
     *
     * @param IATA_Code   the IATA code of the airport
     * @param IACA_Code   the IACA code of the airport
     * @param city        the city where the airport is located
     * @param nation      the nation or country of the airport
     * @param airportName the full name of the airport
     */
    public Airport(String IATA_Code, String IACA_Code, String city, String nation, String airportName) {
        this.IATA_Code = IATA_Code;
        this.IACA_Code = IACA_Code;
        this.city = city;
        this.nation = nation;
        this.airportName = airportName;
    }

    /**
     * Gets the full name of the airport.
     *
     * @return the name of the airport
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * Gets the IATA code for the airport.
     *
     * @return the IATA code of the airport
     */
    public String getIATA_Code() {
        return IATA_Code;
    }

    /**
     * Gets the IACA code for the airport.
     *
     * @return the IACA code of the airport
     */
    public String getIACA_Code() {
        return IACA_Code;
    }

    /**
     * Gets the city where the airport is located.
     *
     * @return the city of the airport
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the nation or country of the airport.
     *
     * @return the nation of the airport
     */
    public String getNation() {
        return nation;
    }

    /**
     * Returns a string representation of the airport, including its codes, location, and name.
     *
     * @return a string describing the airport
     */
    @Override
    public String toString() {
        return "Airport{" +
                "IATA_Code='" + IATA_Code + '\'' +
                ", IACA_Code='" + IACA_Code + '\'' +
                ", city='" + city + '\'' +
                ", nation='" + nation + '\'' +
                ", airportName='" + airportName + '\'' +
                '}';
    }
}
