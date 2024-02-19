package OPPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class instru {
private int id;
private String fname;
private String lname;
private String email;
private String telephone;
private String gender;
private String address;
private String department;
private String rank;

public instru() {}
public instru(int id, String fname, String lname, String email, String telephone,String gender,String address,String department,String rank) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.telephone = telephone;
	this.gender=gender;
	this.address= address;
	this.department= department;
	this.rank = rank;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public instru( String fname, String lname, String email, String telephone,String address,String department, String rank) {
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.telephone = telephone;
	this.address = address;
	this.department = department;
	this.rank= rank;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getRank() {
	return rank;
}
public void setRank(String rank) {
	this.rank = rank;
}

public void makeconnection() {
	// JDBC URL, username, and password of MySQL server
    //String host = "jdbc:mysql://localhost/bithuye";
   // String user = "root";
    //String password = "";
}
public void insertData(String f_n,String l_n, String e_m,String tel,String ge_en,String a_r,String d_p,String r_k) {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO instrutor (fname, lname, email, telephone,gender , address, department, rank) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       stm.setString(1, f_n);
        stm.setString(2, l_n);
        stm.setString(3, e_m);
        stm.setString(4, tel);
        stm.setString(5, ge_en);
        stm.setString(6, a_r);
        stm.setString(7, d_p);
        stm.setString(8, r_k);

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
    String host = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO instrutor (fname, lname, email, telephone, gender, address, department, rank) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, this.fname);
        stm.setString(2, this.lname);
        stm.setString(3, this.email);
        stm.setString(4, this.telephone);
        stm.setString(5, this.gender);
        stm.setString(6, this.address );
        stm.setString(7, this.department);
        stm.setString(8, this.rank);
        
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

public void readwithID(int inputid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";

    // SQL query to select all columns from student where id = ?
    String sql = "SELECT * FROM instrutor WHERE id = ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int studentId = 1; // Replace with the desired student id
        //if()
    	preparedStatement.setInt(1, inputid);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
           this.setId(resultSet.getInt("id"));
           this.setFname(resultSet.getString("fname"));
           this.setLname(resultSet.getString("lname"));
           this.setEmail(resultSet.getString("email"));
           this.setTelephone(resultSet.getString("telephone"));
           this.setGender(resultSet.getString("gender"));
           this.setAddress(resultSet.getString("address"));
           this.setDepartment(resultSet.getString("department"));
           this.setRank(resultSet.getString("rank"));
            
            //String gender = resultSet.getString("gender");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE instrutor SET fname = ?, lname = ?,email = ?, telephone = ?, gender=?, address=?, depertment=?, rank=? WHERE id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
        stm.setString(1, this.getFname());
        stm.setString(2, this.getLname());
        stm.setString(3, this.getEmail()); // Assuming there is a column named 'id' for the WHERE clause
        stm.setString(4, this.getTelephone());
        stm.setString(5, this.getGender());
        stm.setString(6, this.getAddress());
        stm.setString(7, this.getDepartment());
        stm.setString(8, this.getRank());
        stm.setInt(9, inputid);
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
public void delete(int inputid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM instrutor WHERE id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

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
