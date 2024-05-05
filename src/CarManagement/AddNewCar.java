package CarManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddNewCar extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField tf1, tf2, tf3, tf4, tf5;
    Choice ch1,ch2,ch3,ch4,ch5;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    Font f,f1;
    
    AddNewCar(){
        super("Add New Car Details");
        setSize(900, 560);
        setLocation(50, 10);
        
        f=new Font("Consolas", Font.BOLD, 15);
        f1=new Font("Courier New", Font.BOLD, 20);
        
        l1=new JLabel("Add New Car Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.red);
        l1.setFont(f1);
        
        l2=new JLabel("Brand Name");
        l3=new JLabel("Brand Model");
        l4=new JLabel("Car Name");
        l5=new JLabel("Car Seat");
        l6=new JLabel("Car Engine");
        l7=new JLabel("Car Category");
        l8=new JLabel("Car Milage");
        l9=new JLabel("Car Side Mirror");
        l10=new JLabel("Car No");
        l11=new JLabel("Rent Per Days");
        
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
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        
       tf1.setFont(f);
       tf2.setFont(f);
       tf3.setFont(f);
       tf4.setFont(f);
       tf5.setFont(f);
        
        ch1= new Choice();
        ch2= new Choice();
        ch3= new Choice();
        ch4= new Choice();
        ch5= new Choice();
        
        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
        ch4.setFont(f);
        ch5.setFont(f);
        
        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select brand_name from carbrand";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("brand_name"));
                
            }
            rest.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        ch3.add("Four Seater");
        ch3.add("Four+ Seater");
        
        ch4.add("Petrol/Cng");
        ch4.add("Diesel");
        ch4.add("EV");
        
        ch5.add("Yes");
        ch5.add("No");
        
        bt1=new JButton("Add Car");
        bt2=new JButton("Back");
        
        bt1.setBackground(Color.red);
        bt2.setBackground(Color.BLACK);
        
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
       
        bt1.setFont(f);
        bt2.setFont(f);
        
        // After creating buttons bt1 and bt2
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        ImageIcon img = new ImageIcon(Signup_User.class.getResource("Icons/car2.png"));
        Image i1 = img.getImage().getScaledInstance(350, 450, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l12=new JLabel(img1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(ch2);
        p2.add(l4);
        p2.add(tf1);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(tf2);
        p2.add(l7);
        p2.add(ch4);
        p2.add(l8);
        p2.add(tf3);
        p2.add(l9);
        p2.add(ch5);
        p2.add(l10);
        p2.add(tf4);
        p2.add(l11);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.add(l12);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");
        
        ch1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                ch2.removeAll();
                try{
                     ConnectionClass obj=new ConnectionClass();
                    String brand_name=ch1.getSelectedItem();
                    String q1="select * from carbrand where brand_name ='"+brand_name+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next()){
                        ch2.add(rest1.getString("car_model"));
                   
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
            String brand_name=ch1.getSelectedItem();
            String brand_model=ch2.getSelectedItem();
            String car_name=tf1.getText();
            String car_sheet=ch3.getSelectedItem();
            String car_engine=tf2.getText();
            String car_category=ch4.getSelectedItem();
            String car_mileage=tf3.getText();
            String car_mirror=ch5.getSelectedItem();
            String car_no=tf4.getText();
            String rent=tf5.getText();
            String car_status="Available";
            
            try{
                ConnectionClass obj=new ConnectionClass();
                String q="insert into add_car values('"+car_no+"', '"+brand_name+"','"+brand_model+"','"+car_name+"','"+car_sheet+"','"+car_engine+"','"+car_category+"','"+car_mileage+"','"+car_mirror+"','"+rent+"','"+car_status+"')  ";
                int aa=obj.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showMessageDialog(null, "Car Detail Successfully Added");
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please, Fill all Details Carefully");
                }
            }
            catch(Exception exx){
                exx.printStackTrace();
            }
        }
        if(e.getSource()==bt2){
            this.setVisible(false);
        }
    }
    public static void main(String args[]){
        new AddNewCar().setVisible(true);
    }
}
