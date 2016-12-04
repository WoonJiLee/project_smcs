package User_Account;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//import ChangeIDview.MyWinListener;



class ChangeIDview extends JDialog implements ActionListener {
	JPanel p1,p2;
	JLabel labelID;
	JTextField textID1 = new JTextField(10);
	JTextField textID2 = new JTextField(10);
	JButton okButton, cancelButton;
	
	ChangeIDview(Frame parent, String str){
		super(parent,str, true);
		p1 = new JPanel();
		add(p1);
		labelID = new JLabel(" 변경할 ID를 입력 ");
		p1.add(labelID);
		p1.add(textID1);
		textID1.addActionListener(this);
		labelID = new JLabel(" ID 재입력 ");
		p1.add(labelID);
		p1.add(textID2);
		p2 = new JPanel();
		p1.add(p2,"South");
		textID2.addActionListener(this);
		okButton = new JButton("ok");
		okButton.addActionListener(this);
		p2.add(okButton);
		cancelButton = new JButton("cancel");
		cancelButton.addActionListener(this);
		p2.add(cancelButton);		
		setSize(400,200);
		addWindowListener(new MyWinListener());
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==okButton  ){
			if ( textID1.getText()==textID2.getText()){
				String new_id = textID1.getText();
			}
		
		}
		if (e.getSource()==cancelButton){
			textID1.setText(null);
			textID2.setText(null);
			dispose();
		}
		
		
	}
	class MyWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e){
			dispose();
		}
	}
	/*
	public void changingID() {
		// TODO Auto-generated method stub
		
	}
	*/
}


class LoginView extends JDialog implements ActionListener {
	ChangeIDview aIDchange;
	
	JPanel p1,p2,p3;
	JButton changeIDButton, changePWButton;
	JButton logoutButton,scheduleButton,phonebookButton;

	LoginView(Frame parent,String str){
		super(parent,str,true);
		
		p1 = new JPanel();
		add(p1);		
		changeIDButton = new JButton(" Change ID ");		
		changeIDButton.addActionListener(this);
		changePWButton = new JButton(" Change PW ");
		changePWButton.addActionListener(this);
		p1.add(changeIDButton, "Center");
		p1.add(changePWButton, "Center");
		
		p2 = new JPanel();
		p1.add(p2);
		scheduleButton = new JButton("스케쥴 기능");
		scheduleButton.addActionListener(this);
		phonebookButton = new JButton("폰북 기능");
		phonebookButton.addActionListener(this);
		p2.add(scheduleButton);
		p2.add(phonebookButton); 
		
		p3 = new JPanel();
		p1.add(p3,"South");
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(this);
		p3.add(logoutButton);
		setSize(400,200);
		addWindowListener(new MyWinListener());

	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==changeIDButton)
			;//aIDchange.changingID()
		if (e.getSource()==changePWButton)
			;//aPWchange.mm();
		if (e.getSource()==phonebookButton)
			;
		if (e.getSource()==scheduleButton)
			;
		if (e.getSource()==logoutButton){
			dispose();
			
		}
	}

	
	class MyWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e){
			dispose();
		}
	}

	
}

class User_Account extends JFrame implements ActionListener{
	LoginView aLogin;
	ChangeIDview aIDchange;
	//ChangePWview aPWchange;
	
	String url = "jdbc:mysql://127.0.0.1:3306/SoftwareEnginnerHw";
	String user = "root";
	String pass = "4175^^";
	String masterID=user;
	String masterPW=pass;
	String id, pw, new_id, new_pw;
	
	JPanel p;
	JButton loginButton;
	JLabel labelID, labelPW;
	JTextField textID = new JTextField(10);
	JTextField textPW = new JTextField(10);
	
	User_Account(){
		p = new JPanel();
		add(p);
		
		labelID = new JLabel(" ID ");
		labelPW = new JLabel(" PW ");
		p.add(labelID);
		p.add(textID);
		textID.addActionListener(this);
		p.add(labelPW);
		p.add(textPW);
		textPW.addActionListener(this);
		loginButton = new JButton("로그인");
		p.add(loginButton);
		loginButton.addActionListener((ActionListener) this);

	}
	
	public void isLogin(String id, String pw){
		if ( id.equals(masterID) && pw.equals(masterPW) ){
			if (aLogin==null){
				aLogin = new LoginView(this, "LOGIN");
			}
		}
		else
			JOptionPane.showMessageDialog(this, "다시 입력해주세요.","error",JOptionPane.ERROR_MESSAGE);
			
	}
	
	public void isLogout(String id, String pw){
		dispose();
	}
	public void changingID(String new_id, String id){
		
		if (aIDchange==null){
			aIDchange = new ChangeIDview(this, "CHANGE ID");
		}
		
		//JOptionPane.showMessageDialog(this, "다시 입력해주세요.","error",JOptionPane.ERROR_MESSAGE);
	}
	public void changingPW(String new_pw, String pw){
		
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if ( e.getSource()==loginButton ) {
			
			id = textID.getText();
			pw = textPW.getText();
			
			isLogin(id,pw);
			
			textID.setText(null);
			textPW.setText(null);
			
		}
		aLogin.setVisible(true);
		loginButton.requestFocus();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User_Account account = new User_Account();
		account.setTitle("HOME");
		account.setSize(400,200);
		account.setVisible(true);

	}

}


