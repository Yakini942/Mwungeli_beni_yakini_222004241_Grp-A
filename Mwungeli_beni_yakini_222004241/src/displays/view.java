package displays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class view {
	private static String url = "jdbc:mysql://localhost:3306/touch";
	private static String user = "root";
	private static String Password = "";
	private static String query = "SELECT * FROM registration";
	 JFrame frame = new JFrame("Departments");
	 JPanel panel = new JPanel(new BorderLayout());
	 DefaultTableModel model = new DefaultTableModel();
	 JTable table = new JTable(model);
	 JScrollPane scrollPane = new JScrollPane(table);
	 public view(){
		 showframe();
		 addpaner();
	     paneshow();
	     makeconnection();
	 }
    public void showframe() {
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
	}
	
	private void paneshow() {
		// TODO Auto-generated method stub
		panel.setPreferredSize(new Dimension(580, 280));
		panel.add(scrollPane, BorderLayout.CENTER);
		
	}
	private void addpaner() {
		// TODO Auto-generated method stub
		frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.CENTER;
        frame.add(panel, gbc);
        	
	}
	private void makeconnection() {
		// TODO Auto-generated method stub
		   try {
	            Connection connection = DriverManager.getConnection(url, user, Password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);

	            // Get metadata about the ResultSet
	            ResultSetMetaData metaData = resultSet.getMetaData();

	            // Get the number of columns in the ResultSet
	            int columnCount = metaData.getColumnCount();

	            // Add column names to the table model
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(metaData.getColumnName(i));
	            }

	            // Add rows to the table model
	            while (resultSet.next()) {
	                Object[] row = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    row[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(row);
	            }

	            // Close the resources
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	        }
		
	}
	public static void main(String[] args) {
		view as = new view();	
     
    }
}
