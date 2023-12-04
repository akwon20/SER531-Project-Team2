/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Frontend;

import Backend.DatabaseConn;
import Backend.Tuple;
import com.stardog.stark.Value;
import com.stardog.stark.query.BindingSet;
import com.stardog.stark.query.SelectQueryResult;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author austinkwon
 */
public class Source {

    private enum inputTraits {AGE, GENDER, PREG_STAT, H, W, BP_H, BP_L, CHOL, GLUC, NIC_USE, ALC_USE, PHY_ACT}

    private enum inputDiseases {COVID, CVD, AD}

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

    public String getTopRiskAlzheimers() {
        return topRiskAlzheimers;
    }

    public void setTopRiskAlzheimers(String topRiskAlzheimers) {
        this.topRiskAlzheimers = topRiskAlzheimers;
    }

    String topRiskAlzheimers;

    public String getTopRiskCovid() {
        return topRiskCovid;
    }

    public void setTopRiskCovid(String topRiskCovid) {
        this.topRiskCovid = topRiskCovid;
    }

    public String getTopRiskCardiovascular() {
        return topRiskCardiovascular;
    }

    public void setTopRiskCardiovascular(String topRiskCardiovascular) {
        this.topRiskCardiovascular = topRiskCardiovascular;
    }

    String topRiskCovid;
    String topRiskCardiovascular;

