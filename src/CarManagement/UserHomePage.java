
package CarManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserHomePage extends JFrame implements ActionListener {
    JLabel l1;
    Font f, f1;
    
    UserHomePage(){
        this.setTitle("Car Booking Page For USER");
        setLocation(0, 0);
        setSize(1280, 780);
        
        f=new Font("Courier New", Font.BOLD, 20);
        f1=new Font("Consolas", Font.BOLD, 18);
        
        ImageIcon img = new ImageIcon(Signup_User.class.getResource("Icons/13655.jpg"));
        Image i1 = img.getImage().getScaledInstance(1280, 780, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1=new JLabel(img1);
        
        JMenuBar m1=new JMenuBar();
        
       
        JMenu men1=new JMenu("   User Profile  ");
        JMenuItem ment1=new JMenuItem("Update and View My Details");
        //MenuItem ment2=new  JMenuItem("View User Profile");
        
        
        men1.add(ment1);
        //men1.add(ment2);
        
        JMenu men2=new JMenu("  Booking History  ");
        JMenuItem ment3=new JMenuItem("Add New Booking");
        JMenuItem ment4=new  JMenuItem("View Booking History");
        
        men2.add(ment3);
        men2.add(ment4);
        
        JMenu men3=new JMenu("  Car Brand  ");
        //JMenuItem ment5=new JMenuItem("Add New Brand");
        JMenuItem ment6=new  JMenuItem("View Brand");
        
       // men3.add(ment5);
        men3.add(ment6);
        
        JMenu men4=new JMenu("  Vechile  ");
        //JMenuItem ment7=new JMenuItem("Add New Car");
        JMenuItem ment8=new  JMenuItem("View Car");
        
       // men4.add(ment7);
        men4.add(ment8);
        
        //JMenu men5=new JMenu("  Cancellation  ");
        //JMenuItem ment9=new JMenuItem("Cancel Booking");
        
        //men5.add(ment9);
        
        JMenu men6=new JMenu("  Bill  ");
        JMenuItem ment10=new JMenuItem("Check Bill");
        
        men6.add(ment10);
        
        JMenu men7=new JMenu("  Logout  ");
        JMenuItem ment11=new JMenuItem("Exit");
        
        men7.add(ment11);
       
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        //m1.add(men5);
        m1.add(men6);
        m1.add(men7);
        
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        //men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
        
        ment1.setFont(f1);
        //ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        //ment5.setFont(f1);
        ment6.setFont(f1);
        //ment7.setFont(f1);
        ment8.setFont(f1);
        //ment9.setFont(f1);
        ment10.setFont(f1);
        ment11.setFont(f1);
        
        m1.setBackground(new java.awt.Color(48,61,58));//menu bar colour
        //menu bar button color
        men1.setForeground(Color.white);
        men2.setForeground(Color.white);
        men3.setForeground(Color.white);
        men4.setForeground(Color.white);
       // men5.setForeground(Color.white);
        men6.setForeground(Color.white);
        men7.setForeground(Color.red);
        
        ment1.setBackground(new java.awt.Color(48, 61, 58));
        //ment2.setBackground(new java.awt.Color(48, 61, 58));
        ment3.setBackground(new java.awt.Color(48, 61, 58));
        ment4.setBackground(new java.awt.Color(48, 61, 58));
       // ment5.setBackground(new java.awt.Color(48, 61, 58));
        ment6.setBackground(new java.awt.Color(48, 61, 58));
        //ment7.setBackground(new java.awt.Color(48, 61, 58));
        ment8.setBackground(new java.awt.Color(48, 61, 58));
        //ment9.setBackground(new java.awt.Color(48, 61, 58));
        ment10.setBackground(new java.awt.Color(48, 61, 58));
        ment11.setBackground(new java.awt.Color(48, 61, 58));
        
        ment1.setForeground(Color.white);
        //ment2.setForeground(Color.white);
        ment3.setForeground(Color.white);
        ment4.setForeground(Color.white);
        //ment5.setForeground(Color.white);
        ment6.setForeground(Color.white);
        //ment7.setForeground(Color.white);
        ment8.setForeground(Color.white);
        //ment9.setForeground(Color.white);
        ment10.setForeground(Color.white);
        ment11.setForeground(Color.red);
        
        ment1.addActionListener(this);
        //ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
       // ment5.addActionListener(this);
        ment6.addActionListener(this);
       // ment7.addActionListener(this);
        ment8.addActionListener(this);
        //ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        
        
        setJMenuBar(m1);
            
        add(l1);
    }
    
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        
        if (command.equals("Update and View My Details")){
            new Update().setVisible(true);
        }
   
        else if(command.equals("Add New Booking")){
            new AddNewBooking().setVisible(true);
        }
        else if(command.equals("View Booking History")){
           new ViewBookingHistory().setVisible(true);
        }
        
        else if(command.equals("View Brand")){
            new ViewBrand().setVisible(true);
        }
        
        else if(command.equals("View Car")){
            new ViewCar().setVisible(true);
        }
        
        else if(command.equals("Check Booking")){
            System.out.println("Check Booking");
        }
        else if(command.equals("Exit")){
            System.exit(0);
        }
        else if(command.equals("Check Bill")){
            new CheckBill().setVisible(true);
        }
        
        
    }
    public static void main(String args[]){
        new UserHomePage().setVisible(true);
    }
    
}
