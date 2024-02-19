package touch;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class instructor implements ActionListener{
	static final String JDBC_DRIVER = "your_jdbc_driver";
	String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
    String UserN = "222004241";
    String PassD = "222004241";
	String[] departmentOptions = {" ", "Professor", "Administrator", "Library"};
	
	JFrame frame ;
	JLabel fname_lb=new JLabel("First name");
	JLabel lname_lb=new JLabel("Last Name");
	JLabel email_lb=new JLabel("Email");
	JLabel telephone_lb=new JLabel("Telephone");
	JLabel gender_lb=new JLabel("Gender");
	JLabel ad_lb = new JLabel("Address");
	JLabel dp_lb = new JLabel("Department");
	JLabel rank_lb = new JLabel("Password");

	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField telephone_txf=new JTextField();
	JTextField ad_txf = new JTextField();
	JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
	JTextField gender_txf = new JTextField();
	JPasswordField rank_txf = new JPasswordField();

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public instructor() {
		createForm();
	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);	
	}
	private void createForm() {
		frame = new JFrame();
		frame.setTitle("INSTRUCTORS");
		frame.setBounds(0, 0, 400, 500);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);	
		
		setLocationandSize();
		}
	private void setLocationandSize() {
		fname_lb.setBounds(10, 50, 100, 30);
		lname_lb.setBounds(10, 90, 100, 30);
		email_lb.setBounds(10, 130, 100, 30);
		telephone_lb.setBounds(10, 170, 100, 30);
		gender_lb.setBounds(10, 210, 100, 30);
		ad_lb.setBounds(10, 250, 100, 30);
		dp_lb.setBounds(10, 290, 100, 30);
		rank_lb.setBounds(10, 330, 100, 30);
		
		fname_txf.setBounds(160, 50, 130, 30);
		lname_txf.setBounds(160, 90, 130, 30);
		email_txf.setBounds(160, 130, 130, 30);
		telephone_txf.setBounds(160, 170, 130, 30);
		gender_txf.setBounds(160, 210, 130, 30);
		ad_txf.setBounds(160, 250, 130, 30);
		departmentComboBox.setBounds(160, 290, 130, 30);
		rank_txf.setBounds(160, 330, 130, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(65,390, 85, 30);
		Read_btn.setBounds(200,390, 85, 30);
		addcomponentforFrame();
		setFontforall();
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 14);

		fname_lb.setFont(font);
		lname_lb.setFont(font);
		email_lb.setFont(font);
		telephone_lb.setFont(font);
		ad_lb.setFont(font);
		dp_lb.setFont(font);
		rank_lb.setFont(font);

		fname_txf.setFont(font);
		lname_txf.setFont(font);
		email_txf.setFont(font);
		telephone_txf.setFont(font);
		gender_lb.setFont(font);
		gender_txf.setFont(font);
		ad_txf.setFont(font);
		departmentComboBox.setFont(font);
		rank_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		
	}
	private void addcomponentforFrame() {
		
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(email_lb);
		frame.add(telephone_lb);
		frame.add(gender_lb);
		frame.add(ad_lb);
		frame.add(dp_lb);
		frame.add(rank_lb);

		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(email_txf);
		frame.add(telephone_txf);
		frame.add(gender_txf);
		frame.add(ad_txf);
		frame.add(departmentComboBox);
		frame.add(rank_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		
		ActionEvent();
		}
	private void resetTextFields() {
        fname_txf.setText("");
        lname_txf.setText("");
        email_txf.setText("");
        gender_txf.setText("");
        telephone_txf.setText("");
        ad_txf.setText("");
        rank_txf.setText("");
        // Clear the department combo box selection
        departmentComboBox.setSelectedIndex(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()== insert_btn) {
			String Fname = fname_txf.getText();
			String Lname = lname_txf.getText();
			String Email = email_txf.getText();
			String Telephone = telephone_txf.getText();
			String Address = ad_txf.getText();
			String Department = (String) departmentComboBox.getSelectedItem();
			String Rank = rank_txf.getText();
			String Gender = gender_txf.getText();
			
			if (Fname.isEmpty() || Lname.isEmpty() || Email.isEmpty() || Telephone.isEmpty() || Address.isEmpty() || Department.isEmpty() || Rank.isEmpty() || Gender.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields!");
	            return; 
			}
		String resql = "INSERT INTO instrutor (fname, lname, email, telephone, gender, address, department, rank) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
		    try (
		        Connection con = DriverManager.getConnection(url, UserN, PassD);
		    	PreparedStatement stm = con.prepareStatement(resql, Statement.RETURN_GENERATED_KEYS);
		    ) {
		        stm.setString(1, Fname);
		        stm.setString(2, Lname);
		        stm.setString(3, Email);
		        stm.setString(4, Telephone);
		        stm.setString(5, Gender);
		        stm.setString(6, Address);
		        stm.setString(7, Department);
		        stm.setString(8, Rank);
		        
		        int affectedRows = stm.executeUpdate();

                if (affectedRows > 0) {
                	JOptionPane.showMessageDialog(null, "Signup Successful!");
                    // Optionally, you can close the signup frame or perform other actions
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert login credentials!");
                }
                            
                    }
		    	catch (SQLException ex) {
		    			//JOptionPane.showMessageDialog(null, "Enter all fields");
		    			ex.printStackTrace();
		    		}
		    resetTextFields();
		     
		}
	
		else if (e.getActionCommand().equals("View")) {
        	String sql = "SELECT * FROM instrutor ORDER BY id DESC LIMIT 1";
        	try (Connection conn = DriverManager.getConnection(url, UserN, PassD);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                   if (rs.next()) {
                       int id = rs.getInt("id");
                       String fname = rs.getString("fname");
                       String lname = rs.getString("lname");
                       String email = rs.getString("email");
                       String telephone = rs.getString("telephone");
                       String gender = rs.getString("gender");
                       String address = rs.getString("address");
                       String department = rs.getString("department");
                       String rank = rs.getString("rank");

                       JFrame viewFrame = new JFrame("View Data");
                       viewFrame.setLayout(new GridLayout(0,2));
                     //  viewFrame.setLocationRelativeTo(null);
                      viewFrame.setBounds(150, 50, 400, 300);
                       
                       addLabelAndData(viewFrame, "ID:", String.valueOf(id));
                       addLabelAndData(viewFrame, "First Name:", fname);
                       addLabelAndData(viewFrame, "Last Name:", lname);
                       addLabelAndData(viewFrame, "Email:", email);
                       addLabelAndData(viewFrame, "Telephone:", telephone);
                       addLabelAndData(viewFrame, "Gender:", gender);
                       addLabelAndData(viewFrame, "Address:", address);
                       addLabelAndData(viewFrame, "Department:", department);
                       addLabelAndData(viewFrame, "Rank:", rank);
                       
                       viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                      // viewFrame.pack();
                       viewFrame.setVisible(true);
                   } else {
                       JOptionPane.showMessageDialog(null, "No data found!", "Error", JOptionPane.ERROR_MESSAGE);
                   }
               } catch (SQLException ex) {
                   ex.printStackTrace();
                   JOptionPane.showMessageDialog(null, "Failed to view data!", "Error", JOptionPane.ERROR_MESSAGE);
               }
		}
		}
			
		
 
	private void addLabelAndData(Container container, String labelText, String data) {
		container.add(new JLabel(labelText));
        container.add(new JLabel(data));
		
	}	
	public static void main(String[] args) {
		instructor is = new instructor();

	}
}
