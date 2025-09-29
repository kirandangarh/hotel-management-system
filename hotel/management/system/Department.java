package hotel.management.system;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
         JLabel l1 = new JLabel("Department");
         l1.setBounds(0, 15, 350, 30);
         add(l1);
         Border border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         l1.setBorder(border);

         
         JLabel l2 = new JLabel("Budget");
         l2.setBounds(350, 15, 335, 30);
         add(l2);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         l2.setBorder(border);
         
         table = new JTable();
         table.setBounds(0,50,700,350);
         add(table);
         try
         {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from department");
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
        back.setBounds(280,400,120,30);
        add(back);
        
        setBounds(400,200,700,480);
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
        new Department();
    }
}
