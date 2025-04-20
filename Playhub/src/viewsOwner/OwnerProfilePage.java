package viewsOwner;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controllers.DBManagerClient;
import controllers.DBManagerOwner;
import models.Owner;
import roundedComponents.RoundButton;
import roundedComponents.RoundButtonImage;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;
import views.HomeUser;
import views.Login;
import javax.swing.JSeparator;

public class OwnerProfilePage extends JFrame {

	private JPanel contentPane;
	
	private JTextField name;
	private RoundTextField income;
	
	private JButton logout;
	private JButton backHome;
	
	private Owner o;

	/**
	 * Create the frame.
	 */
	public OwnerProfilePage(Owner o) {
		this.o = o;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBounds(-7, 0, 1530, 90);
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
		name.setText(o.getName()+" "+o.getSurname());
		name.setEditable(false);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Inter 24pt Light", Font.PLAIN, 20));
		name.setBackground(new Color(255, 255, 255));
		name.setBounds(654, 110, 397, 42);
		centralPanel.add(name);
		name.setColumns(10);
		
		RoundTextField email = new RoundTextField(10, 10, 10);
		email.setText(o.getEmail());
		email.setEditable(false);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("Inter 24pt Light", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBackground(new Color(255, 255, 255));
		email.setBounds(654, 170, 397, 42);
		centralPanel.add(email);
		
		RoundTextField phone = new RoundTextField(10, 10, 10);
		phone.setText(o.getPhone());
		phone.setEditable(false);
		phone.setHorizontalAlignment(SwingConstants.CENTER);
		phone.setFont(new Font("Inter 24pt Light", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBackground(new Color(255, 255, 255));
		phone.setBounds(654, 230, 397, 42);
		centralPanel.add(phone);
		
		income = new RoundTextField(10, 10, 10);
		String amount = String.format("%.2f €", DBManagerOwner.getIncome(o.getName()));
		income.setText(amount);
		income.setEditable(false);
		income.setHorizontalAlignment(SwingConstants.CENTER);
		income.setFont(new Font("Inter 24pt Light", Font.PLAIN, 20));
		income.setColumns(10);
		income.setBackground(new Color(255, 255, 255));
		income.setBounds(654, 290, 397, 42);
		centralPanel.add(income);
		
		logout = new RoundButton("Cerrar Sesion", 10, 10);
		logout.setForeground(new Color(255, 255, 255));
		logout.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setBorder(null);
		logout.setBackground(new Color(255, 101, 103));
		logout.setBounds(352, 382, 397, 42);
		centralPanel.add(logout);
		
		JLabel nameLbl = new JLabel("Nombre: ");
		nameLbl.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 20));
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setBounds(51, 109, 99, 42);
		centralPanel.add(nameLbl);
		
		JLabel correoLabl = new JLabel("Correo electronico:");
		correoLabl.setHorizontalAlignment(SwingConstants.CENTER);
		correoLabl.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 20));
		correoLabl.setBounds(51, 169, 189, 42);
		centralPanel.add(correoLabl);
		
		JLabel phoneLbl = new JLabel("Teléfono: ");
		phoneLbl.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLbl.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 20));
		phoneLbl.setBounds(51, 229, 99, 42);
		centralPanel.add(phoneLbl);
		
		JLabel incomesLbl = new JLabel("Ingresos totales:");
		incomesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		incomesLbl.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 20));
		incomesLbl.setBounds(51, 289, 165, 42);
		centralPanel.add(incomesLbl);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(215, 215, 215));
		separator1.setBounds(51, 157, 1000, 2);
		centralPanel.add(separator1);
		
		JSeparator separator1_1 = new JSeparator();
		separator1_1.setForeground(new Color(215, 215, 215));
		separator1_1.setBounds(51, 217, 1000, 2);
		centralPanel.add(separator1_1);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setForeground(new Color(215, 215, 215));
		separator1_1_1.setBounds(51, 277, 1000, 2);
		centralPanel.add(separator1_1_1);
		
		JSeparator separator1_1_1_1 = new JSeparator();
		separator1_1_1_1.setForeground(new Color(215, 215, 215));
		separator1_1_1_1.setBounds(51, 341, 1000, 2);
		centralPanel.add(separator1_1_1_1);
		
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
		
		SwingUtilities.invokeLater(() -> {
		    body.requestFocusInWindow();
		});
		
		// Events
		
		backHome.addActionListener(new buttons());
		logout.addActionListener(new buttons());
	}
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == backHome) {
				HomeOwner ho = new HomeOwner(o);
				ho.setVisible(true);
				dispose();
			}else if(button == logout) {
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cerrar sesion?");
				if(option == 0) {
					Login l = new Login();
					l.setVisible(true);
					dispose();
				}
			}
		}
		
	}
	
	
}
