package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton customer, room, department, allemployee,customers,manager,checkout,updatestatus,roomstatus,pickup,search,logout;
    Reception()
    {
       getContentPane().setBackground(Color.white);
        setLayout(null);  
        
        customer = new JButton("New Customer Form");
        customer.setBounds(10,30,200,30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);
        
        room = new JButton("Rooms");
        room.setBounds(10,70,200,30);
        room.setBackground(Color.black);
        room.setForeground(Color.white);
        room.addActionListener(this);
        add(room);
        
        
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);
        
        allemployee = new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.black);
        allemployee.setForeground(Color.white);
        allemployee.addActionListener(this);
        add(allemployee);
        
        customers = new JButton("Customer Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        add(customers);
        
        manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);
        
        checkout = new JButton("CheckOut");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        updatestatus = new JButton("Update Status");
        updatestatus.setBounds(10,310,200,30);
        updatestatus.setBackground(Color.black);
        updatestatus.setForeground(Color.white);
        updatestatus.addActionListener(this);
        add(updatestatus);
        
        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.black);
        roomstatus.setForeground(Color.white);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
        
        search = new JButton("Search Room");
        search.setBounds(10,430,200,30);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
       
        setBounds(350, 200 , 800, 570);
        setVisible(true);
      
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == customer )
        {
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == room)
        {
            setVisible(false);
            new Room();
        }
         else if(ae.getSource() == department)
        {
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allemployee)
        {
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == customers)
        {
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == manager)
        {
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == search )
        {
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == updatestatus)
        {
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomstatus)
        {
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickup)
        {
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource() == checkout)
        {
            setVisible(false);
            new CheckOut();
        }
        else
        {
            setVisible(false);
            System.exit(0);
        }
    }
   public static void main(String args[])
   {
       new Reception();
   }
}
