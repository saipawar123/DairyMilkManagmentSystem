package src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewFarmerFrame extends JFrame {
    DefaultTableModel model;

    public ViewFarmerFrame() {
        setTitle("Farmers");
        setSize(500,300);
        model=new DefaultTableModel(
            new String[]{"ID","Name","Village","Mobile"},0);
        JTable table=new JTable(model);
        add(new JScrollPane(table));
        load();
        setVisible(true);
    }

    void load() {
        try {
            Connection con=DBConnection.getConnection();
            ResultSet rs=con.createStatement().executeQuery("SELECT * FROM farmer");
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt("farmer_id"),
                    rs.getString("name"),
                    rs.getString("village"),
                    rs.getString("mobile")
                });
            }
        } catch(Exception e){e.printStackTrace();}
    }
}