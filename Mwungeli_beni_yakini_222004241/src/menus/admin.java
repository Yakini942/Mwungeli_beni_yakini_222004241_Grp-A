package menus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class admin implements ActionListener {
    private JFrame frame;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private Font font;

    public admin() {
        showframe();
    }

    public void showframe() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        font = new Font("Georgia", Font.BOLD, 18);
        frame.setLocationRelativeTo(null);

        JLabel title_lb = new JLabel("LOGIN");
        title_lb.setBounds(160, 10, 100, 50);
        title_lb.setFont(font);
        frame.add(title_lb);

        JLabel userIdLabel = new JLabel("User ID:");
        frame.add(userIdLabel);
        userIdLabel.setBounds(30, 80, 100, 30);

        userIdField = new JTextField();
        frame.add(userIdField);
        userIdField.setBounds(120, 80, 100, 25);

        JLabel passwordLabel = new JLabel("Password:");
        frame.add(passwordLabel);
        passwordLabel.setBounds(30, 130, 100, 30);

        passwordField = new JPasswordField();
        frame.add(passwordField);
        passwordField.setBounds(120, 130, 100, 25);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBounds(90, 190, 80, 30);
        frame.add(loginButton);

        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(this);
        frame.add(signupButton);
        signupButton.setBounds(190, 190, 80, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = userIdField.getText();
        String password = new String(passwordField.getPassword());

        if (e.getActionCommand().equals("Login")) {
            if (authenticateUser(id, password)) {
               // JOptionPane.showMessageDialog(null, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials! Please try again.");
            }
        } else if (e.getActionCommand().equals("Signup")) {
            // Implement signup functionality if needed
        }
    }

    private boolean authenticateUser(String id, String password) {
        String url = "jdbc:mysql://localhost:3306/mwungeli_beni_yakini_urt";
        String user = "222004241";
        String Password = "222004241";
        String query = "SELECT id, department FROM instrutor WHERE id=? AND rank=?";

        try (Connection connection = DriverManager.getConnection(url, user, Password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String department = resultSet.getString("department");

                openDepartmentFrame(userId, department);
                return true;
            }

            return false;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void openDepartmentFrame(int userId, String department) {
     //   JFrame departmentFrame = new JFrame(department + " Department");
       // departmentFrame.setSize(600, 400);
    //    departmentFrame.setLocationRelativeTo(null);
      //  departmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     //   departmentFrame.setVisible(true);
    
    if (department.equals("Professor")) {
    	new profmenu();
        // Add components specific to the Professor department
    } else if (department.equals("Administrator")) {
        // Add components specific to the Administrator department
    } else if (department.equals("Library")) {
        // Add components specific to the Library department
    } else {
        // Handle other departments or default case
    }
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            admin loginFrame = new admin();
        });
    }
}
