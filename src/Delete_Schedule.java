import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete_Schedule {
	private JFrame frame;
	private JTextField textField;
	private String deleteschedulenum;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://127.0.0.1:3306/SoftwareEnginnerHw";
	String user = "root";
	String pass = "4175^^";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Schedule window = new Delete_Schedule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Delete_Schedule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			con = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame("�����ϱ�");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Num");
		lblNewLabel.setBounds(102, 71, 62, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 68, 116, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		deleteschedulenum = textField.getText();
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{          
					
					String sql = "DELETE FROM Schedule WHERE Schedule_Num="+deleteschedulenum;        
					ps = con.prepareStatement(sql); 
					ps.executeUpdate();
					int n = ps.executeUpdate();
					if(n>0){
						System.out.println("���� ����");
					}else{
						System.out.println("���� ����");
					}
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(78, 129, 105, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("���");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(217, 129, 105, 27);
		frame.getContentPane().add(btnNewButton_1);
	}

}
