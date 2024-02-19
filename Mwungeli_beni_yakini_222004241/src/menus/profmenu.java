package menus;

import java.awt.Color;
//import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import touch.*;



public class profmenu implements ActionListener{
	Courses courses;
	exam exam;
	
	JFrame frami;
	JLabel header = new JLabel("WELLCOME");
	JButton examSButton = new JButton("EXAMS");
	JButton instuctorButton = new JButton("INSTRUCTOR");
	JButton coursesButton = new JButton("COURSES");
	JButton enrollButton = new JButton("ENROLLMENT");
	JButton departmentButton = new JButton("DEPARTMENR");
	JButton libraryBooksButton = new JButton("LIBRARY");
	public profmenu() {
	 showframe();
	}
public void showframe(){
	frami=new JFrame();
	frami.setTitle("menu");
	frami.setBounds(0, 0, 220, 300);
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
	header.setBounds(30, 10, 100, 40);
	coursesButton.setBounds(40, 80, 120, 30);
	examSButton.setBounds(40, 130, 120, 30);
	
	addcomponentforFrame();
	
}
private void addcomponentforFrame() {
	frami.add(coursesButton);
	frami.add(examSButton);
	frami.add(header);
	ActionEvent();
}

@Override
public void actionPerformed(java.awt.event.ActionEvent e) {
	if (e.getActionCommand().equals("COURSES")) {
	  new Courses();
   	// courses.createForm();
   
}else if (e.getActionCommand().equals("EXAMS")) {
	 new exam();
	//exam.createForm();
}
}	
public static void main(String[] args) {
	profmenu sf = new profmenu();
}
}
