package src;
import javax.swing.*;
import java.sql.*;

public class LoginFrame extends JFrame {
    JTextField user;
    JPasswordField pass;

    public LoginFrame() {
        setTitle("Admin Login");
        setSize(300,200);
        setLayout(null);

        JLabel l1=new JLabel("Username");
        JLabel l2=new JLabel("Password");
        user=new JTextField();
        pass=new JPasswordField();
        JButton btn=new JButton("Login");

        l1.setBounds(30,30,80,25);
        l2.setBounds(30,70,80,25);
        user.setBounds(120,30,120,25);
        pass.setBounds(120,70,120,25);
        btn.setBounds(90,120,100,30);

        add(l1);add(l2);add(user);add(pass);add(btn);
        btn.addActionListener(e->login());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void login() {
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
                "SELECT * FROM admin WHERE username=? AND password=?");
            ps.setString(1,user.getText());
            ps.setString(2,pass.getText());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid Login");
            }
        } catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}