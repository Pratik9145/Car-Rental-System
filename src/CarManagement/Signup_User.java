package CarManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Signup_User implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14;
    JButton b1, b2;
    JFrame f;
    JPasswordField pf;
    JComboBox<String> genderComboBox;
    Font f1,f2,f3;

    Signup_User() {
        f3=new Font("Courier New", Font.BOLD, 30);
        f1=new Font("Courier New", Font.BOLD, 20);
        f2=new Font("Consolas", Font.BOLD, 15);
        
        f = new JFrame("Add User Details For SignUp");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 840, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(Signup_User.class.getResource("Icons/Home_car.jpg"));
        Image i1 = img.getImage().getScaledInstance(1200, 857, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Add Your Details");
        l2.setBounds(230, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Name");
        l3.setBounds(50, 150, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.WHITE);
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setBounds(200, 150, 150, 30);
        tf1.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf1);

        l4 = new JLabel("Username");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.WHITE);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setBounds(600, 150, 150, 30);
        tf2.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf2);

        l5 = new JLabel("Password");
        l5.setBounds(50, 200, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.WHITE);
        l1.add(l5);

        pf = new JPasswordField();
        pf.setBounds(200, 200, 150, 30);
        pf.setFont(new Font("Arial", Font.BOLD, 15));
        l1.add(pf);

        l6 = new JLabel("Email");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.WHITE);
        l1.add(l6);

        tf3 = new JTextField();
        tf3.setBounds(600, 200, 150, 30);
        tf3.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf3);

        l7 = new JLabel("Father Name");
        l7.setBounds(50, 250, 140, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.WHITE);
        l1.add(l7);

        tf4 = new JTextField();
        tf4.setBounds(200, 250, 150, 30);
        tf4.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf4);

        l8 = new JLabel("Phone");
        l8.setBounds(450, 250, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.WHITE);
        l1.add(l8);

        tf5 = new JTextField();
        tf5.setBounds(600, 250, 150, 30);
        tf5.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf5);

        l9 = new JLabel("Adhar Number");
        l9.setBounds(50, 300, 160, 30);
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setForeground(Color.WHITE);
        l1.add(l9);

        tf6 = new JTextField();
        tf6.setBounds(200, 300, 150, 30);
        tf6.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf6);

        l10 = new JLabel("City");
        l10.setBounds(450, 300, 100, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.WHITE);
        l1.add(l10);

        tf7 = new JTextField();
        tf7.setBounds(600, 300, 150, 30);
        tf7.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf7);

        l11 = new JLabel("Gender");
        l11.setBounds(50, 350, 100, 30);
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setForeground(Color.WHITE);
        l1.add(l11);
        
        genderComboBox = new JComboBox<>();
        genderComboBox.addItem("Male");
        genderComboBox.addItem("Female");
        genderComboBox.addItem("Other");
        genderComboBox.setBounds(200, 350, 150, 30);
        genderComboBox.setFont(new Font("Arial", Font.BOLD, 15));
        l1.add(genderComboBox);

        
        tf8 = new JTextField();
        tf8.setBounds(200, 350, 150, 30);
        tf8.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf8);

        l12 = new JLabel("Blood Group");
        l12.setBounds(450, 350, 140, 30);
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setForeground(Color.WHITE);
        l1.add(l12);

        tf9 = new JTextField();
        tf9.setBounds(600, 350, 150, 30);
        tf9.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf9);

        l13 = new JLabel("Age");
        l13.setBounds(50, 400, 100, 30);
        l13.setFont(new Font("Arial", Font.BOLD, 20));
        l13.setForeground(Color.WHITE);
        l1.add(l13);

        tf10 = new JTextField();
        tf10.setBounds(200, 400, 150, 30);
        tf10.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf10);

        l14 = new JLabel("DOB");
        l14.setBounds(450, 400, 150, 30);
        l14.setFont(new Font("Arial", Font.BOLD, 20));
        l14.setForeground(Color.WHITE);
        l1.add(l14);

        tf11 = new JTextField();
        tf11.setBounds(600, 400, 150, 30);
        tf11.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf11);

        l15 = new JLabel("Dr. Licence");
        l15.setBounds(50, 450, 180, 30);
        l15.setFont(new Font("Arial", Font.BOLD, 20));
        l15.setForeground(Color.WHITE);
        l1.add(l15);

        tf12 = new JTextField();
        tf12.setBounds(200, 450, 150, 30);
        tf12.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf12);

        l16 = new JLabel("Address");
        l16.setBounds(450, 450, 140, 30);
        l16.setFont(new Font("Arial", Font.BOLD, 20));
        l16.setForeground(Color.WHITE);
        l1.add(l16);

        tf13 = new JTextField();
        tf13.setBounds(600, 450, 150, 30);
        tf13.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf13);
        
        l17 = new JLabel("Dr. Lic. No");
        l17.setBounds(50, 500, 260, 30);
        l17.setFont(new Font("Arial", Font.BOLD, 20));
        l17.setForeground(Color.WHITE);
        l1.add(l17);

        tf14 = new JTextField();
        tf14.setBounds(200, 500, 150, 30);
        tf14.setFont(new Font("Consolas", Font.BOLD, 15));
        l1.add(tf14);

        b1 = new JButton("Submit");
        b2 = new JButton("Back");

        b1.setBounds(400, 500, 150, 40);
        b2.setBounds(600, 500, 150, 40);

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.RED);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        b1.setFont(f1);
        b2.setFont(f1);
        
        l1.add(b1);
        l1.add(b2);

        f.setVisible(true);
        f.setSize(840, 600);
        f.setLocation(300, 100);
        
        l1.setFont(f1);
        l2.setFont(f3);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l12.setFont(f1);
        l13.setFont(f1);
        l11.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        l16.setFont(f1);
        l17.setFont(f1);
        
     
    }

    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
        String name = tf1.getText();
        String username = tf2.getText();
        String password = new String(pf.getPassword()); // Correctly retrieving password from JPasswordField
        String email = tf3.getText();
        String father_name = tf4.getText();
        String phone = tf5.getText();
        String adhar_no = tf6.getText();
        String city = tf7.getText();
        String gender = (String) genderComboBox.getSelectedItem(); // Corrected getting selected gender from JComboBox
        String blood_group = tf9.getText();
        int age = Integer.parseInt(tf10.getText());
        String dob = tf11.getText();
        String driving_license = tf12.getText();
        String dr_lic_no=tf14.getText();
        String address = tf13.getText();
        
        Random r = new Random();
        String user_id = String.valueOf(Math.abs(r.nextInt() % 100000));

        if ((age >= 18) && (driving_license.toLowerCase().equals("yes"))) {
            try {
    ConnectionClass obj = new ConnectionClass();
    String q = "INSERT INTO user (user_id, name, username, password, email, father_name, phone, adhar_no, city, gender, blood_group, age, dob, driving_license, dr_lic_no, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
    PreparedStatement pst = obj.con.prepareStatement(q);
    pst.setString(1, user_id);
    pst.setString(2, name);
    pst.setString(3, username);
    pst.setString(4, password);
    pst.setString(5, email);
    pst.setString(6, father_name);
    pst.setString(7, phone);
    pst.setString(8, adhar_no);
    pst.setString(9, city);
    pst.setString(10, gender);
    pst.setString(11, blood_group);
    pst.setInt(12, age);
    pst.setString(13, dob);
    pst.setString(14, driving_license);
    pst.setString(15, dr_lic_no);
    pst.setString(16, address);
    int rowsAffected = pst.executeUpdate();
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
        f.setVisible(false);
    } else {
        JOptionPane.showMessageDialog(null, "Failed to insert data into the database.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
}
        } else {
            JOptionPane.showMessageDialog(null, "You are not eligible because you don't have a driving licence or you are under age.");
        }
    }
    if (e.getSource() == b2) {
        new Login();
        f.setVisible(false);
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Signup_User();
        });
    }
}
