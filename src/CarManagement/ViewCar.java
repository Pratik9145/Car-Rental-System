package CarManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
public class ViewCar extends JFrame implements ActionListener {
    String x[]={"Car No", "Brand Name", "Brand Model", "Car Name", "Car Sheet", "Car Engine", "Car Category", "Car Mileage", "Car Mirror", "Rent", "Car Status"};
    String y[][]=new String[20][11];
    int i=0, j=0;
    JTable t;
    JButton bt1;
    JTextField tf1;
    JLabel l1,l2;
    Font f,f1;
    JPanel p1, p2, p3;
    

    ViewCar(){
        super("New Car Information");
        setSize(1200, 400);
        setLocation(180, 160);
        
        f=new Font("Consolas", Font.BOLD,15);
        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select * from add_car";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("car_no");
                y[i][j++]=rest.getString("brand_name");
                y[i][j++]=rest.getString("brand_model");
                y[i][j++]=rest.getString("car_name");
                y[i][j++]=rest.getString("car_sheet");
                y[i][j++]=rest.getString("car_engine");
                y[i][j++]=rest.getString("car_category");
                y[i][j++]=rest.getString("car_mileage");
                y[i][j++]=rest.getString("car_mirror");
                y[i][j++]=rest.getString("rent");
                y[i][j++]=rest.getString("car_status");
                
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        add(t);
        JScrollPane sp=new JScrollPane(t);
        
        f1=new Font("Courier New", Font.BOLD, 25);
        
        l1=new JLabel("Delete Any Car");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.YELLOW);
        l1.setFont(f1);
        
        l2=new JLabel("Type Car Number");
        l2.setForeground(Color.GRAY);
        l2.setFont(f1);
        
        tf1=new JTextField();
        tf1.setFont(f);
        
        bt1=new JButton("Delete Car");
        bt1.setBackground(Color.BLACK);
        bt1.setBackground(Color.RED);
        bt1.setFont(f);
        bt1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1, 3, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt1);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2, 1, 10, 10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3, "South");
        add(sp);
    }
    public void actionPerformed(ActionEvent e){
        String carname =tf1.getText();
        if(e.getSource()==bt1){
            if(carname.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill the Car Number");
            }
            else{
                try{
                    ConnectionClass obj=new ConnectionClass();
                    String q="Delete from add_car where car_no='"+carname+"'";
                    int temp=obj.stm.executeUpdate(q);
                    if(temp==1){
                        JOptionPane.showMessageDialog(null, "Car Record Successfully Deleted");
                        setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Car Record Does Not Match!!");
                    }
                }
                catch(Exception exx){
                    exx.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){
        new ViewCar().setVisible(true);
    }
}
