/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Frontend;

import java.util.Scanner;

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
    boolean selectedCovid;
    boolean selectedCardio;
    boolean selectedAlzheimers;

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
        selectedCovid = false;
        selectedCardio = false;
        selectedAlzheimers = false;

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
    
    protected void setSelectedCovid(boolean selectedCovid) {
        this.selectedCovid = selectedCovid;
    }

    protected void setSelectedCardio(boolean selectedCardio) {
        this.selectedCardio = selectedCardio;
    }

    protected void setSelectedAlzheimers(boolean selectedAlzheimers) {
        this.selectedAlzheimers = selectedAlzheimers;
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
    
    protected boolean getSelectedCovid() {
        return this.selectedCovid;
    }

    protected boolean getSelectedCardio() {
        return this.selectedCardio;
    }

    protected boolean getSelectedAlzheimers() {
        return this.selectedAlzheimers;
    }

    protected String getRiskDetails() {
        return this.riskDetails;
    }
    
    protected double calculateGroupMedian(String groupInput) {
        int minVal = 0;
        int maxVal = 0;

        double median = 0.0;

        Scanner scanner = new Scanner(groupInput);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                System.out.println("Value: " + value);
                if (minVal <= 0) {
                    minVal = value;
                }
                else {
                    maxVal = value;
                }
            }
            else {
                scanner.next();
            }
        }

        scanner.close();

        System.out.println("Min val: " + minVal);
        System.out.println("Max val: " + maxVal);

        if (maxVal <= 0) {
            median = minVal;
        }
        else {
            median = (double)(maxVal - minVal) / 2;
        }

        System.out.println("Median: " + median);

        return median;
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
        double result = 0.0;
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

        result = calculateGroupMedian(getAgeGroup());
//        this.riskAlzheimers = 52.3;
        this.riskAlzheimers = result;

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
