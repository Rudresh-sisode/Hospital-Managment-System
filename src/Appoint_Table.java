
import java.awt.Font;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class Appoint_Table extends javax.swing.JFrame {

    /**
     * Creates new form Appoint_Table
     */
    /*Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;*/
    public Appoint_Table() {
        initComponents();
        setIcon();
       // conn=javaconnect.ConnectDB();
         Update_Appo();
                           appo_table.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 12));

    }
     public void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-nonetext.png")));
    }
    
    public void Update_Appo()
    {
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        {
            String sql="select Patient_ID,First_Name,Last_Name,Address,Contact,Doctor_Appoint,Doctor_ID,Set_Date,Set_Time from Appointment_table order by Set_Date";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            appo_table.setModel(DbUtils.resultSetToTableModel(rs));
           // rs=pst.executeQuery();

        }
         catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null,e+"\nConnection Error\nplease check..");
         }
        finally
        {
            try
            {
              if(rs!=null)
              {
                  rs.close();
                  
              }
              if(pst!=null)
              {
                  pst.close();
              }
              if(conn!=null)
              {
                  conn.close();
              }
            }
            catch(SQLException ex)
            {
               JOptionPane.showMessageDialog(null, ex);
            }
        }
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appo_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pi_patient_id = new javax.swing.JTextField();
        pi_doctor_id = new javax.swing.JTextField();
        pi_appoint = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pi_first_name_ = new javax.swing.JTextField();
        pi_last_name = new javax.swing.JTextField();
        pi_address = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pi_contact = new javax.swing.JTextField();
        pi_set_date = new javax.swing.JTextField();
        pi_set_time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Appointment Details");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 190, 170);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("<< Back");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1200, 30, 130, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Patient Details");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(190, 20, 560, 170);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hospital-Top-Slider-Image.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 20, 1190, 170);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel2.setLayout(null);

        appo_table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        appo_table.setForeground(new java.awt.Color(0, 102, 102));
        appo_table.setModel(new javax.swing.table.DefaultTableModel(
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
        appo_table.setRowHeight(30);
        appo_table.setRowMargin(2);
        appo_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appo_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appo_table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(6, 46, 860, 500);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Patient Info");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(900, 30, 430, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Patient ID");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(900, 90, 100, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Doctor ID");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(1060, 90, 110, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Patient Appoint");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(1200, 90, 140, 30);

        pi_patient_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_patient_id);
        pi_patient_id.setBounds(890, 140, 130, 30);

        pi_doctor_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_doctor_id);
        pi_doctor_id.setBounds(1050, 140, 130, 30);

        pi_appoint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_appoint);
        pi_appoint.setBounds(1200, 140, 160, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("First Name");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(900, 210, 110, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Last Name");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(1064, 210, 120, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Address");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(1220, 210, 100, 30);

        pi_first_name_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_first_name_);
        pi_first_name_.setBounds(890, 260, 130, 30);

        pi_last_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_last_name);
        pi_last_name.setBounds(1049, 260, 140, 30);

        pi_address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_address);
        pi_address.setBounds(1210, 260, 150, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Contact");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(910, 340, 120, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Set Date");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(1070, 340, 120, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Set Time");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(1220, 340, 130, 30);

        pi_contact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_contact);
        pi_contact.setBounds(890, 390, 150, 30);

        pi_set_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_set_date);
        pi_set_date.setBounds(1060, 390, 130, 30);

        pi_set_time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(pi_set_time);
        pi_set_time.setBounds(1209, 390, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        //close();
        new Appointment_hm().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void appo_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appo_tableMouseClicked
        // TODO add your handling code here:
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        {
            int row=appo_table.getSelectedRow();
            String Table_click=(appo_table.getModel().getValueAt(row,0).toString());
            String sql="select * from Appointment_table where Patient_ID='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String a=rs.getString("Patient_ID");
                pi_patient_id.setText(a);
                String b=rs.getString("First_Name");
                pi_first_name_.setText(b);
                String c=rs.getString("Last_Name");
                pi_last_name.setText(c);
                String d=rs.getString("Address");
                pi_address.setText(d);
                String e=rs.getString("Contact");
                pi_contact.setText(e);
                String f=rs.getString("Doctor_Appoint");
                pi_appoint.setText(f);
                String g=rs.getString("Doctor_ID");
                pi_doctor_id.setText(g);
                String h=rs.getString("Set_Date");
                pi_set_date.setText(h);
                String i=rs.getString("Set_Time");
                pi_set_time.setText(i);
                
            }
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e+"\nConnection Error\nplease check..");
        }
         finally
        {
            try
            {
              if(rs!=null)
              {
                  rs.close();
                  
              }
              if(pst!=null)
              {
                  pst.close();
              }
              if(conn!=null)
              {
                  conn.close();
              }
            }
            catch(SQLException ex)
            {
               JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_appo_tableMouseClicked

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
            java.util.logging.Logger.getLogger(Appoint_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appoint_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appoint_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appoint_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appoint_Table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appo_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pi_address;
    private javax.swing.JTextField pi_appoint;
    private javax.swing.JTextField pi_contact;
    private javax.swing.JTextField pi_doctor_id;
    private javax.swing.JTextField pi_first_name_;
    private javax.swing.JTextField pi_last_name;
    private javax.swing.JTextField pi_patient_id;
    private javax.swing.JTextField pi_set_date;
    private javax.swing.JTextField pi_set_time;
    // End of variables declaration//GEN-END:variables
}
