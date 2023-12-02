/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

/**
 *
 * @author austinkwon
 */
public class AppFrame extends javax.swing.JFrame {

    /**
     * Creates new form AppFrame
     */

    public AppFrame() {
        System.out.println("AppFrame() Constructor called!");
        initComponents();

        checkboxesLeftInfo = new javax.swing.JCheckBox[15];

        checkboxesLeftInfo[0] = jCheckBoxAge;
        checkboxesLeftInfo[1] = jCheckBoxGender;
        checkboxesLeftInfo[2] = jCheckBoxPregnant;
        checkboxesLeftInfo[3] = jCheckBoxHeight;
        checkboxesLeftInfo[4] = jCheckBoxWeight;
        checkboxesLeftInfo[5] = jCheckBoxBPHigh;
        checkboxesLeftInfo[6] = jCheckBoxBPLow;
        checkboxesLeftInfo[7] = jCheckBoxCholesterol;
        checkboxesLeftInfo[8] = jCheckBoxGlucose;
        checkboxesLeftInfo[9] = jCheckBoxNicotine;
        checkboxesLeftInfo[10] = jCheckBoxAlcohol;
        checkboxesLeftInfo[11] = jCheckBoxPhysical;
        checkboxesLeftInfo[12] = jCheckBoxCovid;
        checkboxesLeftInfo[13] = jCheckBoxCardio;
        checkboxesLeftInfo[14] = jCheckBoxAlzheimers;

        this.source = new Source();

    }

