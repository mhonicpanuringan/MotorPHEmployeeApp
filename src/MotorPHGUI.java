/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mhoni
 */

import java.io.*;
import javax.swing.table.DefaultTableModel;

public class MotorPHGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MotorPHGUI.class.getName());
    
    private DefaultTableModel model;
    
    private final String CSV_FILE = "employees.csv";

    /**
     * Creates new form MotorPHGUI
     */
    public MotorPHGUI() {
    
    initComponents();

    setLocationRelativeTo(null);

    setSize(700, 650);

    tblEmployees.setDefaultEditor(
            Object.class,
            null
    );

    txtGrossPay.setEditable(false);
    txtTotalDeductions.setEditable(false);
    txtNetPay.setEditable(false);

    loadEmployeeData();
    
    }
    
    private void saveTableToCSV() {

    try {

        BufferedWriter bw =
                new BufferedWriter(
                        new FileWriter(CSV_FILE));

        for(int col = 0;
            col < model.getColumnCount();
            col++) {

            bw.write(
                model.getColumnName(col));

            if(col < model.getColumnCount()-1)
                bw.write(",");
        }

        bw.newLine();

        for(int row = 0;
            row < model.getRowCount();
            row++) {

            for(int col = 0;
                col < model.getColumnCount();
                col++) {

                Object value =
                        model.getValueAt(row,col);

                String text =
                        value == null ?
                        "" :
                        value.toString();

                if(text.contains(",")) {
                    text = text.replace("\"", "");
                    text = "\"" + text + "\"";
                }

                bw.write(text);

                if(col < model.getColumnCount()-1)
                    bw.write(",");

            }

            bw.newLine();
        }

        bw.close();

    }
    
    catch(Exception e){

        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Error saving CSV\n" + e.getMessage()
        );

    }
    
}

    private void loadEmployeeData() {
        
                tblEmployees.setAutoResizeMode(
            javax.swing.JTable.AUTO_RESIZE_OFF
        );

        try {

                model = (DefaultTableModel) tblEmployees.getModel();

                model.setRowCount(0);

                BufferedReader br =
                        new BufferedReader(
                                new FileReader(CSV_FILE));

                br.readLine();

                String line;

                while ((line = br.readLine()) != null) {

                    String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    
                    System.out.println("Columns = " + data.length);

                    for(int i = 0; i < data.length; i++){
                        System.out.println(i + " = " + data[i]);
                    }
                    
                    System.out.println("Columns = " + data.length);
                    if(data.length >= 5){

                        model.addRow(new Object[]{

                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            data[5],
                            data[6],
                            data[7],
                            data[8],
                            data[9],
                            data[10],
                            data[11],
                            data[12],
                            data[13],
                            data[14],
                            data[15],
                            data[16],
                            data[17],
                            data[18],

                            data.length > 19 ? data[19] : "",
                            data.length > 20 ? data[20] : "",
                            data.length > 21 ? data[21] : ""

                        });

                    }
                }

                br.close();

            }
            catch(Exception e){

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error loading employees.csv\n" +
                        e.getMessage()
                );

            }

}
    
    private boolean validateFields() {

    if(txtEmployeeNumber.getText().trim().isEmpty() ||
       txtLastName.getText().trim().isEmpty() ||
       txtFirstName.getText().trim().isEmpty() ||
       txtSSSNumber.getText().trim().isEmpty() ||
       txtPhilHealthNumber.getText().trim().isEmpty() ||
       TIN.getText().trim().isEmpty() ||
       txtPagIBIGNumber.getText().trim().isEmpty())
        
    {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please fill all required fields."
        );

        return false;
        
    }

            try{

            Long.parseLong(
                txtEmployeeNumber.getText()
            );

        }catch(NumberFormatException e){

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Employee Number must be numeric."
            );

            return false;
        }

        return true;

}
    
    private boolean employeeExists(String empNo) {

    for(int i = 0; i < model.getRowCount(); i++) {

        if(model.getValueAt(i,0).toString().equals(empNo)) {

            return true;

        }
    }

    return false;
    
}
    private void updateEmployeeRow(int row){

    model.setValueAt(txtEmployeeNumber.getText(), row, 0);
    model.setValueAt(txtLastName.getText(), row, 1);
    model.setValueAt(txtFirstName.getText(), row, 2);
    model.setValueAt(txtSSSNumber.getText(), row, 6);
    model.setValueAt(txtPhilHealthNumber.getText(), row, 7);
    model.setValueAt(TIN.getText(), row, 8);
    model.setValueAt(txtPagIBIGNumber.getText(), row, 9);

    saveTableToCSV();
    loadEmployeeData();
}

    private void deleteEmployeeRow(int row){

        model.removeRow(row);

        saveTableToCSV();
        loadEmployeeData();

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmployeeNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtPayCoverage = new javax.swing.JTextField();
        btnProcessPayroll = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtSSSNumber = new javax.swing.JTextField();
        txtPhilHealthNumber = new javax.swing.JTextField();
        TIN = new javax.swing.JTextField();
        txtPagIBIGNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Label = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        txtRatePerDay = new javax.swing.JTextField();
        txtDaysWorked = new javax.swing.JTextField();
        txtGrossPay = new javax.swing.JTextField();
        txtTotalDeductions = new javax.swing.JTextField();
        txtNetPay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(150, 30));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MotorPH Employee App");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 560, 30));

        jLabel4.setText("Employee Number:");
        jLabel4.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        txtEmployeeNumber.setPreferredSize(new java.awt.Dimension(150, 30));
        txtEmployeeNumber.addActionListener(this::txtEmployeeNumberActionPerformed);
        getContentPane().add(txtEmployeeNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, -1));

        jLabel1.setText("Last Name:");
        jLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 102, -1));

        jLabel2.setText("Pay Coverage:");
        jLabel2.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 80, 30));

        txtLastName.setPreferredSize(new java.awt.Dimension(150, 30));
        txtLastName.addActionListener(this::txtLastNameActionPerformed);
        getContentPane().add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 130, -1));

        txtPayCoverage.setPreferredSize(new java.awt.Dimension(150, 30));
        txtPayCoverage.addActionListener(this::txtPayCoverageActionPerformed);
        getContentPane().add(txtPayCoverage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 130, 30));

        btnProcessPayroll.setText("Process Payroll");
        btnProcessPayroll.setPreferredSize(new java.awt.Dimension(80, 30));
        btnProcessPayroll.addActionListener(this::btnProcessPayrollActionPerformed);
        getContentPane().add(btnProcessPayroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 127, -1));

        btnClear.setText("Clear");
        btnClear.setPreferredSize(new java.awt.Dimension(80, 30));
        btnClear.addActionListener(this::btnClearActionPerformed);
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 80, -1));

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee Number", "Last Name", "First Name", "Birthday", "Address", "Phone Number", "SSS Number", "PhilHealth Number", "TIN Number", "Pag-IBIG Number", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate", "Gross Pay", "Total Deductions", "Net Pay"
            }
        ));
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEmployees);
        if (tblEmployees.getColumnModel().getColumnCount() > 0) {
            tblEmployees.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(7).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(8).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(9).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(10).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(11).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(12).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(13).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(14).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(15).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(16).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(17).setPreferredWidth(150);
            tblEmployees.getColumnModel().getColumn(18).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 570, 170));

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(80, 30));
        btnAdd.addActionListener(this::btnAddActionPerformed);
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(80, 30));
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 30));
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        jLabel5.setText("First Name:");
        jLabel5.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel6.setText("SSS Number");
        jLabel6.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel7.setText("PhilHealth Number");
        jLabel7.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel8.setText("TIN");
        jLabel8.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 60, -1));

        jLabel9.setText("Pag-IBIG Number");
        jLabel9.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        txtFirstName.setPreferredSize(new java.awt.Dimension(150, 30));
        txtFirstName.addActionListener(this::txtFirstNameActionPerformed);
        getContentPane().add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 130, -1));

        txtSSSNumber.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtSSSNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, -1));

        txtPhilHealthNumber.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtPhilHealthNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 130, -1));

        TIN.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(TIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 130, -1));

        txtPagIBIGNumber.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtPagIBIGNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 130, -1));

        jLabel10.setText("Rate Per Day:");
        jLabel10.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 90, 30));

        jLabel11.setText("Days Worked:");
        jLabel11.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 100, 30));

        Label.setText("Gross Pay:");
        Label.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 80, 30));

        Label2.setText("Total Deductions:");
        Label2.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 100, 30));

        Label3.setText("NetPay:");
        Label3.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 70, 30));

        txtRatePerDay.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtRatePerDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 130, 30));

        txtDaysWorked.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtDaysWorked, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 130, 30));

        txtGrossPay.setPreferredSize(new java.awt.Dimension(150, 30));
        txtGrossPay.addActionListener(this::txtGrossPayActionPerformed);
        getContentPane().add(txtGrossPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 130, 30));

        txtTotalDeductions.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtTotalDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 130, 30));

        txtNetPay.setPreferredSize(new java.awt.Dimension(150, 30));
        txtNetPay.addActionListener(this::txtNetPayActionPerformed);
        getContentPane().add(txtNetPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 130, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Employee Information");
        jLabel12.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 180, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Payroll Information");
        jLabel13.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 180, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Employee Records");
        jLabel14.setPreferredSize(new java.awt.Dimension(160, 30));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 180, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmployeeNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeNumberActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void btnProcessPayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessPayrollActionPerformed
        
        if(txtRatePerDay.getText().trim().isEmpty() ||
            txtDaysWorked.getText().trim().isEmpty()) {

             javax.swing.JOptionPane.showMessageDialog(
                     this,
                     "Please enter Rate Per Day and Days Worked."
             );

             return;
         }
        
        try {

            double ratePerDay =
                    Double.parseDouble(
                    txtRatePerDay.getText());

            int daysWorked =
                    Integer.parseInt(
                    txtDaysWorked.getText());

            double grossPay =
                    SalaryComputationModule.computeGrossPay(
                    ratePerDay,
                    daysWorked);

            double sss =
                    SalaryComputationModule.computeSSS(
                    grossPay);

            double philhealth =
                    SalaryComputationModule.computePhilHealth(
                    grossPay);

            double pagibig =
                    SalaryComputationModule.computePagIBIG(
                    grossPay);

            double tax =
                    SalaryComputationModule.computeWithholdingTax(
                    grossPay);

            double deductions =
                    SalaryComputationModule.computeDeductions(
                    sss,
                    philhealth,
                    pagibig,
                    tax);

            double netPay =
                    SalaryComputationModule.computeNetPay(
                    grossPay,
                    deductions);

            txtGrossPay.setText(
                    String.format("%.2f", grossPay));

            txtTotalDeductions.setText(
                    String.format("%.2f", deductions));

            txtNetPay.setText(
                    String.format("%.2f", netPay));

            int row =
                    tblEmployees.getSelectedRow();

            if(row != -1){

                model.setValueAt(
                        String.format("%.2f", grossPay),
                        row,
                        19);

                model.setValueAt(
                        String.format("%.2f", deductions),
                        row,
                        20);

                model.setValueAt(
                        String.format("%.2f", netPay),
                        row,
                        21);

                saveTableToCSV();
            }

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Salary computation completed and saved successfully!"
            );

        }
        catch(NumberFormatException e){

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric values."
            );

            }
        
    }//GEN-LAST:event_btnProcessPayrollActionPerformed

    private void txtPayCoverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayCoverageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayCoverageActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        txtEmployeeNumber.setText("");
        txtLastName.setText("");
        txtFirstName.setText("");
        txtSSSNumber.setText("");
        txtPhilHealthNumber.setText("");
        TIN.setText("");
        txtPagIBIGNumber.setText("");
        txtPayCoverage.setText("");
        txtRatePerDay.setText("");
        txtDaysWorked.setText("");
        txtGrossPay.setText("");
        txtTotalDeductions.setText("");
        txtNetPay.setText("");
    
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if(!validateFields()){
            return;
        }

        String empNo = txtEmployeeNumber.getText().trim();

        if(employeeExists(empNo)){

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Employee Number already exists."
            );

            return;
        }
        
        System.out.println("ADDING ROW");
        model.addRow(new Object[]{

            txtEmployeeNumber.getText(),
            txtLastName.getText(),
            txtFirstName.getText(),
            "",
            "",
            "",
            txtSSSNumber.getText(),
            txtPhilHealthNumber.getText(),
            TIN.getText(),
            txtPagIBIGNumber.getText(),
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""

        });

        saveTableToCSV();
        
        loadEmployeeData();

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Employee added successfully!"
        );

        btnClearActionPerformed(null);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int row = tblEmployees.getSelectedRow();

        if(row == -1){
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Please select an employee first."
            );
            return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(
                    this,
                    "Delete selected employee?",
                    "Confirm Delete",
                     javax.swing.JOptionPane.YES_NO_OPTION
         );

        if(confirm != javax.swing.JOptionPane.YES_OPTION){
            return;
        }

        deleteEmployeeRow(row);

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Employee deleted successfully!"
        );
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        int row = tblEmployees.getSelectedRow();

        if(row == -1) {

            javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Please select an employee first."
                );

                return;
                
        }

        if(!validateFields()) {
            return;
        }

        updateEmployeeRow(row);

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Employee updated successfully!"
        );
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        
        int row = tblEmployees.getSelectedRow();

        txtEmployeeNumber.setText(
                model.getValueAt(row, 0).toString());

        txtLastName.setText(
                model.getValueAt(row, 1).toString());

        txtFirstName.setText(
                model.getValueAt(row, 2).toString());

        txtSSSNumber.setText(
                model.getValueAt(row, 6).toString());

        txtPhilHealthNumber.setText(
                model.getValueAt(row, 7).toString());

        TIN.setText(
                model.getValueAt(row, 8).toString());

        txtPagIBIGNumber.setText(
                model.getValueAt(row, 9).toString());

    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtNetPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNetPayActionPerformed

    private void txtGrossPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrossPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrossPayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
        javax.swing.UIManager.setLookAndFeel(
            javax.swing.UIManager.getSystemLookAndFeelClassName()
        );
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(() -> new MotorPHGUI().setVisible(true));
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JTextField TIN;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnProcessPayroll;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtDaysWorked;
    private javax.swing.JTextField txtEmployeeNumber;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGrossPay;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNetPay;
    private javax.swing.JTextField txtPagIBIGNumber;
    private javax.swing.JTextField txtPayCoverage;
    private javax.swing.JTextField txtPhilHealthNumber;
    private javax.swing.JTextField txtRatePerDay;
    private javax.swing.JTextField txtSSSNumber;
    private javax.swing.JTextField txtTotalDeductions;
    // End of variables declaration//GEN-END:variables
}
