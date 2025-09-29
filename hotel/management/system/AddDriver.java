package hotel.management.system;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener{
    JTextField tfname,tfage ,tfcompany, tfmodel, tflocation;
    JComboBox jbgenopt ,jbavlOptions;
    JRadioButton rbmale,rbfemale;
    JButton adddriver,cancel;
    ButtonGroup bg;
    AddDriver()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font ("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        name.setBounds(60, 70, 120, 30);
        add(name);
        tfname = new JTextField();
        tfname.setBounds(200, 70, 120, 30);
        add(tfname);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        age.setBounds(60, 110, 120, 30);
        add(age);
        tfage = new JTextField();
        tfage.setBounds(200, 110, 120, 30);
        add(tfage);
        
       JLabel lblgender = new JLabel("Gender");
       lblgender.setBounds(60, 150, 120, 30);
       lblgender.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblgender);
       
       rbmale = new JRadioButton("MALE");
       rbmale.setBounds(200, 150, 80, 30);
       rbmale.setFont(new Font("Tahoma" , Font.PLAIN,14));
       rbmale.setBackground(Color.white);
       add(rbmale);
   
       rbfemale = new JRadioButton("FEMALE");
       rbfemale.setBounds(290, 150, 80, 30);
       rbfemale.setFont(new Font("Tahoma" , Font.PLAIN,14));
       rbfemale.setBackground(Color.white);
       add(rbfemale);
       
       bg = new ButtonGroup();
       bg.add(rbmale);
       bg.add(rbfemale);
       
        JLabel company = new JLabel("Car Company");
        company.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        company.setBounds(60, 190, 120, 30);
        add(company);
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 120, 30);
        add(tfcompany);
        
        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        lblmodel.setBounds(60, 230, 120, 30);
        add(lblmodel);
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 120, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Availabe");
        lblavailable.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);
        String avlOptions[] = {"Available","busy"};
        jbavlOptions = new JComboBox(avlOptions);
        jbavlOptions.setBounds(200, 270, 120, 30);
        jbavlOptions.setBackground(Color.white);
        add(jbavlOptions);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font ("Tahoma", Font.PLAIN, 18));
        lbllocation.setBounds(60, 310, 120, 30);
        add(lbllocation);
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 120, 30);
        add(tflocation);
       
        adddriver = new JButton("Add Driver");
        adddriver.setBackground( Color.black);
        adddriver.setForeground(Color.white);
        adddriver.setBounds(60,370,130,30);
        adddriver.addActionListener(this);
        add(adddriver);
        
        cancel= new JButton("Cancel");
        cancel.setBackground( Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
       
         setBounds(300,200,980,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == adddriver)
        {
            String name = tfname.getText();
            String age = tfage.getText();
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
      
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = (String)jbavlOptions.getSelectedItem();
            String location = tflocation.getText();
            try
            {
               Conn conn = new Conn();
               String str1 = "Insert into driver values ('"+name+"', '"+age+"', '"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
               conn.s.executeUpdate(str1);
               JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
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
    public static void main(String[] args)
    {
        new AddDriver();
    }
}
