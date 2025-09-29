package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfRoom, tfavail, tfstatus;
    JButton check, back, update;

    UpdateRoom() {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lbltext = new JLabel("Update Room Status");
        lbltext.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbltext.setBounds(30, 20, 250, 30);
        lbltext.setForeground(Color.blue);
        add(lbltext);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add(rs.getString("num"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30, 130, 100, 20);
        add(lblRoom);
        tfRoom = new JTextField();
        tfRoom.setBounds(200, 130, 150, 25);
        add(tfRoom);

        JLabel lblavail = new JLabel("Availability");
        lblavail.setBounds(30, 180, 100, 20);
        add(lblavail);
        tfavail = new JTextField();
        tfavail.setBounds(200, 180, 150, 25);
        add(tfavail);

        JLabel lblstatus = new JLabel("Cleaning Ststus");
        lblstatus.setBounds(30, 230, 100, 20);
        add(lblstatus);
        tfstatus = new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);


        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(270, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
           String id = customer.getSelectedItem();
           String query = "select * from customer where num = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfRoom.setText(rs.getString("room"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfRoom.getText() + "'");
                while(rs2.next())
                {
                    tfavail.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
       }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number = customer.getSelectedItem();
            String room = tfRoom.getText();
            String avail = tfavail.getText();
            String status = tfstatus.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set roomnumber = '" + room + "', availability = '" + avail + "', cleaning_status = '" + status +"' where roomnumber = '" + tfRoom.getText() + "'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[]) {
        new UpdateRoom();
    }
}
