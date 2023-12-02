/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Frontend;

import Backend.DatabaseConn;

/**
 *
 * @author austinkwon
 */
public class Source {
    
    String ageGroup;
    String gender;
    boolean pregnantStatus;
    int height;
    String weightGroup;
    int bloodPressureHigh;
    int bloodPressureLow;
    int cholesterol;
    int glucose;
    boolean nicotineUse;
    boolean alcoholUse;
    int physicalActivity;
    
    double riskCovid;
    double riskCardio;
    double riskAlzheimers;
    String riskDetails;

    DatabaseConn dbconn;
        
    public Source() {
        System.out.println("Soure() Constructor called!");
        
        ageGroup = "";
        gender = "";
        pregnantStatus = false;
        height = 0;
        weightGroup = "";
        bloodPressureHigh = 0;
        bloodPressureLow = 0;
        cholesterol = 0;
        glucose = 0;
        nicotineUse = false;
        alcoholUse = false;
        physicalActivity = 0;
        
        riskCovid = 0;
        riskCardio = 0;
        riskAlzheimers = 0;
        
        riskDetails = "";
        this.dbconn = new DatabaseConn();
    }
    
    protected void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    
    protected void setGender(String gender) {
        this.gender = gender;
    }
    
    protected void setPregnantStatus(boolean pregnantStatus) {
        this.pregnantStatus = pregnantStatus;
    }
    
    protected void setHeight(int height) {
        this.height = height;
    }
    
    protected void setWeightGroup(String weightGroup) {
        this.weightGroup = weightGroup;
    }
    
    protected void setBloodPressureHigh(int bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
    }
    
    protected void setBloodPressureLow(int bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
    }
    
    protected void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }
    
    protected void setGlucose(int glucose) {
        this.glucose = glucose;
    }
    
    protected void setNicotineUse(boolean nicotineUse) {
        this.nicotineUse = nicotineUse;
    }
    
    protected void setAlcoholUse(boolean alcoholUse) {
        this.alcoholUse = alcoholUse;
    }
    
    protected void setPhysicalActivity(int physicalActivity) {
        this.physicalActivity = physicalActivity;
    }
    
    protected void setRiskDetails(String riskDetails) {
        this.riskDetails = riskDetails;
    }
    
    protected String getAgeGroup() {
        return this.ageGroup;
    }
    
    protected String getGender() {
        return this.gender;
    }
    
    protected boolean getPregnantStatus() {
        return this.pregnantStatus;
    }
    
    protected int getHeight() {
        return this.height;
    }
    
    protected String getWeightGroup() {
        return this.weightGroup;
    }
    
    protected int getBloodPressureHigh() {
        return this.bloodPressureHigh;
    }
    
    protected int getBloodPressureLow() {
        return this.bloodPressureLow;
    }
    
    protected int getCholesterol() {
        return this.cholesterol;
    }
    
    protected int getGlucose() {
        return this.glucose;
    }
    
    protected boolean getNicotineUse() {
        return this.nicotineUse;
    }
    
    protected boolean getAlcoholUse() {
        return this.alcoholUse;
    }
    
    protected int getPhysicalActivity() {
        return this.physicalActivity;
    }
    
    protected String getRiskDetails() {
        return this.riskDetails;
    }
    
    protected String calculateCovidRisk() {
        String riskCovidOutput;
        this.riskCovid = 23.1;

        String queryString =
                "SELECT DISTINCT ?subject_0 " +
                        "FROM <tag:stardog:api:context:default> " +
                        "WHERE { " +
                        "  { " +
                        "    ?subject_0 a <http://www.semanticweb.org/healthcare#Patients> . " +
                        "    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . " +
                        "    FILTER(STR(?dat_0) = \"55\") . " +
                        "  } " +
                        "}";

        this.dbconn.executeQuery(queryString);


        riskCovidOutput = Double.toString(this.riskCovid) + "%";
        
        return riskCovidOutput;
    }
    
    protected String calculateCardioRisk() {
        String riskCardioOutput;
        this.riskCardio = 45.3;

        String queryString =
                "SELECT DISTINCT ?subject_0 " +
                        "FROM <tag:stardog:api:context:default> " +
                        "WHERE { " +
                        "  { " +
                        "    ?subject_0 a <http://www.semanticweb.org/healthcare#Patients> . " +
                        "    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . " +
                        "    FILTER(STR(?dat_0) = \"55\") . " +
                        "  } " +
                        "}";

        this.dbconn.executeQuery(queryString);

        
        riskCardioOutput = Double.toString(this.riskCardio) + "%";
        
        return riskCardioOutput;
    }
    
    protected String calculateAlzheimersRisk() {
        String riskAlzheimersOutput;
        this.riskAlzheimers = 52.3;

        String queryString =
                "SELECT DISTINCT ?subject_0 " +
                        "FROM <tag:stardog:api:context:default> " +
                        "WHERE { " +
                        "  { " +
                        "    ?subject_0 a <http://www.semanticweb.org/healthcare#Patients> . " +
                        "    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . " +
                        "    FILTER(STR(?dat_0) = \"55\") . " +
                        "  } " +
                        "}";

        this.dbconn.executeQuery(queryString);
        
        riskAlzheimersOutput = Double.toString(this.riskAlzheimers) + "%";
        
        return riskAlzheimersOutput;
    }
    
    protected String getTopRiskFactorCovid() {
        String topRiskFactorCovid = "Nicotine Use";
        
        return topRiskFactorCovid;
    }
    
    protected String getTopRiskFactorCardio() {
        String topRiskFactorCardio = "Physical Activity";
        
        return topRiskFactorCardio;
    }
    
    protected String getTopRiskFactorAlzheimers() {
        String topRiskFactorCardio = "Age";
        
        return topRiskFactorCardio;
    }
    
    // For Debug purposes
    protected void printVariables() {
        System.out.println("Age Group: " + getAgeGroup());
        System.out.println("Gender: " + getGender());
        System.out.println("Pregnant: " + getPregnantStatus());
        System.out.println("Height: " + getHeight());
        System.out.println("Weight Group: " + getWeightGroup());
        System.out.println("Blood Pressure (High): " + getBloodPressureHigh());
        System.out.println("Blood Pressure (Low): " + getBloodPressureLow());
        System.out.println("Cholesterol: " + getCholesterol());
        System.out.println("Glucose: " + getGlucose());
        System.out.println("Nicotine Use: " + getNicotineUse());
        System.out.println("Alcohol Use: " + getAlcoholUse());
        System.out.println("Physical Activity: " + getPhysicalActivity());

    }        
}
