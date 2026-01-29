package src;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class MilkCollectionFrame extends JFrame {
    JTextField fid,qty,fat;
    JComboBox<String> session;

    public MilkCollectionFrame() {
        setTitle("Milk Collection");
        setSize(350,320);
        setLayout(null);

        JLabel l1=new JLabel("Farmer ID");
        JLabel l2=new JLabel("Session");
        JLabel l3=new JLabel("Quantity");
        JLabel l4=new JLabel("Fat");

        fid=new JTextField();
        qty=new JTextField();
        fat=new JTextField();
        session=new JComboBox<>(new String[]{"Morning","Evening"});
        JButton save=new JButton("Save");

        l1.setBounds(30,30,100,25);
        l2.setBounds(30,70,100,25);
        l3.setBounds(30,110,100,25);
        l4.setBounds(30,150,100,25);
        fid.setBounds(140,30,120,25);
        session.setBounds(140,70,120,25);
        qty.setBounds(140,110,120,25);
        fat.setBounds(140,150,120,25);
        save.setBounds(120,210,100,30);

        add(l1);add(l2);add(l3);add(l4);
        add(fid);add(session);add(qty);add(fat);add(save);

        save.addActionListener(e->saveMilk());
        setVisible(true);
    }

    void saveMilk() {
        try {
            double q=Double.parseDouble(qty.getText());
            double f=Double.parseDouble(fat.getText());
            double rate=Utils.calculateRate(f);
            double amount=q*rate;

            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                "INSERT INTO milk_collection VALUES(NULL,?,?,?,?,?,?,?)");
            ps.setInt(1,Integer.parseInt(fid.getText()));
            ps.setString(2,session.getSelectedItem().toString());
            ps.setDouble(3,q);
            ps.setDouble(4,f);
            ps.setDouble(5,rate);
            ps.setDouble(6,amount);
            ps.setDate(7,new java.sql.Date(new Date().getTime()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Saved Amount="+amount);
        } catch(Exception e){e.printStackTrace();}
    }
}