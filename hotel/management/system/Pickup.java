package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
import javax.swing.border.Border;
public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
         JLabel lbltext = new JLabel("Pickup Service");
         lbltext.setFont(new Font("Tahoma",Font.PLAIN,20));
         lbltext.setBounds(400,30,200,30);
         add(lbltext);
        
         
         JLabel lblcar = new JLabel("Type of Car");
         lblcar.setBounds(50,100,100,20);
         add(lblcar);
         typeofcar = new Choice();
         typeofcar.setBounds(150,100,200,25);
         add(typeofcar);
         try
         {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                typeofcar.add(rs.getString("model"));
            }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
         
         available = new JCheckBox("Only Display Available");
         available.setBounds(650,100,150,25);
         available.setBackground(Color.white);
         add(available);
        
         JLabel lblname = new JLabel("Name");
         lblname.setBounds(0,180,143,20);
         add(lblname);
         Border border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblname.setBorder(border);
         
         JLabel lblage = new JLabel("Age");
         lblage.setBounds(143,180,143,20);
         add(lblage);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblage.setBorder(border);
         
         
         JLabel lblgender = new JLabel("Gender");
         lblgender.setBounds(286,180,143,20);
         add(lblgender);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblgender.setBorder(border);
         
         
         JLabel lblcompany = new JLabel("Company");
         lblcompany.setBounds(429,180,143,20);
         add(lblcompany);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblcompany.setBorder(border);
         
         
         JLabel lblmodel = new JLabel("Model");
         lblmodel.setBounds(572,180,143,20);
         add(lblmodel);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblmodel.setBorder(border);
         
         JLabel lblavail = new JLabel("Availability");
         lblavail.setBounds(715,180,143,20);
         add(lblavail);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblavail.setBorder(border);
         
         JLabel lbllocation = new JLabel("Location");
         lbllocation.setBounds(858,180,143,20);
         add(lbllocation);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lbllocation.setBorder(border);
         
         table = new JTable();
         table.setBounds(0,200,1000,300);
         add(table);
         try
         {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from driver");
           table.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        
         
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(350,520,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(550,520,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()== submit)
        {
            try{
       
                String query1 = "select * from driver where model = '"+typeofcar.getSelectedItem()+"'";
                String query2 = "select * from driver where available = 'Available' AND model = '"+typeofcar.getSelectedItem()+"'";
                Conn conn = new Conn();
                ResultSet rs;
                if (available.isSelected())
                {
                rs = conn.s.executeQuery(query2);
                }
                else
                {
                 rs = conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String args[])
    {
        new Pickup();
    }
}
