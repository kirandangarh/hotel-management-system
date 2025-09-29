package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField number,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;
    ButtonGroup bg;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    AddCustomer()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);  
      
        JLabel text = new JLabel("New Customer Forrm");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel lblid = new JLabel("ID");
        lblid .setBounds(35,80,100,25);
        lblid .setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid );
        
        String options[] = {"Aadhar Card","Driving License","Passport","PAN Card","Voter-Id card","Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber .setBounds(35,120,100,25);
        lblnumber .setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber );
        number = new JTextField();
        number.setBounds(200, 120, 150, 25);
        add(number);
        
        JLabel lblname = new JLabel("Name");
        lblname .setBounds(35,160,100,25);
        lblname .setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname );
        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,25);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender );
       
       rbmale = new JRadioButton("MALE");
       rbmale.setBounds(200, 200, 80, 25);
       rbmale.setFont(new Font("Tahoma" , Font.PLAIN,14));
       rbmale.setBackground(Color.white);
       add(rbmale);
   
       rbfemale = new JRadioButton("FEMALE");
       rbfemale.setBounds(290, 200, 80, 25);
       rbfemale.setFont(new Font("Tahoma" , Font.PLAIN,14));
       rbfemale.setBackground(Color.white);
       add(rbfemale);
       
       bg = new ButtonGroup();
       bg.add(rbmale);
       bg.add(rbfemale);
       
       JLabel lblcountry = new JLabel("Country");
       lblcountry.setBounds(35,240,100,25);
       lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
       add(lblcountry);
       tfcountry = new JTextField();
       tfcountry.setBounds(200, 240, 150, 25);
       add(tfcountry);
       
       JLabel lblroom = new JLabel("Allocated Room");
       lblroom.setBounds(35,280,150,25);
       lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
       add(lblroom);
       
       croom = new Choice();
       try
       {
           Conn conn = new Conn();
           String query = "select * from room where availability ='Available'";
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next())
                   {
                       croom.add(rs.getString("roomnumber"));
                   }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       croom.setBounds(200, 280,150,25);
       add(croom);
       
        JLabel lbltime = new JLabel("Check-In Time");
        lbltime.setBounds(35,320,150,25);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
        Date date = new Date();
        checkintime = new JLabel(""+date);
        checkintime.setBounds(200, 320, 150, 25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,25);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBounds(50, 410, 120,30);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(210, 410, 120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        
        setBounds(350, 200 , 800, 550);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String id = (String)comboid.getSelectedItem();
            String num = number.getText();
            String name = tfname.getText();
            String gender = null;
        if(!rbmale.isSelected() && !rbfemale.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Please Select a gender!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        else if(rbmale.isSelected())
        {
            gender = "Male";
        }
        else if(rbfemale.isSelected())
        {
            gender = "Female";
        }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String intime = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            
            try{
               Conn conn = new Conn();
               String query = "Insert into customer values ('"+id+"','"+num+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+intime+"','"+deposit+"')";
               String query2 = "Update room SET availability = 'Occupied' where roomnumber='"+room+"'";
               conn.s.executeUpdate(query);
               conn.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
               setVisible(false);
               new Reception();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
            new Reception();
        }
    }
   public static void main(String[] args)
   {
       new AddCustomer();
   }
}
