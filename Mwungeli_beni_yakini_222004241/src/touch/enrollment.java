package touch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import OPPS.enroll;

public class enrollment implements ActionListener{
	JFrame frame; 
	JLabel enroid_lb=new JLabel("enrollment_ID");
	JLabel student_lb=new JLabel("Student ID");
	JLabel course_lb=new JLabel("Course");
	JLabel enrodate_lb=new JLabel("Enrollment date");
	JLabel grade_lb=new JLabel("Grade");

	JTextField enroid_txf=new JTextField();
	JTextField student_txf=new JTextField();
	JTextField course_txf=new JTextField();
	JTextField enrodate_txf=new JTextField();
	JTextField grade_txf=new JTextField();
	


	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public enrollment() {
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
		frame.setTitle("ENROLLMENT");
		frame.setBounds(0, 0, 450, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		setLocationandSize();
	}


	private void setLocationandSize() {
		enroid_lb.setBounds(10, 10, 170, 30);
		student_lb.setBounds(10, 50, 170, 30);
		course_lb.setBounds(10, 90, 170, 30);
		enrodate_lb.setBounds(10, 130, 170, 30);
		grade_lb.setBounds(10, 170, 170, 30);
		
		enroid_txf.setBounds(190, 10, 150, 30);
		student_txf.setBounds(190, 50, 150, 30);
		course_txf.setBounds(190, 90, 150, 30);
		enrodate_txf.setBounds(190, 130, 150, 30);
		grade_txf.setBounds(190, 170, 150, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(80,210, 85, 30);
		Read_btn.setBounds(170,210, 85, 30);
		update_btn.setBounds(80,250, 85, 30);
		delete_btn.setBounds(170,250, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Courier New", Font.BOLD, 14);

		enroid_lb.setFont(font);
		student_lb.setFont(font);
		course_lb.setFont(font);
		enrodate_lb.setFont(font);
		grade_lb.setFont(font);
		

		enroid_txf.setFont(font);
		student_txf.setFont(font);
		course_txf.setFont(font);
		enrodate_txf.setFont(font);
		grade_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(enroid_lb);
		frame.add(student_lb);
		frame.add(course_lb);
		frame.add(enrodate_lb);
		frame.add(grade_lb);
		
		frame.add(enroid_txf);
		frame.add(student_txf);
		frame.add(course_txf);
		frame.add(enrodate_txf);
		frame.add(grade_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		enroll en =new enroll();
		if(e.getSource()==insert_btn) {
			en.setStudent(student_txf.getText());
			en.setCourse(course_txf.getText());
			en.setEnrodate(enrodate_txf.getText());
			en.setGrade(grade_txf.getText());
			
			//st.insertData(st.getFname(), st.getLname(), st.getEnrodate(), st.getTelephone(), st.getGender());
			en.insertData();
		}else if (e.getSource()==Read_btn) {
			int id=Integer.parseInt(enroid_lb.getText());
			en.readwithENROID(id);
			enroid_lb.setText(String.valueOf(en.getEnroid()));
			student_txf.setText(en.getStudent());
			course_txf.setText(en.getCourse());
			enrodate_txf.setText(en.getEnrodate());
			grade_txf.setText(en.getGrade());
			
			
		}else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(enroid_lb.getText());
			
			en.setStudent(student_txf.getText());
			en.setCourse(course_txf.getText());
			en.setEnrodate(enrodate_txf.getText());
			en.setGrade(grade_txf.getText());
			en.update(id);
		}else {
			int id=Integer.parseInt(enroid_lb.getText());
			en.delete(id);
		}

	}
	public static void main(String[] args) {
		enrollment oll = new enrollment();

	}



}

