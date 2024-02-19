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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import OPPS.exa;

public class exam implements ActionListener{
	String url = "jdbc:mysql://localhost/mwungeli_beni_yakini_urt";
    String UserN = "222004241";
    String PassD = "222004241";
	JFrame frame; 
	JLabel eid_lb=new JLabel("SCHEDULE TEST");
	JLabel course_lb=new JLabel("Course name");
	JLabel date_lb=new JLabel("Exam date");
	JLabel room_lb=new JLabel("Room");
	JLabel etype_lb=new JLabel("Test Type");
	JLabel duration_lb=new JLabel("Duration");

	JTextField eid_txf=new JTextField();
	JTextField course_txf=new JTextField();
	JTextField date_txf=new JTextField();
	JTextField room_txf=new JTextField();
	JTextField etype_txf=new JTextField();
	JTextField duration_txf=new JTextField();


	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public exam() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	public void createForm() {
		frame=new JFrame();
		frame.setTitle("EXAMS");
		frame.setBounds(0, 0, 450, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.white);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		setLocationandSize();
	}


	private void setLocationandSize() {
		eid_lb.setBounds(170, 10, 180, 30);
		course_lb.setBounds(10, 50, 100, 30);
		date_lb.setBounds(10, 90, 100, 30);
		room_lb.setBounds(10, 130, 100, 30);
		etype_lb.setBounds(10, 170, 100, 30);
		duration_lb.setBounds(10, 210, 100, 30);
		
		eid_txf.setBounds(160, 10, 150, 30);
		course_txf.setBounds(160, 50, 150, 30);
		date_txf.setBounds(160, 90, 150, 30);
		room_txf.setBounds(160, 130, 150, 30);
		etype_txf.setBounds(160, 170, 150, 30);
		duration_txf.setBounds(160, 210, 150, 30);
		//Buttons CRUD
		insert_btn.setBounds(80,250, 85, 30);
		Read_btn.setBounds(200,250, 85, 30);
		update_btn.setBounds(80,290, 85, 30);
		delete_btn.setBounds(170,290, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Courier New", Font.BOLD, 14);

		eid_lb.setFont(font);
		course_lb.setFont(font);
		date_lb.setFont(font);
		room_lb.setFont(font);
		etype_lb.setFont(font);
		duration_lb.setFont(font);

		eid_txf.setFont(font);
		course_txf.setFont(font);
		date_txf.setFont(font);
		room_txf.setFont(font);
		etype_txf.setFont(font);
		duration_txf.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add( eid_lb);
		frame.add(course_lb);
		frame.add(date_lb);
		frame.add(room_lb);
		frame.add(etype_lb);
		frame.add(duration_lb);
		
		frame.add(course_txf);
		frame.add(date_txf);
		frame.add(room_txf);
		frame.add(etype_txf);
		frame.add(duration_txf);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();
	}
	private void resetTextFields() {
        course_txf.setText("");
        room_txf.setText("");
        date_txf.setText("");
        etype_txf.setText("");
        duration_txf.setText("");
       
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		exa ex =new exa();
		if(e.getSource()== insert_btn) {
			String Course = course_txf.getText();
			String Date = date_txf.getText();
			String Room = room_txf.getText();
			String Etype = etype_txf.getText();
			String Duration = duration_txf.getText();
			
			if (Course.isEmpty() || Date.isEmpty() || Room.isEmpty() || Etype.isEmpty() || Duration.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields!");
	            return; 
			}
			String Ssql = "INSERT INTO exam (course, date, room, etype, duration) VALUES (?, ?, ?, ?, ?)";
			try (
			        Connection con = DriverManager.getConnection(url, UserN, PassD);
			    	PreparedStatement stm = con.prepareStatement(Ssql, Statement.RETURN_GENERATED_KEYS);
			    ) {
			        stm.setString(1, Course);
			        stm.setString(2, Date);
			        stm.setString(3, Room);
			        stm.setString(4, Etype);
			        stm.setString(5, Duration);
			        
			        int affectedRows = stm.executeUpdate();

	                if (affectedRows > 0) {
	                	JOptionPane.showMessageDialog(null, " Successful!");
	                    // Optionally, you can close the signup frame or perform other actions
	                } else {
	                    JOptionPane.showMessageDialog(null, "Failed to insert login credentials!");
	                }
	                            
	                    }
			    	catch (SQLException es) {
			    			//JOptionPane.showMessageDialog(null, "Enter all fields");
			    			es.printStackTrace();
			    		}
			resetTextFields();
			
		}	else if (e.getActionCommand().equals("View")) {
	        	String sql = "SELECT * FROM exam ORDER BY eid DESC LIMIT 1";
	        	try (Connection conn = DriverManager.getConnection(url, UserN, PassD);
	                    Statement stmt = conn.createStatement();
	                    ResultSet rs = stmt.executeQuery(sql)) {

	                   if (rs.next()) {
	                       int id = rs.getInt("eid");
	                       String Course = rs.getString("course");
	                       String Date = rs.getString("date");
	                       String Room = rs.getString("room");
	                       String Etype = rs.getString("etype");
	                       String Durarion = rs.getString("duration");
	                      

	                       JFrame viewFrame = new JFrame("View Data");
	                       viewFrame.setLayout(new GridLayout(0,2));
	                     //  viewFrame.setLocationRelativeTo(null);
	                      viewFrame.setBounds(150, 50, 400, 300);
	                       
	                       addLabelAndData(viewFrame, "ID:", String.valueOf(id));
	                       addLabelAndData(viewFrame, "Course:", Course);
	                       addLabelAndData(viewFrame, "Date:", Date);
	                       addLabelAndData(viewFrame, "Room:", Room);
	                       addLabelAndData(viewFrame, "exam type:", Etype);
	                       addLabelAndData(viewFrame, "Gender:", Durarion);
	                      
	                       
	                       viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                      // viewFrame.pack();
	                       viewFrame.setVisible(true);
	                   } else {
	                       JOptionPane.showMessageDialog(null, "No data found!", "Error", JOptionPane.ERROR_MESSAGE);
	                   }
	               } catch (SQLException es) {
	                   es.printStackTrace();
	                   JOptionPane.showMessageDialog(null, "Failed to view data!", "Error", JOptionPane.ERROR_MESSAGE);
	               }
		
		
		
		} else if (e.getSource()==update_btn){
			int id=Integer.parseInt(eid_txf.getText());
			
			ex.setCourse(course_txf.getText());
			ex.setDate(date_txf.getText());
			ex.setRoom(room_txf.getText());
			ex.setEtype(etype_txf.getText());
			ex.setDuration(duration_txf.getText());
			ex.update(id);
		}else {
			int id=Integer.parseInt(eid_txf.getText());
			ex.delete(id);
		}
	}
	private void addLabelAndData(Container container, String labelText, String data) {
		container.add(new JLabel(labelText));
      container.add(new JLabel(data));
	}
	public static void main(String[] args) {
		exam as = new exam();

	}



}

