package src;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class PaymentSummaryFrame extends JFrame {
    DefaultTableModel model;

    public PaymentSummaryFrame() {
        setTitle("Payment Summary");
        setSize(400,300);
        model=new DefaultTableModel(
            new String[]{"Farmer ID","Total Amount"},0);
        JTable table=new JTable(model);
        add(new JScrollPane(table));
        load();
        setVisible(true);
    }

    void load() {
        try {
            Connection con=DBConnection.getConnection();
            ResultSet rs=con.createStatement().executeQuery(
                "SELECT farmer_id, SUM(amount) total FROM milk_collection GROUP BY farmer_id");
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt("farmer_id"),
                    rs.getDouble("total")
                });
            }
        } catch(Exception e){e.printStackTrace();}
    }
}