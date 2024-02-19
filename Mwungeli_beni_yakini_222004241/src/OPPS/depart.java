package OPPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class depart {
	String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
    String UserN = "222004241";
    String passD = "222004241";
private int did;
private String dname;
private String office;
private String email;
private String chair;

public depart() {}
public depart(int did, String dname, String office, String email, String chair) {
	super();
	this.did = did;
	this.dname = dname;
	this.office = office;
	this.email = email;
	this.chair = chair;

}

public depart(String dname, String office, String email, String chair) {
	this.dname = dname;
	this.office = office;
	this.email = email;
	this.chair = chair;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getOffice() {
	return office;
}
public void setOffice(String office) {
	this.office = office;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getChair() {
	return chair;
}
public void setChair(String chair) {
	this.chair = chair;
}
public void makeconnection() {
	// JDBC URL, username, and password of MySQL server
    //String host = "jdbc:mysql://localhost/bithuye";
    //String user = "root";
    //String password = "";
}
public void insertData(String c_n,String d_n, String c_d,String d_p,String p_f) {
	// JDBC URL, username, and password of MySQL server
   

    // SQL query to insert data
    String sql = "INSERT INTO department (dname, office, Email,Chair) VALUES (?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(url, UserN, passD);

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
    String host = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
    String user = "222004241";
    String password = "222004241";

    // SQL query to insert data
    String sql = "INSERT INTO department (Dname, Office, Email,Chair) VALUES (?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, this.dname);
        stm.setString(2, this.office);
        stm.setString(3, this.email);
        stm.setString(4, this.chair);
       

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

public void readwithDID(int inputDid) {
	// JDBC URL, username, and password of MySQL server
    
    // SQL query to select all columns from student where Did = ?
    String sql = "SELECT * FROM department WHERE did = ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(url, UserN, passD);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int studentDid = 1; // Replace with the desired student Did
        //if()
    	preparedStatement.setInt(1, inputDid);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setDid(resultSet.getInt("did"));
           this.setDname(resultSet.getString("dname"));
           this.setOffice(resultSet.getString("office"));
           this.setEmail(resultSet.getString("email"));
            this.setChair(resultSet.getString("chair"));
            //String prof = resultSet.getString("prof");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputdid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/bithuye";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE department SET dname = ?, office = ?,email = ?, chair = ? WHERE did = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
        stm.setString(1, this.getDname());
        stm.setString(2, this.getOffice());
        stm.setString(3, this.getEmail()); // Assuming there is a column named 'Did' for the WHERE clause
        stm.setString(4, this.getChair());
        stm.setInt(5, inputdid);
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
public void delete(int inputDid) {
	// JDBC URL, username, and password of MySQL server
    

    // SQL query to delete data
    String sql = "DELETE FROM department WHERE Did = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, UserN, passD);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputDid); // Assuming there is a column named 'Did' for the WHERE clause

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
