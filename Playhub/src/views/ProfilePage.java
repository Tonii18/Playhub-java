package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManagerClient;
import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundButtonImage;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;

public class ProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private RoundTextField balance;
	
	private JButton logout;
	private JButton bookings;
	private JButton add;
	private JButton backHome;
	
	private User u;

	/**
	 * Create the frame.
	 */
	public ProfilePage(User u) {
		this.u = u;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBounds(-8, 0, 1530, 90);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(730, 10, 70, 70);
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		Image resized = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		
		JLabel lblHub = new JLabel("HUB");
		lblHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblHub.setForeground(Color.WHITE);
		lblHub.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 40));
		lblHub.setBounds(810, 23, 110, 44);
		navbar.add(lblHub);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setForeground(new Color(255, 255, 255));
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		title1.setBounds(588, 23, 110, 44);
		navbar.add(title1);
		logo.setIcon(new ImageIcon(resized));
		navbar.add(logo);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1530, 90);
		background.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		navbar.add(background);
		
		JPanel body = new JPanel();
		body.setBounds(-8, 90, 1530, 681);
		contentPane.add(body);
		body.setLayout(null);
		
		JLabel pic = new JLabel("");
		pic.setBounds(690, 35, 150, 150);
		pic.setIcon(new ImageIcon(getClass().getResource("/pic2.png")));
		body.add(pic);
		
		JPanel centralPanel = new RoundPanel(20, 20);
		centralPanel.setBackground(new Color(255, 255, 255));
		centralPanel.setBounds(214, 109, 1102, 462);
		body.add(centralPanel);
		centralPanel.setLayout(null);
		
		name = new RoundTextField(10, 10, 10);
		name.setText(u.getName());
		name.setEditable(false);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		name.setBackground(new Color(230, 230, 230));
		name.setBounds(352, 110, 397, 42);
		centralPanel.add(name);
		name.setColumns(10);
		
		RoundTextField email = new RoundTextField(10, 10, 10);
		email.setText(u.getMail());
		email.setEditable(false);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBackground(new Color(230, 230, 230));
		email.setBounds(352, 170, 397, 42);
		centralPanel.add(email);
		
		RoundTextField phone = new RoundTextField(10, 10, 10);
		phone.setText(u.getPhone());
		phone.setEditable(false);
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBackground(new Color(230, 230, 230));
		phone.setBounds(352, 230, 397, 42);
		centralPanel.add(phone);
		
		balance = new RoundTextField(10, 10, 10);
		String amount = String.format("%.2f €", DBManagerClient.getBalance(u.getName()));
		balance.setText(amount);
		balance.setEditable(false);
		balance.setHorizontalAlignment(SwingConstants.CENTER);
		balance.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		balance.setColumns(10);
		balance.setBackground(new Color(230, 230, 230));
		balance.setBounds(352, 290, 397, 42);
		centralPanel.add(balance);
		
		logout = new RoundButton("Cerrar Sesion", 10, 10);
		logout.setForeground(new Color(255, 255, 255));
		logout.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setBorder(null);
		logout.setBackground(new Color(255, 101, 103));
		logout.setBounds(352, 382, 180, 42);
		centralPanel.add(logout);
		
		bookings = new RoundButton("Ver Reservas", 10, 10);
		bookings.setForeground(new Color(255, 255, 255));
		bookings.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		bookings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bookings.setBorder(null);
		bookings.setBackground(new Color(54, 184, 140));
		bookings.setBounds(569, 382, 180, 42);
		centralPanel.add(bookings);
		
		add = new RoundButtonImage("", 10, 10);
		add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add.setBorder(null);
		add.setBackground(new Color(255, 181, 26));
		add.setIcon(new ImageIcon(getClass().getResource("/addBalance.png")));
		add.setBounds(759, 290, 42, 42);
		centralPanel.add(add);
		
		JLabel back = new JLabel("");
		back.setBounds(0, 0, 1530, 340);
		back.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		body.add(back);
		
		backHome = new RoundButtonImage("", 10, 10);
		backHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backHome.setBorder(null);
		backHome.setIcon(new ImageIcon(getClass().getResource("/arrow_back (2).png")));
		backHome.setBounds(20, 620, 50, 50);
		body.add(backHome);
		
		add.addActionListener(new buttons());
		backHome.addActionListener(new buttons());
		logout.addActionListener(new buttons());
		bookings.addActionListener(new buttons());
		
	}
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == add) {
				addBalance();
			}else if(button == backHome) {
				HomeUser h = new HomeUser(u);
				h.setVisible(true);
				dispose();
			}else if(button == logout) {
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cerrar sesion?");
				if(option == 0) {
					Login l = new Login();
					l.setVisible(true);
					dispose();
				}
			}else if(button == bookings) {
				BookingListPage blp = new BookingListPage(u);
				blp.setVisible(true);
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void addBalance() {
		String input = JOptionPane.showInputDialog(null, "Introduce la cantidad que deseas abonar");
		double amount = Double.parseDouble(input);
		
		DBManagerClient.setNewBalance(u.getName(), amount);
		JOptionPane.showMessageDialog(null, "¡Has ingresado en tu cuenta de PlayHub correctamente "+amount+" Euros!");
		balance.setText(String.valueOf(DBManagerClient.getBalance(u.getName())));
	}
	
}
