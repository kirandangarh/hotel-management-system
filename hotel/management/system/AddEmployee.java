package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfemail,tfsalary,tfphone,tfaadhar;
    JButton submit;
    JRadioButton rbmale,rbfemale,other;
    JComboBox cbjob;
    ButtonGroup bg;
    private void clearForm() {
    tfname.setText("");
    tfage.setText("");
    tfsalary.setText("");
    tfphone.setText("");
    tfemail.setText("");
    tfaadhar.setText("");
    bg.clearSelection(); 
    cbjob.setSelectedIndex(0); 
   }
    AddEmployee()
    {
       setLayout(null);
       JLabel lblname = new JLabel("NAME");
       lblname.setBounds(60, 30, 120, 30);
       lblname.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblname);
       tfname = new JTextField();
       tfname.setBounds(200, 30, 150, 30);
       add(tfname);
       
       JLabel lblgender = new JLabel("GENDER");
       lblgender.setBounds(60, 80, 120, 30);
       lblgender.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblgender);
       
       rbmale = new JRadioButton("MALE");
       rbmale.setBounds(200, 80, 80, 30);
       rbmale.setFont(new Font("Tahoma" , Font.PLAIN,14));
       rbmale.setBackground(Color.white);
       add(rbmale);
   
       rbfemale = new JRadioButton("FEMALE");
       rbfemale.setBounds(290, 80, 90, 30);
       rbfemale.setFont(new Font("Tahoma" , Font.PLAIN,14));
       rbfemale.setBackground(Color.white);
       add(rbfemale);
       
       other = new JRadioButton("OTHER");
       other.setBounds(390, 80, 80, 30); 
       other.setFont(new Font("Tahoma" , Font.PLAIN,14));
       other.setBackground(Color.white);
       add(other);
        
       bg = new ButtonGroup();
       bg.add(rbmale);
       bg.add(rbfemale);
       bg.add(other);
       
       JLabel lblage = new JLabel("AGE");
       lblage.setBounds(60, 130, 120, 30);
       lblage.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblage);
       tfage = new JTextField();
       tfage.setBounds(200, 130, 150, 30);
       add(tfage);
       
       
       
       JLabel lbljob = new JLabel("JOB");
       lbljob.setBounds(60, 180, 120, 30);
       lbljob.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lbljob);
       
       String str[] = {"Front Desk Clerk","Porters","Chef","House Keeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant"};
       cbjob = new JComboBox(str);
       cbjob.setBounds(200,180, 120,30);
       cbjob.setFont(new Font("Tahona", Font.PLAIN, 17));
       cbjob.setBackground(Color.white);
       add(cbjob);
       
       JLabel lblsalary = new JLabel("SALARY");
       lblsalary.setBounds(60, 230, 120, 30);
       lblsalary.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblsalary);
       tfsalary = new JTextField();
       tfsalary.setBounds(200, 230, 150, 30);
       add(tfsalary);
       
       JLabel lblphone = new JLabel("PHONE");
       lblphone.setBounds(60, 280, 120, 30);
       lblphone.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblphone);
       tfphone = new JTextField();
       tfphone.setBounds(200, 280, 150, 30);
       add(tfphone);
       
       JLabel lblemail = new JLabel("E-MAIL");
       lblemail.setBounds(60, 330, 120, 30);
       lblemail.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblemail);
       tfemail = new JTextField();
       tfemail.setBounds(200, 330, 150, 30);
       add(tfemail);
       
       JLabel lblaadhar = new JLabel("AADHAR-NO...");
       lblaadhar.setBounds(60, 380, 120, 30);
       lblaadhar.setFont(new Font("Tahona", Font.PLAIN, 17));
       add(lblaadhar);
       tfaadhar = new JTextField();
       tfaadhar.setBounds(200, 380, 150, 30);
       add(tfaadhar); 
       
       submit = new JButton("SUBMIT");
       submit.setBackground( Color.black);
       submit.setForeground(Color.white);
       submit.setBounds(200, 430, 150, 30);
       submit.addActionListener(this);
       add(submit);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(380, 60, 450, 370);
       add(image);
       
       
       getContentPane().setBackground(Color.white);
       setBounds(350, 200, 850, 540);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name = tfname.getText();
        if(tfname.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Name Should Not Be Empty","Error",JOptionPane.ERROR_MESSAGE);
            tfname.setBackground(Color.red);
            return; 
        }
        String age = tfage.getText();
        
        try {
        int ageInt = Integer.parseInt(age);
        if (ageInt <= 0 || ageInt > 100) {
        JOptionPane.showMessageDialog(null, "Please enter a valid age!", "Error", JOptionPane.ERROR_MESSAGE);
        tfage.setBackground(Color.red);
        return;
         }
        } 
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Age must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        tfage.setBackground(Color.red);
        return;
}
        String salary = tfsalary.getText();
        
        String email = tfemail.getText();
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address!", "Error", JOptionPane.ERROR_MESSAGE);
        tfemail.setBackground(Color.red);
        return;
}

        String phone = tfphone.getText();
        if (!phone.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(null, "Phone number must be 10 digits!", "Error", JOptionPane.ERROR_MESSAGE);
        tfphone.setBackground(Color.red);
        return;
}
        String aadhar = tfaadhar.getText();
        
        String gender = null;
        if(!rbmale.isSelected() && !rbfemale.isSelected() && !other.isSelected())
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
        else if(other.isSelected())
        {
            gender = "Other";
        }
        
        String job = (String)cbjob.getSelectedItem();
        try{
            Conn conn = new Conn();
            
            String query = "Insert into employee values ('"+name+"','"+gender+"','"+age+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            conn.s.executeUpdate(query);
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this employee?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

            JOptionPane.showMessageDialog(null,"Employee Added Successfully!");
            clearForm();
            setVisible(false);
            new Dashboard();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    public static void main(String args[])
    {
        new AddEmployee();
    }
}
