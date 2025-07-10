package model;

public class Luggage {
   
    private int luggageId;
    private int reportId;
    
    private int luggageNumber;
    private LuggageStatus luggageStatus;
    
    public Luggage(int luggageId, int luggageNumber, LuggageStatus luggageStatus) {
    this.luggageId = luggageId;
    this.luggageNumber = luggageNumber;
    this.luggageStatus = luggageStatus;
    }

    public int getLuggageId() {
        return this.luggageId;
    }

    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    public int getReportId() {
        return this.reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getLuggageNumber() {
        return this.luggageNumber;
    }

    public void setLuggageNumber(int luggageNumber) {
        this.luggageNumber = luggageNumber;
    }

    public LuggageStatus getLuggageStatus() {
        return this.luggageStatus;
    }

    public void setLuggageStatus(LuggageStatus luggageStatus) {
        this.luggageStatus = luggageStatus;
    }
    
}
