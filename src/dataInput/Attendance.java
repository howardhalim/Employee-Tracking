/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dataInput;

import assignment.att.AttBlock;
import assignment.att.AttBlockchain;
import assignment.function.AttendanceClass;
import assignment.function.EmployeeClass;
import assignment.loc.LocBlockchain;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Steven-
 */
public class Attendance extends javax.swing.JFrame {
    private ArrayList<AttendanceClass> attList = new ArrayList<>();
    /**
     * Creates new form Attendance
     */
    public Attendance() {
        initComponents();
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
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        attMonth = new javax.swing.JComboBox<>();
        attDay = new javax.swing.JTextField();
        attYear = new javax.swing.JTextField();
        onLeave = new javax.swing.JRadioButton();
        attSubmit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        empList = new javax.swing.JList<>();
        Search = new javax.swing.JButton();
        selectEmp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        selectedEmployee = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        inHour = new javax.swing.JTextField();
        inLabel = new javax.swing.JLabel();
        inLabel2 = new javax.swing.JLabel();
        inMin = new javax.swing.JTextField();
        outLabel = new javax.swing.JLabel();
        outHour = new javax.swing.JTextField();
        outLabel2 = new javax.swing.JLabel();
        outMin = new javax.swing.JTextField();
        shiftLabel = new javax.swing.JLabel();
        shiftSelected = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(173, 216, 230));

        back.setBackground(new java.awt.Color(173, 216, 230));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/dataset/smallback.png"))); // NOI18N
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ATTENDANCE RECORD INPUT");

        jLabel2.setText("Date");

        attMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        attMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attMonthActionPerformed(evt);
            }
        });

        attDay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        attDay.setToolTipText("");
        attDay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                attDayFocusGained(evt);
            }
        });
        attDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attDayActionPerformed(evt);
            }
        });

        attYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        attYear.setToolTipText("");
        attYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                attYearFocusGained(evt);
            }
        });
        attYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attYearActionPerformed(evt);
            }
        });

        onLeave.setText("On-Leave");
        onLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLeaveActionPerformed(evt);
            }
        });

        attSubmit.setText("Submit");
        attSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attSubmitActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));

        empList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        empList.setToolTipText("");
        jScrollPane1.setViewportView(empList);
        List<EmployeeClass> emp = assignment.main.Main.EmployeeList;
        String[] name = new String[emp.size()];
        for(int i = 0;i<emp.size();i++){
            name[i] = emp.get(i).getName();
        }
        empList.setListData(name);

        Search.setBackground(new java.awt.Color(173, 216, 230));
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/dataset/search_1_3.png"))); // NOI18N
        Search.setContentAreaFilled(false);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        selectEmp.setText("Select");
        selectEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectEmp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectEmp)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Selected Employee");

        selectedEmployee.setEditable(false);

        jPanel3.setBackground(new java.awt.Color(173, 216, 230));

        inHour.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inHour.setToolTipText("");
        inHour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inHourFocusGained(evt);
            }
        });
        inHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inHourActionPerformed(evt);
            }
        });

        inLabel.setText("Check-In");

        inLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inLabel2.setText(":");

        inMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inMinActionPerformed(evt);
            }
        });

        outLabel.setText("Check-Out");

        outHour.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outHourActionPerformed(evt);
            }
        });

        outLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outLabel2.setText(":");

        outMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outMinActionPerformed(evt);
            }
        });

        shiftLabel.setText("Shift");

        shiftSelected.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Morning", "Afternoon" }));
        shiftSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outLabel)
                    .addComponent(inLabel))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inHour)
                    .addComponent(outHour, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(outLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outMin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(inLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inMin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(shiftLabel)
                        .addGap(18, 18, 18)
                        .addComponent(shiftSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inLabel)
                    .addComponent(inHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inLabel2)
                    .addComponent(inMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shiftLabel)
                    .addComponent(shiftSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outLabel)
                    .addComponent(outHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outLabel2)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(onLeave)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(attDay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(attYear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(attSubmit)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectedEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel3))))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(attYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(attMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(onLeave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attSubmit)
                    .addComponent(back))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        assignment.main.Main.main.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void inHourFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inHourFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_inHourFocusGained

    private void inHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inHourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inHourActionPerformed

    private void inMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inMinActionPerformed

    private void outMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outMinActionPerformed

    private void outHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outHourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outHourActionPerformed

    private void attMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attMonthActionPerformed

    private void attDayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_attDayFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_attDayFocusGained

    private void attDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attDayActionPerformed

    private void attYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_attYearFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_attYearFocusGained

    private void attYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attYearActionPerformed

    private void onLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLeaveActionPerformed
        if(onLeave.isSelected()){
            inLabel.setVisible(false);
            inHour.setVisible(false);
            inLabel2.setVisible(false);
            inMin.setVisible(false);
            outLabel.setVisible(false);
            outHour.setVisible(false);
            outLabel2.setVisible(false);
            outMin.setVisible(false);
            shiftLabel.setVisible(false);
            shiftSelected.setVisible(false);
        } else{
            inLabel.setVisible(true);
            inHour.setVisible(true);
            inLabel2.setVisible(true);
            inMin.setVisible(true);
            outLabel.setVisible(true);
            outHour.setVisible(true);
            outLabel2.setVisible(true);
            outMin.setVisible(true);
            shiftLabel.setVisible(true);
            shiftSelected.setVisible(true);
        }
    }//GEN-LAST:event_onLeaveActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

    private void attSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attSubmitActionPerformed
        try{
            boolean validTime = false;
            boolean validShift = false;
            boolean validYear = true;
            boolean passed = false;
            String checkIn = "-";
            String checkOut = "-";
            String lateStatus = "-";
            String shift = "-";
            String workHours = "-";
            String date;
            // Get Form data
            String employee = selectedEmployee.getText();
            int dateD = parseInt(attDay.getText());
            String dateM = (String) attMonth.getSelectedItem();
            int dateY = parseInt(attYear.getText());
            date = dateD+"-"+dateM+"-"+dateY;
            boolean leaveStatus = onLeave.isSelected();
            
            if(!leaveStatus){
                // Check in - Check out
                int inH = parseInt(inHour.getText());
                int inM = parseInt(inMin.getText());
                int outH = parseInt(outHour.getText());
                int outM = parseInt(outMin.getText());
                // Validate time input (daily)
                if (inH > 23 || inH < 0 || outH > 23 || outH < 0){
                    JOptionPane.showMessageDialog(this, "Invalid Hour!\nPlease input from 00 to 23");
                } else if (inH > 59 || inH < 0 || outM > 59 || outM < 0){
                    JOptionPane.showMessageDialog(this, "Invalid Minute!\nPlease input from 00 to 59");
                } else if (outH < inH || (outH == inH && outH < inH)){
                    JOptionPane.showMessageDialog(this, "Employee can't check out before check in time!");
                }else{
                    validTime = true;
                }
                checkIn = String.format("%02d", inH) + ":" + String.format("%02d", inM);
                checkOut = String.format("%02d", outH) + ":" + String.format("%02d", outM);
                
                // Shift
                shift = (String) shiftSelected.getSelectedItem(); 
                
                // Late status (Morning: 7-12, Afternoon 13-18)
                if((shift == "Morning" && inH >= 7 && inM > 00) || (shift == "Afternoon" && inH >= 13 && inM > 00)){
                    lateStatus = "Late";
                } else if ((shift == "Morning" && (inH > 12) || inH < 7)){
                    validShift = false;
                } else if ((shift == "Afternoon" && (inH > 18) || inH < 13)){
                    validShift = false;
                } else {
                    lateStatus = "On Time";
                    validShift = true;
                }

                // workHours
                int workH = outH - inH;
                int workM = outM - inM;
                workHours = String.format("%02d", workH) + " Hours " + String.format("%02d", workM) + " Mins";
                if (validTime && validShift){
                    passed = true;
                }
            }

            if(passed || leaveStatus){
                AttendanceClass att = new AttendanceClass(employee, checkIn, checkOut, shift, lateStatus, date, workHours, leaveStatus);
                attList.add(att);
                
                if (JOptionPane.showConfirmDialog(this, "Do you want to add more records?", "QUESTION",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    validTime= false;
                    validShift= false;
                    passed = false;
                    selectedEmployee.setText("");
                    attDay.setText("");
                    attYear.setText("");
                    inHour.setText("");
                    inMin.setText("");
                    outHour.setText("");
                    outMin.setText("");
                } else {
                    // Pass data to server
                    boolean success = assignment.main.Server.addEmployeeAttendance(attList);
                    if (success){
                        JOptionPane.showMessageDialog(this, "Record(s) Added!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to add record.\nPlease try again!");
                    }
                    // Restart page
                    this.dispose();
                    new Attendance().setVisible(true);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please input correctly!");
        }
    }//GEN-LAST:event_attSubmitActionPerformed

    private void selectEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEmpActionPerformed
        try{
            String listVal = empList.getSelectedValue();
            if(listVal == null){
                JOptionPane.showMessageDialog(this, "Please choose an employee!");
            } else{
                selectedEmployee.setText(listVal);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Oops! There is something wrong.");
        }
    }//GEN-LAST:event_selectEmpActionPerformed

    private void shiftSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftSelectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftSelectedActionPerformed
    
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField attDay;
    private javax.swing.JComboBox<String> attMonth;
    private javax.swing.JButton attSubmit;
    private javax.swing.JTextField attYear;
    private javax.swing.JButton back;
    private javax.swing.JList<String> empList;
    private javax.swing.JTextField inHour;
    private javax.swing.JLabel inLabel;
    private javax.swing.JLabel inLabel2;
    private javax.swing.JTextField inMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton onLeave;
    private javax.swing.JTextField outHour;
    private javax.swing.JLabel outLabel;
    private javax.swing.JLabel outLabel2;
    private javax.swing.JTextField outMin;
    private javax.swing.JButton selectEmp;
    private javax.swing.JTextField selectedEmployee;
    private javax.swing.JLabel shiftLabel;
    private javax.swing.JComboBox<String> shiftSelected;
    // End of variables declaration//GEN-END:variables
}