    List<inputTraits> receivedTraits = new ArrayList<>();
    List<inputDiseases> receivedDiseases = new ArrayList<>();


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
        receivedDiseases.add(inputDiseases.COVID);
    }

    protected void setSelectedCardio(boolean selectedCardio) {
        this.selectedCardio = selectedCardio;
        receivedDiseases.add(inputDiseases.CVD);
    }

    protected void setSelectedAlzheimers(boolean selectedAlzheimers) {
        this.selectedAlzheimers = selectedAlzheimers;
        receivedDiseases.add(inputDiseases.AD);
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
                } else {
                    maxVal = value;
                }
            } else {
                scanner.next();
            }
        }

        scanner.close();

        System.out.println("Min val: " + minVal);
        System.out.println("Max val: " + maxVal);

        if (maxVal <= 0) {
            median = minVal;
        } else {
            median = (double) (maxVal + minVal) / 2;
        }

        System.out.println("Median: " + median);

        return median;
    }

    protected String calculateCovidRisk() {
        String riskCovidOutput;
        this.riskCovid = 23.1;
        List<Tuple<String, Double>> frequency = new ArrayList<>();
        int agePosition = 1;
        int obesityPosition = 1;
        int pregnancyPosition = 1;
        int genderPostion = 1;
        int nicotinePosition = 1;



        //if age is selected, get total number of patients with that age who have covid
        if (!Objects.equals(getAgeGroup(), "")) {
            // Add patient counts for different age groups to the frequency list
            frequency.add(new Tuple<>("< 5", getTotalPatientsWithGivenAge("< 5")));
            frequency.add(new Tuple<>("5 - 19", getTotalPatientsWithGivenAge("5 - 19")));
            frequency.add(new Tuple<>("20 - 34", getTotalPatientsWithGivenAge("20 - 34")));
            frequency.add(new Tuple<>("35 - 49", getTotalPatientsWithGivenAge("35 - 49")));
            frequency.add(new Tuple<>("50 - 64", getTotalPatientsWithGivenAge("50 - 64")));
            frequency.add(new Tuple<>("65 <", getTotalPatientsWithGivenAge("65 <")));

            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of ageGroup in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getAgeGroup())) {
                    agePosition = i;
                    break;
                }
            }

            this.riskCovid = agePosition;
        }

        //if gender is selected , calculate rank and risk for the gender
        if (!Objects.equals(getGender(), "")) {

            //calculate male and female patients and sort them by gender
            frequency.clear();
            frequency.add(new Tuple<>("Male", getCovidPatientsByGender("2")));
            frequency.add(new Tuple<>("Female", getCovidPatientsByGender("1")));

            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of choosen gender in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getGender())) {
                    genderPostion = i;
                    break;
                }
            }

            //calculate rank of the given value
            this.riskCovid += genderPostion;
        }

        if (getPregnantStatus()) {
            //calculate patients for covid with pregnency
            frequency.clear();
            frequency.add(new Tuple<>("Male", getCovidPatientsByPregnancy("0")));
            frequency.add(new Tuple<>("Female", getCovidPatientsByPregnancy("1")));

            //calculate patients for covid without pregnency
            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of choosen pregnencyValue in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getGender())) {
                    pregnancyPosition = i;
                    break;
                }
            }
            this.riskCovid += pregnancyPosition;

        }

        System.out.println("Checking for obesity in COVID");
        //check for obesity
        boolean obesity = false;
        if (getHeight() != 0 && !Objects.equals(getWeightGroup(), "")) {
            // calculate bmi
            double bmi = calculateBmi(calculateGroupMedian(getWeightGroup()), getHeight());
            // person is obese if BMI is above 30
            obesity = bmi > 30.00;
            if(obesity){

                //get patients who are obese , and not obese and have COVID
                frequency.clear();
                frequency.add(new Tuple<>("False", getCovidPatientsByObesity("0")));
                frequency.add(new Tuple<>("True", getCovidPatientsByObesity("1")));

                //calculate patients for covid with obesity
                // Sort the frequency list by patient count in ascending order
                frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

                // Find the position of obesity in the sorted list
                for (int i = 0; i < frequency.size(); i++) {
                    if (frequency.get(i).getFirst().equals(getGender())) {
                        nicotinePosition = i;
                        break;
                    }
                }
                this.riskCovid += nicotinePosition;
            }
        }

        if(getNicotineUse()){

            //get patients who smoke and have COVID
            frequency.clear();
            frequency.add(new Tuple<>("False", getCovidPatientsWhoSmoke("0")));
            frequency.add(new Tuple<>("True", getCovidPatientsByObesity("1")));

            //calculate patients for covid with obesity
            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of obesity in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getGender())) {
                    obesityPosition = i;
                    break;
                }
            }
            this.riskCovid += obesityPosition;
        }

        //Calculating the top risk factor
        double maxValue = Double.MIN_VALUE;
        if (obesityPosition > maxValue) {
            maxValue = obesityPosition;
            setTopRiskCovid("Obesity");
        }
        if (agePosition > maxValue) {
            maxValue = agePosition;
            setTopRiskCovid("Age");
        }
        if (genderPostion > maxValue) {
            maxValue = genderPostion;
            setTopRiskCovid("Gender");
        }
        if (pregnancyPosition > maxValue){
            maxValue = pregnancyPosition;
            setTopRiskCovid("Pregnency");
        }
        if (nicotinePosition > maxValue){
            maxValue = nicotinePosition;
            setTopRiskCovid("Nicotine");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        riskCovidOutput = decimalFormat.format((this.riskCovid/14) * 100) + "%";
        return riskCovidOutput;
    }

    private Double getCovidPatientsWhoSmoke(String number) {

        System.out.println("Calculating Covid patients by smoking :" + number);
        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                "\n" +
                "SELECT (COUNT(?patient) AS ?patientCount)\n" +
                "FROM <tag:stardog:api:context:default>\n" +
                "WHERE {\n" +
                "    ?patient a healthcare:Patients ;\n" +
                "            healthcare:hasCovid ?Covid ;");
        //append 0 or 1 according to 0 or 1
        sb.append("             healthcare:smokes \"").append(number).append("\"  .");
        sb.append("    ?Covid a healthcare:COVID19 .\n" +
                "    FILTER (STR(?Covid) = \"http://www.semanticweb.org/healthcare#1\")\n" +
                "}");


        System.out.println(sb);
        double totalPatientsWhoSmoke = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWhoSmoke = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                System.out.println("Total number of patients :" + totalPatientsWhoSmoke);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWhoSmoke;

    }

    private Double getCovidPatientsByObesity(String number) {

        System.out.println("Calculating Covid patients by Obesity" + number);
        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                "\n" +
                "SELECT (COUNT(?patient) AS ?patientCount)\n" +
                "FROM <tag:stardog:api:context:default>\n" +
                "WHERE {\n" +
                "    ?patient a healthcare:Patients ;\n" +
                "            healthcare:hasCovid ?Covid ;");
        //append 1 or 2 according to male or female
        sb.append("            healthcare:hasObesity ?Obesity.\n");
        sb.append("    ?Covid a healthcare:COVID19 .\n" + "FILTER (STR(?Obesity) = \"http://www.semanticweb.org/healthcare#")
                .append(number)
                .append("\") \n")
                .append("    FILTER (STR(?Covid) = \"http://www.semanticweb.org/healthcare#1\")\n").append("}");


        System.out.println(sb);
        double totalCovidPatientsWithObesity = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalCovidPatientsWithObesity = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                System.out.println("Total number of patients :" + totalCovidPatientsWithObesity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCovidPatientsWithObesity;

    }

    private Double getCovidPatientsByPregnancy(String number) {

        System.out.println("Calculating Covid patients by Pregnancy" + number);
        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                "\n" +
                "SELECT (COUNT(?patient) AS ?patientCount)\n" +
                "FROM <tag:stardog:api:context:default>\n" +
                "WHERE {\n" +
                "    ?patient a healthcare:Patients ;\n" +
                "            healthcare:hasCovid ?Covid ;");
        //append 1 or 2 according to male or female
        sb.append("             healthcare:isPregnant \"").append(number).append("\"  .");
        sb.append("    ?Covid a healthcare:COVID19 .\n" +
                "    FILTER (STR(?Covid) = \"http://www.semanticweb.org/healthcare#1\")\n" +
                "}");


        System.out.println(sb);
        double totalPatientsWithPregnancy = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWithPregnancy = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                System.out.println("Total number of patients :" + totalPatientsWithPregnancy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWithPregnancy;

    }

    private double getCovidPatientsByGender(String number) {

        System.out.println("Calculating Covid patients by Gender" + number);
        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                "\n" +
                "SELECT (COUNT(?patient) AS ?patientCount)\n" +
                "FROM <tag:stardog:api:context:default>\n" +
                "WHERE {\n" +
                "    ?patient a healthcare:Patients ;\n" +
                "            healthcare:hasCovid ?Covid ;");
        //append 1 or 2 according to male or female
        sb.append("             healthcare:hasGender \"").append(number).append("\"  .");
        sb.append("    ?Covid a healthcare:COVID19 .\n" +
                "    FILTER (STR(?Covid) = \"http://www.semanticweb.org/healthcare#1\")\n" +
                "}");


        System.out.println(sb.toString());
        double totalPatientsWithGender = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWithGender = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                System.out.println("Total number of patients :" + totalPatientsWithGender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWithGender;
    }

    private double getTotalPatientsWithGivenAge(String ageGroup) {

        System.out.print("Calculating total number of patients with a given age" + ageGroup);

        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                "\n" +
                "SELECT (COUNT(?patient) AS ?patientCount)\n" +
                "FROM <tag:stardog:api:context:default>\n" +
                "WHERE {\n" +
                "    ?patient a healthcare:Patients ;\n" +
                "            healthcare:hasCovid ?Covid .\n" +
                "    ?Covid a healthcare:COVID19 .");

        switch (ageGroup) {
            case ("< 5"):
                System.out.println("Selected < 5 for Covid ");
                sb.append("  ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n "
                        + " FILTER(STR(?age) < \"5\") .");
                break;
            case ("5 - 19"):
                System.out.println("5 - 19");
                sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age  . \n"
                        + "    FILTER(STR(?age) >= \"5\" && STR(?age) <= \"19\") . \n");
                break;
            case ("20 - 34"):
                System.out.println("20 - 34");
                sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                        + "    FILTER(STR(?age) >= \"20\" && STR(?age) <= \"34\") . \n");
                break;
            case ("35 - 49"):
                System.out.println("35 - 49");
                sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                        + "    FILTER(STR(?age) >= \"35\" && STR(?age) <= \"49\") . \n");
                break;
            case ("50 - 64"):
                System.out.println("50 - 64");
                sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                        + "    FILTER(STR(?age) >= \"50\" && STR(?age) <= \"64\") . \n");
                break;
            case ("65 <"):
                System.out.println("65 <");
                sb.append("   ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                        + "    FILTER(STR(?age) >= \"65\") . \n");
                break;
            default:
                System.out.println("Age Group not selected!");
        }
        sb.append("   FILTER (STR(?Covid) = \"http://www.semanticweb.org/healthcare#1\")");
        sb.append("}");

        System.out.println(sb.toString());
        double totalPatientsWithAge = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWithAge = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                System.out.println("Total number of patients :" + totalPatientsWithAge);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWithAge;

    }

    private Double getTotalPatientsinCovid() {
        String query = "PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                "\n" +
                "SELECT (COUNT(?patient) AS ?patientCount)\n" +
                "FROM <tag:stardog:api:context:default>\n" +
                "WHERE {\n" +
                "    ?patient a healthcare:Patients ;\n" +
                "            healthcare:hasCovid ?Covid .\n" +
                "    ?Covid a healthcare:COVID19 .\n" +
                "    FILTER (STR(?Covid) = \"http://www.semanticweb.org/healthcare#1\")\n" +
                "}";
        double patientCount = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(query)) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                patientCount = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                System.out.println("Total number of patients :" + patientCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientCount;
    }

    private String generateCovidqueryString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT ?subject_0 \n"
                + "FROM <tag:stardog:api:context:default> \n");
        sb.append("WHERE { \n" +
                "  { \n" +
                "    ?subject_0 a <http://www.semanticweb.org/healthcare#Patients> . \n");

        System.out.print("Age Group: ");
        switch (getAgeGroup()) {
            case ("< 5"):
                System.out.println("< 5");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 \n. "
                        + "    FILTER(STR(?dat_0) < \"5\") . \n");
                break;
            case ("5 - 19"):
                System.out.println("5 - 19");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . \n"
                        + "    FILTER(STR(?dat_0) >= \"5\" && STR(?dat_0) <= \"19\") . \n");
                break;
            case ("20 - 34"):
                System.out.println("20 - 34");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . \n"
                        + "    FILTER(STR(?dat_0) >= \"20\" && STR(?dat_0) <= \"34\") . \n");
                break;
            case ("35 - 49"):
                System.out.println("35 - 49");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . \n"
                        + "    FILTER(STR(?dat_0) >= \"35\" && STR(?dat_0) <= \"49\") . \n");
                break;
            case ("50 - 64"):
                System.out.println("50 - 64");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . \n"
                        + "    FILTER(STR(?dat_0) >= \"50\" && STR(?dat_0) <= \"64\") . \n");
                break;
            case ("65 <"):
                System.out.println("65 <");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . \n"
                        + "    FILTER(STR(?dat_0) >= \"65\") . \n");
                break;
            default:
                System.out.println("Age Group not selected!");
        }

        System.out.print("Age Group: ");
        switch (getGender()) {
            case ("Male"):
                System.out.println("Male");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasGender> \"1\" \n. ");
                break;
            case ("Female"):
                System.out.println("Female");
                sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#hasGender> \"2\" . \n");
                break;
            default:
                System.out.println("Gender not selected!");
        }

        // FIXME: Pregnant still = true even after deselected (where singleton comes in?)
        System.out.println("Pregnancy: ");
        if (getPregnantStatus()) {
            System.out.println("Pregnant");
            sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#isPregnant> \"97\" \n. ");
        } else {
            System.out.println("Not Pregnant");
            sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#isPregnant> \"0\" \n. ");
        }

        System.out.println("Smoking: ");
        if (getNicotineUse()) {
            System.out.println("Smokes");
            sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#smokes> \"1\" \n. ");
        } else {
            System.out.println("Does not smoke");
            sb.append("    ?subject_0 <http://www.semanticweb.org/healthcare#smokes> \"0\" \n. ");
        }

        sb.append("  } \n" + "}\n");

        return sb.toString();
    }

    private Double getCVDPatientsWhoSmoke(String number) {

        System.out.println("Calculating CVD patients by smoking :" + number);
        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                  "\n" +
                  "SELECT (COUNT(?patient) AS ?CVDCount)\n" +
                  "FROM <tag:stardog:api:context:default>\n" +
                  "WHERE {\n" +
                  "    ?patient a healthcare:Patients ;\n" +
                  "            healthcare:hasCardiovascular ?cardio ;");
        //append 0 or 1 according to 0 or 1
        sb.append("             healthcare:smokes \"").append(number).append("\"  .");
        sb.append("    ?cardio a healthcare:Cardiovascular .\n" +
                  "    FILTER (STR(?cardio) = \"http://www.semanticweb.org/healthcare#1\")\n" +
                  "}");


        System.out.println(sb);
        double totalPatientsWhoSmoke = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWhoSmoke = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("CVDCount"))));
                System.out.println("Total number of patients :" + totalPatientsWhoSmoke);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWhoSmoke;

    }

    private double getCVDPatientsByObesity(String number) {

        System.out.println("Calculating Cardio patients by Gender" + number);
        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                  "\n" +
                  "SELECT (COUNT(?patient) AS ?CVDCount)\n" +
                  "FROM <tag:stardog:api:context:default>\n" +
                  "WHERE {\n" +
                  "    ?patient a healthcare:Patients ;\n" +
                  "            healthcare:hasCardiovascular ?cardio ;");
        //append 1 or 2 according to male or female
        sb.append("             healthcare:hasGender \"").append(number).append("\"  .");
        sb.append("    ?cardio a healthcare:Cardiovascular .\n" +
                  "    FILTER (STR(?cardio) = \"http://www.semanticweb.org/healthcare#1\")\n" +
                  "}");


        System.out.println(sb.toString());
        double totalPatientsWithGender = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWithGender = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("CVDCount"))));
                System.out.println("Total number of patients :" + totalPatientsWithGender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWithGender;
    }

    private double getTotalCVDPatientsWithGivenAge(String ageGroup) {

        System.out.print("Calculating total number of patients with a given age:");

        StringBuilder sb = new StringBuilder();
        sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n" +
                  "\n" +
                  "SELECT (COUNT(?patient) AS ?cvdCount)\n" +
                  "FROM <tag:stardog:api:context:default>\n" +
                  "WHERE {\n" +
                  "    ?patient a healthcare:Patients ;\n" +
                  "            healthcare:hasCardiovascular ?cardio .\n" +
                  "    ?cardio a healthcare:Cardiovascular .\n");

        switch (ageGroup) {
        case ("< 5"):
            System.out.println(" < 5");
            sb.append("  ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n "
                      + " FILTER(STR(?age) < \"5\") .");
            break;
        case ("5 - 19"):
            System.out.println("5 - 19");
            sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age  . \n"
                      + "    FILTER(STR(?age) >= \"5\" && STR(?age) <= \"19\") . \n");
            break;
        case ("20 - 34"):
            System.out.println("20 - 34");
            sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                      + "    FILTER(STR(?age) >= \"20\" && STR(?age) <= \"34\") . \n");
            break;
        case ("35 - 49"):
            System.out.println("35 - 49");
            sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                      + "    FILTER(STR(?age) >= \"35\" && STR(?age) <= \"49\") . \n");
            break;
        case ("50 - 64"):
            System.out.println("50 - 64");
            sb.append("    ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                      + "    FILTER(STR(?age) >= \"50\" && STR(?age) <= \"64\") . \n");
            break;
        case ("65 <"):
            System.out.println("65 <");
            sb.append("   ?patient <http://www.semanticweb.org/healthcare#hasAge> ?age . \n"
                      + "    FILTER(STR(?age) >= \"65\") . \n");
            break;
        default:
            System.out.println("Age Group not selected!");
        }
        sb.append("   FILTER (STR(?cardio) = \"http://www.semanticweb.org/healthcare#1\")");
        sb.append("}");

        double totalPatientsWithAge = 0.0;
        try (SelectQueryResult queryResult = dbconn.executeQuery(sb.toString())) {

            while (queryResult.hasNext()) {
                BindingSet tuple = queryResult.next();
                totalPatientsWithAge = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("cvdCount"))));
                System.out.println("Total number of patients :" + totalPatientsWithAge);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPatientsWithAge;

    }


    protected String calculateCardioRisk() {
        System.out.println("Calculating CVD Risk");
        String riskCardioOutput;
        this.riskCardio = 23.1;
        List<Tuple<String, Double>> frequency = new ArrayList<>();
        int agePosition = 1;
        int obesityPosition = 1;
        int pregnancyPosition = 1;
        int genderPostion = 1;
        int nicotinePosition = 1;



        //if age is selected, get total number of patients with that age who have covid
        if (!Objects.equals(getAgeGroup(), "")) {
            // Add patient counts for different age groups to the frequency list
            frequency.add(new Tuple<>("< 5", getTotalCVDPatientsWithGivenAge("< 5")));
            frequency.add(new Tuple<>("5 - 19", getTotalCVDPatientsWithGivenAge("5 - 19")));
            frequency.add(new Tuple<>("20 - 34", getTotalCVDPatientsWithGivenAge("20 - 34")));
            frequency.add(new Tuple<>("35 - 49", getTotalCVDPatientsWithGivenAge("35 - 49")));
            frequency.add(new Tuple<>("50 - 64", getTotalCVDPatientsWithGivenAge("50 - 64")));
            frequency.add(new Tuple<>("65 <", getTotalCVDPatientsWithGivenAge("65 <")));

            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of ageGroup in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getAgeGroup())) {
                    agePosition = i;
                    break;
                }
            }

            this.riskCardio = agePosition;
        }

        //if gender is selected , calculate rank and risk for the gender
        if (!Objects.equals(getGender(), "")) {

            //calculate male and female patients and sort them by gender
            frequency.clear();
            frequency.add(new Tuple<>("Male", getCovidPatientsByGender("2")));
            frequency.add(new Tuple<>("Female", getCovidPatientsByGender("1")));

            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of choosen gender in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getGender())) {
                    genderPostion = i;
                    break;
                }
            }

            //calculate rank of the given value
            this.riskCardio += genderPostion;
        }

        if (getPregnantStatus()) {
            //calculate patients for covid with pregnency
            frequency.clear();
            frequency.add(new Tuple<>("Male", getCovidPatientsByPregnancy("0")));
            frequency.add(new Tuple<>("Female", getCovidPatientsByPregnancy("1")));

            //calculate patients for covid without pregnency
            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of choosen pregnencyValue in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getGender())) {
                    pregnancyPosition = i;
                    break;
                }
            }
            this.riskCardio += pregnancyPosition;

        }

        System.out.println("Checking for obesity in CVD");
        //check for obesity
        boolean obesity = false;
        if (getHeight() != 0 && !Objects.equals(getWeightGroup(), "")) {
            // calculate bmi
            double bmi = calculateBmi(calculateGroupMedian(getWeightGroup()), getHeight());
            // person is obese if BMI is above 30
            obesity = bmi > 30.00;
            if(obesity){

                //get patients who are obese , and not obese and have COVID
                frequency.clear();
                frequency.add(new Tuple<>("False", getCVDPatientsByObesity("0")));
                frequency.add(new Tuple<>("True", getCVDPatientsByObesity("1")));

                //calculate patients for covid with obesity
                // Sort the frequency list by patient count in ascending order
                frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

                // Find the position of obesity in the sorted list
                for (int i = 0; i < frequency.size(); i++) {
                    if (frequency.get(i).getFirst().equals(getGender())) {
                        nicotinePosition = i;
                        break;
                    }
                }
                this.riskCardio += nicotinePosition;
            }
        }

        if(getNicotineUse()){

            //get patients who smoke and have COVID
            frequency.clear();
            frequency.add(new Tuple<>("False", getCVDPatientsWhoSmoke("0")));
            frequency.add(new Tuple<>("True", getCVDPatientsWhoSmoke("1")));

            //calculate patients for covid with obesity
            // Sort the frequency list by patient count in ascending order
            frequency.sort(Comparator.comparingDouble(Tuple::getSecond));

            // Find the position of obesity in the sorted list
            for (int i = 0; i < frequency.size(); i++) {
                if (frequency.get(i).getFirst().equals(getGender())) {
                    obesityPosition = i;
                    break;
                }
            }
            this.riskCardio += obesityPosition;
        }

        //Calculating the top risk factor
        double maxValue = Double.MIN_VALUE;
        if (obesityPosition > maxValue) {
            maxValue = obesityPosition;
            setTopRiskCardiovascular("Obesity");
        }
        if (agePosition > maxValue) {
            maxValue = agePosition;
            setTopRiskCardiovascular("Age");
        }
        if (genderPostion > maxValue) {
            maxValue = genderPostion;
            setTopRiskCardiovascular("Gender");
        }
        if (pregnancyPosition > maxValue){
            maxValue = pregnancyPosition;
            setTopRiskCardiovascular("Pregnency");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        riskCardioOutput = decimalFormat.format((this.riskCardio/14) * 100) + "%";
        return riskCardioOutput;
    }

    protected String calculateAlzheimersRisk() {
        Map<String, String> mapAgeField = new HashMap<>();
        mapAgeField.put("50 - 64", "50-64 years");
        mapAgeField.put("5 - 19" , "5-19 years");
        mapAgeField.put("20 - 34" , "20-34 years");
        mapAgeField.put("35 - 49" , "35-49 years");
        String riskAlzheimerOutput;
        this.riskAlzheimers = 52.3;

        System.out.println("calculating Alzheimers Risk ... ");
        Map<String, String> factors = new HashMap<>();
        if (!Objects.equals(getAgeGroup(), "")) {
            System.out.println("Setting age group in map");

            factors.put("healthcare:ageGroup", "\"" + mapAgeField.get(getAgeGroup()) + "\"");
        }
        if (!Objects.equals(getGender(), "")) {
            if (getGender().equals("Male")) {
                factors.put("healthcare:gender", "\"Male\"");
            } else {
                factors.put("healthcare:gender", "\"Female\"");
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
        double obesityRisk = 1.0;
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
                    obesityRisk = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                    System.out.println("obesity avg Value percentage:" + obesityRisk);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                factors.remove("healthcare:topic");
            }

        }

        //set avg for nicotine as 0 by default
        double nicotineRisk = 1.0;
        if (getNicotineUse()) {
            factors.put("healthcare:topic", "\"smoking\"");
            // get value for nicotine
            StringBuilder sb = new StringBuilder();
            sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n");
            sb.append("SELECT (AVG(?dataValue) as ?averageDataValue)\n");

            String obesityQueryAlzheimer = generateAlzheimersqueryString(factors, sb);
            try (SelectQueryResult queryResult = dbconn.executeQuery(obesityQueryAlzheimer)) {

                while (queryResult.hasNext()) {
                    BindingSet tuple = queryResult.next();
                    nicotineRisk = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                    System.out.println("nicotine avg Value percentage:" + nicotineRisk);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                factors.remove("healthcare:topic");
            }

        }

        double noPhysicalActivityRisk = 1.0;
        if (getPhysicalActivity() < 1) {
            factors.put("healthcare:topic", "\"no physical activity\"");
            //get noPhysicalActivityRisk
            StringBuilder sb = new StringBuilder();
            sb.append("PREFIX healthcare: <http://www.semanticweb.org/healthcare#>\n");
            sb.append("SELECT (AVG(?dataValue) as ?averageDataValue)\n");

            String obesityQueryAlzheimer = generateAlzheimersqueryString(factors, sb);
            try (SelectQueryResult queryResult = dbconn.executeQuery(obesityQueryAlzheimer)) {

                while (queryResult.hasNext()) {
                    BindingSet tuple = queryResult.next();
                    noPhysicalActivityRisk = Double.parseDouble(Value.lex(Objects.requireNonNull(tuple.get("averageDataValue"))));
                    System.out.println("no physical activity avg Value percentage:" + noPhysicalActivityRisk);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                factors.remove("healthcare:topic");
            }
        }

        // 34% are obese and have AD
        this.riskAlzheimers = obesityRisk + nicotineRisk + noPhysicalActivityRisk / 3;

        //Calculating the top risk factor
        double maxValue = Double.MIN_VALUE;
        if (obesityRisk > maxValue) {
            maxValue = obesityRisk;
            setTopRiskAlzheimers("Obesity");
        }
        if (nicotineRisk > maxValue) {
            maxValue = nicotineRisk;
            setTopRiskAlzheimers("Nicotine");
        }
        if (noPhysicalActivityRisk > maxValue) {
            maxValue = noPhysicalActivityRisk;
            setTopRiskAlzheimers("No Physical Activity");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        riskAlzheimerOutput = decimalFormat.format(this.riskAlzheimers) + "%";

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

    private String generateAlzheimersqueryString(Map<String, String> factors, StringBuilder stringBuilder) {
        stringBuilder.append(" FROM <tag:stardog:api:context:default>\n");
        stringBuilder.append("WHERE {\n");
        stringBuilder.append(" ?survey a healthcare:Survey ;\n");
        for (Map.Entry<String, String> factor : factors.entrySet()) {
            stringBuilder.append(factor.getKey()).append(" ").append(factor.getValue()).append(";\n");
        }
        stringBuilder.append(" healthcare:dataValue ?dataValue .\n");
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    protected String getTopRiskFactorCovid() {
        return getTopRiskCovid();
    }

    protected String getTopRiskFactorCardio() {

        return topRiskCardiovascular;
    }

    protected String getTopRiskFactorAlzheimers() {
        return getTopRiskAlzheimers();
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
