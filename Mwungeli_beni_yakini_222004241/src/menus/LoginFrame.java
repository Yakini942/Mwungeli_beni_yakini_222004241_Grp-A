package menus;
import javax.swing.*;

import touch.registration;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame  implements ActionListener {
	private JFrame frame;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private Font font;
    
    
    public LoginFrame() {
    	frame = new JFrame();
    	frame.setTitle("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        font = new Font("Georgia", Font.BOLD, 18);
        frame.setLocationRelativeTo(null);
       
        JLabel title_lb = new JLabel("LOGIN");
        title_lb.setBounds(130, 10, 100, 50);
        title_lb.setFont(font);
        frame.add(title_lb);
        
        JLabel userIdLabel = new JLabel("User ID:");
        frame.add(userIdLabel);
        userIdLabel.setBounds(30, 80, 100, 30);

        userIdField = new JTextField();
        frame.add(userIdField);
        userIdField.setBounds(120, 80, 100, 30);

        JLabel passwordLabel = new JLabel("Password:");
        frame.add(passwordLabel);
        passwordLabel.setBounds(30, 130, 100, 30);

        passwordField = new JPasswordField();
        frame.add(passwordField);
        passwordField.setBounds(120, 130, 100, 30);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBounds(50, 170, 80, 30);
        frame.add(loginButton);
        
        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(this);
        frame.add(signupButton);
        signupButton.setBounds(140, 170, 80, 30);
        
        JButton instrlogButton = new JButton("ADMINS");
        instrlogButton.addActionListener(this);
        instrlogButton.setBounds(300, 10, 80, 30);
        frame.add(instrlogButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//registration reg = new registration(); 
        
        String id = userIdField.getText();
        String password = new String(passwordField.getPassword());

        if (e.getActionCommand().equals("Login")) {
            if (authenticateUser(id, password)) {
                // Open a new window upon successful login
                JOptionPane.showMessageDialog(null, "Login Successful!");
                new menust();
                //menu.showframe();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials! Please try again.");
            }
        } else if (e.getActionCommand().equals("Signup")) {
        	new registration();
        }else if (e.getActionCommand().equals("ADMINS")) {
        	 new admin();
        	
		}
    }

    private boolean authenticateUser(String id, String password) {
    	String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
	    String UserN = "222004241";
	    String passD = "222004241";
        String query = "SELECT * FROM registration WHERE id=? AND password=?";

        try (Connection connection = DriverManager.getConnection(url, UserN, passD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // If result set has a next, user is authenticated

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           new LoginFrame();
        });
    }
}
