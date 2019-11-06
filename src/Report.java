

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;

import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.awt.print.*;



import net.proteanit.sql.DbUtils;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Report extends javax.swing.JFrame {
    /*Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    */

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        //conn=javaconnect.ConnectDB();
        setIcon();
        Update_patient_table();
        Update_O_B();
        Update_In_patient();
        Update_Billing();
         Update_Appoint();
          opd_table.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 12));
          opb_table.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 12));
          in_patient_table.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 12));
          in_patient_bill.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 12));
          Appointment.getTableHeader().setFont(new Font("Tohoma", Font.BOLD, 12));

    }
    public void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-nonetext.png")));
    }
    public void Update_patient_table()
    {
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
            /*
            update table
            */
         String sql="select * from Patient_table order by Date";
            //String sql="select * from Billing order by Bill_No";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            opd_table.setModel(DbUtils.resultSetToTableModel(rs));
           // rs=pst.executeQuery();

        }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null,"Exception 8 "+e);
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
    public void Update_Billing()
    {
        /*
        billing table
        */
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
         String sql="select Bill_No,Patient_ID,Patient_Name,Patient_Type,Doctor_Charge,Room_Charge,Operation_Charge,Admit_days,Nursing_Charge,Injection_Charge,CheckUp_Charge,Total,Date from Billing order by Date";
            //String sql="select * from Billing order by Bill_No";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            in_patient_bill.setModel(DbUtils.resultSetToTableModel(rs));
           // rs=pst.executeQuery();

        }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null,"Exception 8 "+e);
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
    public void Update_Appoint()
    {
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        
        try
        {
         String sql="select * from Appointment_table order by Set_Time";
            //String sql="select * from Billing order by Bill_No";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Appointment.setModel(DbUtils.resultSetToTableModel(rs));
           // rs=pst.executeQuery();

        }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null,"Exception 8 "+e);
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
    public void Update_In_patient()
    {
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
         String sql="select Patient_ID,First_Name,Last_Name,Gender,Age,Weight,DOB,Mobile,Address,Live_with,DOA,DOD,Room_no,Treatment_By from In_Patient order by DOA";
            //String sql="select * from Billing order by Bill_No";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            in_patient_table.setModel(DbUtils.resultSetToTableModel(rs));
           // rs=pst.executeQuery();

        }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null,"Exception 8 "+e);
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

    public void Update_O_B()
    {
        /*
        completed
        ordinaty patient bill
        */
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
         String sql="select * from Oridinary_Bill order by Date";
            //String sql="select * from Billing order by Bill_No";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            opb_table.setModel(DbUtils.resultSetToTableModel(rs));
           // rs=pst.executeQuery();

        }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null,"Exception 8 "+e);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        opd_table = new javax.swing.JTable();
        view_all = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        opb_table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        in_patient_table = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        in_patient_bill = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        Appointment = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Report");
        setSize(new java.awt.Dimension(700, 700));

        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("View a Desire Report");
        jLabel2.setToolTipText("view your report here");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 310, 52);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("From");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 80, 80, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("To");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(670, 80, 34, 30);

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(430, 80, 200, 30);

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(760, 80, 180, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("View");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1020, 80, 100, 35);

        opd_table.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        opd_table.setModel(new javax.swing.table.DefaultTableModel(
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
        opd_table.setRowHeight(20);
        opd_table.setRowMargin(2);
        jScrollPane2.setViewportView(opd_table);

        jScrollPane1.setViewportView(jScrollPane2);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 130, 1350, 520);

        view_all.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_all.setForeground(new java.awt.Color(0, 102, 102));
        view_all.setText("View All");
        view_all.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });
        jPanel1.add(view_all);
        view_all.setBounds(20, 83, 110, 40);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 102));
        jButton6.setText("Print");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(1153, 80, 100, 35);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home-icon.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(1270, 10, 60, 60);

        jTabbedPane1.addTab("Ordinary Patient", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("View a Desire Report");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 20, 310, 52);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("From");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(330, 80, 80, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("To");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(670, 80, 34, 30);

        jDateChooser3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jDateChooser3);
        jDateChooser3.setBounds(430, 80, 200, 30);

        jDateChooser4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(jDateChooser4);
        jDateChooser4.setBounds(760, 80, 180, 30);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N

        opb_table.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        opb_table.setModel(new javax.swing.table.DefaultTableModel(
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
        opb_table.setRowHeight(30);
        opb_table.setRowMargin(2);
        jScrollPane3.setViewportView(opb_table);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(2, 130, 1370, 520);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("View");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(1020, 80, 100, 35);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 102));
        jButton7.setText("View All");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(20, 83, 110, 40);

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 102, 102));
        jButton12.setText("Print");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(1153, 80, 100, 35);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home-icon.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16);
        jButton16.setBounds(1270, 10, 60, 60);

        jTabbedPane1.addTab("O.P.Bill", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("View a Desire Report");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 20, 310, 52);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("From");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(330, 80, 80, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("To");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(670, 80, 50, 30);

        jDateChooser5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jDateChooser5);
        jDateChooser5.setBounds(430, 80, 200, 30);

        jDateChooser6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel3.add(jDateChooser6);
        jDateChooser6.setBounds(760, 80, 180, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("View");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(1020, 80, 100, 35);

        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N

        in_patient_table.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        in_patient_table.setModel(new javax.swing.table.DefaultTableModel(
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
        in_patient_table.setRowHeight(30);
        in_patient_table.setRowMargin(0);
        jScrollPane6.setViewportView(in_patient_table);

        jScrollPane7.setViewportView(jScrollPane6);

        jPanel3.add(jScrollPane7);
        jScrollPane7.setBounds(0, 130, 1370, 510);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 102));
        jButton8.setText("View All");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(20, 83, 110, 40);

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 102, 102));
        jButton13.setText("Print");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13);
        jButton13.setBounds(1153, 80, 100, 35);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home-icon.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17);
        jButton17.setBounds(1270, 10, 60, 60);

        jTabbedPane1.addTab("IN Patient", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("View a Desire Report");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(10, 20, 310, 52);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("From");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(330, 80, 80, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("To");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(670, 80, 34, 30);

        jDateChooser7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jDateChooser7);
        jDateChooser7.setBounds(430, 80, 200, 30);

        jDateChooser8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jDateChooser8);
        jDateChooser8.setBounds(760, 80, 180, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 102));
        jButton4.setText("View");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(1020, 80, 100, 35);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N

        in_patient_bill.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        in_patient_bill.setModel(new javax.swing.table.DefaultTableModel(
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
        in_patient_bill.setRowHeight(30);
        in_patient_bill.setRowMargin(2);
        jScrollPane4.setViewportView(in_patient_bill);

        jScrollPane5.setViewportView(jScrollPane4);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(0, 130, 1370, 510);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 102, 102));
        jButton9.setText("View All");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9);
        jButton9.setBounds(20, 83, 110, 40);

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 102, 102));
        jButton14.setText("Print");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14);
        jButton14.setBounds(1153, 80, 100, 35);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home-icon.png"))); // NOI18N
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton18);
        jButton18.setBounds(1270, 10, 60, 60);

        jTabbedPane1.addTab("IN Patient Bill", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("View a Desire Report");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(10, 20, 310, 52);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("From");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(330, 80, 80, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("To");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(670, 80, 34, 30);

        jDateChooser9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel5.add(jDateChooser9);
        jDateChooser9.setBounds(760, 80, 180, 30);

        jDateChooser10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel5.add(jDateChooser10);
        jDateChooser10.setBounds(430, 80, 200, 30);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 102));
        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5);
        jButton5.setBounds(1020, 80, 100, 35);

        jScrollPane9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N

        Appointment.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        Appointment.setModel(new javax.swing.table.DefaultTableModel(
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
        Appointment.setRowHeight(30);
        Appointment.setRowMargin(2);
        jScrollPane8.setViewportView(Appointment);

        jScrollPane9.setViewportView(jScrollPane8);

        jPanel5.add(jScrollPane9);
        jScrollPane9.setBounds(0, 130, 1350, 510);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 102, 102));
        jButton10.setText("View All");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(20, 83, 110, 40);

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 102, 102));
        jButton15.setText("Print");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton15);
        jButton15.setBounds(1153, 80, 100, 35);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home-icon.png"))); // NOI18N
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton19);
        jButton19.setBounds(1270, 10, 60, 60);

        jTabbedPane1.addTab("Appointment", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        /*
        Appointment view all
        */
        try
        {
            Update_Appoint();
            
        }
        catch(Exception ex)
        {
            
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        /*
        in patient bill
        */
        try
        {
        Update_Billing();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        /*
        in patient table
        */
        try
        {
            
        
        Update_In_patient();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        /*
        ordianry patient bill
        */
        try
        {
        Update_O_B();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
        // TODO add your handling code here:/*
        /*
        ordinary patient table
        */
        try
        {
            
        
        Update_patient_table();
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_view_allActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*
        ordinary patient
        */
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
            if(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Select Date First");
            }
            else if(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Selected Date First");
            }
            else
            {
            String sql="select * from Patient_table where Date between'"+ ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText()+"'and'"+((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText()+"'order by Date desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            opd_table.setModel(DbUtils.resultSetToTableModel(rs));
            }   
        }
        catch(Exception ex)
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        /* PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName("  ");

    Printable printable = new Printable() {

            public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                    }

                    Dimension size = jScrollPane1.getSize();
                    BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

                    jScrollPane1.print(bufferedImage.getGraphics());

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);
                   // System.out.println("pd.getWidth is\t"+pf.getWidth()+"\nand pf.getHeightis\t"+pf.getHeight());
                    return Printable.PAGE_EXISTS;
            }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0,700,890);
    paper.setSize(800,890);

    PageFormat format = new PageFormat();
    format.setPaper(paper);
    format.setOrientation(PageFormat.PORTRAIT);

    printjob.setPrintable(printable, format);
    if (printjob.printDialog() == false)
            return;

    try {
            printjob.print();
    } catch (PrinterException ex) {
            System.out.println("NO PAGE FOUND." + ex);
    }

            
                
*/
        MessageFormat header=new MessageFormat("Report print");       
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try
        {
            opd_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
          dispose();
        new Origine().setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
         try
        {
            if(((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Select Date First");
            }
            else if(((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Selected Date First");
            }
            else
            {
            String sql="select * from Oridinary_Bill where Date between'"+ ((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText()+"'and'"+((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText()+"'order by Date desc";
           pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            opb_table.setModel(DbUtils.resultSetToTableModel(rs));
            }   
        }
        catch(Exception ex)
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
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
            if(((JTextField)jDateChooser5.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Select Date First");
            }
            else if(((JTextField)jDateChooser6.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Selected Date First");
            }
            else
            {
                String a=((JTextField)jDateChooser5.getDateEditor().getUiComponent()).getText();
                String b=((JTextField)jDateChooser6.getDateEditor().getUiComponent()).getText();
            String sql="select Patient_ID,First_Name,Last_Name,Gender,Age,Weight,DOB,Mobile,Address,Live_with,DOA,DOD,Room_no,Treatment_By from In_Patient where DOA between'"+a+"'and'"+b+"'order by DOA desc";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            in_patient_table.setModel(DbUtils.resultSetToTableModel(rs));
            }   
        }
        catch(Exception ex)
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        /*
        inPatient bill
        */
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
        try
        {
            if(((JTextField)jDateChooser7.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Select Date First");
            }
            else if(((JTextField)jDateChooser8.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Selected Date First");
            }
            else
            {
           // String sql="select Patient_ID,First_Name,Last_Name,Gender,Age,Weight,DOB,Mobile,Address,Live_with,DOA,DOD,Room_no,Treatment_By from In_Patient where DOA between'"+ ((JTextField)jDateChooser5.getDateEditor().getUiComponent()).getText()+"'and'"+((JTextField)jDateChooser6.getDateEditor().getUiComponent()).getText()+"'order by DOA desc";
             String sql="select Bill_No,Patient_ID,Patient_Name,Patient_Type,Doctor_Charge,Room_Charge,Operation_Charge,Admit_days,Nursing_Charge,Injection_Charge,CheckUp_Charge,Total,Date from Billing where Date between'"+ ((JTextField)jDateChooser7.getDateEditor().getUiComponent()).getText()+"'and'"+ ((JTextField)jDateChooser8.getDateEditor().getUiComponent()).getText()+"'";
             pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            in_patient_bill.setModel(DbUtils.resultSetToTableModel(rs));
            }   
        }
        catch(Exception ex)
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        /*
        last
        */
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    conn=javaconnect.ConnectDB();
          try
        {
            if(((JTextField)jDateChooser10.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Select Date First");
            }
            else if(((JTextField)jDateChooser9.getDateEditor().getUiComponent()).getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Selected Date First");
            }
            else
            {
            String sql="select * from Appointment_table where Set_Date between'"+ ((JTextField)jDateChooser10.getDateEditor().getUiComponent()).getText()+"'and'"+((JTextField)jDateChooser9.getDateEditor().getUiComponent()).getText()+"'order by Set_Date desc";
             pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Appointment.setModel(DbUtils.resultSetToTableModel(rs));
            }   
        }
        catch(Exception ex)
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        /* PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName("  ");

    Printable printable = new Printable() {

            public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                    }

                    Dimension size = jScrollPane3.getSize();
                    BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

                    jScrollPane3.print(bufferedImage.getGraphics());

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

                    return Printable.PAGE_EXISTS;
            }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0,700,890);
    paper.setSize(800,890);

    PageFormat format = new PageFormat();
    format.setPaper(paper);
    format.setOrientation(PageFormat.LANDSCAPE);

    printjob.setPrintable(printable, format);
    if (printjob.printDialog() == false)
            return;

    try {
            printjob.print();
    } catch (PrinterException ex) {
            System.out.println("NO PAGE FOUND." + ex);
    }*/
         MessageFormat header=new MessageFormat("Report print");       
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try
        {
            opd_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
           
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
          /*PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName("  ");

    Printable printable = new Printable() {

            public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                    }

                    Dimension size = jScrollPane7.getSize();
                    BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

                    jScrollPane7.print(bufferedImage.getGraphics());

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

                    return Printable.PAGE_EXISTS;
            }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0,700,890);
    paper.setSize(800,890);

    PageFormat format = new PageFormat();
    format.setPaper(paper);
    format.setOrientation(PageFormat.LANDSCAPE);

    printjob.setPrintable(printable, format);
    if (printjob.printDialog() == false)
            return;

    try {
            printjob.print();
    } catch (PrinterException ex) {
            System.out.println("NO PAGE FOUND." + ex);
    }*/
           MessageFormat header=new MessageFormat("Report print");       
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try
        {
            in_patient_table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        /*PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName("  ");

    Printable printable = new Printable() {

            public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                    }

                    Dimension size = jScrollPane5.getSize();
                    BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

                    jScrollPane5.print(bufferedImage.getGraphics());

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

                    return Printable.PAGE_EXISTS;
            }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0,700,890);
    paper.setSize(800,890);

    PageFormat format = new PageFormat();
    format.setPaper(paper);
    format.setOrientation(PageFormat.LANDSCAPE);

    printjob.setPrintable(printable, format);
    if (printjob.printDialog() == false)
            return;

    try {
            printjob.print();
    } catch (PrinterException ex) {
            System.out.println("NO PAGE FOUND." + ex);
    }*/
        MessageFormat header=new MessageFormat("Report print");       
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try
        {
            in_patient_bill.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
         /* PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName("  ");

    Printable printable = new Printable() {

            public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                    }

                    Dimension size = jScrollPane9.getSize();
                    BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

                    jScrollPane9.print(bufferedImage.getGraphics());

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

                    return Printable.PAGE_EXISTS;
            }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0,700,890);
    paper.setSize(800,890);

    PageFormat format = new PageFormat();
    format.setPaper(paper);
    format.setOrientation(PageFormat.LANDSCAPE);

    printjob.setPrintable(printable, format);
    if (printjob.printDialog() == false)
            return;

    try {
            printjob.print();
    } catch (PrinterException ex) {
            System.out.println("NO PAGE FOUND." + ex);
    }*/
          MessageFormat header=new MessageFormat("Report print");       
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try
        {
            Appointment.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Origine().setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Origine().setVisible(true);
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Origine().setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Origine().setVisible(true);
    }//GEN-LAST:event_jButton19ActionPerformed

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Appointment;
    private javax.swing.JTable in_patient_bill;
    private javax.swing.JTable in_patient_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable opb_table;
    private javax.swing.JTable opd_table;
    private javax.swing.JButton view_all;
    // End of variables declaration//GEN-END:variables
}
