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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.print.attribute.*; 
import javax.print.attribute.standard.*; 

public class Printing extends javax.swing.JFrame  {
   /* Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;*/
    Hospital_Bill acc=new Hospital_Bill();
    String cc="";
    

    /**
     * Creates new form Printing
     */
    public Printing() {
        initComponents();
        setIcon();
        //conn=javaconnect.ConnectDB();
        
      
       
    
     
        Currect_Date();
       
        
    }
   public Printing(String a,String b)
   {
      
        initComponents();
      
       // conn=javaconnect.ConnectDB();
          Inpatient(a);
          Bill_show(b);
            setIcon();
        
        Currect_Date();
   }
 
    public void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-nonetext.png")));
    }
    /*public Printing(String ac)
    {
        initComponents();
          conn=javaconnect.ConnectDB();
           setIcon();
       
    }*/
    public void Inpatient(String abc)
    {
         Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        { 
            String sql="select Patient_ID,First_Name,Last_Name,Address,Treatment_By,Mobile,DOB,Gender,Live_with,DOA,DOD,Images from In_Patient where Patient_ID='"+abc+"'";
             pst=conn.prepareStatement(sql);
          
           rs=pst.executeQuery();
           if(rs.next())
           {
               String pid=rs.getString("Patient_ID");
               
               print_id.setText(pid);
               String a=rs.getString("First_Name");
               String b=rs.getString("Last_Name");
               print_name.setText(a+" "+b);
               String c=rs.getString("Address");
               print_address.setText(c);
               String d=rs.getString("Mobile");
               print_mobile.setText(d);
               String e=rs.getString("DOB");
               print_dob.setText(e);
               String f=rs.getString("Gender");
               print_gender.setText(f);
               String g=rs.getString("Live_with");
               print_gardian.setText(g);
               String h=rs.getString("DOA");
               print_doa.setText(h);
               String i=rs.getString("DOD");
               print_dod.setText(i); 
                byte[] bi=rs.getBytes("Images"); 
                ImageIcon image=new ImageIcon(bi);
                Image mi=image.getImage();
                Image myimg=mi.getScaledInstance(image_icon_print.getWidth(),image_icon_print.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(myimg);
                image_icon_print.setIcon(newIcon);
            image_icon_print.revalidate();
            String j=rs.getString("Treatment_By");
            print_treatment.setText(j);
            
               
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
               String a=rs.getString("Bill_No");
               bill_search_print.setText(a);
               String b=rs.getString("Doctor_Charge");
               doctor_charge.setText(b);
               String c=rs.getString("Room_Charge");
               room_charge.setText(c);
               String d=rs.getString("Operation_Charge");
               opration_charge.setText(d);
               String e=rs.getString("Admit_days");
               admit_days.setText(e);
               String f=rs.getString("Nursing_Charge");
               nursing_charge.setText(f);
               String g=rs.getString("Injection_Charge");
               injection_charge.setText(g);
               String h=rs.getString("CheckUp_Charge");
               check_bill.setText(h);
               String i=rs.getString("Total");
               print_b_total.setText(i);
               
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
    public void Currect_Date()
    {
        Calendar call=new GregorianCalendar();
        int month=call.get(Calendar.MONTH);
        int year=call.get(Calendar.YEAR);
        int day=call.get(Calendar.DAY_OF_MONTH);
        txt_date.setText("Date-"+day+"/"+(month+1)+"/"+year);
    }
   
   /* public void Show_Patient_Data()
    {
        try
        {
            String sql="select First_Name,Last_Name,Gender,DOB,DOA,DOD,Address,Mobile from In_Patient where Patient_ID='"+acc.b_id+"'";
             pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            { 
              /* String a=rs.getString("Patient_ID");
               print_id.setText(a);
                
                String a=rs.getString("First_Name");
                String b=rs.getString("Last_Name");
                print_id.setText(a+" "+b);
                String c=rs.getString("Gender");
                print_gender.setText(c);
                String d=rs.getString("Mobile");
                print_mobile.setText(d);
                String e=rs.getString("DOB");
                print_dob.setText(e);
                String f=rs.getString("DOA");
                print_doa.setText(f);
                String g=rs.getString("DOD");
                print_dod.setText(g);
                print_name.setText((acc.b_id).toString());
                
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"some errer occured  "+ e);
        }
        finally
        {
            try
            {
                rs.close();
                pst.close();
                
            }
            catch(Exception ex)
            {
                
            }
        }
        
    }
    public void Show_Bill_Data()
    {
        
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        print_table = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        image_icon_print = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bill_search_print = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        print_address = new javax.swing.JTextField();
        print_id = new javax.swing.JTextField();
        print_treatment = new javax.swing.JTextField();
        print_mobile = new javax.swing.JTextField();
        print_dob = new javax.swing.JTextField();
        print_gender = new javax.swing.JTextField();
        print_gardian = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        print_dod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        print_b_total = new javax.swing.JTextField();
        doctor_charge = new javax.swing.JTextField();
        room_charge = new javax.swing.JTextField();
        opration_charge = new javax.swing.JTextField();
        admit_days = new javax.swing.JTextField();
        nursing_charge = new javax.swing.JTextField();
        injection_charge = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        print_doa = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        print_name = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        check_bill = new javax.swing.JTextField();
        txt_date = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admit Patient  Bill");

        print_table.setBackground(new java.awt.Color(255, 255, 255));
        print_table.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Bill Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N
        print_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setLayer(image_icon_print, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image_icon_print, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image_icon_print, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        print_table.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 80, 160, 170));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Personl Detail");
        print_table.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 250, 48));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Enter Bill No");
        print_table.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 120, 30));

        bill_search_print.setEditable(false);
        bill_search_print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bill_search_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_search_printActionPerformed(evt);
            }
        });
        bill_search_print.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bill_search_printKeyReleased(evt);
            }
        });
        print_table.add(bill_search_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 150, 32));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Patient Name");
        print_table.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Address");
        print_table.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Treatment By");
        print_table.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 319, 130, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Mobile");
        print_table.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 60, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("D.O.B");
        print_table.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 60, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Gender");
        print_table.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 70, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Guardians");
        print_table.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 100, 30));

        print_address.setEditable(false);
        print_address.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(print_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 258, 324, 30));

        print_id.setEditable(false);
        print_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                print_idKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                print_idKeyTyped(evt);
            }
        });
        print_table.add(print_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 140, 30));

        print_treatment.setEditable(false);
        print_treatment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_treatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_treatmentActionPerformed(evt);
            }
        });
        print_table.add(print_treatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 321, 213, 30));

        print_mobile.setEditable(false);
        print_mobile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(print_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 382, 213, 30));

        print_dob.setEditable(false);
        print_dob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(print_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 441, 213, 30));

        print_gender.setEditable(false);
        print_gender.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(print_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 502, 213, 30));

        print_gardian.setEditable(false);
        print_gardian.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(print_gardian, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 560, 213, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("D.O.D");
        print_table.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 610, 60, 30));

        print_dod.setEditable(false);
        print_dod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_dod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_dodActionPerformed(evt);
            }
        });
        print_table.add(print_dod, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 150, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Bill Info");
        print_table.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 150, 54));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("D.R Charge");
        print_table.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 120, 34));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Room Charge");
        print_table.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 150, 34));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Operation Charge");
        print_table.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 163, 34));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Admit Days");
        print_table.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 110, 34));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Nursing Charge");
        print_table.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 150, 34));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Injection Charge");
        print_table.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 163, 34));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("I.C.U Charge");
        print_table.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 120, 34));

        print_b_total.setEditable(false);
        print_b_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_b_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_b_totalActionPerformed(evt);
            }
        });
        print_table.add(print_b_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, 180, 30));

        doctor_charge.setEditable(false);
        doctor_charge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(doctor_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 190, 180, 30));

        room_charge.setEditable(false);
        room_charge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(room_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 250, 180, 30));

        opration_charge.setEditable(false);
        opration_charge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(opration_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 180, 30));

        admit_days.setEditable(false);
        admit_days.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(admit_days, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 180, 30));

        nursing_charge.setEditable(false);
        nursing_charge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(nursing_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 180, 30));

        injection_charge.setEditable(false);
        injection_charge.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        injection_charge.setAutoscrolls(false);
        print_table.add(injection_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 180, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("D.O.A");
        print_table.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 60, 30));

        print_doa.setEditable(false);
        print_doa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_doa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_doaActionPerformed(evt);
            }
        });
        print_table.add(print_doa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 160, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Patient ID");
        print_table.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, 30));

        print_name.setEditable(false);
        print_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print_table.add(print_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 191, 310, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Total");
        print_table.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 60, 40));

        check_bill.setEditable(false);
        check_bill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        check_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_billActionPerformed(evt);
            }
        });
        print_table.add(check_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, 180, 30));

        txt_date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_date.setForeground(new java.awt.Color(0, 102, 102));
        print_table.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 40, 200, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print-icon (1).png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close-icon (2).png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Refresh");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(print_table, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(964, 964, 964)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(print_table, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void print_treatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_treatmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print_treatmentActionPerformed

    private void bill_search_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_search_printActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_search_printActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*
        WE ARE GOING TO PRINT DATA HERE USING PRINTER
        */
       
         PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName("  ");

    Printable printable = new Printable() {

            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                            return Printable.NO_SUCH_PAGE;
                    }

                    Dimension size = print_table.getSize();
                    BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

                    print_table.print(bufferedImage.getGraphics());

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

                    return Printable.PAGE_EXISTS;
            }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0,700,890);
    paper.setSize(700,890);

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

    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void print_b_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_b_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print_b_totalActionPerformed

    private void print_dodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_dodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print_dodActionPerformed

    private void print_doaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_doaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print_doaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Hospital_Bill().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void check_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_billActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_billActionPerformed

    private void print_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_print_idKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_print_idKeyTyped

    private void print_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_print_idKeyReleased
        // TODO add your handling code here:
        /*
        here are perform operation 
        
        */
       /* try
        {
           String sql="select First_Name,Last_Name,Address,Treatment_By,Mobile,DOB,Gender,Live_with,DOA,DOD,Images from In_Patient where Patient_ID=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1,print_id.getText());
           rs=pst.executeQuery();
           if(rs.next())
           {
               String a=rs.getString("First_Name");
               String b=rs.getString("Last_Name");
               print_name.setText(a+" "+b);
               String c=rs.getString("Address");
               print_address.setText(c);
               String d=rs.getString("Mobile");
               print_mobile.setText(d);
               String e=rs.getString("DOB");
               print_dob.setText(e);
               String f=rs.getString("Gender");
               print_gender.setText(f);
               String g=rs.getString("Live_with");
               print_gardian.setText(g);
               String h=rs.getString("DOA");
               print_doa.setText(h);
               String i=rs.getString("DOD");
               print_dod.setText(i); 
                byte[] bi=rs.getBytes("Images"); 
                ImageIcon image=new ImageIcon(bi);
                Image mi=image.getImage();
                Image myimg=mi.getScaledInstance(image_icon_print.getWidth(),image_icon_print.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(myimg);
                image_icon_print.setIcon(newIcon);
            image_icon_print.revalidate();
            String j=rs.getString("Treatment_By");
            print_treatment.setText(j);
            
               
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
                rs.close();
                pst.close();
                
            }
            catch(Exception ea)
            {
                
            }
        }*/
    }//GEN-LAST:event_print_idKeyReleased

    private void bill_search_printKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_search_printKeyReleased
        // TODO add your handling code here:
        /*
        Here we also doing same as previous....
        for now, first we use bill textfield then apply it key-release event and 
        */
        /*String sql="select Doctor_Charge,Room_Charge,Operation_Charge,Admit_days,Nursing_Charge,Injection_Charge,CheckUp_Charge,Total from Billing where Bill_No=?";
                try
                {
                     pst=conn.prepareStatement(sql);
           pst.setString(1,bill_search_print.getText());
           rs=pst.executeQuery();
           if(rs.next())
           {
                String a=rs.getString("Doctor_Charge");
               doctor_charge.setText(a);
               String b=rs.getString("Room_Charge");
               room_charge.setText(b);
               String c=rs.getString("Operation_Charge");
               opration_charge.setText(c);
               String d=rs.getString("Admit_days");
               admit_days.setText(d);
               String e=rs.getString("Nursing_Charge");
               nursing_charge.setText(e);
               String f=rs.getString("Injection_Charge");
               injection_charge.setText(f);
               String ff=rs.getString("CheckUp_Charge");
               check_bill.setText(ff);
               String g=rs.getString("Total");
               print_b_total.setText(g);
              
               
               
               
           }
                }
                catch(Exception ez)
                {
                    JOptionPane.showMessageDialog(null, ez);
                }
                finally
                {
                    try
                    {
                        rs.close();
                        pst.close();
                    }
                    catch(Exception e)
                    {
                        
                    }
                }*/
    }//GEN-LAST:event_bill_search_printKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        /*
        refreshing text
        */
        print_id.setText("");
        print_name.setText("");
        print_address.setText("");
        print_treatment.setText("");
        print_mobile.setText("");
        print_dob.setText("");
        print_gender.setText("");
        print_gardian.setText("");
        print_doa.setText("");
        print_dod.setText("");
        doctor_charge.setText("");
        room_charge.setText("");
        opration_charge.setText("");
        admit_days.setText("");
        nursing_charge.setText("");
        injection_charge.setText("");
        check_bill.setText("");
        print_b_total.setText("");
         image_icon_print.setIcon(null);
                image_icon_print.revalidate();
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
            java.util.logging.Logger.getLogger(Printing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Printing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Printing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Printing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Printing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField admit_days;
    public javax.swing.JTextField bill_search_print;
    public javax.swing.JTextField check_bill;
    public javax.swing.JTextField doctor_charge;
    public javax.swing.JLabel image_icon_print;
    public javax.swing.JTextField injection_charge;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField nursing_charge;
    public javax.swing.JTextField opration_charge;
    public javax.swing.JTextField print_address;
    public javax.swing.JTextField print_b_total;
    public javax.swing.JTextField print_doa;
    public javax.swing.JTextField print_dob;
    public javax.swing.JTextField print_dod;
    public javax.swing.JTextField print_gardian;
    public javax.swing.JTextField print_gender;
    public javax.swing.JTextField print_id;
    public javax.swing.JTextField print_mobile;
    public javax.swing.JTextField print_name;
    private javax.swing.JPanel print_table;
    public javax.swing.JTextField print_treatment;
    public javax.swing.JTextField room_charge;
    private javax.swing.JLabel txt_date;
    // End of variables declaration//GEN-END:variables
}
