
import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;

public class Hospital_Bill extends javax.swing.JFrame {
      

    /**
     * Creates new form Hospital_Bill
     */
    /*Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;*/
     String filename=null;
    byte[] person_image=null;
    String pti=null;
    
    
    
    public Hospital_Bill() {
         initComponents();
         setIcon();
      //  conn=javaconnect.ConnectDB();
        Update_Bill();
         bill_next.setEnabled(false);
         String take=b_id.getText();
         
          check();
         
        //b_nom.setText(contractNo);
        
        
    }
    public void check()
    {
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        {
            //b_nom.getText();
            String a="MH-3000";
            // b_nom.setText("MH-3000");
          //  String check= b_nom.getText();
            for(int i=0;i<1000;i++)
            {
            String sql="select Bill_No from Billing where Bill_no>'"+a+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
               
               a=rs.getString("Bill_No");
              
            }
        }
            //b_nom.setText(a);
            String value=a;
            String va2=value.replaceAll("MH-", "");
            int VALUE=Integer.parseInt(va2);
            ++VALUE;
             b_nom.setText("MH-"+VALUE);
            /*
             String VALUE    ="MH-1001";
        String v2=VALUE.replaceAll("MH-", "");
        int value=Integer.parseInt(v2);
        ++value;
        JOptionPane.showMessageDialog(null, "my replace code is\n\t\t\tMH-"+value);
            */
                    
                    
                    
            
            
            
        }
        catch(NumberFormatException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex+"\nConnection error\n\tplease check out");
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
     
     
    
