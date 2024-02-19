package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class recruitments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jobtextf;
	private JTextField rectextf;
	private JTextField inttextf;
	private JTextField offertextf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recruitments frame = new recruitments();
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
	public recruitments() {
		setTitle("recruitment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("job_requisition_number");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(260, 0, 0, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("recruiting_source");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 81, 211, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("interview_notes");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 122, 169, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("offer_letter");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(28, 153, 141, 19);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
		String sql="INSERT INTO recruitment VALUES(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, Integer.parseInt(jobtextf.getText()));
		st.setString(2, rectextf.getText());
		st.setString(3, inttextf.getText());
		st.setString(4, offertextf.getText());
		
		st.executeUpdate();
		JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
		
		st.close();
		con.close();
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				
			}	
				
				
				
				
			
		}
	});
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(20, 259, 126, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobtextf.setText(null);
				rectextf.setText(null);
				inttextf.setText(null);
				offertextf.setText(null);
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(230, 260, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("job_requisition_number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(20, 44, 190, 26);
		contentPane.add(lblNewLabel_4);
		
		jobtextf = new JTextField();
		jobtextf.setBounds(264, 43, 96, 20);
		contentPane.add(jobtextf);
		jobtextf.setColumns(10);
		
		rectextf = new JTextField();
		rectextf.setBounds(264, 80, 96, 20);
		contentPane.add(rectextf);
		rectextf.setColumns(10);
		
		inttextf = new JTextField();
		inttextf.setBounds(264, 121, 96, 20);
		contentPane.add(inttextf);
		inttextf.setColumns(10);
		
		offertextf = new JTextField();
		offertextf.setBounds(264, 152, 96, 20);
		contentPane.add(offertextf);
		offertextf.setColumns(10);
		
		JLabel RECRUITMENT = new JLabel("RECRUITMENT");
		RECRUITMENT.setFont(new Font("Tahoma", Font.BOLD, 18));
		RECRUITMENT.setBounds(120, 10, 148, 27);
		contentPane.add(RECRUITMENT);
		
		table = new JTable();
		table.setBounds(454, 13, 360, 204);
		contentPane.add(table);
		
		JButton btnNewButton_2 = new JButton("VIEW");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
					java.sql.Statement st=con.createStatement();
					String query="SELECT * FROM recruitments";
					ResultSet rs=st.executeQuery(query);
					java.sql.ResultSetMetaData rsdm=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int cols=rsdm.getColumnCount();
					String[]colName=new String[cols];
					for(int i=0;i<cols;i++)
					colName[i]=rsdm.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String job_requisition_number,recruiting_source,interview_notes,offer_letter;
					while(rs.next()) {
						job_requisition_number=rs.getString(1);
						recruiting_source=rs.getString(2);
						interview_notes=rs.getString(3);
						offer_letter=rs.getString(4);
					
						String[]row= {job_requisition_number,recruiting_source,interview_notes,offer_letter};	
						model.addRow(row);
						
								
					}
					
					
				}catch (Exception e2) {
					// TODO: handle exception
				}
					
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(433, 262, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/talent_management_system","root","");
						String sql="UPDATE recruitments SET recruiting_source=?,interview_notes=?,offer_letter=? WHERE job_requisition_number=?";					
						PreparedStatement st=con.prepareStatement(sql);

						
						st.setString(1, rectextf.getText());
						st.setString(2, inttextf.getText());
						st.setString(3, offertextf.getText());					
						st.setInt(4, Integer.parseInt(jobtextf.getText()));					
											
											
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
		btnNewButton_3.setBounds(617, 263, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
