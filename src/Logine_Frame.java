/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Logine_Frame extends javax.swing.JFrame {
 /*Connection conn=null;
 ResultSet rs=null;
 PreparedStatement pst=null;*/
 String users_id="";
 GraphicsDevice vc;

    /**
     * Creates new form 
     */
    public Logine_Frame() {
        initComponents();
        setIcon();
       // conn=javaconnect.ConnectDB();
        FullScreen();
        
	
	//Initialize the vc with the Screen Device
	
        
       // jButton1.setEnabled(false);
    }
    public void FullScreen(){
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc=ge.getDefaultScreenDevice();
	}	
        
    public void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-nonetext.png")));
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_user_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_user_pass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login_Window", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Submit");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 118, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/person-icon.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, 140));

        txt_user_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_user_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_user_idFocusGained(evt);
            }
        });
        txt_user_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_user_idActionPerformed(evt);
            }
        });
        txt_user_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_user_idKeyTyped(evt);
            }
        });
        jPanel1.add(txt_user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 148, 213, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Register-icon.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 140, 120));

        txt_user_pass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_user_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_user_passKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_user_passKeyTyped(evt);
            }
        });
        jPanel1.add(txt_user_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 213, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Book Antiqua", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Change Password");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 150, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aaaaa.jpg"))); // NOI18N
        jLabel7.setText("     ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -160, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 190, 170);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Welcome in Login");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(200, 40, 530, 130);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hospital-Top-Slider-Image.jpg"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(170, 20, 1200, 170);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, Short.MAX_VALUE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection conn=null;
 ResultSet rs=null;
 PreparedStatement pst=null;
  conn=javaconnect.ConnectDB();
        String sql="select * from Admin where user_id=? and user_password=?";
        try
        {
            String st=txt_user_id.getText();
            String st2=txt_user_pass.getText();
            if(st.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "User Name is Empty");
                
            }
            else if(st2.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Password is Empty");
            }
            else
            {
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt_user_id.getText());
                       pst.setString(2,txt_user_pass.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                
              
                
                dispose();
                Origine sh=new Origine();
                sh.setVisible(true);
              
                
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"User_Name and passwoed is not correct");
                txt_user_id.setText("");
                txt_user_pass.setText("");
            }
            }
        }
        catch(HeadlessException | SQLException e)
        {
             JOptionPane.showMessageDialog(null,e);
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

    private void txt_user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_user_idActionPerformed
        // TODO add your handling code here:
        
              
    }//GEN-LAST:event_txt_user_idActionPerformed

    private void txt_user_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_user_idKeyTyped
        // TODO add your handling code here:
        if (!txt_user_id.getText().equals("")) {
            jButton1.setEnabled(true);
} else {
            jButton1.setEnabled(false);
}
        
    }//GEN-LAST:event_txt_user_idKeyTyped

    private void txt_user_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_user_passKeyTyped
        // TODO add your handling code here:
          if (!txt_user_pass.getText().equals("")) {
            jButton1.setEnabled(true);
} else {
            jButton1.setEnabled(false);
}
        
    }//GEN-LAST:event_txt_user_passKeyTyped

    private void txt_user_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_user_passKeyPressed
        // TODO add your handling code here:
        Connection conn=null;
 ResultSet rs=null;
 PreparedStatement pst=null;
  conn=javaconnect.ConnectDB();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            String sql="select * from Admin where user_id=? and user_password=?";
        try
        {
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt_user_id.getText());
            pst.setString(2,txt_user_pass.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"User_name and password is correct");
               
                
                dispose();
                Origine sh=new Origine();
                sh.setVisible(true);
                
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"User_Name and passwoed is not correct");
                txt_user_id.setText("");
                txt_user_pass.setText("");
            }
        }
        catch(HeadlessException | SQLException e)
        {
             JOptionPane.showMessageDialog(null,e);
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
        
    }//GEN-LAST:event_txt_user_passKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection conn=null;
 ResultSet rs=null;
 PreparedStatement pst=null;
  conn=javaconnect.ConnectDB();
         String sql="select * from Admin where user_id=? and user_password=?";
        try
        {
            String st=txt_user_id.getText();
            String st2=txt_user_pass.getText();
            if(st.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "User Name is Empty");
                
            }
            else if(st2.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Password is Empty");
            }
            else
            {
            pst=conn.prepareStatement(sql);
            pst.setString(1,txt_user_id.getText());
           
            pst.setString(2,txt_user_pass.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                
                
                dispose();
                Change_Password sh=new Change_Password();
                sh.setVisible(true);
                
                
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"User_Name and passwoed is not correct");
                txt_user_id.setText("");
                txt_user_pass.setText("");
            }
            }
        }
        catch(HeadlessException | SQLException e)
        {
             JOptionPane.showMessageDialog(null,e);
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
       
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_user_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusGained
        // TODO add your handling code here:
      
         
       
    }//GEN-LAST:event_txt_user_idFocusGained

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
            java.util.logging.Logger.getLogger(Logine_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logine_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logine_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logine_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logine_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_user_id;
    private javax.swing.JPasswordField txt_user_pass;
    // End of variables declaration//GEN-END:variables
}