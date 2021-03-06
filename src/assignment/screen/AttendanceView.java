/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.screen;

import assignment.att.AttBlock;
import assignment.att.AttBlockchain;
import assignment.att.AttTransaction;
import assignment.function.AttendanceClass;
import assignment.function.EmployeeClass;
import assignment.function.LocationClass;
import assignment.loc.LocBlock;
import assignment.loc.LocBlockchain;
import assignment.loc.LocTransaction;
import assignment.main.Server;
import static assignment.screen.EmployeeView.EmployeeSelected;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author howard
 */
public class AttendanceView extends javax.swing.JFrame {

    /**
     * Creates new form LocationView
     */
    public AttendanceView() {
        initComponents();
    }
    public static EmployeeClass EmployeeSelected;
    public static AttendanceClass SelectedAttendance;
    public static List<AttendanceClass> attendanceList;
    boolean srch;
    
    List<EmployeeClass> lemp;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        SearchField = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();

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

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);
        List<EmployeeClass> emp = assignment.main.Main.EmployeeList;
        String[] name = new String[emp.size()];
        for(int i = 0;i<emp.size();i++){
            name[i] = emp.get(i).getName();
        }
        jList1.setListData(name);

        Search.setBackground(new java.awt.Color(173, 216, 230));
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/dataset/search_1_3.png"))); // NOI18N
        Search.setContentAreaFilled(false);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList2);

        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(back))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        assignment.main.Main.main.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        if(SearchField.getText().equals("")){
            lemp = assignment.main.Main.EmployeeList;
            String[] name = new String[lemp.size()];
            for(int i = 0;i<lemp.size();i++){
                name[i] = lemp.get(i).getName();
            }
            jList1.setListData(name);
        }
        else{
            List<EmployeeClass> emp = assignment.main.Main.EmployeeList;
            lemp = new ArrayList<>();
            for(int i=0;i<emp.size();i++){
                if(emp.get(i).getName().contains(SearchField.getText())){
                    lemp.add(emp.get(i));
                }
            }
            String[] name = new String[lemp.size()];
            for(int i = 0;i<lemp.size();i++){
                name[i] = lemp.get(i).getName();
            }
            jList1.setListData(name); 
            srch = true;
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int idx = jList1.getSelectedIndex();
        if(idx==-1){
            JOptionPane.showMessageDialog(this,
                    "Data has not been selected!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            ); 
        }else{
            if(!srch) 
                EmployeeSelected = assignment.main.Main.EmployeeList.get(idx);
            else{
                EmployeeSelected = lemp.get(idx);
            }
            List<AttendanceClass> lst = getAttendanceData();
            attendanceList = lst;
            System.out.println(attendanceList);
            String[] date = new String[lst.size()];
            for(int i = 0;i<lst.size();i++){
                date[i] = lst.get(i).getDate();
            }
            jList2.setListData(date);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int idx = jList2.getSelectedIndex();
         if(idx==-1){
            JOptionPane.showMessageDialog(this,
                    "Data has not been selected!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            ); 
        }else{
            SelectedAttendance = attendanceList.get(idx);
            AttendanceDetails details = new AttendanceDetails();
            details.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed
    private List<AttendanceClass> getAttendanceData(){
        //System.out.println(LocBlockchain.get());
        List<AttBlock> allData = AttBlockchain.get();
        EmployeeClass EmployeeSelected = AttendanceView.EmployeeSelected;
        List<AttendanceClass> attlist = new ArrayList<>();
        String id = EmployeeSelected.getName();
        System.out.println(id);
//        System.out.println(allData);
        for(AttBlock s : allData){
           
            int idx = s.getHeader().getIndex();
            if(idx!=0){
                AttTransaction temp = s.getTransaction();
                System.out.println("QQ" + temp);
                for(int i = 0 ;i< temp.getDataLst().size();i++){
                    String idS = temp.getDataLst().get(i).getEmployeeId();
                    if(id.equals(idS)){
                        System.out.println(temp.getDataLst().get(i).getDate());
                        attlist.add(temp.getDataLst().get(i));
                        
                    }
                }
                
                
            }
            
        }
        System.out.println(attlist);
        return attlist;
        //List<EmployeeClass> emp = assignment.main.Main.EmployeeList;
        //String[] name = new String[emp.size()];
        //for(int i = 0;i<emp.size();i++){
        //    name[i] = emp.get(i).getName();
        //}
        //jList1.setListData(name);
    }
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
            java.util.logging.Logger.getLogger(AttendanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton back;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
