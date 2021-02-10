/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package health;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public final class PatientView extends javax.swing.JFrame {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    int curRow=0;
    String username, userType;
    DefaultListModel model = new DefaultListModel();
    int index;
    int requestID;
    /**
     * Creates new form PatientView
     * @param patient
     */
    public PatientView(String patient) {
        initComponents();
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Andrea\\Documents\\NetBeansProjects\\health.sqlite");
            //JOptionPane.showMessageDialog (null, "Connected");
            Statement statement = conn.createStatement();
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        username = patient;
        setUsername(patient);
        userType = "Patient";
        setUserType(userType);
        jList1.setVisible(false);

    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public int getRequestID(){
        return this.requestID;
    }

    public void setRequestID(int requestID){
        this.requestID = requestID;
    }

    public String getUserType(){
        return this.userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        InProgressButton = new javax.swing.JButton();
        closedButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        openRequest = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InProgressButton.setText("In Progress Requests");
        InProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InProgressButtonActionPerformed(evt);
            }
        });

        closedButton.setText("Closed Requests");
        closedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closedButtonActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 3, 24)); // NOI18N
        jLabel1.setText("Your Request History");

        openRequest.setText("Open Selected Request");
        openRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openRequestActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("HealthConnect");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        newButton.setText("New Requests");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(openRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(234, 234, 234)
                                                .addComponent(backButton))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addComponent(InProgressButton)
                                                .addGap(67, 67, 67)
                                                .addComponent(closedButton)
                                                .addGap(115, 115, 115)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel7))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(InProgressButton)
                                        .addComponent(closedButton)
                                        .addComponent(newButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(openRequest)
                                        .addComponent(backButton))
                                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>

    private void InProgressButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jLabel1.setText("Your Opened Requests");
        jList1.setVisible(true);
        String element;
        String sql ="select RID,Date from Request where Status=? and PUsername=?";
        model.removeAllElements();
        element = "RID        Date";
        model.addElement(element);
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, "In Progress");
            pst.setString(2, username);
            rs = pst.executeQuery();
            if(rs.next()){
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                element = rs.getString("RID") + "        " + rs.getString("Date");
                model.addElement(element);
                while (rs.next()){
                    element = rs.getString("RID") + "        " + rs.getString("Date");
                    model.addElement(element);
                }
                jList1.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null, "No requests are in progress.");

            }
        }

        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);}finally{
            try{
                rs.close();
                pst.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jLabel1.setText("Your New Requests");
        jList1.setVisible(true);
        String element;
        String sql ="select RID,Date from Request where Status=? and PUsername=?";
        model.removeAllElements();
        element = "RID        Date";
        model.addElement(element);
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, "New");
            pst.setString(2, username);
            rs = pst.executeQuery();
            if(rs.next()){
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                element = rs.getString("RID") + "        " + rs.getString("Date");
                model.addElement(element);
                while (rs.next()){
                    element = rs.getString("RID") + "        " + rs.getString("Date");
                    model.addElement(element);
                }
                jList1.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null, "No new requests.");

            }
        }

        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);}finally{
            try{
                rs.close();
                pst.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void closedButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jLabel1.setText("Your Closed Requests");
        jList1.setVisible(true);
        String element;
        String sql ="select RID,Date from Request where Status=? and PUsername=?";
        model.removeAllElements();
        element = "RID        Date";
        model.addElement(element);
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, "Closed");
            pst.setString(2, username);
            rs = pst.executeQuery();
            if(rs.next()){
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                element = rs.getString("RID") + "        " + rs.getString("Date");
                model.addElement(element);
                while (rs.next()){
                    element = rs.getString("RID") + "        " + rs.getString("Date");
                    model.addElement(element);
                }
                jList1.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null, "No requests have been closed.");

            }
        }

        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);}finally{
            try{
                rs.close();
                pst.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        Profile p = new Profile(username);
        p.setVisible(true);
    }

    private void openRequestActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(jList1.getSelectedIndex() != -1)
        {
            String temp_requestID = jList1.getSelectedValue().toString();
            temp_requestID = temp_requestID.substring(0,3);
            requestID = Integer.parseInt(temp_requestID);
            setRequestID(requestID);
            RequestConversation r = new RequestConversation(requestID, username, userType);
            dispose();
            r.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null, "Please select a request");
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        final NewJFrame s = new NewJFrame();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PatientView(s.getUsername()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton InProgressButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton closedButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newButton;
    private javax.swing.JButton openRequest;
    // End of variables declaration
}

