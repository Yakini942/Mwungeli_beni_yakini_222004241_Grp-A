package touch;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registration  implements ActionListener{

	JFrame signupframe;
	static final String JDBC_DRIVER = "your_jdbc_driver";
	 String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
	    String UserN = "222004241";
	    String passD = "222004241";

	JLabel signup = new JLabel("SignUp-Portal");

	JLabel fnamelb = new JLabel("First Name");
	JLabel lnamelb = new JLabel("Last Name");
	JLabel pnumberlb = new JLabel("Phone-number");
	JLabel emaillb = new JLabel("Email");
	JLabel doblb = new JLabel("Date of Birth");
	JLabel genderlb = new JLabel("Gender");
	JLabel addresslb = new JLabel("Address");
	JLabel nationlb = new JLabel("Nationality");
	JLabel majorlb = new JLabel("Major");
	JLabel passwordlb = new JLabel("Password");

	JTextField fnametxf = new JTextField();
	JTextField lnametxf = new JTextField();
	JTextField pnumbertxf = new JTextField();
	JTextField emailtxf = new JTextField();
	JTextField dobtxf = new JTextField();
	JTextField gendertxf = new JTextField();
	JTextField addresstxf = new JTextField();
	JTextField nationtxf = new JTextField();
	JTextField majortxf = new JTextField();
	JPasswordField passwordtxf = new JPasswordField();

	JButton SignUpbtn = new JButton("SignUp");
	JButton viewButton = new JButton("View");
	JLabel format = new JLabel("Date of birth format: [YY-MM-DD]");

	public registration () {
		createform();
		setlocationandsize();
		addcomponent();
		setupActionListeners();
	}

	public void createform() {
		signupframe = new JFrame();
		signupframe.setTitle("Sign-Up Portal");
		signupframe.setBounds(0,0,500,650);
		signupframe.getContentPane().setLayout(null);
		signupframe.getContentPane().setBackground(Color.white);
		signupframe.setVisible(true);
		signupframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		signupframe.setResizable(false);
		signupframe.setLocationRelativeTo(null);


	}

	private void setlocationandsize() {

		signup.setBounds(180, 50, 90, 30);
		fnamelb.setBounds(50, 100, 90, 30);
		lnamelb.setBounds(50, 140, 90, 30);
		pnumberlb.setBounds(50, 180, 90, 30);
		emaillb.setBounds(50, 220, 90, 30);
		doblb.setBounds(50, 260, 90, 30);
		genderlb.setBounds(50, 300, 90, 30);
		addresslb.setBounds(50, 340, 90, 30);
		nationlb.setBounds(50, 380, 90, 30);
		majorlb.setBounds(50, 420, 90, 30);
		passwordlb.setBounds(50, 460, 90, 30);

		fnametxf.setBounds(170, 100, 250, 30);
		lnametxf.setBounds(170, 140, 250, 30);
		pnumbertxf.setBounds(170, 180, 250, 30);
		emailtxf.setBounds(170, 220, 250, 30);
		dobtxf.setBounds(170, 260, 250, 30);
		gendertxf.setBounds(170, 300, 250, 30);
		addresstxf.setBounds(170, 340, 250, 30);
		nationtxf.setBounds(170, 380, 250, 30);
		majortxf.setBounds(170, 420, 250, 30);
		passwordtxf.setBounds(170, 460, 250, 30);
		format.setBounds(140, 500, 260, 30);

		SignUpbtn.setBounds(100, 540, 90, 30);
		viewButton.setBounds(320, 540, 90, 30);

	}

	private void addcomponent() {

		signupframe.add(signup);

		signupframe.add(addresslb);
		signupframe.add(fnamelb);
		signupframe.add(doblb);
		signupframe.add(lnamelb);
		signupframe.add(nationlb);
		signupframe.add(genderlb);
		signupframe.add(passwordlb);
		signupframe.add(pnumberlb);
		signupframe.add(majorlb);
		signupframe.add(emaillb);

		signupframe.add(addresstxf);
		signupframe.add(fnametxf);
		signupframe.add(dobtxf);
		signupframe.add(lnametxf);
		signupframe.add(nationtxf);
		signupframe.add(gendertxf);
		signupframe.add(passwordtxf);
		signupframe.add(pnumbertxf);
		signupframe.add(majortxf);
		signupframe.add(emailtxf);
		signupframe.add(format);
		signupframe.add(SignUpbtn);
		signupframe.add(viewButton);

	}

	private void setupActionListeners() {
		SignUpbtn.addActionListener(this);
		viewButton.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SignUpbtn) {
            String firstName = fnametxf.getText();
            String lastName = lnametxf.getText();
            String phoneNumber = pnumbertxf.getText();
            String email = emailtxf.getText();
            String dob = dobtxf.getText();
            String gender = gendertxf.getText();
            String address = addresstxf.getText();
            String nation = nationtxf.getText();
            String major = majortxf.getText();
            String password = passwordtxf.getText();
            int intValue = Integer.parseInt(phoneNumber);
            
            String inSql = "INSERT INTO registration (first_name, last_name, phone_number, email, birth_date, gender, address, nationality, major, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (
            		Connection conn = DriverManager.getConnection(url, UserN, passD);
            		PreparedStatement Stmt = conn.prepareStatement(inSql, Statement.RETURN_GENERATED_KEYS)
            						
            		) {
            				Stmt.setString(1, firstName);
                            Stmt.setString(2, lastName);
                            Stmt.setInt(3, intValue);
                            Stmt.setString(4, email);
                            Stmt.setString(5, dob);
                            Stmt.setString(6, gender);
                            Stmt.setString(7, address);
                            Stmt.setString(8, nation);
                            Stmt.setString(9, major);
                            Stmt.setString(10, password);
                                 int affectedRows = Stmt.executeUpdate();

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
            
        }else if (e.getActionCommand().equals("View")) {
        	String sql = "SELECT * FROM registration ORDER BY id DESC LIMIT 1";
        	try (Connection conn = DriverManager.getConnection(url, UserN, passD);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {

                   if (rs.next()) {
                       int id = rs.getInt("id");
                       String fname = rs.getString("first_name");
                       String lname = rs.getString("last_name");
                       String email = rs.getString("email");
                       String telephone = rs.getString("phone_number");
                       String gender = rs.getString("gender");
                       String dob = rs.getString("birth_date");
                       String nation = rs.getString("nationality");
                       String address = rs.getString("address");
                       String major = rs.getString("major");
                       String pass = rs.getString("password");

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
                       addLabelAndData(viewFrame, "Date of Birth:", dob);
                       addLabelAndData(viewFrame, "Nationality:", nation);
                       addLabelAndData(viewFrame, "Address:", address);
                       addLabelAndData(viewFrame, "Major:", major);
                       addLabelAndData(viewFrame, "Password:", pass);
                       
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
        new registration();

	}

}

