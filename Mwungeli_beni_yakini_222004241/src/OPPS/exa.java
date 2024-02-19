package OPPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class exa {
	String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
    String UserN = "222004241";
    String passD = "222004241";
private int eid;
private String course;
private String date;
private String room;
private String etype;
private String duration;
public exa() {}
public exa(int eid, String course, String date, String room, String etype,String duration) {
	super();
	this.eid = eid;
	this.course = course;
	this.date = date;
	this.room = room;
	this.etype = etype;
	this.duration=duration;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public exa(String Course, String Date, String Room, String Etype) {
	this.course = Course;
	this.date = Date;
	this.room = Room;
	this.etype = Etype;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getRoom() {
	return room;
}
public void setRoom(String room) {
	this.room = room;
}
public String getEtype() {
	return etype;
}
public void setEtype(String etype) {
	this.etype = etype;
}
public void makeconnection() {
	// JDBC URL, username, and password of MySQL server
    //String host = "jdbc:mysql://localhost/bithuye";
    //String user = "root";
    //String password = "";
}
public void insertData(String c_s,String d_t, String r_m,String e_t,String d_n) {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/bithuye";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO exam (course, date, room, etype, duration) VALUES (?, ?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, c_s);
        stm.setString(2, d_t);
        stm.setString(3, r_m);
        stm.setString(4, e_t);
        stm.setString(5, d_n);

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
    String host = "jdbc:mysql://localhost/bithuye";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO exam (Course, Date, room, etype, duration) VALUES (?, ?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, this.course);
        stm.setString(2, this.date);
        stm.setString(3, this.room);
        stm.setString(4, this.etype);
        stm.setString(5, this.duration);

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

public void readwithEID(int inputEid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/bithuye";
    String user = "root";
    String password = "";

    // SQL query to select all columns from student where Eid = ?
    String sql = "SELECT * FROM exam WHERE eid = ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int studentEid = 1; // Replace with the desired student Eid
        //if()
    	preparedStatement.setInt(1, inputEid);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setEid(resultSet.getInt("eid"));
           this.setCourse(resultSet.getString("course"));
           this.setDate(resultSet.getString("date"));
           this.setRoom(resultSet.getString("room"));
            this.setEtype(resultSet.getString("etype"));
            this.setDuration(resultSet.getString("duration"));
            //String duration = resultSet.getString("duration");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputeid) {
	// JDBC URL, username, and password of MySQL server
   

    // SQL query to update data
    String sql = "UPDATE exam SET course = ?, date = ?, room = ?, etype = ?, duration=? WHERE eid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, UserN, passD);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
        stm.setString(1, this.getCourse());
        stm.setString(2, this.getDate());
        stm.setString(3, this.getRoom()); // Assuming there is a column named 'Eid' for the WHERE clause
        stm.setString(4, this.getEtype());
        stm.setString(5, this.getDuration());
        stm.setInt(6, inputeid);
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
public void delete(int inputEid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/bithuye";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM exam WHERE eid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputEid); // Assuming there is a column named 'Eid' for the WHERE clause

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
