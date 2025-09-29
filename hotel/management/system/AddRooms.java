package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
    JTextField tfroom,tfprice ;
    JComboBox cbavailable,jbcleanopt,jbtypeopt;
    JButton addroom,cancel;
    AddRooms()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font ("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel roomno = new JLabel("Room Number");
        roomno.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        roomno.setBounds(60, 80, 120, 30);
        add(roomno);
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 120, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        String AvailableOptions[] = {"Available","Occupied"};
        cbavailable = new JComboBox(AvailableOptions);
        cbavailable.setBounds(200, 130, 150, 30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
       
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        String cleanOptions[] = {"Cleaned","Dirty"};
        jbcleanopt = new JComboBox(cleanOptions);
        jbcleanopt.setBounds(200, 180, 150, 30);
        jbcleanopt.setBackground(Color.white);
        add(jbcleanopt);
       
        JLabel roomprice = new JLabel("Price");
        roomprice.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        roomprice.setBounds(60, 230, 120, 30);
        add(roomprice);
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);
        String typeOptions[] = {"Single Bed","Double Bed"};
        jbtypeopt = new JComboBox(typeOptions);
        jbtypeopt.setBounds(200, 280, 150, 30);
        jbtypeopt.setBackground(Color.white);
        add(jbtypeopt);
        
        addroom = new JButton("Add Room");
        addroom.setBackground( Color.black);
        addroom.setForeground(Color.white);
        addroom.setBounds(60,350,130,30);
        addroom.addActionListener(this);
        add(addroom);
        
        cancel= new JButton("Cancel");
        cancel.setBackground( Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
       
        
        
        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == addroom)
        {
            String roomno = tfroom.getText();
            String availability = (String)cbavailable.getSelectedItem();
            String status = (String) jbcleanopt.getSelectedItem();
            String cleaning = (String) jbtypeopt.getSelectedItem();
            String price = tfprice.getText();
            try
            {
               Conn conn = new Conn();
               String str = "Insert into room values ('"+roomno+"', '"+availability+"', '"+status+"','"+price+"','"+ cleaning+"')";
               conn.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null, "New Room Added Successfully");
               setVisible(false);
               new Dashboard();
               
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new AddRooms();
    }
}
