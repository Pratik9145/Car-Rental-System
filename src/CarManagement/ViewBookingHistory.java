package CarManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookingHistory extends JFrame implements ActionListener {
    String x[]={"Booking ID", "Customer Username", "Brand Name","Brand Model", "Car No", "Car Name","Car Category","Car Mileage", "Rent", "Total Days","Booking Date", "Status"};      
    String y[][]=new String[20][12];
    int i=0, j=0;
    JTable t;
    JButton bt1;
    JTextField tf1, tf2;
    JLabel l1,l2,l3;
    Font f,f1;
    JPanel p1, p2, p3;

    
    ViewBookingHistory(){
        super("New Booking History");
        setSize(1200, 400);
        setLocation(180, 160);
        
        f1=new Font("Courier New", Font.BOLD, 25);
        f=new Font("Consolas", Font.BOLD,15);
        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select * from car_booking";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("booking_id");
                y[i][j++]=rest.getString("customer_username");
                y[i][j++]=rest.getString("brand_name");
                y[i][j++]=rest.getString("brand_model");
                y[i][j++]=rest.getString("car_no");
                y[i][j++]=rest.getString("car_name");
                y[i][j++]=rest.getString("car_category");
                y[i][j++]=rest.getString("car_mileage");
                y[i][j++]=rest.getString("car_rent");
                y[i][j++]=rest.getString("total_days");
                y[i][j++]=rest.getString("booking_date");
                y[i][j++]=rest.getString("booking_status");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
           // JScrollPane js=new JScrollPane(t);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane js=new JScrollPane(t);
        l1=new JLabel("Cancel Status Of Any Bike");
        l1.setForeground(Color.orange);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        
        l2=new JLabel("Type Booking Id");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        l3=new JLabel("Type Car Number");
        l3.setFont(f1);
        l3.setForeground(Color.GRAY);
        
        tf1=new JTextField();
        tf1.setFont(f);
        
        tf2=new JTextField();
        tf2.setFont(f);
        
        bt1=new JButton("Cancel Status");
        bt1.setBackground(Color.BLACK);
        bt1.setBackground(Color.RED);
        bt1.setFont(f);
        bt1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1, 5, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2, 1, 10, 10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3,"South");
        add(js);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1){
            String booking_id=tf1.getText();
            String car_no=tf2.getText();
            
            if(booking_id.isEmpty()||car_no.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill Booking Id And Car Number!");
            }
            else{
                try{
                    ConnectionClass obj=new ConnectionClass();
                    String q="update car_booking set booking_status='Cancel' where booking_id='"+booking_id+"'";
                    int aa=obj.stm.executeUpdate(q);
                    if(aa==1){
                        JOptionPane.showMessageDialog(null, "Status Is Updated");
                        String q1="update add_car set car_status='Availabel' where car_no='"+car_no+"'";
                        obj.stm.executeUpdate(q1);
                    }
                    
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){
        new ViewBookingHistory().setVisible(true);
    }
}
