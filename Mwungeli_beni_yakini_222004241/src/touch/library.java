package touch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import OPPS.libra;

public class library implements ActionListener{
	JFrame frame; 
	JLabel bookId_lb=new JLabel("BOOK ID");
	JLabel title_lb=new JLabel("Title ");
	JLabel author_lb=new JLabel("Author");
	JLabel genre_lb=new JLabel("Genre");
	JLabel status_lb=new JLabel("Status");

	JTextField bookId_txf=new JTextField();
	JTextField title_txf=new JTextField();
	JTextField author_txf=new JTextField();
	JTextField genre_txf=new JTextField();
	//JTextField status_txf=new JTextField();
	
	String []status={"available", "checked out"};
	JComboBox<String> statusBox = new JComboBox<>(status);


	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public library() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		
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
		bookId_lb.setBounds(10, 10, 170, 30);
		title_lb.setBounds(10, 50, 170, 30);
		author_lb.setBounds(10, 90, 170, 30);
		genre_lb.setBounds(10, 130, 170, 30);
		status_lb.setBounds(10, 170, 170, 30);
		
		bookId_txf.setBounds(190, 10, 150, 30);
		title_txf.setBounds(190, 50, 150, 30);
		author_txf.setBounds(190, 90, 150, 30);
		genre_txf.setBounds(190, 130, 150, 30);
		statusBox.setBounds(190, 170, 150, 30);
		
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

		bookId_lb.setFont(font);
		title_lb.setFont(font);
		author_lb.setFont(font);
		genre_lb.setFont(font);
		status_lb.setFont(font);
		

		bookId_txf.setFont(font);
		title_txf.setFont(font);
		author_txf.setFont(font);
		genre_txf.setFont(font);
		statusBox.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.ITALIC, 12);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addcomponentforFrame() {
		frame.add(bookId_lb);
		frame.add(title_lb);
		frame.add(author_lb);
		frame.add(genre_lb);
		frame.add(status_lb);
		
		frame.add(bookId_txf);
		frame.add(title_txf);
		frame.add(author_txf);
		frame.add(genre_txf);
		frame.add(statusBox);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		libra en =new libra();
		if(e.getSource()==insert_btn) {
			en.setTitle(title_txf.getText());
			en.setAuthor(author_txf.getText());
			en.setGenre(genre_txf.getText());
			String selectedOption = (String) statusBox.getSelectedItem();
			en.setStatus(selectedOption);
			
			en.insertData();
		}else if (e.getSource()==Read_btn) {
			int id=Integer.parseInt(bookId_txf.getText());
			en.readwithBOOKID(id);
			bookId_txf.setText(String.valueOf(en.getBookId()));
			title_txf.setText(en.getTitle());
			author_txf.setText(en.getAuthor());
			genre_txf.setText(en.getGenre());
			en.setStatus(en.getStatus());
			
			
		}else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(bookId_txf.getText());
			
			en.setTitle(title_txf.getText());
			en.setAuthor(author_txf.getText());
			en.setGenre(genre_txf.getText());
			en.setStatus((String)statusBox.getSelectedItem());
			en.update(id);
		}else {
			int id=Integer.parseInt(bookId_lb.getText());
			en.delete(id);
		}

	}
	public static void main(String[] args) {
		library li = new library();
	}



}

