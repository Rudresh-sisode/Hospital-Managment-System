/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class Change_Password extends javax.swing.JFrame {
/*Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;*/
    String point="";
     Logine_Frame access=new Logine_Frame();
    /**
     * Creates new form Change_Password
     */
    public Change_Password() {
        initComponents();
       // conn=javaconnect.ConnectDB();
        point=access.users_id;
       // System.out.println("constructor point si\t"+point);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        C_pass = new javax.swing.JPasswordField();
        E_pass = new javax.swing.JPasswordField();
        N_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        user_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Change Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Conform Password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 160, 28));

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("User Login");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 100, 28));

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("New Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, 28));

        jButton1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 120, 30));

        C_pass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(C_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 220, 25));

        E_pass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(E_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 220, 25));

        N_pass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(N_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 220, 25));

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Exist Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 28));
        jPanel1.add(user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 220, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Epass=E_pass.getText();
        String Npass=N_pass.getText();
        String Cpass=C_pass.getText();
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
      conn=javaconnect.ConnectDB();
       try
       {
          
           if(E_pass.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Fill Exist Password first");
               
           }
           else  if(N_pass.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Fill New Password Password first");
               
           }
           else  if(C_pass.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Fill Conform Password first");
               
           }
            else
           {
           //String a=rs.getString("user_id");
               if(N_pass.getText().equals(C_pass.getText()))
               {
              
         String sql="update Admin set user_password='"+Cpass+"' where user_id='"+user_id.getText()+"'";
         
             pst=conn.prepareStatement(sql);
             int C=JOptionPane.showConfirmDialog(null,"Do you want to Really Save?","Conform Save",JOptionPane.YES_NO_OPTION);
              if(C==0)
              {
                   pst.execute();
                   JOptionPane.showMessageDialog(null, "Update Successfully");
                   new Logine_Frame().setVisible(true);
              }
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Password not Match");
               }
           }
       }
       catch(HeadlessException | SQLException ex)
       {
           JOptionPane.showMessageDialog(null, ex);
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
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField C_pass;
    private javax.swing.JPasswordField E_pass;
    private javax.swing.JPasswordField N_pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField user_id;
    // End of variables declaration//GEN-END:variables
}