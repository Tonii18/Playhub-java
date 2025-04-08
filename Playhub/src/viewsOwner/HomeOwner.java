package viewsOwner;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.Owner;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;

public class HomeOwner extends JFrame {

	private JPanel contentPane;
	
	private Owner o;
	
	private JButton profile;
	private JButton bussiness;

	/**
	 * Create the frame.
	 */
	public HomeOwner(Owner o) {
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
		navbar.setBounds(-8, 0, 1530, 90);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(730, 10, 70, 70);
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		Image resized = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(resized));
		navbar.add(logo);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setForeground(new Color(255, 255, 255));
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		title1.setBounds(588, 23, 110, 44);
		navbar.add(title1);
		
		JLabel title2 = new JLabel("HUB");
		title2.setForeground(new Color(255, 255, 255));
		title2.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 40));
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setBounds(810, 23, 110, 44);
		navbar.add(title2);
		
		JLabel back = new JLabel("");
		back.setBounds(0, 0, 1530, 90);
		back.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		navbar.add(back);
		
		JPanel body = new JPanel();
		body.setBounds(-8, 90, 1530, 681);
		contentPane.add(body);
		body.setLayout(null);
		
		JPanel profilePanel = new RoundPanel(20, 20);
		profilePanel.setBackground(new Color(255, 255, 255));
		profilePanel.setBounds(300, 371, 434, 269);
		body.add(profilePanel);
		profilePanel.setLayout(null);
		
		JLabel profileLbl = new JLabel("<html>Ver<br>Perfil</html>");
		profileLbl.setHorizontalAlignment(SwingConstants.LEFT);
		profileLbl.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		profileLbl.setBounds(20, 20, 100, 50);
		profilePanel.add(profileLbl);
		
		profile = new RoundButton("Ver Perfil", 10, 10);
		profile.setForeground(new Color(255, 255, 255));
		profile.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profile.setBackground(new Color(59, 167, 176));
		profile.setBorder(null);
		profile.setBounds(55, 227, 324, 31);
		profilePanel.add(profile);
		
		profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				profile.setBackground(new Color(54, 184, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				profile.setBackground(new Color(59, 167, 176));
			}
			
		});
		
		JLabel image = new JLabel("");
		image.setBounds(108, 81, 217, 122);
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/incomes.png"));
		Image resized3 = icon3.getImage().getScaledInstance(217, 122, Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(resized3));
		profilePanel.add(image);
		
		JPanel bussinessPanel = new RoundPanel(20, 20);
		bussinessPanel.setBackground(Color.WHITE);
		bussinessPanel.setBounds(796, 371, 434, 269);
		body.add(bussinessPanel);
		bussinessPanel.setLayout(null);
		
		JLabel bussinessLbl = new JLabel("<html>Ver mis<br>Negocios</html>");
		bussinessLbl.setHorizontalAlignment(SwingConstants.LEFT);
		bussinessLbl.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		bussinessLbl.setBounds(20, 20, 100, 50);
		bussinessPanel.add(bussinessLbl);
		
		bussiness = new RoundButton("Ver Perfil", 10, 10);
		bussiness.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bussiness.setText("Ir a Negocios");
		bussiness.setForeground(Color.WHITE);
		bussiness.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		bussiness.setBorder(null);
		bussiness.setBackground(new Color(59, 167, 176));
		bussiness.setBounds(55, 227, 324, 31);
		bussinessPanel.add(bussiness);
		
		bussiness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bussiness.setBackground(new Color(54, 184, 140));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bussiness.setBackground(new Color(59, 167, 176));
			}
			
		});
		
		JLabel image2 = new JLabel("");
		image2.setBounds(108, 81, 217, 122);
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/bussiness-list.png"));
		Image resized4 = icon4.getImage().getScaledInstance(217, 122, Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(resized4));
		bussinessPanel.add(image2);
		
		JLabel vector = new JLabel("");
		vector.setBounds(523, 37, 484, 323);
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/owner-dashboard.png"));
		Image resized2 = icon2.getImage().getScaledInstance(484, 323, Image.SCALE_SMOOTH);
		vector.setIcon(new ImageIcon(resized2));
		body.add(vector);
		
		// Events
		
		profile.addActionListener(new buttons());
		bussiness.addActionListener(new buttons());
	}
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == profile) {
				OwnerProfilePage opp = new OwnerProfilePage(o);
				opp.setVisible(true);
				dispose();
			}
		}
		
	}
}
