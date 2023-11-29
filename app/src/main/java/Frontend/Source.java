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
    String height;
    String weightGroup;
    String bloodPressureHigh;
    String bloodPressureLow;
    String cholesterol;
    String glucose;
    
    boolean nicotineUse;
    boolean alcoholUse;
    String physicalActivity;
    
    public Source() {
        System.out.println("Soure() Constructor called!");
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
    
    protected void setHeight(String height) {
        this.height = height;
    }
    
    protected void setWeightGroup(String weightGroup) {
        this.weightGroup = weightGroup;
    }
    
    protected void setBloodPressureHigh(String bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
    }
    
    protected void setBloodPressureLow(String bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
    }
    
    protected void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }
    
    protected void setGlucose(String glucose) {
        this.glucose = glucose;
    }
    
    protected void setNicotineUse(boolean nicotineUse) {
        this.nicotineUse = nicotineUse;
    }
    
    protected void setAlcoholUse(boolean alcoholUse) {
        this.alcoholUse = alcoholUse;
    }
    
    protected void setPhysicalActivity(String physicalActivity) {
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
    
    protected String getHeight() {
        return this.height;
    }
    
    protected String getWeightGroup() {
        return this.weightGroup;
    }
    
    protected String getBloodPressureHigh() {
        return this.bloodPressureHigh;
    }
    
    protected String getBloodPressureLow() {
        return this.bloodPressureLow;
    }
    
    protected String getCholesterol() {
        return this.cholesterol;
    }
    
    protected String getGlucose() {
        return this.glucose;
    }
    
    protected boolean getNicotineUse() {
        return this.nicotineUse;
    }
    
    protected boolean getAlcoholUse() {
        return this.alcoholUse;
    }
    
    protected String getPhysicalActivity() {
        return this.physicalActivity;
    }
        
}
