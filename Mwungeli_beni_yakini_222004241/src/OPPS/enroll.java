package OPPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class enroll {
	 String host = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
	    String user = "222004241";
	    String password = "222004241";
private int enroid;
private String student;
private String course;
private String enrodate;
private String grade;

public enroll() {}
public enroll(int enroid, String student, String course, String enrodate, String grade) {
	super();
	this.enroid = enroid;
	this.student = student;
	this.course = course;
	this.enrodate = enrodate;
	this.grade = grade;

}

public enroll(String student, String course, String enrodate, String grade) {
	this.student = student;
	this.course = course;
	this.enrodate = enrodate;
	this.grade = grade;
}
public int getEnroid() {
	return enroid;
}
public void setEnroid(int enroid) {
	this.enroid = enroid;
}
public String getStudent() {
	return student;
}
public void setStudent(String student) {
	this.student = student;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getEnrodate() {
	return enrodate;
}
public void setEnrodate(String enrodate) {
	this.enrodate = enrodate;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public void makeconnection() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";
}
public void insertData(String c_n,String d_n, String c_d,String d_p,String p_f) {
	// JDBC URL, username, and password of MySQL server
    

    // SQL query to insert data
    String sql = "INSERT INTO enrollment (student, course, enrodate, grade) VALUES (?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, c_n);
        stm.setString(2, d_n);
        stm.setString(3, c_d);
        stm.setString(4, d_p);
        stm.setString(5, p_f);

        // Execute the query
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data inserted successfully!");
            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }	
}

public void insertData() {
	// JDBC URL, username, and password of MySQL server
    
    // SQL query to insert data
    String sql = "INSERT INTO enrollment (student, course, enrodate, grade) VALUES (?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, this.student);
        stm.setString(2, this.course);
        stm.setString(3, this.enrodate);
        stm.setString(4, this.grade);
       

        // Execute the query
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data inserted successfully!");
            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }	
}

public void readwithENROID(int inputEnroid) {
	// JDBC URL, username, and password of MySQL server
    

    // SQL query to select all columns from student where Enroid = ?
    String sql = "SELECT * FROM enrollment WHERE enroid = ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int studentEnroid = 1; // Replace with the desired student Enroid
        //if()
    	preparedStatement.setInt(1, inputEnroid);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setEnroid(resultSet.getInt("enroid"));
           this.setStudent(resultSet.getString("student"));
           this.setCourse(resultSet.getString("course"));
           this.setEnrodate(resultSet.getString("enrodate"));
            this.setGrade(resultSet.getString("grade"));
            //String prof = resultSet.getString("prof");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputenroid) {
	// JDBC URL, username, and password of MySQL server
   

    // SQL query to update data
    String sql = "UPDATE enrollment SET student = ?, course = ?,enrodate = ?, grade = ? WHERE enroid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
        stm.setString(1, this.getStudent());
        stm.setString(2, this.getCourse());
        stm.setString(3, this.getEnrodate()); // Assuming there is a column named 'Enroid' for the WHERE clause
        stm.setString(4, this.getGrade());
        stm.setInt(5, inputenroid);
        // Execute the update
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
        } else {
            System.out.println("Failed to update data. No matching record found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputEnroid) {
	// JDBC URL, username, and password of MySQL server
   

    // SQL query to delete data
    String sql = "DELETE FROM enrollment WHERE enroid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputEnroid); // Assuming there is a column named 'Enroid' for the WHERE clause

        // Execute the delete
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
        } else {
            System.out.println("Failed to delete data. No matching record found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}

