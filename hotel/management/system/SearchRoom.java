package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;
import javax.swing.border.Border;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
         JLabel lbltext = new JLabel("Search for Room");
         lbltext.setFont(new Font("Tahoma",Font.PLAIN,20));
         lbltext.setBounds(400,30,200,30);
         add(lbltext);
        
         
         JLabel lblbed = new JLabel("Bed Type");
         lblbed.setBounds(50,100,100,20);
         add(lblbed);
         bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
         bedtype.setBounds(150, 100, 150, 25);
         bedtype.setBackground(Color.white);
         add(bedtype);
         
         available = new JCheckBox("Only Display Available");
         available.setBounds(650,100,150,25);
         available.setBackground(Color.white);
         add(available);
        
         JLabel lblroom = new JLabel("Room Number");
         lblroom.setBounds(0,180,200,20);
         add(lblroom);
         Border border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblroom.setBorder(border);
         
         JLabel lblavail = new JLabel("Availability");
         lblavail.setBounds(200,180,200,20);
         add(lblavail);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblavail.setBorder(border);
         
         
         JLabel lblstatus = new JLabel("Room Status");
         lblstatus.setBounds(400,180,200,20);
         add(lblstatus);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblstatus.setBorder(border);
         
         
         JLabel lblprice = new JLabel("Price");
         lblprice.setBounds(600,180,200,20);
         add(lblprice);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lblprice.setBorder(border);
         
         
         JLabel lbltype = new JLabel("Bed-Type");
         lbltype.setBounds(800,180,200,20);
         add(lbltype);
         border = BorderFactory.createLineBorder(Color.BLACK, 2); 
         lbltype    .setBorder(border);
         
         
         
         
         table = new JTable();
         table.setBounds(0,200,1000,300);
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
       
                String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
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
        new SearchRoom();
    }
}