  /* public void In_patient_Details()
   {
       Printing pt=new Printing();
        try
        {
            String ch=b_id.getText();
           String sql="select First_Name,Last_Name,Address,Treatment_By,Mobile,DOB,Gender,Live_with,DOA,DOD,Images from In_Patient where Patient_ID='"+ch+"'";
           pst=conn.prepareStatement(sql);
          // pst.setString(1,b_id.getText());
           rs=pst.executeQuery();
           if(rs.next())
           {
               String a=rs.getString("First_Name");
               String b=rs.getString("Last_Name");
               pt.print_name.setText(a+" "+b);
               String c=rs.getString("Address");
               pt.print_address.setText(c);
               String d=rs.getString("Mobile");
               pt.print_mobile.setText(d);
               String e=rs.getString("DOB");
               pt.print_dob.setText(e);
               String f=rs.getString("Gender");
               pt.print_gender.setText(f);
               String g=rs.getString("Live_with");
               pt.print_gardian.setText(g);
               String h=rs.getString("DOA");
               pt.print_doa.setText(h);
               String i=rs.getString("DOD");
               pt.print_dod.setText(i); 
                byte[] bi=rs.getBytes("Images"); 
                ImageIcon image=new ImageIcon(bi);
                Image mi=image.getImage();
                Image myimg=mi.getScaledInstance(pt.image_icon_print.getWidth(),pt.image_icon_print.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(myimg);
                pt.image_icon_print.setIcon(newIcon);
            pt.image_icon_print.revalidate();
            String j=rs.getString("Treatment_By");
            pt.print_treatment.setText(j);
            
               
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
        }
   }*/
    public void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo-nonetext.png")));
    }
     public void Update_Bill()
    {
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        
        try
        {
         String sql="select Bill_No,Patient_ID,Patient_Name,Doctor_Charge,Room_Charge from Billing order by Bill_No";
            //String sql="select * from Billing order by Bill_No";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            b_table.setModel(DbUtils.resultSetToTableModel(rs));
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
        jLabel18 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        b_labal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        b_nom = new javax.swing.JTextField();
        b_id = new javax.swing.JTextField();
        c_charge = new javax.swing.JTextField();
        b_name = new javax.swing.JTextField();
        p_type = new javax.swing.JTextField();
        d_charge = new javax.swing.JTextField();
        r_charge = new javax.swing.JTextField();
        o_charge = new javax.swing.JTextField();
        a_day = new javax.swing.JTextField();
        n_charge = new javax.swing.JTextField();
        i_charge = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        bill_next = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        total_hb = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        bill_date = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        b_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admit Patient Bill");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 190, 170);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("IN Patient Bill");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(200, 50, 520, 110);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-icon (1).png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(1280, 20, 60, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hospital-Top-Slider-Image.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 20, 1200, 170);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IN Patient Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane3.setLayer(b_labal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_labal, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_labal, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jDesktopPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Patient ID");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 100, 32));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Patient Name");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, 32));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Doctor Charge");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 140, 32));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Operation Charge");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 420, 160, 32));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Patient Type");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Room Charge");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 130, 32));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Days");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 50, 32));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Nursing Charge");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 149, 32));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("I.C.U Charge");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 160, 32));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Injection Charge");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 600, 160, 32));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Bill No");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 60, 30));

        b_nom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(b_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 150, 30));

        b_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_idActionPerformed(evt);
            }
        });
        b_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b_idKeyReleased(evt);
            }
        });
        jPanel4.add(b_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 150, 30));

        c_charge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        c_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_chargeActionPerformed(evt);
            }
        });
        c_charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_chargeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c_chargeKeyTyped(evt);
            }
        });
        jPanel4.add(c_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 140, 30));

        b_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_nameActionPerformed(evt);
            }
        });
        jPanel4.add(b_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 260, 30));

        p_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_typeActionPerformed(evt);
            }
        });
        jPanel4.add(p_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 220, 30));

        d_charge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        d_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_chargeActionPerformed(evt);
            }
        });
        d_charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                d_chargeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                d_chargeKeyTyped(evt);
            }
        });
        jPanel4.add(d_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 140, 30));

        r_charge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        r_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_chargeActionPerformed(evt);
            }
        });
        r_charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                r_chargeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                r_chargeKeyTyped(evt);
            }
        });
        jPanel4.add(r_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 140, 30));

        o_charge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        o_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o_chargeActionPerformed(evt);
            }
        });
        o_charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                o_chargeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                o_chargeKeyTyped(evt);
            }
        });
        jPanel4.add(o_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 140, 30));

        a_day.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_dayActionPerformed(evt);
            }
        });
        a_day.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                a_dayKeyTyped(evt);
            }
        });
        jPanel4.add(a_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 70, 30));

        n_charge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        n_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_chargeActionPerformed(evt);
            }
        });
        n_charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                n_chargeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                n_chargeKeyTyped(evt);
            }
        });
        jPanel4.add(n_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 140, 30));

        i_charge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        i_charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_chargeActionPerformed(evt);
            }
        });
        i_charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                i_chargeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                i_chargeKeyTyped(evt);
            }
        });
        jPanel4.add(i_charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 140, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Save");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 100, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 102));
        jButton2.setText("Delete");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 100, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Update");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 100, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 102));
        jButton4.setText("Search");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 100, 30));

        bill_next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bill_next.setForeground(new java.awt.Color(0, 102, 102));
        bill_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Next-icon (1).png"))); // NOI18N
        bill_next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bill_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bill_nextMouseClicked(evt);
            }
        });
        bill_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill_nextActionPerformed(evt);
            }
        });
        jPanel4.add(bill_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, 70, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 102));
        jButton5.setText("Upload");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 110, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Rs");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 670, 50, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Rs");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 50, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Rs");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 50, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Rs");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 50, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Rs");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 50, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Rs");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 610, 50, 30));

        total_hb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel4.add(total_hb, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, 140, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 102));
        jButton6.setText("Total");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 660, 90, 30));

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Refresh-icon.png"))); // NOI18N
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel4.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, 60));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Admit Days");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 110, 32));
        jPanel4.add(bill_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 150, 30));

        jScrollPane1.setViewportView(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IN Patient Bill info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N

        b_table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_table.setModel(new javax.swing.table.DefaultTableModel(
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
        b_table.setRowHeight(30);
        b_table.setRowMargin(2);
        b_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(b_table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        /*
        HERE WE ONLY UPDATE DATA NOT IMAGE
        */
         String a=b_nom.getText();
         String b=b_id.getText();
         String c=b_name.getText();
         String d=p_type.getText();
         String e=d_charge.getText();
         String f=r_charge.getText();
         String g=o_charge.getText();
         String h=a_day.getText();
         String i=n_charge.getText();
         String j=i_charge.getText();
         String k=c_charge.getText();
           String l=((JTextField)bill_date.getDateEditor().getUiComponent()).getText();
           String m=total_hb.getText();
           Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
                 
        try
        {
            /*
             String sql="update In_Patient set First_Name='"+b+"',Last_Name='"+c+"',Gender='"+d+"',Age='"+e+"',Weight='"+f+"',DOB='"+m+"',Mobile='"+g+"',Address='"+j+"',Live_with='"+k+"',DOA='"+h+"',DOD='"+i+"',Room_no='"+l+"',Treatment_By='"+n+"' where Patient_ID='"+a+"'";
             pst=conn.prepareStatement(sql);
            pst.execute();
            
                 JOptionPane.showMessageDialog(null,"UPDATED");

            */
            if(a.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Bill No is Empty");
            }
            else if(b.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Patient ID is Empty");
            }
            else
            {
            String sql="update Billing set Patient_ID='"+b+"',Patient_Name='"+c+"',Patient_Type='"+d+"',Doctor_Charge='"+e+"',Room_Charge='"+f+"',Operation_Charge='"+g+"',Admit_days='"+h+"',Nursing_Charge='"+i+"',Injection_Charge='"+j+"',CheckUp_Charge='"+k+"',Date='"+l+"',Total='"+m+"' where Bill_No='"+a+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "UPDATED SUCCUSSFULLY !!");
              //check();
            b_id.setText("");
            b_name.setText("");
            p_type.setText("");
             ((JTextField)bill_date.getDateEditor().getUiComponent()).setText("");
            d_charge.setText("");
            r_charge.setText("");
            o_charge.setText("");
            a_day.setText("");
            n_charge.setText("");
            i_charge.setText("");
            c_charge.setText("");
            b_labal.setIcon(null);
            b_labal.revalidate();
             total_hb.setText("");
             Update_Bill();
            }
          
        }
        catch(HeadlessException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex+"\nConnection Error\nplease check..");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        /*
        DLETE OPERATION PERFORM HERE .,ITS DELETING WHOLE INFORMATION
        */
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        {
            String st=b_nom.getText();
            String st2=b_id.getText();
            if(st.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Bill No is Empty");
            }
            
            else if(st2.isEmpty())
                    {
                    JOptionPane.showMessageDialog(null, "Patient Id is Empty");
                    }
            else
            {
                
            
                String sql="delete from Billing where Bill_No=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, b_nom.getText());

            int p=JOptionPane.showConfirmDialog(null,"Do you want to Delete","Conform Delete",JOptionPane.YES_NO_OPTION);
            if(p==0)
            {
                pst.execute();
                 //check();
                Update_Bill();
                JOptionPane.showMessageDialog(null, "Deleted");
                 b_nom.setText("");
            b_id.setText("");
            b_name.setText("");
            p_type.setText("");
            
            d_charge.setText("");
            r_charge.setText("");
            o_charge.setText("");
            a_day.setText("");
            n_charge.setText("");
            i_charge.setText("");
            c_charge.setText("");
            b_labal.setIcon(null);
            b_labal.revalidate();
             total_hb.setText("");
                          ((JTextField)bill_date.getDateEditor().getUiComponent()).setText("");

                
            }
            }
        }
        catch(HeadlessException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex+"\nConnection Error\nplease check..");
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

    private void i_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_chargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_i_chargeActionPerformed

    private void n_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_chargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_chargeActionPerformed

    private void a_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a_dayActionPerformed

    private void o_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o_chargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_o_chargeActionPerformed

    private void r_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_chargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_chargeActionPerformed

    private void d_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_chargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_d_chargeActionPerformed

    private void p_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_typeActionPerformed

    private void b_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_nameActionPerformed

    private void c_chargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_chargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_chargeActionPerformed

    private void b_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_idActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        /*
        Search Operation perform here
        */
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
         try
         {
             String st=b_nom.getText();
             if(st.isEmpty())
             {
                 JOptionPane.showMessageDialog(null, "Bill Search Field is Empty");
             }
             else
             {
              String sql="select Patient_ID,Patient_Name,Patient_Type,Doctor_Charge,Operation_Charge,Admit_days,Nursing_Charge,Injection_Charge,CheckUp_Charge,Room_Charge,Image,Date,Total from Billing where Bill_No=?";
        
            pst=conn.prepareStatement(sql);
            pst.setString(1,b_nom.getText());
            rs=pst.executeQuery();
            if(rs.next()) 
            {
                /*String a=rs.getString("Bill_No");
               b_nom.setText(a);*/
                String b=rs.getString("Patient_ID");
               b_id.setText(b);
                String c=rs.getString("Patient_Name");
               b_name.setText(c);
                String d=rs.getString("Patient_Type");
               p_type.setText(d);
                String e=rs.getString("Doctor_Charge");
               d_charge.setText(e);
                String f=rs.getString("Operation_Charge");
               o_charge.setText(f);
                String g=rs.getString("Admit_days");
               a_day.setText(g);
                String h=rs.getString("Nursing_Charge");
               n_charge.setText(h);
                String i=rs.getString("Injection_Charge");
               i_charge.setText(i);
                String j=rs.getString("CheckUp_Charge");
               c_charge.setText(j);
                String k=rs.getString("Room_Charge");
               r_charge.setText(k);
                 byte[] bi=rs.getBytes("Image");
                ImageIcon image=new ImageIcon(bi);
                Image mi=image.getImage();
                Image myimg=mi.getScaledInstance(b_labal.getWidth(),b_labal.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(myimg);
                b_labal.setIcon(newIcon);
            b_labal.revalidate();
            String l=rs.getString("Date");
            ((JTextField)bill_date.getDateEditor().getUiComponent()).setText(l);
             String m=rs.getString("Total");
            total_hb.setText(m);
            
            }
             }
            
        }
        catch(HeadlessException | SQLException e)
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
        /*
        HERE WE PERFORM SAVING DATA INTO TABLE
        */  
           // double result=Integer.valueOf(d_charge.getText())+Intege.valueOf(r_charge.getText())+Integer.valueOf(o_charge.getText())+Double.valueOf(a_day.getText())+Double.valueOf(n_charge.getText())+Double.valueOf(i_charge.getText())+Double.valueOf(c_charge);

        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
        try
        {
            String st=b_nom.getText();
            /* String contractNo = SequentialNumber.GetNextNumber();
        b_nom.setText(contractNo);*/
            String st2=b_id.getText();
            /*if(st.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Bill No is Empty");
            }
            else*/ if(st2.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Patient Id is Empty");
                
            }
            else
            {
        String sql="insert into Billing  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,b_nom.getText());
             pst.setString(2,b_id.getText());
              pst.setString(3,b_name.getText());
               pst.setString(4,p_type.getText());
                pst.setString(5,d_charge.getText());
                 pst.setString(6,r_charge.getText());
                  pst.setString(7,o_charge.getText());
                   pst.setString(8,a_day.getText());
                    pst.setString(9,n_charge.getText());
                     pst.setString(10,i_charge.getText());
                      pst.setString(11,c_charge.getText());
                      pst.setBytes(12,person_image);
                      
                       /*int a = Integer.parseInt(d_charge.getText());
                    int b = Integer.parseInt(r_charge.getText()); 
             int c=Integer.parseInt(o_charge.getText());
             int d=Integer.parseInt(a_day.getText());
             int e=Integer.parseInt(n_charge.getText());
             int f=Integer.parseInt(i_charge.getText());
             int g=Integer.parseInt(c_charge.getText());
                int cc=(a+b+c+e+f+g)*d;
             total_hb.setText(String.valueOf(cc));*/
             pst.setString(13, total_hb.getText());
               pst.setString(14,((JTextField)bill_date.getDateEditor().getUiComponent()).getText());
            int p=JOptionPane.showConfirmDialog(null,"Do you want to save","Conform Save",JOptionPane.YES_NO_OPTION);

             if(p==0)
             {
              pst.execute();
               //check();
               
             JOptionPane.showMessageDialog(null, "Saved");
             bill_next.setEnabled(true);
             /*
              String VALUE    ="MH-1001";
        String v2=VALUE.replaceAll("MH-", "");
        int value=Integer.parseInt(v2);
        ++value; 
             */
             String VALUE=b_nom.getText();
             String v2=VALUE.replaceAll("MH-", "");
        int value=Integer.parseInt(v2);
        ++value;
             Update_Bill();
          //  b_nom.setText("");
          /*String stt = SequentialNumber.GetNextNumber();
              */  b_nom.setText("MH-"+value);
            b_id.setText("");
            b_name.setText("");
            p_type.setText("");
            ((JTextField)bill_date.getDateEditor().getUiComponent()).setText("");
            d_charge.setText("");
            r_charge.setText("");
            o_charge.setText("");
            a_day.setText("");
            n_charge.setText("");
            i_charge.setText("");
            c_charge.setText("");
            b_labal.setIcon(null);
            b_labal.revalidate();
            total_hb.setText("");
             
             /*
              
             
             */
             
             }
            }
            
            
            
        }
        catch(HeadlessException | NumberFormatException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex+"\nConnection Error\nplease check..");
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

    private void b_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_idKeyReleased
        // TODO add your handling code here:
        /*
        PATIENT ID KEY REALESE EVENT WILL DISPLAY WHOLE INFORMATION IN JTEXTFIELD
        */
        /*String a=b_id.getText();
        try
        {
            String sql="select * from Billing where Patinet_ID='"+a+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String aa=rs.getString("Patient_ID");
               b_id.setText(aa);
               String b=rs.getString("Bill_No");
               b_id.setText(b);
               String c=rs.getString("Patient_Name");
               b_id.setText(c);
               String d=rs.getString("Patient_Type");
               b_id.setText(d);
               String e=rs.getString("Doctor_Charge");
               b_id.setText(e);
               String f=rs.getString("Room_Charge");
               b_id.setText(e);
               
               String g=rs.getString("Operation_Charge");
               b_id.setText(g);
               String h=rs.getString("Admit_days");
               b_id.setText(h);
               String i=rs.getString("Nursing_Charge");
               b_id.setText(i);
               String j=rs.getString("Injection_Charge");
               b_id.setText(j);
               String k=rs.getString("CheckUp_Charge");
               b_id.setText(k);
               
               byte[] bi=rs.getBytes("Image");
                ImageIcon image=new ImageIcon(bi);
                Image mi=image.getImage();
                Image myimg=mi.getScaledInstance(b_labal.getWidth(),b_labal.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(myimg);
                b_labal.setIcon(newIcon);
            b_labal.revalidate();
                
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }*/
    }//GEN-LAST:event_b_idKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        /*
        upload a file from c drive
        */
          // TODO add your handling code here:
      JFileChooser chooser=new JFileChooser();
      
      chooser.showOpenDialog(null);
      FileNameExtensionFilter filter=new FileNameExtensionFilter("*.IMAGE","JPG","GIF","PNG");
      chooser.addChoosableFileFilter(filter);
      
      File f=chooser.getSelectedFile();
      filename=f.getAbsolutePath();
      /*
      below from we want to use this code line into our hospital_bill.java jFrame program
      */
      ImageIcon imageicon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(b_labal.getWidth(), b_labal.getHeight(), Image.SCALE_SMOOTH));
      b_labal.setIcon(imageicon);
      try
      { 
          File image=new File(filename);
          FileInputStream fis=new FileInputStream(image);
          ByteArrayOutputStream bos=new ByteArrayOutputStream();
          byte[] buf=new byte[1024];
          for(int readnum;(readnum=fis.read(buf))!=-1;)
          {
              
           bos.write(buf,0,readnum);    
          }
          person_image=bos.toByteArray();
          
      }
      catch(IOException e)
      {
          JOptionPane.showMessageDialog(null, "Some error occured  "+e);
      }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void b_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_tableMouseClicked
        // TODO add your handling code here:
        /*
        mouse click actin perform
        */
        Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
     conn=javaconnect.ConnectDB();
         try
       {
            int row=b_table.getSelectedRow();
            String Table_click=(b_table.getModel().getValueAt(row,0).toString());
            String sql="select Bill_No,Patient_ID,Patient_Name,Patient_Type,Doctor_Charge,Room_Charge,Operation_Charge,Admit_days,Nursing_Charge,Injection_Charge,CheckUp_Charge,Image,Total,Date from Billing where Bill_No='"+Table_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
               
               String a=rs.getString("Bill_No");
               b_nom.setText(a);
               String b=rs.getString("Patient_ID");
               b_id.setText(b);
               String c=rs.getString("Patient_Name");
               b_name.setText(c);
               String d=rs.getString("Patient_Type");
               p_type.setText(d);
               String e=rs.getString("Doctor_Charge");
               d_charge.setText(e);
               String ee=rs.getString("Room_Charge");
               r_charge.setText(ee);
               String ff=rs.getString("Date");
               ((JTextField)bill_date.getDateEditor().getUiComponent()).setText(ff); 
             String m=rs.getString("Total");
            total_hb.setText(m);
            
               
               String f=rs.getString("Operation_Charge");
               o_charge.setText(f);
               String g=rs.getString("Admit_days");
               a_day.setText(g);
               String h=rs.getString("Nursing_Charge");
               n_charge.setText(h);
               String i=rs.getString("Injection_Charge");
               i_charge.setText(i);
               String j=rs.getString("CheckUp_Charge");
               c_charge.setText(j);
                byte[] bi=rs.getBytes("Image");
                ImageIcon image=new ImageIcon(bi);
                Image mi=image.getImage();
                Image myimg=mi.getScaledInstance(b_labal.getWidth(),b_labal.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newIcon=new ImageIcon(myimg);
                b_labal.setIcon(newIcon);
                
            b_labal.revalidate();
            bill_next.setEnabled(true);
           
           

             Update_Bill();
               
               
            }
       }
         catch(SQLException ex)
         {
             JOptionPane.showMessageDialog(null,ex+" Image not selected???");
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
    }//GEN-LAST:event_b_tableMouseClicked

    private void d_chargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d_chargeKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
      
    }//GEN-LAST:event_d_chargeKeyTyped

    private void r_chargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_chargeKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
    }//GEN-LAST:event_r_chargeKeyTyped

    private void o_chargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_o_chargeKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
    }//GEN-LAST:event_o_chargeKeyTyped

    private void a_dayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a_dayKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
    }//GEN-LAST:event_a_dayKeyTyped

    private void n_chargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_chargeKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
    }//GEN-LAST:event_n_chargeKeyTyped

    private void i_chargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_i_chargeKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
    }//GEN-LAST:event_i_chargeKeyTyped

    private void c_chargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_chargeKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACKSPACE)|| (c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
        {
            evt.consume();
        }
    }//GEN-LAST:event_c_chargeKeyTyped

    private void bill_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill_nextActionPerformed
        // TODO add your handling code here:
        /*
        HERE WE PRINTING THIS BILL INFORMATIN OK
        */
        
        /* String id=b_id.getText();
         String bill=b_nom.getText();
        dispose();
       // Printing pt=new Printing();
        Printing pt=new Printing(id,bill);
      //  pt.Inpatient(id);
        pt.setVisible(true);
        */
       //****************** Hospital_Bill_1
        
        
       
        String id=b_id.getText();
         String bill=b_nom.getText();
         dispose();
         Hospital_bill_1 hos=new Hospital_bill_1(id,bill);
         hos.setVisible(true);
        
        
        
       
        
        
        
    }//GEN-LAST:event_bill_nextActionPerformed

    private void c_chargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_chargeKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_c_chargeKeyReleased

    private void i_chargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_i_chargeKeyReleased

       
    }//GEN-LAST:event_i_chargeKeyReleased

    private void n_chargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_chargeKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_n_chargeKeyReleased

    private void o_chargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_o_chargeKeyReleased
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_o_chargeKeyReleased

    private void r_chargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_chargeKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_r_chargeKeyReleased

    private void d_chargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d_chargeKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_d_chargeKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        // TODO add your handling code here:
        int a = Integer.parseInt(d_charge.getText());
                    int b = Integer.parseInt(r_charge.getText()); 
             int c=Integer.parseInt(o_charge.getText());
             int d=Integer.parseInt(a_day.getText());
             int e=Integer.parseInt(n_charge.getText());
             int f=Integer.parseInt(i_charge.getText());
             int g=Integer.parseInt(c_charge.getText());
                int cc=(a+b+e)*d;
                int xx=cc+c+f+g;
             total_hb.setText(String.valueOf(xx));
             bill_next.setEnabled(true);
             
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        /*
        refreshing
        */
       //check();
       check();
            b_id.setText("");
            b_name.setText("");
            p_type.setText("");
            ((JTextField)bill_date.getDateEditor().getUiComponent()).setText("");
            d_charge.setText("");
            r_charge.setText("");
            o_charge.setText("");
            a_day.setText("");
            n_charge.setText("");
            i_charge.setText("");
            c_charge.setText("");
            b_labal.setIcon(null);
            b_labal.revalidate();
             total_hb.setText("");
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Origine().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void bill_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bill_nextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bill_nextMouseClicked

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
            java.util.logging.Logger.getLogger(Hospital_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hospital_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hospital_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hospital_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hospital_Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a_day;
    public javax.swing.JTextField b_id;
    private javax.swing.JLabel b_labal;
    private javax.swing.JTextField b_name;
    private javax.swing.JTextField b_nom;
    private javax.swing.JTable b_table;
    private com.toedter.calendar.JDateChooser bill_date;
    private javax.swing.JButton bill_next;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JTextField c_charge;
    private javax.swing.JTextField d_charge;
    private javax.swing.JTextField i_charge;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane3;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField n_charge;
    private javax.swing.JTextField o_charge;
    private javax.swing.JTextField p_type;
    private javax.swing.JTextField r_charge;
    private javax.swing.JTextField total_hb;
    // End of variables declaration//GEN-END:variables
}
