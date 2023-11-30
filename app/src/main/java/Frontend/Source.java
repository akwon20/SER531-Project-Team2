/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Frontend;

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
