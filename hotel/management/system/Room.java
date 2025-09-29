package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
import javax.swing.border.Border;
public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600,600);
        add(image);
        
         JLabel lblroom = new JLabel("Room Number");
         lblroom.setBounds(0,10,100,20);
         add(lblroom);
         Border border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblroom.setBorder(border);
         
         JLabel lblavail = new JLabel("Availability");
         lblavail.setBounds(100,10,100,20);
         add(lblavail);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblavail.setBorder(border);
         
         
         JLabel lblstatus = new JLabel("Room Status");
         lblstatus.setBounds(200,10,100,20);
         add(lblstatus);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblstatus.setBorder(border);
         
         
         JLabel lblprice = new JLabel("Price");
         lblprice.setBounds(300,10,100,20);
         add(lblprice);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblprice.setBorder(border);
         
         
         JLabel lbltype = new JLabel("Bed-Type");
         lbltype.setBounds(400,10,100,20);
         add(lbltype);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lbltype    .setBorder(border);
         
         
         
         
         table = new JTable();
         table.setBounds(0,40,500,400);
         add(table);
         try
         {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from room");
           table.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String args[])
    {
        new Room();
    }
}
