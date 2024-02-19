package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class performance_reviews extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					performance_reviews frame = new performance_reviews();
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
	public performance_reviews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("performance_review_id");
		lblNewLabel.setBounds(10, 27, 190, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(298, 27, 96, 20);
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("job_title ");
		lblNewLabel_1.setBounds(10, 66, 155, 24);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("performance_goals");
		lblNewLabel_2.setBounds(10, 101, 190, 41);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ratings ");
		lblNewLabel_3.setBounds(10, 153, 165, 25);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("feedback");
		lblNewLabel_4.setBounds(10, 189, 125, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(298, 75, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(298, 107, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(298, 152, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(298, 183, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
			String sql="INSERT INTO performance_reviews VALUES(?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(textField.getText()));
			st.setString(2, textField_1.getText());
			st.setString(3, textField_2.getText());
			st.setString(4, textField_3.getText());
			st.setString(5, textField_4.getText());
			
			
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
			
			st.close();
			con.close();
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}	
					
					
					
					
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 260, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
			}
		});
		btnNewButton_1.setForeground(new Color(128, 64, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(204, 301, 89, 23);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(513, 11, 330, 259);
		contentPane.add(table);
		
		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
					java.sql.Statement st=con.createStatement();
					String query="SELECT * FROM performance_reviews";
					ResultSet rs=st.executeQuery(query);
					java.sql.ResultSetMetaData rsdm=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int cols=rsdm.getColumnCount();
					String[]colName=new String[cols];
					for(int i=0;i<cols;i++)
					colName[i]=rsdm.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String  performance_reviewsid,jobtitle,performancegoals,ratings,feedback;
					while(rs.next()) {
						performance_reviewsid=rs.getString(1);
						jobtitle=rs.getString(2);
						performancegoals=rs.getString(3);
						ratings=rs.getString(4);
						feedback=rs.getString(5);
						
						String[]row= {performance_reviewsid,jobtitle,performancegoals,ratings,feedback};	
						model.addRow(row);
						
								
					}
					
					
				}catch (Exception e2) {
					// TODO: handle exception
				}
					
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(275, 262, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
					String sql="UPDATE performance_reviews SET job_title=?,performance_goals=?,ratings=?,feedback=? WHERE performance_review_id=?";					
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(399, 262, 104, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");	
					String sql="DELETE FROM performance_reviews WHERE  performance_reviews_id=?";
					int idtxf=Integer.parseInt(JOptionPane.showInputDialog("Enter ID  to delete ")); 
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1, idtxf);
					JOptionPane.showMessageDialog(btnNewButton_4, "recored out!!");
					st.executeUpdate();
					st.close();
					con.close();
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}	
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(150, 260, 96, 25);
		contentPane.add(btnNewButton_4);
	}
}
