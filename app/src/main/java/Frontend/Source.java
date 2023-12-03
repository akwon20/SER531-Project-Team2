/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Frontend;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import Backend.DatabaseConn;
import com.stardog.stark.Literal;
import com.stardog.stark.Value;
import com.stardog.stark.query.BindingSet;
import com.stardog.stark.query.SelectQueryResult;
import com.stardog.stark.query.io.QueryResultWriters;

/**
 *
 * @author austinkwon
 */
public class Source {

    private enum inputTraits{AGE, GENDER, PREG_STAT, H, W, BP_H, BP_L, CHOL, GLUC, NIC_USE, ALC_USE, PHY_ACT}
    private enum inputDiseases{COVID, CVD, AD}

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

    List<inputTraits> receivedTraits = new ArrayList<>();
    List<inputTraits> receivedDiseases = new ArrayList<>();


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
        physicalActivity = -1;
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
        receivedTraits.add(inputTraits.AGE);
    }
    
    protected void setGender(String gender) {
        this.gender = gender;
        receivedTraits.add(inputTraits.GENDER);
    }
    
    protected void setPregnantStatus(boolean pregnantStatus) {
        this.pregnantStatus = pregnantStatus;
        receivedTraits.add(inputTraits.PREG_STAT);
    }
    
    protected void setHeight(int height) {
        this.height = height;
        receivedTraits.add(inputTraits.H);
    }
    
    protected void setWeightGroup(String weightGroup) {
        this.weightGroup = weightGroup;
        receivedTraits.add(inputTraits.W);
    }
    
    protected void setBloodPressureHigh(int bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
        receivedTraits.add(inputTraits.BP_H);
    }
    
    protected void setBloodPressureLow(int bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
        receivedTraits.add(inputTraits.BP_L);
    }
    
    protected void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
        receivedTraits.add(inputTraits.CHOL);
    }
    
    protected void setGlucose(int glucose) {
        this.glucose = glucose;
        receivedTraits.add(inputTraits.GLUC);
    }
    
    protected void setNicotineUse(boolean nicotineUse) {
        this.nicotineUse = nicotineUse;
        receivedTraits.add(inputTraits.NIC_USE);
    }
    
    protected void setAlcoholUse(boolean alcoholUse) {
        this.alcoholUse = alcoholUse;
        receivedTraits.add(inputTraits.ALC_USE);
    }
    
    protected void setPhysicalActivity(int physicalActivity) {
        this.physicalActivity = physicalActivity;
        receivedTraits.add(inputTraits.PHY_ACT);
    }
    
    protected void setSelectedCovid(boolean selectedCovid) {
        this.selectedCovid = selectedCovid;
        receivedTraits.add(inputTraits.AGE);
    }

    protected void setSelectedCardio(boolean selectedCardio) {
        this.selectedCardio = selectedCardio;
        receivedTraits.add(inputTraits.AGE);
    }

    protected void setSelectedAlzheimers(boolean selectedAlzheimers) {
        this.selectedAlzheimers = selectedAlzheimers;
        receivedTraits.add(inputTraits.AGE);
    }

    protected void setRiskDetails(String riskDetails) {
        this.riskDetails = riskDetails;
        receivedTraits.add(inputTraits.AGE);
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
            median = (double)(maxVal + minVal) / 2;
        }

        System.out.println("Median: " + median);

        return median;
    }

    protected String calculateCovidRisk() {
        String riskCovidOutput;
        this.riskCovid = 23.1;

        //start with generate string with if-else condition
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

        SelectQueryResult result = this.dbconn.executeQuery(queryString);


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

        SelectQueryResult result = this.dbconn.executeQuery(queryString);


        riskCardioOutput = Double.toString(this.riskCardio) + "%";
        
        return riskCardioOutput;
    }
    
    protected String calculateAlzheimersRisk() {
        Map<String, String> mapAgeField = new HashMap<>();
        mapAgeField.put("50 - 64", "50-64_years");
        String riskAlzheimerOutput;
        double result = 0.0;
        this.riskAlzheimers = 52.3;

        System.out.println("calculating Alzheimers Risk ... ");
        Map<String, String> factors = new HashMap<>();
        if (!Objects.equals(getAgeGroup(), "")) {
            System.out.println("Setting age group in map");

            factors.put("healthcare:ageGroup", "\"" + mapAgeField.get(getAgeGroup()) + "\"");
        }
        if (!Objects.equals(getGender(), "")) {
            if (getGender().equals("Male")) {
                factors.put("healthcare:gender", "\"1\"^^<http://www.w3.org/2001/XMLSchema#decimal>");
            } else {
                factors.put("healthcare:gender", "\"0\"^^<http://www.w3.org/2001/XMLSchema#decimal>");
            }
        }

        System.out.println("Checking for obesity");
        //check for obesity
        boolean obesity = false;
        if (getHeight() != 0 && !Objects.equals(getWeightGroup(), "")) {
            // calculate bmi
            double bmi = calculateBmi(calculateGroupMedian(getWeightGroup()), getHeight());
            // person is obese if BMI is above 30
            obesity = bmi > 30.00;
        }

        //add obesity to the query if the value is true
        double averageValue;
        if (obesity) {
            factors.put("healthcare:topic", "\"obesity\"");
            // get value for obesity
            StringBuilder sb = new StringBuilder();
            sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n");
            sb.append("SELECT (AVG(?dataValue) as ?averageDataValue)\n");

            String obesityQueryAlzheimer = generateAlzheimersqueryString(factors, sb);
            try (SelectQueryResult queryResult = dbconn.executeQuery(obesityQueryAlzheimer)) {

                while (queryResult.hasNext()) {
                    BindingSet tuple = queryResult.next();
                    String medianPrct = Value.lex(Objects.requireNonNull(tuple.get("averageDataValue")));
                    System.out.println("BindingSet out" + medianPrct);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            averageValue = 0;
        }

        if (!getNicotineUse())
            factors.put("nicotine", "True");
        if (getPhysicalActivity() != -1)
            factors.put("physicalActivity", String.valueOf(getPhysicalActivity()));

        // 34% are obese and have AD

        riskAlzheimerOutput = Double.toString(this.riskAlzheimers) + "%";

        return riskAlzheimerOutput;
    }

    private double calculateBmi(double weightInPounds, int heightInCm) {

        // Convert weight from pounds to kilograms
        double weightInKg = weightInPounds / 2.20462;

        // Convert height from centimeters to meters
        double heightInMeters = heightInCm / 100.0;

        // Calculate BMI
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        System.out.println("BMI: " + bmi);
        return bmi;
    }

    private String generateAlzheimersqueryString(Map<String , String> factors , StringBuilder stringBuilder) {
        stringBuilder.append(" FROM <tag:stardog:api:context:default>\n");
        stringBuilder.append("WHERE {\n");
        stringBuilder.append(" ?survey a healthcare:Survey ;\n");
        for ( Map.Entry<String  , String> factor: factors.entrySet() ) {
            stringBuilder.append(factor.getKey()).append(" ").append(factor.getValue()).append(";\n");
        }
        stringBuilder.append(" healthcare:dataValue ?dataValue .\n");
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
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
