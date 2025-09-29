package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfRoom, tfName, tfCheckin, tfPaid, tfPending;
    JButton check, back, update;

    UpdateCheck() {
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lbltext = new JLabel("Update Status");
        lbltext.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbltext.setBounds(90, 20, 200, 30);
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
        lblRoom.setBounds(30, 120, 100, 20);
        add(lblRoom);
        tfRoom = new JTextField();
        tfRoom.setBounds(200, 120, 150, 25);
        add(tfRoom);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 160, 100, 20);
        add(lblName);
        tfName = new JTextField();
        tfName.setBounds(200, 160, 150, 25);
        add(tfName);

        JLabel lblCheckin = new JLabel("Checkin Time");
        lblCheckin.setBounds(30, 200, 100, 20);
        add(lblCheckin);
        tfCheckin = new JTextField();
        tfCheckin.setBounds(200, 200, 150, 25);
        add(tfCheckin);

        JLabel lblPaid = new JLabel("Amount Paid");
        lblPaid.setBounds(30, 240, 100, 20);
        add(lblPaid);
        tfPaid = new JTextField();
        tfPaid.setBounds(200, 240, 150, 25);
        add(tfPaid);

        JLabel lblPending = new JLabel("Pending Amount");
        lblPending.setBounds(30, 280, 100, 20);
        add(lblPending);
        tfPending = new JTextField();
        tfPending.setBounds(200, 280, 150, 25);
        add(tfPending);

        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            try {
                Conn c = new Conn();
                String id = customer.getSelectedItem();
                String query = "select * from customer where num = '" + id + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfRoom.setText(rs.getString("room"));
                    tfName.setText(rs.getString("name"));
                    tfCheckin.setText(rs.getString("CheckInTime"));
                    tfPaid.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '" + tfRoom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfPaid.getText());
                    tfPending.setText(" " + amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number = customer.getSelectedItem();
            String room = tfRoom.getText();
            String name = tfName.getText();
            String checkin = tfCheckin.getText();
            String deposit = tfPaid.getText();
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '" + room + "', name = '" + name + "', CheckInTime = '" + checkin + "', deposit = '" + deposit + "' where num = '" +number+ "'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[]) {
        new UpdateCheck();
    }
}
