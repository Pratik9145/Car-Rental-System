
package CarManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CheckBill extends JFrame implements ActionListener {
    JButton bt1,bt2;
    JLabel l1,l2;
    JTextArea ta;
    Choice ch1,ch2;
    JPanel p1;
    Font f;
    String q;
    CheckBill(){
        this.setTitle("Generate Bill Slip");
        setLocation(100, 100);
        setSize(450, 500);
        setResizable(false);
        
        f=new Font("Consolas", Font.BOLD,15);
        
        l1=new JLabel("Customer Username");
        l2=new JLabel ("Booking Id");
        
        l1.setFont(f);
        l2.setFont(f);
        
        ch1=new Choice();
        ch2=new Choice();
        
        try{
            ConnectionClass obj=new ConnectionClass();
            q="select distinct customer_username from car_booking";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("customer_username"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        ch1.setFont(f);
        ch2.setFont(f);
        
        bt1=new JButton("Show");
        bt2=new JButton("Print PDF");
        
        bt1.setBackground(Color.black);
        bt2.setBackground(Color.black);
        bt1.setForeground(Color.white);
        bt1.setForeground(Color.white);
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        ta=new JTextArea();
        JScrollPane sp=new JScrollPane(ta);
        ta.setFont(f);
        ta.setEditable(false);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(3,2,10,10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(ch2);
        p1.add(bt1);
        p1.add(bt2);
        
        setLayout(new BorderLayout());
        add(sp,"Center");
        add(p1,"South");
        
        ch1.addMouseListener(new MouseAdapter(){
            @Override 
            public void mouseClicked(MouseEvent arg0){
                ch2.removeAll();
                try{
                    ConnectionClass obj=new ConnectionClass();
                    String c_username=ch1.getSelectedItem();
                    String q1="select distinct booking_id from car_booking where customer_username='"+c_username+"'";
                    ResultSet rs=obj.stm.executeQuery(q1);
                    while(rs.next()){
                        ch2.add(rs.getString("booking_id"));
                        
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        
    });
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bt1){
            ta.setText("\n-------CAR BOOKING BILL-------");
            try{
                ConnectionClass obj=new ConnectionClass();
                String user_name=ch1.getSelectedItem();
                String booking_id=ch2.getSelectedItem();
                String q3="Select * from car_booking where customer_username='"+user_name+"' and booking_id='"+booking_id+"'";
                ResultSet rest=obj.stm.executeQuery(q3);
                while(rest.next()){
                    ta.append("\n\n Cutomer Name: "+rest.getString("customer_username"));
                    ta.append("\n\n Cutomer Number: "+rest.getString("customer_phone"));
                    ta.append("\n\n ------------------------------------------------\n ");
                    ta.append("\n\n Car Brand: "+rest.getString("brand_name"));
                    ta.append("\n\n Brand Model: "+rest.getString("brand_model"));
                    ta.append("\n\n Car Number: "+rest.getString("car_no"));
                    ta.append("\n\n Car Name: "+rest.getString("car_name"));
                    ta.append("\n\n ------------------------------------------------\n ");
                    ta.append("\n\n Total Days: "+rest.getString("total_days"));
                    ta.append("\n\n Booking Date: "+rest.getString("booking_date"));
                    ta.append("\n\n ------------------------------------------------\n ");
                    
                    float gross_payment=Float.parseFloat(rest.getString("car_rent"));
                    double tax=(gross_payment*2.1)/100;
                    ta.append("\n Gross Payment: " +gross_payment);
                    double total_payment=gross_payment+tax;
                    
                    ta.append("\n Total Payment: "+total_payment);
                    ta.append("\n Tax: "+tax);
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bt2){
            try{
                ta.print();
            }
            catch(Exception wx){
                wx.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new CheckBill().setVisible(true);
    }
}
