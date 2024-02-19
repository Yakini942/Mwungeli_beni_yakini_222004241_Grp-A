package OPPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class cours {
	    String host = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
	    String user = "222004241";
	    String password = "222004241";
private int cid;
private String cname;
private String decpt;
private String credits;
private String dpart;
private String prof;
public cours() {}
public cours(int cid, String cname, String desc, String credits, String dpart,String prof) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.decpt = desc;
	this.credits = credits;
	this.dpart = dpart;
	this.prof=prof;
}
public String getProf() {
	return prof;
}
public void setProf(String prof) {
	this.prof = prof;
}
public cours(String Cname, String Dec, String Credits, String Dpart) {
	this.cname = Cname;
	this.decpt = Dec;
	this.credits = Credits;
	this.dpart = Dpart;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getDesc() {
	return decpt;
}
public void setDesc(String dec) {
	this.decpt= dec;
}
public String getCredits() {
	return credits;
}
public void setCredits(String credits) {
	this.credits = credits;
}
public String getDpart() {
	return dpart;
}
public void setDpart(String dpart) {
	this.dpart = dpart;
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
    String sql = "INSERT INTO courses (cname, decpt, credits,dpart,prof) VALUES (?, ?, ?, ?, ?)";

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
        if (rowsAffected > 1) {
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
    String sql = "INSERT INTO courses (cname, decpt, credits,dpart,prof) VALUES (?, ?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
       stm.setString(1, this.cname);
        stm.setString(2, this.decpt);
        stm.setString(3, this.credits);
        stm.setString(4, this.dpart);
        stm.setString(5, this.prof);

        // Execute the query
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 1) {
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

public void readwithCID(int inputCid) {
	// JDBC URL, username, and password of MySQL server
   

    // SQL query to select all columns from student where Cid = ?
    String sql = "SELECT * FROM courses WHERE cid = ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int studentCid = 1; // Replace with the desired student Cid
        //if()
    	preparedStatement.setInt(1, inputCid);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setCid(resultSet.getInt("cid"));
           this.setCname(resultSet.getString("cname"));
           this.setDesc(resultSet.getString("decpt"));
           this.setCredits(resultSet.getString("credits"));
            this.setDpart(resultSet.getString("dpart"));
            this.setProf(resultSet.getString("prof"));
            //String prof = resultSet.getString("prof");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputcid) {
	// JDBC URL, username, and password of MySQL server
    

    // SQL query to update data
    String sql = "UPDATE courses SET cname = ?, decpt= ?, credits = ?, dpart = ?, prof=? WHERE cid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
        stm.setString(1, this.getCname());
        stm.setString(2, this.getDesc());
        stm.setString(3, this.getCredits()); // Assuming there is a column named 'Cid' for the WHERE clause
        stm.setString(4, this.getDpart());
        stm.setString(5, this.getProf());
        stm.setInt(6, inputcid);
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
public void delete(int inputCid) {
	// JDBC URL, username, and password of MySQL server
  

    // SQL query to delete data
    String sql = "DELETE FROM courses WHERE cid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputCid); // Assuming there is a column named 'Cid' for the WHERE clause

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
