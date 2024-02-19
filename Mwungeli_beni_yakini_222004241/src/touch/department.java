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

import OPPS.depart;

public class department implements ActionListener{
	JFrame frame; 
	JLabel did_lb=new JLabel("Department_ID");
	JLabel dname_lb=new JLabel("Department name");
	JLabel office_lb=new JLabel("Office");
	JLabel email_lb=new JLabel("Email");
	JLabel chair_lb=new JLabel("Chair Instructor");

	JTextField did_txf=new JTextField();
	JTextField dname_txf=new JTextField();
	JTextField office_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField chair_txf=new JTextField();
	


	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public department() {
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
		frame.setTitle("DEPARTMENTS");
		frame.setBounds(0, 0, 450, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		setLocationandSize();
	}


	private void setLocationandSize() {
		did_lb.setBounds(10, 10, 170, 30);
		dname_lb.setBounds(10, 50, 170, 30);
		office_lb.setBounds(10, 90, 170, 30);
		email_lb.setBounds(10, 130, 170, 30);
		chair_lb.setBounds(10, 170, 170, 30);
		
		did_txf.setBounds(190, 10, 150, 30);
		dname_txf.setBounds(190, 50, 150, 30);
		office_txf.setBounds(190, 90, 150, 30);
		email_txf.setBounds(190, 130, 150, 30);
		chair_txf.setBounds(190, 170, 150, 30);
		
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

		did_lb.setFont(font);
		dname_lb.setFont(font);
		office_lb.setFont(font);
		email_lb.setFont(font);
		chair_lb.setFont(font);
		

		did_txf.setFont(font);
		dname_txf.setFont(font);
		office_txf.setFont(font);
		email_txf.setFont(font);
		chair_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(did_lb);
		frame.add(dname_lb);
		frame.add(office_lb);
		frame.add(email_lb);
		frame.add(chair_lb);
		
		frame.add(did_txf);
		frame.add(dname_txf);
		frame.add(office_txf);
		frame.add(email_txf);
		frame.add(chair_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		depart dp =new depart();
		if(e.getSource()==insert_btn) {
			dp.setDname(dname_txf.getText());
			dp.setOffice(office_txf.getText());
			dp.setEmail(email_txf.getText());
			dp.setChair(chair_txf.getText());
			
			//st.insertData(st.getFname(), st.getLname(), st.getEmail(), st.getTelephone(), st.getGender());
			dp.insertData();
		}else if (e.getSource()==Read_btn) {
			int id=Integer.parseInt(did_lb.getText());
			dp.readwithDID(id);
			did_lb.setText(String.valueOf(dp.getDid()));
			dname_txf.setText(dp.getDname());
			office_txf.setText(dp.getOffice());
			email_txf.setText(dp.getEmail());
			chair_txf.setText(dp.getChair());
			
			
		}else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(did_lb.getText());
			
			dp.setDname(dname_txf.getText());
			dp.setOffice(office_txf.getText());
			dp.setEmail(email_txf.getText());
			dp.setChair(chair_txf.getText());
			dp.update(id);
		}else {
			int id=Integer.parseInt(did_lb.getText());
			dp.delete(id);
		}

	}
	public static void main(String[] args) {
		department DP = new department();

	}



}

