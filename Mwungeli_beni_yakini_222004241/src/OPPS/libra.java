package OPPS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class libra {
	String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
    String UserN = "222004241";
    String passD = "222004241";
private int bookId;
private String title;
private String author;
private String genre;
private String status;

public libra() {}
public libra(int bookId, String title, String author, String genre, String status) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.author = author;
	this.genre = genre;
	this.status = status;

}

public libra(String title, String author, String genre, String status) {
	this.title = title;
	this.author = author;
	this.genre = genre;
	this.status = status;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public void makeconnection() {
	// JDBC URL, username, and password of MySQL server
   
}
public void insertData(String c_n,String d_n, String c_d,String d_p,String p_f) {
	// JDBC URL, username, and password of MySQL server
  

    // SQL query to insert data
    String sql = "INSERT INTO library (title, author, genre, status) VALUES (?, ?, ?, ?)";

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
    

    // SQL query to insert data
    String sql = "INSERT INTO library (title, author, genre, status) VALUES (?, ?, ?, ?)";

    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(url, UserN, passD);

        // Create a prepared statement
        PreparedStatement stm= con.prepareStatement(sql);
    ) {
        // Set the values for the prepared statement
        stm.setString(1, this.title);
        stm.setString(2, this.author);
        stm.setString(3, this.genre);
        stm.setString(4, this.status);
       

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

public void readwithBOOKID(int inputBookId) {
	// JDBC URL, username, and password of MySQL server
  

    // SQL query to select all columns from title where BookId = ?
    String sql = "SELECT * FROM library WHERE bookId = ?";

    try (
        // Establish the connection
        Connection connection = DriverManager.getConnection(url, UserN, passD);

        // Create a prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ) {
        // Set the value for the parameterized query
        //int titleBookId = 1; // Replace with the desired title BookId
        //if()
    	preparedStatement.setInt(1, inputBookId);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Process the result set
        while (resultSet.next()) {
        	this.setBookId(resultSet.getInt("bookId"));
           this.setTitle(resultSet.getString("title"));
           this.setAuthor(resultSet.getString("author"));
           this.setGenre(resultSet.getString("genre"));
            this.setStatus(resultSet.getString("status"));
            //String prof = resultSet.getString("prof");

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(int inputbookId) {
	// JDBC URL, username, and password of MySQL server
   

    // SQL query to update data
    String sql = "UPDATE library SET title = ?, author = ?,genre = ?, status = ? WHERE bookId = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, UserN, passD);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
        stm.setString(1, this.getTitle());
        stm.setString(2, this.getAuthor());
        stm.setString(3, this.getGenre()); // Assuming there is a column named 'BookId' for the WHERE clause
        stm.setString(4, this.getStatus());
        stm.setInt(5, inputbookId);
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
public void delete(int inputBookId) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/touch";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM library WHERE bookId = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputBookId); // Assuming there is a column named 'BookId' for the WHERE clause

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