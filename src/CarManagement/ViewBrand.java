package CarManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class ViewBrand extends JFrame implements ActionListener {
    String x[]={"Brand ID","Brand Name", "Model Name", "Year"};
    String y[][]=new String[20][4];
    int i=0, j=0;
    JTable t;
    Font f, f1;
    JLabel l1,l2;
    JTextField tf1;
    JButton bt1;
    JPanel p1, p2, p3;
    ViewBrand(){
        super("Brand Information");
        setSize(1000, 400);
        setLocation(180, 160);
        f=new Font("Consolas", Font.BOLD,15);
        
        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select * from carbrand";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("brand_id");
                y[i][j++]=rest.getString("brand_name");
                y[i][j++]=rest.getString("car_model");
                y[i][j++]=rest.getString("year");
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
        f1=new Font("Courier New", Font.BOLD, 30);
        JScrollPane sp=new JScrollPane(t);
        l1=new JLabel("Delete Any Car Brand");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.ORANGE);
        add(sp);
        
        l2=new JLabel("Brand/Model ID");
        l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        tf1=new JTextField();
        tf1.setFont(f);
        
        bt1=new JButton("Delete Brand/Model");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        bt1.setFont(f);
        bt1.addActionListener(this);
        
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
        if(e.getSource()==bt1){
            String brand_id=tf1.getText();
            
            if(brand_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Fill The Brand ID");
            }
            else{
                try{
                    ConnectionClass obj=new ConnectionClass();
                    String q="delete from carbrand where brand_id='"+brand_id+"'";
                    int res=obj.stm.executeUpdate(q);
                    if(res==1){
                        JOptionPane.showMessageDialog(null, "Bike Brand/Model Record Is Deleted!!");
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Bike Brand/Model Record Does Match!!");
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){
        new ViewBrand().setVisible(true);
    }
    
}
