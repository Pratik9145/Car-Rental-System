package CarManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.util.Random;

public class AddNewBooking extends JFrame implements ActionListener  {
    Font f,f1,f2;
    Choice ch1, ch2, ch3, ch4, ch5;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JButton bt1 ,bt2;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    JPanel p1, p2, p3;    
    AddNewBooking(){
        super("Add New Car Details");
        setSize(1000, 810);
        setLocation(130, 40);
        setResizable(false);
        
        f=new Font("Consolas", Font.BOLD, 15);
        f1=new Font("Courier New", Font.BOLD, 20);
        f2=new Font("Courier New", Font.BOLD, 30);
        
        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();
        ch5=new Choice();
        
        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select username from user";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("username"));
            }
            rest.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        try{
            ConnectionClass obj1=new ConnectionClass();
            String q="select brand_name from add_car";
            ResultSet rest=obj1.stm.executeQuery(q);
            while(rest.next()){
                ch2.add(rest.getString("brand_name"));
            }
            rest.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        ch5.add("1");
        ch5.add("2");
        ch5.add("3");
        ch5.add("4");
        ch5.add("5");
        
        l1=new JLabel("Add New Car Booking");
        l1.setForeground(Color.orange);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f2);

        l2=new JLabel("Customer UserName");
        l3=new JLabel("Customer Name");
        l4=new JLabel("Customer Phone");
        l5=new JLabel("Brand Name");
        l6=new JLabel("Brand Model");
        l7=new JLabel("Car No");
        l8=new JLabel("Car Name");
        l9=new JLabel("Car Seater");
        l10=new JLabel("Car Engine");
        l11=new JLabel("Car Category");
        l12=new JLabel("Car Mileage");
        l14=new JLabel("Car Side Mirror");
        l15=new JLabel("Car Price Per Day");
        l16=new JLabel("How Many Days");
        
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l7.setForeground(Color.WHITE);
        l8.setForeground(Color.WHITE);
        l9.setForeground(Color.WHITE);
        l10.setForeground(Color.WHITE);
        l11.setForeground(Color.WHITE);
        l12.setForeground(Color.WHITE);
        l14.setForeground(Color.WHITE);
        l15.setForeground(Color.WHITE);
        l16.setForeground(Color.WHITE);
       
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        tf8=new JTextField();
        tf9=new JTextField();
        
        //1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        l16.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        
        tf1.setFont(f);
        tf2.setFont(f);
        tf3.setFont(f);
        tf4.setFont(f);
        tf5.setFont(f);
        tf6.setFont(f);
        tf7.setFont(f);
        tf8.setFont(f);
        tf9.setFont(f);
        
        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
        ch4.setFont(f);
        ch5.setFont(f);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        
        bt1=new JButton("Add Car");
        bt2=new JButton("Back");
        
        bt1.setBackground(Color.orange);
        bt2.setBackground(Color.gray);
        bt1.setForeground(Color.black);
        bt2.setForeground(Color.white);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        ImageIcon img = new ImageIcon(Signup_User.class.getResource("Icons/car3.png"));
        Image i1 = img.getImage().getScaledInstance(550, 420, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l13 = new JLabel(img1);
        
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        p1.setBackground(new Color(1, 11, 19));
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l13);
        p2.setBackground(new Color(1, 11, 19));
 
