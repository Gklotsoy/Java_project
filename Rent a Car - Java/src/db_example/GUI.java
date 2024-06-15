package db_example;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import java.awt.Color;


public class GUI {

	private JFrame frame;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_address;
	private JTextField txt_email;
	private JTextField txt_phone;
	private JTextField txtPhoneNumber;
	private JTextField txt_customer;
	private JTextField txt_id;
	private JTextField searchCustomerTXT;
	private JTextField txt_model;
	private JTextField txt_cost;
	private JTextField txt_cc;
	private JTextField txt_seats;
	private JTextField txt_start_day;
	private JTextField txt_start_month;
	private JTextField txt_start_year;
	private JTextField txt_end_day;
	private JTextField txt_end_month;
	private JTextField txt_end_year;
	private JTextField txt_car_id;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1216, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 1180, 481);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New Customer", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD NEW CUSTOMER");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(457, 46, 259, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(361, 95, 99, 29);
		panel.add(lblNewLabel_1);
		
		txt_fname = new JTextField();
		txt_fname.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_fname.setBounds(490, 96, 212, 27);
		panel.add(txt_fname);
		txt_fname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(361, 135, 99, 29);
		panel.add(lblNewLabel_1_1);
		
		txt_lname = new JTextField();
		txt_lname.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_lname.setColumns(10);
		txt_lname.setBounds(490, 134, 212, 27);
		panel.add(txt_lname);
		
		txt_address = new JTextField();
		txt_address.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_address.setColumns(10);
		txt_address.setBounds(490, 216, 212, 27);
		panel.add(txt_address);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(361, 175, 99, 29);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Address");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(361, 215, 99, 29);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Email");
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(361, 255, 99, 29);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Phone");
		lblNewLabel_1_1_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1_4.setBounds(361, 295, 99, 29);
		panel.add(lblNewLabel_1_1_4);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_email.setColumns(10);
		txt_email.setBounds(490, 259, 212, 27);
		panel.add(txt_email);
		
		txt_phone = new JTextField();
		txt_phone.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_phone.setColumns(10);
		txt_phone.setBounds(490, 299, 212, 27);
		panel.add(txt_phone);
		
		enum Genders{
			Male, Female
		}
		
		JComboBox<Genders> gender_select = new JComboBox<Genders>(Genders.values());
		gender_select.setFont(new Font("Arial", Font.PLAIN, 13));
		gender_select.setBounds(490, 172, 212, 28);
		panel.add(gender_select);
		
		JButton save_btn = new JButton("SAVE");
		save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first_name = txt_fname.getText();
				String last_name = txt_lname.getText();
				Enum<?> gender = (Enum<?>) gender_select.getSelectedItem();
				String address = txt_address.getText();
				String email = txt_email.getText();
				String phone = txt_phone.getText();
				String sql;

				try {
					Connection connection = DBUtils.getConnection();
					java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					

					
					if (first_name.equals(" ") || first_name.equals("") ) {
					    JOptionPane.showMessageDialog(frame, "Name is required");
					}
					else if (last_name.equals(" ") || last_name.equals("") ) {
					    JOptionPane.showMessageDialog(frame, "Last name is required");
					}
					else if (address.equals(" ") || address.equals("") ) {
					    JOptionPane.showMessageDialog(frame, "Address is required");
					}
					else if (email.equals(" ") || email.equals("") ) {
					    JOptionPane.showMessageDialog(frame, "Email is required");
					}
					else if (phone.equals(" ") || phone.equals("") ) {
					    JOptionPane.showMessageDialog(frame, "Phone is required");
					    
					}
					else if(email != null && phone != null) {
						sql = "SELECT id FROM customers WHERE email = '"+email+"' OR phone = '"+phone+"'";
						
						statement.execute(sql);
						@SuppressWarnings("unused")
						boolean checkCustomer = statement.execute(sql); 
						if(checkCustomer = false) {
							JOptionPane.showMessageDialog(frame, "Email or phone already exists!");
						}
						else {
							sql = "INSERT INTO customers (first_name, last_name, gender, address, email, phone)"
									+ "VALUES ('"+first_name+"', '"+last_name+"', '"+gender+"', '"+address+"', '"+email+"', '"+phone+"')";
							statement.execute(sql);
							
							JOptionPane.showMessageDialog(frame, "Customer Added");
							
							txt_fname.setText(null);
							txt_lname.setText(null);
							txt_address.setText(null);
							txt_email.setText(null);
							txt_phone.setText(null);
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		save_btn.setFont(new Font("Arial", Font.BOLD, 13));
		save_btn.setBounds(520, 337, 135, 39);
		panel.add(save_btn);
		
		JButton clear_btn = new JButton("CLEAR");
		clear_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_fname.setText(null);
				txt_lname.setText(null);
				txt_address.setText(null);
				txt_email.setText(null);
				txt_phone.setText(null);
				
			}
		});
		clear_btn.setFont(new Font("Arial", Font.BOLD, 13));
		clear_btn.setBounds(520, 387, 135, 39);
		panel.add(clear_btn);
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("New Car", null, panel_2, null);
		
		JLabel lblNewLabel_2 = new JLabel("ADD NEW CAR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(447, 11, 175, 47);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Model");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(250, 88, 122, 22);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("Category");
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(250, 141, 122, 22);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Daily Cost");
		lblNewLabel_4_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(250, 193, 122, 22);
		panel_2.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Cylinder Capacity");
		lblNewLabel_4_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_4.setBounds(250, 239, 122, 22);
		panel_2.add(lblNewLabel_4_4);
		
		txt_model = new JTextField();
		txt_model.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_model.setBounds(434, 89, 218, 22);
		panel_2.add(txt_model);
		txt_model.setColumns(10);
		
		txt_cost = new JTextField();
		txt_cost.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_cost.setColumns(10);
		txt_cost.setBounds(434, 195, 218, 22);
		panel_2.add(txt_cost);
		
		txt_cc = new JTextField();
		txt_cc.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_cc.setColumns(10);
		txt_cc.setBounds(434, 241, 218, 22);
		panel_2.add(txt_cc);
		
		enum carCategory{
			Economy, Compact, Midsize, Fullsize, SUV, Van, Luxury
				}
		
		JComboBox<carCategory> category_box = new JComboBox<carCategory>(carCategory.values());
		category_box.setFont(new Font("Arial", Font.PLAIN, 13));
		category_box.setBounds(434, 138, 218, 31);
		panel_2.add(category_box);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("Seats");
		lblNewLabel_4_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_4_1.setBounds(250, 285, 122, 22);
		panel_2.add(lblNewLabel_4_4_1);
		
		txt_seats = new JTextField();
		txt_seats.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_seats.setColumns(10);
		txt_seats.setBounds(434, 287, 218, 22);
		panel_2.add(txt_seats);
		
		JButton save_car_btn = new JButton("SAVE");
		save_car_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String car_model = txt_model.getText();
				Enum<?> car_category = (Enum<?>) category_box.getSelectedItem();
				String daily_cost = txt_cost.getText();
				String cylinder_capacity = txt_cc.getText();
				String seats_number = txt_seats.getText();
				String sql = null;

				

				
				try {
					Connection connection = DBUtils.getConnection();
					java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					
					if(car_model.equals("") || car_model.equals(" ")) {
						JOptionPane.showMessageDialog(frame, "Add model");
					}
					else if(daily_cost.equals("") || daily_cost.equals(" ")) {
						JOptionPane.showMessageDialog(frame, "Add daily cost");
					}
					else if(cylinder_capacity.equals("") || cylinder_capacity.equals(" ")) {
						JOptionPane.showMessageDialog(frame, "Add daily Cylinder Capacity");
					}
					else if(seats_number.equals("") || seats_number.equals(" ")) {
						JOptionPane.showMessageDialog(frame, "Add Number of Seats");
					}
					else {
						
						sql = "SELECT model FROM cars WHERE model = '"+car_model+"'";
						
						
						statement.execute(sql);
						@SuppressWarnings("unused")
						boolean checkCar = statement.execute(sql); 
						if(checkCar = false) {
							JOptionPane.showMessageDialog(frame, "'"+car_model+"' already exists! Add something to differeciate it");
						}
						else{
							boolean isNumericDaily_cost = daily_cost.matches("[0-9]+");
							boolean isNumericCylinder_capacity = cylinder_capacity.matches("[0-9]+");
							boolean isNumericSeats_number = seats_number.matches("[0-9]+");
							
							if(isNumericDaily_cost && isNumericCylinder_capacity && isNumericSeats_number) {
							
							sql = "INSERT INTO cars(model, daily_cost, cubic_capacity, seats, category)"
									+ "VALUES('"+car_model+"', '"+daily_cost+"', '"+cylinder_capacity+"', '"+seats_number+"', '"+car_category+"')";
							
							statement.execute(sql);
							JOptionPane.showMessageDialog(frame, "Car Added");
							txt_model.setText(null);
							txt_seats.setText(null);
							txt_cost.setText(null);
							
							
							}
							else {
								JOptionPane.showMessageDialog(frame, "Enter Valid Values");
							}
						}

						
					}

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		save_car_btn.setFont(new Font("Arial", Font.BOLD, 15));
		save_car_btn.setBounds(492, 347, 89, 37);
		panel_2.add(save_car_btn);

		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Rent A Car", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Search Customer");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(54, 24, 130, 25);
		panel_1.add(lblNewLabel_3);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setToolTipText("");
		txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPhoneNumber.setBounds(194, 25, 210, 25);
		panel_1.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		txt_customer = new JTextField();
		txt_customer.setBackground(new Color(192, 192, 192));
		txt_customer.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_customer.setColumns(10);
		txt_customer.setBounds(194, 96, 295, 25);
		panel_1.add(txt_customer);
		
		JLabel lblNewLabel_3_1 = new JLabel("Customer");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(54, 96, 100, 25);
		panel_1.add(lblNewLabel_3_1);
		

		enum carCategories{
			All, Economy, Compact, Midsize, Fullsize, SUV, Van, Luxury
		}
		
		JComboBox<carCategories> select_car_category = new JComboBox<carCategories>(carCategories.values());
		select_car_category.setFont(new Font("Arial", Font.PLAIN, 13));
		select_car_category.setBounds(846, 20, 227, 30);
		panel_1.add(select_car_category);
		
		JLabel lblNewLabel_3_2 = new JLabel("Car Categories");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(702, 24, 130, 25);
		panel_1.add(lblNewLabel_3_2);
		
		@SuppressWarnings("rawtypes")
		JComboBox<String> select_car = new JComboBox();
		select_car.setFont(new Font("Arial", Font.PLAIN, 13));
		select_car.setBounds(846, 96, 227, 30);
		panel_1.add(select_car);
		
		JButton btn_search_cat = new JButton("Go");
		btn_search_cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String car_category = (String) select_car_category.getSelectedItem().toString();

				
				select_car.removeAllItems();
				String sql = null;
				
				try {
					Connection connection = DBUtils.getConnection();
					java.sql.Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					if (car_category == "All") {
						sql = "SELECT model FROM cars";
					}
					else {
						sql = "SELECT model FROM cars WHERE category = '"+car_category+"'";
					}
					
					
					ResultSet resultSet = statement1.executeQuery(sql);
					
					while(resultSet.next()) {
						String cars = resultSet.getString("model");
						select_car.addItem(cars);
						
						
					}
					resultSet.close();
					statement1.close();
					connection.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_search_cat.setFont(new Font("Arial", Font.BOLD, 13));
		btn_search_cat.setBounds(1101, 19, 53, 37);
		panel_1.add(btn_search_cat);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Car Model");
		lblNewLabel_3_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(702, 94, 100, 25);
		panel_1.add(lblNewLabel_3_2_1);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setVisible(false);
		txt_id.setToolTipText("");
		txt_id.setHorizontalAlignment(SwingConstants.CENTER);
		txt_id.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_id.setColumns(10);
		txt_id.setBounds(157, 96, 27, 25);
		panel_1.add(txt_id);
		
		
		JLabel lblNewLabel_3_3 = new JLabel("From");
		lblNewLabel_3_3.setVisible(false);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(194, 266, 82, 25);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Until");
		lblNewLabel_3_3_1.setVisible(false);
		lblNewLabel_3_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_1.setBounds(696, 266, 71, 25);
		panel_1.add(lblNewLabel_3_3_1);
		
		txt_start_day = new JTextField();
		txt_start_day.setToolTipText("");
		txt_start_day.setVisible(false);
		txt_start_day.setHorizontalAlignment(SwingConstants.CENTER);
		txt_start_day.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_start_day.setColumns(10);
		txt_start_day.setBounds(286, 267, 53, 25);
		panel_1.add(txt_start_day);
		
		txt_start_month = new JTextField();
		txt_start_month.setVisible(false);
		txt_start_month.setToolTipText("");
		txt_start_month.setHorizontalAlignment(SwingConstants.CENTER);
		txt_start_month.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_start_month.setColumns(10);
		txt_start_month.setBounds(359, 267, 62, 25);
		panel_1.add(txt_start_month);
		
		txt_start_year = new JTextField();
		txt_start_year.setVisible(false);
		txt_start_year.setToolTipText("");
		txt_start_year.setHorizontalAlignment(SwingConstants.CENTER);
		txt_start_year.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_start_year.setColumns(10);
		txt_start_year.setBounds(443, 267, 66, 25);
		panel_1.add(txt_start_year);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("DD");
		lblNewLabel_3_3_2.setVisible(false);
		lblNewLabel_3_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_2.setBounds(286, 229, 53, 25);
		panel_1.add(lblNewLabel_3_3_2);
		
		JLabel lblNewLabel_3_3_2_1 = new JLabel("MM");
		lblNewLabel_3_3_2_1.setVisible(false);
		lblNewLabel_3_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_2_1.setBounds(355, 229, 66, 25);
		panel_1.add(lblNewLabel_3_3_2_1);
		
		JLabel lblNewLabel_3_3_2_1_1 = new JLabel("YYYY");
		lblNewLabel_3_3_2_1_1.setVisible(false);
		lblNewLabel_3_3_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_2_1_1.setBounds(443, 229, 66, 25);
		panel_1.add(lblNewLabel_3_3_2_1_1);
		
		JLabel lblNewLabel_3_3_2_2 = new JLabel("DD");
		lblNewLabel_3_3_2_2.setVisible(false);
		lblNewLabel_3_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_2_2.setBounds(788, 228, 53, 25);
		panel_1.add(lblNewLabel_3_3_2_2);
		
		txt_end_day = new JTextField();
		txt_end_day.setVisible(false);
		txt_end_day.setToolTipText("");
		txt_end_day.setHorizontalAlignment(SwingConstants.CENTER);
		txt_end_day.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_end_day.setColumns(10);
		txt_end_day.setBounds(788, 266, 53, 25);
		panel_1.add(txt_end_day);
		
		txt_end_month = new JTextField();
		txt_end_month.setVisible(false);
		txt_end_month.setToolTipText("");
		txt_end_month.setHorizontalAlignment(SwingConstants.CENTER);
		txt_end_month.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_end_month.setColumns(10);
		txt_end_month.setBounds(861, 266, 62, 25);
		panel_1.add(txt_end_month);
		
		JLabel lblNewLabel_3_3_2_1_2 = new JLabel("MM");
		lblNewLabel_3_3_2_1_2.setVisible(false);
		lblNewLabel_3_3_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_2_1_2.setBounds(857, 228, 66, 25);
		panel_1.add(lblNewLabel_3_3_2_1_2);
		
		JLabel lblNewLabel_3_3_2_1_1_1 = new JLabel("YYYY");
		lblNewLabel_3_3_2_1_1_1.setVisible(false);
		lblNewLabel_3_3_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3_3_2_1_1_1.setBounds(945, 228, 66, 25);
		panel_1.add(lblNewLabel_3_3_2_1_1_1);
		
		txt_end_year = new JTextField();
		txt_end_year.setVisible(false);
		txt_end_year.setToolTipText("");
		txt_end_year.setHorizontalAlignment(SwingConstants.CENTER);
		txt_end_year.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_end_year.setColumns(10);
		txt_end_year.setBounds(945, 266, 66, 25);
		panel_1.add(txt_end_year);
		
		JButton btn_search = new JButton("Go");
		btn_search.setFont(new Font("Arial", Font.BOLD, 13));
		btn_search.setBounds(436, 19, 53, 37);
		panel_1.add(btn_search);
		
		JButton btn_save_rental = new JButton("SAVE");
		btn_save_rental.setVisible(false);
		btn_save_rental.setFont(new Font("Arial", Font.BOLD, 13));
		btn_save_rental.setBounds(515, 334, 156, 37);
		panel_1.add(btn_save_rental);
		
		JButton btn_confirm = new JButton("CONFIRM");
		btn_confirm.setFont(new Font("Arial", Font.BOLD, 13));
		btn_confirm.setBounds(515, 161, 156, 37);
		panel_1.add(btn_confirm);
		
		txt_car_id = new JTextField();
		txt_car_id.setEditable(false);
		txt_car_id.setVisible(false);
		txt_car_id.setToolTipText("");
		txt_car_id.setHorizontalAlignment(SwingConstants.CENTER);
		txt_car_id.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_car_id.setColumns(10);
		txt_car_id.setBounds(805, 96, 27, 25);
		panel_1.add(txt_car_id);
		
		
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PhoneNumber = txtPhoneNumber.getText();
				String sql = null;
				
				
				try {
					Connection connection = DBUtils.getConnection();
					java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet resultSet;
					
					if (PhoneNumber.equals(" ") || PhoneNumber.equals("") ) {
					    JOptionPane.showMessageDialog(frame, "Search for a phone number");
					}
					else {
	
						sql = "SELECT id, first_name, last_name FROM customers WHERE phone = '"+PhoneNumber+"'";
						
						resultSet = statement.executeQuery(sql);
						
						if (resultSet.next()) {
			                String name = resultSet.getString("first_name");
			                String lastName = resultSet.getString("last_name");
			                txt_customer.setText(name.concat(" ").concat(lastName));
			                int customerID = resultSet.getInt("id");
			                txt_id.setText(Integer.toString(customerID));
			            } else {
			                JOptionPane.showMessageDialog(frame, "No customer found with the given phone number.");
			            }

						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btn_confirm.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				String car_model = null;
				String customerID = txt_id.getText();
				
				if(select_car.getItemCount() != 0) {
				car_model = select_car.getSelectedItem().toString();
				}
				
				
				if(txt_id == null && txt_id.equals("") && txt_id.equals(" ")) {
					
				}
				else {
					customerID = txt_id.getText();
				}
				
				String sql;
				int carID = 0;
				
					if (!customerID.isEmpty()) {
						if(select_car.getItemCount() != 0) {
						
							if(car_model != null) {
								
								try {
									Connection connection = DBUtils.getConnection();
									java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
									ResultSet resultSet;
									
									sql = "SELECT id FROM cars WHERE model = '"+car_model+"'";
									
									resultSet = statement.executeQuery(sql);
									
									
									while(resultSet.next()) {
									carID = resultSet.getInt("id");
									}
									
									String carIDStr = Integer.toString(carID);
									
									txt_car_id.setText(carIDStr);
									
									
									lblNewLabel_3_3.setVisible(true);
									lblNewLabel_3_3_1.setVisible(true);
									lblNewLabel_3_3_2.setVisible(true);
									lblNewLabel_3_3_2_1.setVisible(true);
									lblNewLabel_3_3_2_1_1.setVisible(true);
									lblNewLabel_3_3_2_2.setVisible(true);
									lblNewLabel_3_3_2_1_2.setVisible(true);
									lblNewLabel_3_3_2_1_1_1.setVisible(true);
									txt_start_day.setVisible(true);
									txt_start_month.setVisible(true);
									txt_start_year.setVisible(true);
									txt_end_day.setVisible(true);
									txt_end_month.setVisible(true);
									txt_end_year.setVisible(true);
									btn_save_rental.setVisible(true);
									
									

								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								

							
							} else if(car_model == null && customerID != null) {
								JOptionPane.showMessageDialog(frame, "Choose a car model");
							}
					
						}
						else {
							JOptionPane.showMessageDialog(frame, "Choose a car category");
						}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Search for a customer");
				}
			}
		});
		
		
		btn_save_rental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String car_model = select_car.getSelectedItem().toString();
				String customerID = txt_id.getText();
				String startDay = txt_start_day.getText();
				String startMonth = txt_start_month.getText();
				String startYear = txt_start_year.getText();
				String endDay = txt_end_day.getText();
				String endMonth = txt_end_month.getText();
				String endYear = txt_end_year.getText();
				String startDate = null;
				String endDate = null;
				String sql;
				String carIDstr = txt_car_id.getText();
				int carID = Integer.parseInt(carIDstr);
				

				if(startDay.length() == 2 && startMonth.length() == 2 && startYear.length() == 4) {
					startDate = startYear.concat("-").concat(startMonth).concat("-").concat(startDay);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Enter Valid Values To Start Date");
				}
				
				if(endDay.length() == 2 && endMonth.length() == 2 && endYear.length() == 4) {
					endDate = endYear.concat("-").concat(endMonth).concat("-").concat(endDay);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Enter Valid Values To End Date");
				}
				
				try {
					Connection connection = DBUtils.getConnection();
					java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

					
					
					if(carID != 0) {

						
						 sql = "INSERT INTO rentals (customer_id, car_id, start_date, end_date) "
								+ "VALUES ('"+customerID+"', '"+carID+"', '"+startDate+"', '"+endDate+"')";
						
						
						
						statement.execute(sql);
						
						JOptionPane.showMessageDialog(frame, "Completed");
						
						lblNewLabel_3_3.setVisible(false);
						lblNewLabel_3_3_1.setVisible(false);
						lblNewLabel_3_3_2.setVisible(false);
						lblNewLabel_3_3_2_1.setVisible(false);
						lblNewLabel_3_3_2_1_1.setVisible(false);
						lblNewLabel_3_3_2_2.setVisible(false);
						lblNewLabel_3_3_2_1_2.setVisible(false);
						lblNewLabel_3_3_2_1_1_1.setVisible(false);
						txt_start_day.setVisible(false);
						txt_start_month.setVisible(false);
						txt_start_year.setVisible(false);
						txt_end_day.setVisible(false);
						txt_end_month.setVisible(false);
						txt_end_year.setVisible(false);
						btn_save_rental.setVisible(false);
						
						txt_start_day.setText(null);
						txt_start_month.setText(null);
						txt_start_year.setText(null);
						txt_end_day.setText(null);
						txt_end_month.setText(null);
						txt_end_year.setText(null);
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "Failed");
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Rentals", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JLabel lblNewLabel_4_1 = new JLabel("Search By");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(273, 24, 117, 28);
		panel_3.add(lblNewLabel_4_1);
		
		enum SearchBy {
			Customer, Car
		}
		
		JComboBox<SearchBy> search_by = new JComboBox<SearchBy>(SearchBy.values());
		search_by.setFont(new Font("Arial", Font.PLAIN, 13));
		search_by.setBounds(429, 25, 224, 28);
		panel_3.add(search_by);
		

		
		JLabel searchLabel = new JLabel("Search");
		searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
		searchLabel.setBounds(59, 93, 117, 28);
		searchLabel.setVisible(false);
		panel_3.add(searchLabel);
		
		searchCustomerTXT = new JTextField();
		searchCustomerTXT.setFont(new Font("Arial", Font.PLAIN, 13));
		searchCustomerTXT.setBounds(190, 94, 217, 28);
		searchCustomerTXT.setVisible(false);
		panel_3.add(searchCustomerTXT);
		searchCustomerTXT.setColumns(10);
		
		JLabel chooseLabel = new JLabel("Choose");
		chooseLabel.setFont(new Font("Arial", Font.BOLD, 14));
		chooseLabel.setBounds(625, 93, 117, 28);
		chooseLabel.setVisible(false);
		panel_3.add(chooseLabel);
		
		@SuppressWarnings("rawtypes")
		JComboBox<String> searchCarBox = new JComboBox();
		searchCarBox.setBounds(782, 96, 224, 25);
		searchCarBox.setVisible(false);
		panel_3.add(searchCarBox);
		
		JTextPane results_panel = new JTextPane();
		results_panel.setEditable(false);
		results_panel.setBounds(59, 276, 1080, 145);
		panel_3.add(results_panel);
		
		JButton searchRentals_btn = new JButton("Go");

		searchRentals_btn.setFont(new Font("Arial", Font.BOLD, 14));
		searchRentals_btn.setBounds(506, 161, 67, 34);
		searchRentals_btn.setVisible(false);
		panel_3.add(searchRentals_btn);
		
		JButton confirm_btn = new JButton("Confirm");
		confirm_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchChoise = search_by.getSelectedItem().toString();
				
				if (searchChoise == "Customer") {
					searchLabel.setVisible(true);
					searchCustomerTXT.setVisible(true);
					searchRentals_btn.setVisible(true);
					chooseLabel.setVisible(false);
					searchCarBox.setVisible(false);
					
				}else if(searchChoise == "Car"){
					searchLabel.setVisible(false);
					searchCustomerTXT.setVisible(false);
					chooseLabel.setVisible(true);
					searchCarBox.setVisible(true);
					searchRentals_btn.setVisible(true);
					
					String sql = "SELECT model FROM cars";
					
					try {
						Connection connection = DBUtils.getConnection();
						java.sql.Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
						ResultSet resultSet = statement1.executeQuery(sql);
						
						while(resultSet.next()) {
							String cars = resultSet.getString("model");
							searchCarBox.addItem(cars);
							
							
						}
						resultSet.close();
						statement1.close();
						connection.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
				}

			}
		});
		confirm_btn.setFont(new Font("Arial", Font.BOLD, 13));
		confirm_btn.setBounds(702, 25, 138, 28);
		panel_3.add(confirm_btn);
		

		
		searchRentals_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchChoise = search_by.getSelectedItem().toString();
				String phoneSearchCustomer = null;
				String selectedCar = null;
				String sql = null;
				
				try {
					Connection connection = DBUtils.getConnection();
					java.sql.Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet resultSet;
					
					
					if(searchChoise == "Customer") {
						selectedCar = null;
						searchCarBox.removeAllItems();
						phoneSearchCustomer = searchCustomerTXT.getText();
						
						sql = "SELECT customer_id AS customer_id, first_name AS first_name, last_name AS last_name, phone AS phone, "
								+ "car_id AS car_id, model AS model, start_date AS start_date, end_date AS end_date "
								+ "FROM rentals "
								+ "JOIN customers ON rentals.customer_id = customers.id "
								+ "JOIN cars ON rentals.car_id = cars.id "
								+ "WHERE phone = '"+phoneSearchCustomer+"' "
								+ "ORDER BY start_date DESC";
						
						
								resultSet = statement.executeQuery(sql);
								resultSet.first();

								StringBuilder resultBuilder = new StringBuilder();
								if (resultSet.isBeforeFirst()) {
									results_panel.setText("No data found");
								} else {
									do {
										String f_name = resultSet.getString("first_name");
										String l_name = resultSet.getString("last_name");
										String car_model = resultSet.getString("model");
										Date start_date = resultSet.getDate("start_date");
										Date end_date = resultSet.getDate("end_date");

										String s_date = start_date.toString();
										String e_date = end_date.toString();

										String result = f_name + " " + l_name + " " + car_model + " " + s_date + " " + e_date;
										resultBuilder.append(result).append("\n");

									} while(resultSet.next());

									results_panel.setText(resultBuilder.toString());
								}
						
					}
					else if (searchChoise == "Car") {
						phoneSearchCustomer = null;
						selectedCar = searchCarBox.getSelectedItem().toString();
						
						sql = "SELECT customer_id AS customer_id, first_name AS first_name, last_name AS last_name, phone AS phone, "
								+ "car_id AS car_id, model AS model, start_date AS start_date, end_date AS end_date "
								+ "FROM rentals "
								+ "JOIN customers ON rentals.customer_id = customers.id "
								+ "JOIN cars ON rentals.car_id = cars.id "
								+ "WHERE model = '"+selectedCar+"' "
								+ "ORDER BY start_date DESC";
						
						
								resultSet = statement.executeQuery(sql);
								resultSet.first();

								StringBuilder resultBuilder = new StringBuilder();
								if (resultSet.isBeforeFirst()) {
									results_panel.setText("No data found");
								} else {
									do {
										String f_name = resultSet.getString("first_name");
										String l_name = resultSet.getString("last_name");
										String car_model = resultSet.getString("model");
										Date start_date = resultSet.getDate("start_date");
										Date end_date = resultSet.getDate("end_date");

										String s_date = start_date.toString();
										String e_date = end_date.toString();

										String result = f_name + " " + l_name + " " + car_model + " " + s_date + " " + e_date;
										resultBuilder.append(result).append("\n");
										

									} while(resultSet.next());

									results_panel.setText(resultBuilder.toString());
								}

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

			}
		});
		
		
		
	}
}