    private void jCheckBoxAllActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBoxAll.isSelected()) {
            System.out.println("All checkbox selected!");
            for (int i = 0; i < 15; i++) {
                if (!checkboxesLeftInfo[i].isSelected()) {
                    checkboxesLeftInfo[i].setSelected(true);
                }
            }
        }
        else {
            System.out.println("All checkbox deselected!");
        }
    }

    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        System.out.println("Submit button clicked!");

        for (int i = 0; i < 12; i++) {
            if (checkboxesLeftInfo[i].isSelected()) {
                System.out.println("Checkbox " + i + " selected!");
                try {
                    sendInput(i);
                } catch(NumberFormatException e) {
                    System.out.println("Error: Must take integers!");
                    displayErrorWindow("Error: Text field must take integers!");
                    return;
                }
            }
            else {
                System.out.println("Checkbox " + i + " not selected!");
            }
        }

        if (!checkOneDiseaseSelected()) {
            System.out.println("Error: At least one disease must be selected!");
            displayErrorWindow("Error: At least one disease must be selected!");
            return;
        }
        else if (!checkOneFactorSelected()) {
            System.out.println("Error: At least one risk factor must be selected!");
            displayErrorWindow("Error: At least one risk factor must be selected!");
            return;
        }

        updateOutput();

        jTabbedPane1.setSelectedIndex(1);
        source.printVariables();    // Remove once debugging is finished
    }//GEN-LAST:event_buttonSubmitActionPerformed

    private void clearInfoCheckBoxes() {
        System.out.println("clearInfoCheckBoxes() called!");

        for (int i = 0; i < 15; i++) {
            checkboxesLeftInfo[i].setSelected(false);
        }
    }

    private void sendInput(int index){
        System.out.println("Sending input from checkbox: " + index);

        switch(index) {
            case 0:
                source.setAgeGroup((String)jComboBoxAge.getSelectedItem());
                break;
            case 1:
                source.setGender((String)jComboBoxGender.getSelectedItem());
                break;
            case 2:
                source.setPregnantStatus(jCheckBoxPregnant.isSelected());
                break;
            case 3:
                source.setHeight(Integer.parseInt(jTextFieldHeight.getText()));
                break;
            case 4:
                source.setWeightGroup((String)jComboBoxWeight.getSelectedItem());
                break;
            case 5:
                source.setBloodPressureHigh(Integer.parseInt(jTextFieldBPHigh.getText()));
                break;
            case 6:
                source.setBloodPressureLow(Integer.parseInt(jTextFieldBPLow.getText()));
                break;
            case 7:
                source.setCholesterol(Integer.parseInt(jTextFieldCholesterol.getText()));
                break;
            case 8:
                source.setGlucose(Integer.parseInt(jTextFieldGlucose.getText()));
                break;
            case 9:
                source.setNicotineUse(jCheckBoxNicotine.isSelected());
                break;
            case 10:
                source.setAlcoholUse(jCheckBoxAlcohol.isSelected());
                break;
            case 11:
                source.setPhysicalActivity(Integer.parseInt(jTextFieldPhysical.getText()));
                break;
            default:
                System.out.println("No input sent!");
        }
    }

    private void updateOutput() {
        // Reset output text panes before getting results
        jTextPaneRiskCovid.setText("");
        jTextPaneFactorCovid.setText("");

        jTextPaneRiskCardio.setText("");
        jTextPaneFactorCardio.setText("");

        jTextPaneRiskAlzheimers.setText("");
        jTextPaneFactorAlzheimers.setText("");

        jTextPaneRiskDetails.setText("");

        if (checkboxesLeftInfo[12].isSelected()) {
            jTextPaneRiskCovid.setText(source.calculateCovidRisk());
            jTextPaneFactorCovid.setText(source.getTopRiskFactorCovid());
        }

        if (checkboxesLeftInfo[13].isSelected()) {
            jTextPaneRiskCardio.setText(source.calculateCardioRisk());
            jTextPaneFactorCardio.setText(source.getTopRiskFactorCardio());
        }

        if (checkboxesLeftInfo[14].isSelected()) {
            jTextPaneRiskAlzheimers.setText(source.calculateAlzheimersRisk());
            jTextPaneFactorAlzheimers.setText(source.getTopRiskFactorAlzheimers());
        }

        jTextPaneRiskDetails.setText(source.getRiskDetails());
    }

    private boolean checkOneDiseaseSelected() {
        for (int i = 12; i < 15; i++) {
            if (checkboxesLeftInfo[i].isSelected()) {
                return true;
            }
        }

        return false;
    }

    private boolean checkOneFactorSelected() {
        for (int i = 0; i < 12; i++) {
            if (checkboxesLeftInfo[i].isSelected()) {
                return true;
            }
        }

        return false;
    }

    private void displayErrorWindow(String message) {
        ErrorFrame errorFrame = new ErrorFrame(message);
        errorFrame.setVisible(true);
    }

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Clear button clicked!");

        jCheckBoxAll.setSelected(false);

        clearInfoCheckBoxes();
        clearInputCheckBoxes();
        clearInputComboBoxes();
        clearInputTextFields();
    }

    private void clearInputCheckBoxes() {
        System.out.println("clearInputCheckBoxes() called!");

        alcoholBoolCheckbox.setSelected(false);
        nicotineBoolCheckbox.setSelected(false);
        pregnantBoolCheckbox.setSelected(false);
    }

    private void clearInputComboBoxes() {
        System.out.println("clearInputComboBoxes() called!");
        jComboBoxAge.setSelectedItem("1-12");
        jComboBoxGender.setSelectedItem("Male");
        jComboBoxWeight.setSelectedItem("125 >");
    }

    private void clearInputTextFields() {
        System.out.println("clearInputTextFields() called!");

        jTextFieldBPHigh.setText("");
        jTextFieldBPLow.setText("");
        jTextFieldCholesterol.setText("");
        jTextFieldGlucose.setText("");
        jTextFieldHeight.setText("");
        jTextFieldPhysical.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jlabelPhysicalInfo = new javax.swing.JLabel();
        jlabelTrait = new javax.swing.JLabel();
        jlabelInput = new javax.swing.JLabel();
        jPanelPhysical = new javax.swing.JPanel();
        jCheckBoxAge = new javax.swing.JCheckBox();
        jCheckBoxGender = new javax.swing.JCheckBox();
        jCheckBoxPregnant = new javax.swing.JCheckBox();
        jCheckBoxHeight = new javax.swing.JCheckBox();
        jCheckBoxWeight = new javax.swing.JCheckBox();
        jCheckBoxBPHigh = new javax.swing.JCheckBox();
        jCheckBoxBPLow = new javax.swing.JCheckBox();
        jCheckBoxCholesterol = new javax.swing.JCheckBox();
        jCheckBoxGlucose = new javax.swing.JCheckBox();
        jLabelAge = new javax.swing.JLabel();
        jLabelGender = new javax.swing.JLabel();
        jLabelPregnant = new javax.swing.JLabel();
        jLabelHeight = new javax.swing.JLabel();
        jLabelWeight = new javax.swing.JLabel();
        jLabelBPHigh = new javax.swing.JLabel();
        jLabelBPLow = new javax.swing.JLabel();
        jLabelCholesterol = new javax.swing.JLabel();
        jLabelGlucose = new javax.swing.JLabel();
        jComboBoxAge = new javax.swing.JComboBox<>();
        jComboBoxGender = new javax.swing.JComboBox<>();
        pregnantBoolCheckbox = new javax.swing.JCheckBox();
        jTextFieldHeight = new javax.swing.JTextField();
        jTextFieldBPHigh = new javax.swing.JTextField();
        jTextFieldBPLow = new javax.swing.JTextField();
        jTextFieldCholesterol = new javax.swing.JTextField();
        jTextFieldGlucose = new javax.swing.JTextField();
        jComboBoxWeight = new javax.swing.JComboBox<>();
        jlabelBehavioral = new javax.swing.JLabel();
        jlabelDisease = new javax.swing.JLabel();
        jPanelDisease = new javax.swing.JPanel();
        jCheckBoxCovid = new javax.swing.JCheckBox();
        jCheckBoxCardio = new javax.swing.JCheckBox();
        jCheckBoxAlzheimers = new javax.swing.JCheckBox();
        jLabelCovid = new javax.swing.JLabel();
        jLabelCardio = new javax.swing.JLabel();
        jLabelAlzheimers = new javax.swing.JLabel();
        jPanelBehavior = new javax.swing.JPanel();
        jCheckBoxNicotine = new javax.swing.JCheckBox();
        jCheckBoxAlcohol = new javax.swing.JCheckBox();
        jCheckBoxPhysical = new javax.swing.JCheckBox();
        jLabelNicotine = new javax.swing.JLabel();
        jLabelAlcohol = new javax.swing.JLabel();
        jLabelPhysical = new javax.swing.JLabel();
        nicotineBoolCheckbox = new javax.swing.JCheckBox();
        alcoholBoolCheckbox = new javax.swing.JCheckBox();
        jTextFieldPhysical = new javax.swing.JTextField();
        jPanelButton = new javax.swing.JPanel();
        buttonSubmit = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        jCheckBoxAll = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jlabelOutputRisk = new javax.swing.JLabel();
        jlabelOutputDisease = new javax.swing.JLabel();
        jlabelOutputBiggestFactor = new javax.swing.JLabel();
        jlabelOutputBiggestFactor1 = new javax.swing.JLabel();
        jlabelOutputRisk1 = new javax.swing.JLabel();
        jlabelOutputDisease1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelOutputCovid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneRiskCovid = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneFactorCovid = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jLabelOutputCardio = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneRiskCardio = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPaneFactorCardio = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jLabelOutputAlzheimers = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPaneRiskAlzheimers = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPaneFactorAlzheimers = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPaneRiskDetails = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAC Risk Analyzer");
        setLocation(new java.awt.Point(409, 71));

        jlabelPhysicalInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelPhysicalInfo.setText("Physical Info");

        jlabelTrait.setBackground(new java.awt.Color(119, 119, 119));
        jlabelTrait.setForeground(new java.awt.Color(255, 255, 255));
        jlabelTrait.setText("   Trait");
        jlabelTrait.setOpaque(true);

        jlabelInput.setBackground(new java.awt.Color(119, 119, 119));
        jlabelInput.setForeground(new java.awt.Color(255, 255, 255));
        jlabelInput.setText("   Input");
        jlabelInput.setOpaque(true);

        jLabelAge.setText("Age");

        jLabelGender.setText("Gender");

        jLabelPregnant.setText("Pregnant");

        jLabelHeight.setText("Height");

        jLabelWeight.setText("Weight (lbs)");

        jLabelBPHigh.setText("Blood Pressure (High)");

        jLabelBPLow.setText("Blood Pressure (Low)");

        jLabelCholesterol.setText("Cholesterol");

        jLabelGlucose.setText("Glucose");

        jComboBoxAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 5", "5 - 19", "20 - 34", "35 - 49", "50 - 64", "65 <" }));

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        pregnantBoolCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTextFieldHeight.setToolTipText("");
        jTextFieldHeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldBPHigh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldBPLow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldCholesterol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldGlucose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBoxWeight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 125", "125 - 150", "150 - 175", "175 - 200", "200 <" }));

        jlabelBehavioral.setText("Behavioral Info");

        jlabelDisease.setText("Target Diseases");

        jLabelCovid.setText("COVID-19");

        jLabelCardio.setText("Cardiovascular Disease");

        jLabelAlzheimers.setText("Alzheimer's Disease");

        javax.swing.GroupLayout jPanelDiseaseLayout = new javax.swing.GroupLayout(jPanelDisease);
        jPanelDisease.setLayout(jPanelDiseaseLayout);
        jPanelDiseaseLayout.setHorizontalGroup(
            jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiseaseLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCovid)
                    .addComponent(jCheckBoxCardio)
                    .addComponent(jCheckBoxAlzheimers))
                .addGap(71, 71, 71)
                .addGroup(jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAlzheimers)
                    .addComponent(jLabelCardio)
                    .addComponent(jLabelCovid))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanelDiseaseLayout.setVerticalGroup(
            jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiseaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDiseaseLayout.createSequentialGroup()
                        .addGroup(jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDiseaseLayout.createSequentialGroup()
                                .addGroup(jPanelDiseaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBoxCovid)
                                    .addComponent(jLabelCovid))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxCardio))
                            .addComponent(jLabelCardio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxAlzheimers))
                    .addComponent(jLabelAlzheimers))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelNicotine.setText("Nicotine Use");

        jLabelAlcohol.setText("Alcohol Use");

        jLabelPhysical.setText("Physical Activity (Avg days/week)");

        nicotineBoolCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        alcoholBoolCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTextFieldPhysical.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelBehaviorLayout = new javax.swing.GroupLayout(jPanelBehavior);
        jPanelBehavior.setLayout(jPanelBehaviorLayout);
        jPanelBehaviorLayout.setHorizontalGroup(
            jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBehaviorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxNicotine)
                    .addComponent(jCheckBoxAlcohol)
                    .addComponent(jCheckBoxPhysical))
                .addGap(71, 71, 71)
                .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelNicotine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPhysical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAlcohol, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPhysical, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(alcoholBoolCheckbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nicotineBoolCheckbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanelBehaviorLayout.setVerticalGroup(
            jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBehaviorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBehaviorLayout.createSequentialGroup()
                        .addComponent(nicotineBoolCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alcoholBoolCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBehaviorLayout.createSequentialGroup()
                        .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBoxNicotine)
                            .addGroup(jPanelBehaviorLayout.createSequentialGroup()
                                .addComponent(jLabelNicotine)
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxAlcohol)
                            .addComponent(jLabelAlcohol))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBehaviorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxPhysical)
                            .addComponent(jLabelPhysical))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTextFieldPhysical.getAccessibleContext().setAccessibleName("Physical Activity");

        buttonSubmit.setText("Submit");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        buttonClear.setText("Clear");

        javax.swing.GroupLayout jPanelButtonLayout = new javax.swing.GroupLayout(jPanelButton);
        jPanelButton.setLayout(jPanelButtonLayout);
        jPanelButtonLayout.setHorizontalGroup(
            jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(buttonSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(buttonClear)
                .addGap(23, 23, 23))
        );
        jPanelButtonLayout.setVerticalGroup(
            jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSubmit)
                    .addComponent(buttonClear))
                .addContainerGap())
        );

        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPhysicalLayout = new javax.swing.GroupLayout(jPanelPhysical);
        jPanelPhysical.setLayout(jPanelPhysicalLayout);
        jPanelPhysicalLayout.setHorizontalGroup(
            jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxGlucose)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelGlucose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxCholesterol)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelCholesterol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxBPLow)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelBPLow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxBPHigh)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelBPHigh)))
                                .addGap(237, 237, 237)
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldBPHigh, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldBPLow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextFieldCholesterol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldGlucose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabelBehavioral)
                                    .addComponent(jlabelDisease))
                                .addGap(459, 459, 459)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxAge)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxGender)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPhysicalLayout.createSequentialGroup()
                                        .addComponent(jCheckBoxPregnant)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelPregnant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxHeight)
                                    .addComponent(jCheckBoxWeight))
                                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabelWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(216, 216, 216)
                                        .addComponent(jComboBoxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pregnantBoolCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))))
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabelHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                .addComponent(jPanelDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                .addComponent(jPanelBehavior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPhysicalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        jPanelPhysicalLayout.setVerticalGroup(
            jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBoxAge))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAge)
                            .addComponent(jComboBoxAge, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jCheckBoxGender))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabelGender))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jCheckBoxPregnant))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelPregnant))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pregnantBoolCheckbox)))
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addComponent(jCheckBoxHeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxWeight))
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jComboBoxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHeight)
                            .addComponent(jTextFieldHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelWeight)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jCheckBoxBPHigh))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabelBPHigh))
                    .addComponent(jTextFieldBPHigh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jCheckBoxBPLow))
                            .addComponent(jTextFieldBPLow, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelBPLow)))
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jCheckBoxCholesterol))
                            .addComponent(jTextFieldCholesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelCholesterol)))
                .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGlucose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelPhysicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPhysicalLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabelGlucose))
                            .addComponent(jCheckBoxGlucose))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlabelBehavioral)
                .addGap(16, 16, 16)
                .addComponent(jPanelBehavior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelDisease)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldHeight.getAccessibleContext().setAccessibleName("Height");
        jTextFieldBPHigh.getAccessibleContext().setAccessibleName("Blood Pressure (High)");
        jTextFieldBPLow.getAccessibleContext().setAccessibleName("Blood Pressure (Low)");
        jTextFieldCholesterol.getAccessibleContext().setAccessibleName("Cholesterol");
        jTextFieldGlucose.getAccessibleContext().setAccessibleName("Glucose");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelPhysicalInfo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jCheckBoxAll)
                        .addGap(57, 57, 57)
                        .addComponent(jlabelTrait, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlabelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabelTrait)
                        .addComponent(jlabelInput))
                    .addComponent(jCheckBoxAll))
                .addGap(13, 13, 13)
                .addComponent(jlabelPhysicalInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPhysical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBoxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAllActionPerformed(evt);
            }
        });

        jTabbedPane1.addTab("Input", jPanel1);

        jlabelOutputRisk.setBackground(new java.awt.Color(119, 119, 119));
        jlabelOutputRisk.setForeground(new java.awt.Color(255, 255, 255));
        jlabelOutputRisk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelOutputRisk.setText("Risk");
        jlabelOutputRisk.setOpaque(true);

        jlabelOutputDisease.setBackground(new java.awt.Color(119, 119, 119));
        jlabelOutputDisease.setForeground(new java.awt.Color(255, 255, 255));
        jlabelOutputDisease.setText("   Disease");
        jlabelOutputDisease.setOpaque(true);

        jlabelOutputBiggestFactor.setBackground(new java.awt.Color(119, 119, 119));
        jlabelOutputBiggestFactor.setForeground(new java.awt.Color(255, 255, 255));
        jlabelOutputBiggestFactor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelOutputBiggestFactor.setText("Biggest Factor");
        jlabelOutputBiggestFactor.setToolTipText("");
        jlabelOutputBiggestFactor.setOpaque(true);

        jlabelOutputBiggestFactor1.setBackground(new java.awt.Color(119, 119, 119));
        jlabelOutputBiggestFactor1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelOutputBiggestFactor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelOutputBiggestFactor1.setText("Disease");
        jlabelOutputBiggestFactor1.setToolTipText("");
        jlabelOutputBiggestFactor1.setOpaque(true);

        jlabelOutputRisk1.setBackground(new java.awt.Color(119, 119, 119));
        jlabelOutputRisk1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelOutputRisk1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelOutputRisk1.setText(" ");
        jlabelOutputRisk1.setOpaque(true);

        jlabelOutputDisease1.setBackground(new java.awt.Color(119, 119, 119));
        jlabelOutputDisease1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelOutputDisease1.setText("   Risk Factors");
        jlabelOutputDisease1.setOpaque(true);

        jLabelOutputCovid.setText("COVID-19");

        jTextPaneRiskCovid.setEditable(false);
        jTextPaneRiskCovid.setText("0%");
        jScrollPane1.setViewportView(jTextPaneRiskCovid);

        jScrollPane2.setViewportView(jTextPaneFactorCovid);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOutputCovid)
                .addGap(130, 130, 130)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOutputCovid))
                .addContainerGap())
        );

        jLabelOutputCardio.setText("Cardiovascular Diseases");

        jTextPaneRiskCardio.setEditable(false);
        jTextPaneRiskCardio.setText("0%");
        jTextPaneRiskCardio.setSize(new java.awt.Dimension(62, 21));
        jScrollPane3.setViewportView(jTextPaneRiskCardio);

        jScrollPane4.setViewportView(jTextPaneFactorCardio);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOutputCardio)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOutputCardio))
                .addContainerGap())
        );

        jLabelOutputAlzheimers.setText("Alzheimer's Disease");

        jTextPaneRiskAlzheimers.setEditable(false);
        jTextPaneRiskAlzheimers.setText("0%");
        jTextPaneRiskAlzheimers.setSize(new java.awt.Dimension(62, 21));
        jScrollPane5.setViewportView(jTextPaneRiskAlzheimers);

        jScrollPane6.setViewportView(jTextPaneFactorAlzheimers);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOutputAlzheimers)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelOutputAlzheimers))
                .addContainerGap())
        );

        jScrollPane7.setViewportView(jTextPaneRiskDetails);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlabelOutputDisease1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelOutputRisk1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelOutputBiggestFactor1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlabelOutputDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelOutputRisk, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelOutputBiggestFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelOutputRisk)
                    .addComponent(jlabelOutputDisease)
                    .addComponent(jlabelOutputBiggestFactor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelOutputRisk1)
                    .addComponent(jlabelOutputDisease1)
                    .addComponent(jlabelOutputBiggestFactor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Output", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("run() called!");
                new AppFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox alcoholBoolCheckbox;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JCheckBox jCheckBoxAge;
    private javax.swing.JCheckBox jCheckBoxAlcohol;
    private javax.swing.JCheckBox jCheckBoxAll;
    private javax.swing.JCheckBox jCheckBoxAlzheimers;
    private javax.swing.JCheckBox jCheckBoxBPHigh;
    private javax.swing.JCheckBox jCheckBoxBPLow;
    private javax.swing.JCheckBox jCheckBoxCardio;
    private javax.swing.JCheckBox jCheckBoxCholesterol;
    private javax.swing.JCheckBox jCheckBoxCovid;
    private javax.swing.JCheckBox jCheckBoxGender;
    private javax.swing.JCheckBox jCheckBoxGlucose;
    private javax.swing.JCheckBox jCheckBoxHeight;
    private javax.swing.JCheckBox jCheckBoxNicotine;
    private javax.swing.JCheckBox jCheckBoxPhysical;
    private javax.swing.JCheckBox jCheckBoxPregnant;
    private javax.swing.JCheckBox jCheckBoxWeight;
    private javax.swing.JComboBox<String> jComboBoxAge;
    private javax.swing.JComboBox<String> jComboBoxGender;
    private javax.swing.JComboBox<String> jComboBoxWeight;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelAlcohol;
    private javax.swing.JLabel jLabelAlzheimers;
    private javax.swing.JLabel jLabelBPHigh;
    private javax.swing.JLabel jLabelBPLow;
    private javax.swing.JLabel jLabelCardio;
    private javax.swing.JLabel jLabelCholesterol;
    private javax.swing.JLabel jLabelCovid;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelGlucose;
    private javax.swing.JLabel jLabelHeight;
    private javax.swing.JLabel jLabelNicotine;
    private javax.swing.JLabel jLabelOutputAlzheimers;
    private javax.swing.JLabel jLabelOutputCardio;
    private javax.swing.JLabel jLabelOutputCovid;
    private javax.swing.JLabel jLabelPhysical;
    private javax.swing.JLabel jLabelPregnant;
    private javax.swing.JLabel jLabelWeight;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBehavior;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelDisease;
    private javax.swing.JPanel jPanelPhysical;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldBPHigh;
    private javax.swing.JTextField jTextFieldBPLow;
    private javax.swing.JTextField jTextFieldCholesterol;
    private javax.swing.JTextField jTextFieldGlucose;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldPhysical;
    private javax.swing.JTextPane jTextPaneFactorAlzheimers;
    private javax.swing.JTextPane jTextPaneFactorCardio;
    private javax.swing.JTextPane jTextPaneFactorCovid;
    private javax.swing.JTextPane jTextPaneRiskAlzheimers;
    private javax.swing.JTextPane jTextPaneRiskCardio;
    private javax.swing.JTextPane jTextPaneRiskCovid;
    private javax.swing.JTextPane jTextPaneRiskDetails;
    private javax.swing.JLabel jlabelBehavioral;
    private javax.swing.JLabel jlabelDisease;
    private javax.swing.JLabel jlabelInput;
    private javax.swing.JLabel jlabelOutputBiggestFactor;
    private javax.swing.JLabel jlabelOutputBiggestFactor1;
    private javax.swing.JLabel jlabelOutputDisease;
    private javax.swing.JLabel jlabelOutputDisease1;
    private javax.swing.JLabel jlabelOutputRisk;
    private javax.swing.JLabel jlabelOutputRisk1;
    private javax.swing.JLabel jlabelPhysicalInfo;
    private javax.swing.JLabel jlabelTrait;
    private javax.swing.JCheckBox nicotineBoolCheckbox;
    private javax.swing.JCheckBox pregnantBoolCheckbox;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JCheckBox[] checkboxesLeftInfo;
    private Source source;

}
