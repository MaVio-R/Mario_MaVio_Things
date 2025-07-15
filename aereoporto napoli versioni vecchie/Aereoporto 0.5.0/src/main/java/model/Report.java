package model;

public class Report {
    
    private int reportId;
    
    private int reportCode;
    private String reportDescription;
    private String reportTime;
    
    public Report(int reportId, int reportCode, String reportDescription, String reportTime) {
        this.reportId = reportId;
        this.reportCode = reportCode;
        this.reportDescription = reportDescription;
        this.reportTime = reportTime;
    }
    
    public int getReportId() {
        return this.reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
    
    public int getReportCode() {
        return this.reportCode;
    }

    public void setReportCode(int reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportDescription() {
        return this.reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportTime() {
        return this.reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

}
