
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Hospital_bill_1 extends javax.swing.JFrame {

    /**
     * Creates new form Hospital_bill_1
     */
    String a="";
    String b="";
    String c="";
    String d="";
    String e="";
    String f="";
                                                    
    String g="";
    String h="";
    String i="";
    String j="";
    String k="";
    String l="";
    String m="";
    String n="";
    String o="";
    
            
            
    public Hospital_bill_1() {
        initComponents();
        printingbill();
    }
    public Hospital_bill_1(String a,String b)
    {
       initComponents();
        
        Inpatient(a);
        printingbill(); 
    }
   
    public void Inpatient(String abc)
    {
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        { 
            String sql="select Patient_ID,First_Name,Last_Name,Address,DOA,DOD from In_Patient where Patient_ID='"+abc+"'";
             pst=conn.prepareStatement(sql);
          
           rs=pst.executeQuery();
           if(rs.next())
           {
               /*String pid=rs.getString("Patient_ID");
               
               print_id.setText(pid);
               String a=rs.getString("First_Name");
              */
               a=rs.getString("Patient_ID");
               System.out.println("Patient id is\t"+a);
                       
               b=rs.getString("First_Name");
               
               c=rs.getString("Last_Name");
               
               d=rs.getString("Address");
               
               e=rs.getString("DOA");
               
               f=rs.getString("DOD");
               
            
               
           }
          
        }
        catch(SQLException ex)
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
    }
    public void Bill_show(String bill)
    {
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        {
            String sql="select Bill_No,Doctor_Charge,Room_Charge,Operation_Charge,Admit_days,Nursing_Charge,Injection_Charge,CheckUp_Charge,Total from Billing where Bill_No='"+bill+"'";
             pst=conn.prepareStatement(sql);
          
           rs=pst.executeQuery();
           if(rs.next())
           {
               g=rs.getString("Bill_No");
               
                h=rs.getString("Doctor_Charge");
                
                 i=rs.getString("Room_Charge");
                 
                  j=rs.getString("Operation_Charge");
                  
                   k=rs.getString("Admit_days");
                   
                    l=rs.getString("Nursing_Charge");
                    
                     m=rs.getString("Injection_Charge");
                     
                      n=rs.getString("CheckUp_Charge");
                      
                       o=rs.getString("Total");
               
               
           }
        }
        catch(SQLException ex)
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
    }
     public void printingbill()
    {
        Calendar call=new GregorianCalendar();
        int month=call.get(Calendar.MONTH);
        int year=call.get(Calendar.YEAR);
        int day=call.get(Calendar.DAY_OF_MONTH);
        //txt_date.setText("Date-"+day+"/"+(month+1)+"/"+year);
        txt_print_bill.append("\t/-/-/-/-/ XYZ HOSPITAL /-/-/-/-/\n"+
                
                "\n Patient ID\t"+a+"\t\tDate "+day+"/"+(month+1)+"/"+year+
                "\n Patient Name\t"+b+" "+c+
                "\n Patient Type\t"+d+
                "\n Date of Admitted\t"+e+
                "\n Date of Discharge\t"+f+
                
                "\n\n\n    Type\t\t   Amounts"+
                 "\n-----------------------------------------------------------------------"+       
                 "\n\n* Bill No\t\t"+g+
                "\n\n* Dr.Charge\t\t"+h+
                "\n\n* Room Charge\t\t"+i+
                "\n\n* Operation Charge\t\t"+j+
                "\n\n* Admit Days\t\t"+k+
                "\n\n* Nursing Charge\t\t"+l+
                "\n\n* Injection Charge\t\t"+m+
                "\n\n* CheckUp Charge\t\t"+n+
                "\n-----------------------------------------------------------------------"+
                "\n\n\t\tTotal\t  "+o+
                 "\n-----------------------------------------------------------------------"
                
        
        
        
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_print_bill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_print_bill.setEditable(false);
        txt_print_bill.setColumns(20);
        txt_print_bill.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txt_print_bill.setRows(5);
        jScrollPane1.setViewportView(txt_print_bill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 690));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 60, 60));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ThisPrint.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 60, 60));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            txt_print_bill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Hospital_bill_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Origine().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Hospital_Bill().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Hospital_bill_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hospital_bill_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hospital_bill_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hospital_bill_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hospital_bill_1().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea txt_print_bill;
    // End of variables declaration//GEN-END:variables
}
