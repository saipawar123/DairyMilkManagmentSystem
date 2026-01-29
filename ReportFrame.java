package src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ReportFrame extends JFrame {
    DefaultTableModel model;

    public ReportFrame() {
        setTitle("Report");
        setSize(600,300);
        model=new DefaultTableModel(
            new String[]{"Farmer","Session","Qty","Fat","Amount","Date"},0);
        JTable table=new JTable(model);
        add(new JScrollPane(table));
        load();
        setVisible(true);
    }

    void load() {
        try {
            Connection con=DBConnection.getConnection();
            ResultSet rs=con.createStatement().executeQuery("SELECT * FROM milk_collection");
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt("farmer_id"),
                    rs.getString("session"),
                    rs.getDouble("quantity"),
                    rs.getDouble("fat"),
                    rs.getDouble("amount"),
                    rs.getDate("date")
                });
            }
        } catch(Exception e){e.printStackTrace();}
    }
}