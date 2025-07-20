package Model;

public class Airport {
    private String IATA_code;
    private String IACA_code;
    private String city;
    private String nation;
    private String name;

    public Airport(String IATA_code, String IACA_code, String city, String nation, String name) {
        this.IATA_code = IATA_code;
        this.IACA_code = IACA_code;
        this.city = city;
        this.nation = nation;
        this.name = name;
    }

    public String getIATA_code() {
        return IATA_code;
    }

    public void setIATA_code(String IATA_code) {
        this.IATA_code = IATA_code;
    }

    public String getIACA_code() {
        return IACA_code;
    }

    public void setIACA_code(String IACA_code) {
        this.IACA_code = IACA_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
