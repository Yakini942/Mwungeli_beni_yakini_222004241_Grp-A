package menus;

import java.awt.Color;
//import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import displays.couresdisplay;
import displays.departdisplay;
import displays.enrolldisplay;
import displays.examdisplay;
import displays.instructdisplay;
import displays.libradisplay;


public class menust implements ActionListener{
	couresdisplay courses;
	departdisplay department;
	enrolldisplay enrollment;
	examdisplay exam;
	instructdisplay instructor;
	libradisplay library;
	
	JFrame frami;
	JLabel header = new JLabel("WELLCOME");
	JButton examSButton = new JButton("EXAMS");
	JButton instuctorButton = new JButton("INSTRUCTOR");
	JButton coursesButton = new JButton("COURSES");
	JButton enrollButton = new JButton("ENROLLMENT");
	JButton departmentButton = new JButton("DEPARTMENR");
	JButton libraryBooksButton = new JButton("LIBRARY");
	public menust() {
	 showframe();
	}
public void showframe(){
	frami=new JFrame();
	frami.setTitle("menu");
	frami.setBounds(0, 0, 520, 300);
	frami.getContentPane().setLayout(null);
	frami.getContentPane().setBackground(Color.GRAY);
	frami.setVisible(true);
	frami.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frami.setResizable(true);
	frami.setLocationRelativeTo(null);
	setlocation();
}
private void ActionEvent() {
	examSButton.addActionListener(this);
	instuctorButton.addActionListener(this);
	coursesButton.addActionListener(this);
	enrollButton.addActionListener(this);
	departmentButton.addActionListener(this);
	libraryBooksButton.addActionListener(this);
}
private void setlocation(){
	header.setBounds(140, 10, 100, 40);
	coursesButton.setBounds(40, 80, 120, 30);
	enrollButton.setBounds(180, 80, 120, 30);
	instuctorButton.setBounds(320, 80, 120, 30);
	examSButton.setBounds(40, 130, 120, 30);
	libraryBooksButton.setBounds(180, 130, 120, 30);
	departmentButton.setBounds(320, 130, 120, 30);
	addcomponentforFrame();
	
}
private void addcomponentforFrame() {
	frami.add(coursesButton);
	frami.add(departmentButton);
	frami.add(enrollButton);
	frami.add(examSButton);
	frami.add(instuctorButton);
	frami.add(libraryBooksButton);
	frami.add(header);
	ActionEvent();
}

@Override
public void actionPerformed(java.awt.event.ActionEvent e) {
	if (e.getActionCommand().equals("COURSES")) {
	 courses = new couresdisplay();
   	 courses.showframe();
   } else if (e.getActionCommand().equals("DEPARTMENR")) {
	   department = new departdisplay();
	   department.showframe();
}else if (e.getActionCommand().equals("ENROLLMENT")) {
	enrollment = new enrolldisplay();
	enrollment.showframe();
}else if (e.getActionCommand().equals("EXAMS")) {
	exam = new examdisplay();
	exam.showframe();
}else if (e.getActionCommand().equals("INSTRUCTOR")) {
	instructor = new instructdisplay();
	instructor.showframe();
}else if (e.getActionCommand().equals("LIBRARY")) {
	library = new libradisplay();
	library.showframe();	
}
	
}	
public static void main(String[] args) {
	menust sf = new menust();
}
}
