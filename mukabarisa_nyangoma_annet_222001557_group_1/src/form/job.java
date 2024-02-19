package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class job extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					job frame = new job();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public job() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("job_title");
		lblNewLabel.setBounds(10, 28, 110, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("department");
		lblNewLabel_1.setBounds(10, 64, 110, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("location");
		lblNewLabel_2.setBounds(10, 97, 92, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("responsibilities");
		lblNewLabel_3.setBounds(10, 132, 110, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("qualification");
		lblNewLabel_4.setBounds(10, 163, 110, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("salary range");
		lblNewLabel_5.setBounds(10, 193, 203, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(216, 27, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 63, 185, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 131, 185, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 162, 185, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(216, 192, 185, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(39, 238, 133, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(305, 312, 179, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
			String sql="INSERT INTO job VALUES(?,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(textField.getText()));
			st.setString(2,textField_1.getText());
			st.setString(3, textField_2.getText());
			st.setString(4, textField_3.getText());
			st.setString(5, textField_4.getText());
			st.setString(6, textField_5.getText());
			
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
			
			st.close();
			con.close();
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}	
					
					
					
					
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 261, 121, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(665, 295, 133, 40);
		contentPane.add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(216, 96, 185, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
					java.sql.Statement st=con.createStatement();
					String query="SELECT * FROM job";
					ResultSet rs=st.executeQuery(query);
					java.sql.ResultSetMetaData rsdm=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int cols=rsdm.getColumnCount();
					String[]colName=new String[cols];
					for(int i=0;i<cols;i++)
					colName[i]=rsdm.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String  job_title,department,location,responsibilities,qualification,salary_range;
					while(rs.next()) {
						job_title=rs.getString(1);
						department=rs.getString(2);
						location=rs.getString(3);
						responsibilities=rs.getString(4);
						qualification=rs.getString(5);
						salary_range=rs.getString(6);
						
						String[]row= {job_title,department,location,responsibilities,qualification,salary_range};	
						model.addRow(row);
						
								
					}
					
					
				}catch (Exception e2) {
					// TODO: handle exception
				}
					
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(176, 261, 89, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
						String sql="UPDATE job SET department=?,location=?,responsibilities=?,qualification=?,salary_range=? WHERE job_title=?";					
						PreparedStatement st=con.prepareStatement(sql);

						st.setString(1,textField_1.getText());
						st.setString(2, textField_2.getText());
						st.setString(3, textField_3.getText());
						st.setString(4, textField_4.getText());					
						st.setInt(5, Integer.parseInt(textField.getText()));					
											
											
						JOptionPane.showMessageDialog(btnNewButton_3, "data changed!!!");
						st.executeUpdate();
						st.close();
						con.close();
											
											
											
											
										} catch (Exception e2) {
											// TODO: handle exception
										}
										
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(312, 261, 110, 40);
		contentPane.add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(473, 11, 335, 256);
		contentPane.add(table);
	}
}
