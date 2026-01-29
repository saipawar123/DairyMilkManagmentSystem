package src;
import javax.swing.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard");
        setSize(350,300);
        setLayout(null);

        JButton f=new JButton("Add Farmer");
        JButton v=new JButton("View Farmers");
        JButton m=new JButton("Milk Collection");
        JButton r=new JButton("Reports");
        JButton p=new JButton("Payment Summary");

        f.setBounds(90,20,160,30);
        v.setBounds(90,60,160,30);
        m.setBounds(90,100,160,30);
        r.setBounds(90,140,160,30);
        p.setBounds(90,180,160,30);

        add(f);add(v);add(m);add(r);add(p);

        f.addActionListener(e->new FarmerFrame());
        v.addActionListener(e->new ViewFarmerFrame());
        m.addActionListener(e->new MilkCollectionFrame());
        r.addActionListener(e->new ReportFrame());
        p.addActionListener(e->new PaymentSummaryFrame());

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}