        p3=new JPanel();
        p3.setLayout(new GridLayout(15, 2, 10, 10));
        p3.add(l2);
        p3.add(ch1);
        p3.add(l3);
        p3.add(tf1);
        p3.add(l4);
        p3.add(tf2);
        p3.add(l5);
        p3.add(ch2);
        p3.add(l6);
        p3.add(ch3);
        p3.add(l7);
        p3.add(ch4);
        p3.add(l8);
        p3.add(tf3);
        p3.add(l9);
        p3.add(tf4);
        p3.add(l10);
        p3.add(tf5);
        p3.add(l11);
        p3.add(tf6);
        p3.add(l12);
        p3.add(tf7);
        p3.add(l14);
        p3.add(tf8);
        p3.add(l15);
        p3.add(tf9);
        p3.add(l16);
        p3.add(ch5);
        p3.add(bt1);
        p3.add(bt2);
        p3.setBackground(new Color(1, 11, 19));
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"West");
        add(p3,"Center");
        
        ch1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                //ch2.removeAll();
                try{
                     ConnectionClass obj=new ConnectionClass();
                    String cuser=ch1.getSelectedItem();
                    String q1="select name, phone from user where username ='"+cuser+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next()){
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("phone"));
                        
                   
                    }
                }
                catch(Exception ess){
                    ess.printStackTrace();
                }
            }
        
        });
        
        ch2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                ch3.removeAll();
                try{
                     ConnectionClass obj=new ConnectionClass();
                    String bname=ch2.getSelectedItem();
                    String q1="select brand_model from add_car where brand_name='"+bname+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next()){
                        ch3.add(rest1.getString("brand_model"));
                   
                    }
                }
                catch(Exception ess){
                    ess.printStackTrace();
                }
            }
        
        });
        
        ch3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                ch4.removeAll();
                try{
                     ConnectionClass obj=new ConnectionClass();
                    String bmodel=ch3.getSelectedItem();
                    String q1="select car_no from add_car where brand_model='"+bmodel+"'and car_status='Available'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next()){
                        ch4.add(rest1.getString("car_no"));
                   
                    }
                }
                catch(Exception ess){
                    ess.printStackTrace();
                }
            }
        
        });
        
        ch4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                
                try{
                     ConnectionClass obj=new ConnectionClass();
                    String car_no=ch4.getSelectedItem();
                    String bmodel=ch3.getSelectedItem();
                    String bname=ch2.getSelectedItem();
                    
                   String q1 = "select * from add_car where brand_model='" + bmodel + "' and car_no='" + car_no + "' and brand_name='" + bname + "'";


                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next()){
                        tf3.setText(rest1.getString("car_name"));
                        tf4.setText(rest1.getString("car_sheet"));
                        tf5.setText(rest1.getString("car_engine"));
                        tf6.setText(rest1.getString("car_category"));
                        tf7.setText(rest1.getString("car_mileage"));
                        tf8.setText(rest1.getString("car_mirror"));
                        tf9.setText(rest1.getString("rent"));
                   
                    }
                }
                catch(Exception ess){
                    ess.printStackTrace();
                }
            }
        
        });
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1){
            String username=ch1.getSelectedItem();
            String name=tf1.getText();
            String phone=tf2.getText();
            String brandname=ch2.getSelectedItem();
            String brand_model=ch3.getSelectedItem();
            String carno=ch4.getSelectedItem();
            String carname=tf3.getText();
            String carsheet=tf4.getText();
            String car_engine=tf5.getText();
            String car_category=tf6.getText();
            String car_mileage=tf7.getText();
            String car_mirror=tf8.getText();
            int days_count=Integer.parseInt(ch5.getSelectedItem());
            int car_price=days_count*(Integer.parseInt(tf9.getText()));
            String booking_status="Booked";
            Random r= new Random();
            String booking_id=""+Math.abs(r.nextInt()%10000);
            Date dtf=new Date();
            
            try{
                ConnectionClass obj3=new ConnectionClass();
                String q = "INSERT INTO car_booking (booking_id, customer_username, customer_name, customer_phone, brand_name, brand_model, car_no, car_name, car_sheet, car_engine, car_category, car_mileage, car_mirror, car_rent, total_days, booking_date, booking_status) VALUES ('" + booking_id + "', '" + username + "', '" + name + "', '" + phone + "', '" + brandname + "', '" + brand_model + "', '" + carno + "', '" + carname + "', '" + carsheet + "', '" + car_engine + "', '" + car_category + "', '" + car_mileage + "', '" + car_mirror + "', " + car_price + ", " + days_count + ", '" + dtf + "', '" + booking_status + "')";

                int aa=obj3.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showMessageDialog(null, "Car Successfully Booked");
                    
                    String q1 = "update add_car set car_status='Booked' where car_no='" + carno + "'";
                    obj3.stm.executeUpdate(q1);
                    this.setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please Fill All Details Carefully");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
        if(e.getSource()==bt2){
            this.setVisible(false);
        }
    }
    public static void main(String args[]){
        new AddNewBooking().setVisible(true);
    }
    
}
