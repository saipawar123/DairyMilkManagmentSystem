package src;
import javax.swing.*;
import java.sql.*;

public class FarmerFrame extends JFrame {
    JTextField name,village,mobile;

    public FarmerFrame() {
        setTitle("Farmer Registration");
        setSize(350,260);
        setLayout(null);

        JLabel l1=new JLabel("Name");
        JLabel l2=new JLabel("Village");
        JLabel l3=new JLabel("Mobile");

        name=new JTextField();
        village=new JTextField();
        mobile=new JTextField();
        JButton save=new JButton("Save");

        l1.setBounds(30,30,80,25);
        l2.setBounds(30,70,80,25);
        l3.setBounds(30,110,80,25);
        name.setBounds(120,30,150,25);
        village.setBounds(120,70,150,25);
        mobile.setBounds(120,110,150,25);
        save.setBounds(120,160,100,30);

        add(l1);add(l2);add(l3);
        add(name);add(village);add(mobile);add(save);

        save.addActionListener(e->addFarmer());
        setVisible(true);
    }

    void addFarmer() {
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                "INSERT INTO farmer(name,village,mobile) VALUES(?,?,?)");
            ps.setString(1,name.getText());
            ps.setString(2,village.getText());
            ps.setString(3,mobile.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Farmer Added");
        } catch(Exception e){e.printStackTrace();}
    }
}