import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class User_Account {
	static String masterID,masterPW;
	static String new_id,new_pw;
	String id,pw;
	
	public void login(String id,String pw){
		if ( id.equals(masterID) && pw.equals(masterPW) )
			;//loginButton.clicked();
	}
	public void logout(String id,String pw){
		;
	}
	public void changeID(String new_id,String id){
		;
	}
	public void changePW(String new_pw,String pw){
		;
	}
}

class LoginView extends JDialog implements ActionListener {
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
			;
		if (e.getSource()==changePWButton)
			;
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
public class ExHome extends JFrame implements ActionListener{
	LoginView aLogin;
	
	
	static String masterID, masterPW;
	String new_id,new_pw;
	String id, pw;
	
	JPanel p;
	JButton loginButton;
	JLabel labelID, labelPW;
	JTextField textID = new JTextField(10);
	JPasswordField textPW = new JPasswordField(10);
	
	ExHome(){
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
	public void actionPerformed(ActionEvent e){
		//if (       ){			
			if ( ( textID.equals(masterID) && textPW.equals(masterPW) ) && e.getSource()==loginButton){		
				if (aLogin==null)
					aLogin = new LoginView(this, "LOGIN");
				
				textID.setText(null);
				textPW.setText(null);								
			}
			else {
				JOptionPane.showMessageDialog(this, "다시 입력해주세요.","error",JOptionPane.ERROR_MESSAGE);
				textID.setText(null);
				textPW.setText(null);
			}
			
			aLogin.setVisible(true);
			loginButton.requestFocus();
		//}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExHome home = new ExHome();
		home.setTitle("HOME");
		home.setSize(400,200);
		home.setVisible(true);
		

	}

}
