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

import OPPS.cours;

public class Courses implements ActionListener{
	JFrame frame; 
	JLabel cid_lb=new JLabel("Course ID");
	JLabel cname_lb=new JLabel("Course name");
	JLabel desc_lb=new JLabel("Description");
	JLabel credit_lb=new JLabel("Credits");
	JLabel dpart_lb=new JLabel("Department");
	JLabel prof_lb=new JLabel("Professor");

	JTextField cid_txf=new JTextField();
	JTextField cname_txf=new JTextField();
	JTextField desc_txf=new JTextField();
	JTextField credit_txf=new JTextField();
	JTextField dpart_txf=new JTextField();
	JTextField prof_txf=new JTextField();


	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Courses() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		//genderBox.addActionListener(this);
	}
	public void createForm() {
		frame = new JFrame();
		frame.setTitle("COURSES");
		frame.setBounds(0, 0, 450, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		setLocationandSize();
	}


	private void setLocationandSize() {
		cid_lb.setBounds(10, 10, 100, 30);
		cname_lb.setBounds(10, 50, 100, 30);
		desc_lb.setBounds(10, 90, 100, 30);
		credit_lb.setBounds(10, 130, 100, 30);
		dpart_lb.setBounds(10, 170, 100, 30);
		prof_lb.setBounds(10, 210, 100, 30);
		
		cid_txf.setBounds(160, 10, 150, 30);
		cname_txf.setBounds(160, 50, 150, 30);
		desc_txf.setBounds(160, 90, 150, 30);
		credit_txf.setBounds(160, 130, 150, 30);
		dpart_txf.setBounds(160, 170, 150, 30);
		prof_txf.setBounds(160, 210, 150, 30);
		//Buttons CRUD
		insert_btn.setBounds(80,250, 85, 30);
		Read_btn.setBounds(170,250, 85, 30);
		update_tbtn.setBounds(80,290, 85, 30);
		delete_btn.setBounds(170,290, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 14);

		cid_lb.setFont(font);
		cname_lb.setFont(font);
		desc_lb.setFont(font);
		credit_lb.setFont(font);
		dpart_lb.setFont(font);
		prof_lb.setFont(font);

		cid_txf.setFont(font);
		cname_txf.setFont(font);
		desc_txf.setFont(font);
		credit_txf.setFont(font);
		dpart_txf.setFont(font);
		prof_txf.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(cid_lb);
		frame.add(cname_lb);
		
		frame.add(desc_lb);
		frame.add(credit_lb);
		frame.add(dpart_lb);
		frame.add(prof_lb);
		
		frame.add(cid_txf);
		frame.add(cname_txf);
		frame.add(desc_txf);
		frame.add(credit_txf);
		frame.add(dpart_txf);
		frame.add(prof_txf);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cours sp =  new cours();
		if(e.getSource()==insert_btn) {
			sp.setCname(cname_txf.getText());
			sp.setDesc(desc_txf.getText());
			sp.setCredits(credit_txf.getText());
			sp.setDpart(dpart_txf.getText());
			sp.setProf(prof_txf.getText());
			
			//st.insertData(st.getFname(), st.getLname(), st.getEmail(), st.getTelephone(), st.getGender());
			sp.insertData();
		}else if (e.getSource()==Read_btn) {
			int id=Integer.parseInt(cid_txf.getText());
			sp.readwithCID(id);
			cid_txf.setText(String.valueOf(sp.getCid()));
			cname_txf.setText(sp.getCname());
			desc_txf.setText(sp.getDesc());
			credit_txf.setText(sp.getCredits());
			dpart_txf.setText(sp.getDpart());
			prof_txf.setText(sp.getProf());
			
		}else if (e.getSource()==update_tbtn) {
			int id=Integer.parseInt(cid_txf.getText());
			
			sp.setCname(cname_txf.getText());
			sp.setDesc(desc_txf.getText());
			sp.setCredits(credit_txf.getText());
			sp.setDpart(dpart_txf.getText());
			sp.setProf(prof_txf.getText());
			sp.update(id);
		}else {
			int id=Integer.parseInt(cid_txf.getText());
			sp.delete(id);
		}

	}
	public static void main(String[] args) {
		Courses sf = new Courses();

	}



}

