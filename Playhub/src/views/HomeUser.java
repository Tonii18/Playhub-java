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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundPanel;

public class HomeUser extends JFrame {

	private JPanel contentPane;
	
	private JButton footballButton;
	private JButton basketButton;
	private JButton padelButton;
	private JButton othersButton;
	private JButton menu;
	
	private User u;

	/**
	 * Create the frame.
	 */
	public HomeUser(User u) {
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
		navbar.setBackground(new Color(128, 255, 255));
		navbar.setBounds(-8, 0, 1530, 90);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(730, 10, 70, 70);
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		Image resized = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		
		menu = new JButton("");
		menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu.setContentAreaFilled(false);
		menu.setBorder(null);
		menu.setBounds(1455, 21, 48, 48);
		menu.setIcon(new ImageIcon(getClass().getResource("/Menu.png")));
		navbar.add(menu);
		logo.setIcon(new ImageIcon(resized));
		navbar.add(logo);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setForeground(new Color(255, 255, 255));
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		title1.setBounds(588, 23, 110, 44);
		navbar.add(title1);
		
		JLabel title2 = new JLabel("HUB");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 40));
		title2.setBounds(810, 23, 110, 44);
		navbar.add(title2);
		
		JLabel navbarColor = new JLabel("");
		navbarColor.setBounds(0, 0, 1530, 90);
		navbarColor.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		navbar.add(navbarColor);
		
		JPanel body = new JPanel();
		body.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		body.setBounds(0, 90, 1514, 681);
		contentPane.add(body);
		body.setLayout(null);
		
		JPanel footballPanel = new RoundPanel(20, 20);
		footballPanel.setBorder(null);
		footballPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		footballPanel.setBackground(new Color(255, 255, 255));
		footballPanel.setBounds(79, 104, 279, 398);
		((RoundPanel) footballPanel).setCustomBorderColor(new Color(59, 167, 176));
		((RoundPanel) footballPanel).setCustomBorderThickness(2.5F);
		body.add(footballPanel);
		footballPanel.setLayout(null);
		
		JLabel footImage = new JLabel("");
		footImage.setBounds(25, 23, 228, 157);
		ImageIcon original = new ImageIcon(getClass().getResource("/football.png"));
		Image resizedPng = original.getImage().getScaledInstance(228, 157, Image.SCALE_SMOOTH);
		
		footballButton = new JButton("");
		footballButton.setContentAreaFilled(false);
		footballButton.setBorder(null);
		footballButton.setBounds(10, 11, 259, 376);
		footballPanel.add(footballButton);
		footImage.setIcon(new ImageIcon(resizedPng));
		footballPanel.add(footImage);
		
		JLabel sectionName = new JLabel("Fútbol");
		sectionName.setForeground(new Color(59, 167, 176));
		sectionName.setHorizontalAlignment(SwingConstants.CENTER);
		sectionName.setFont(new Font("Inter 24pt Light", Font.PLAIN, 28));
		sectionName.setBounds(10, 344, 259, 31);
		footballPanel.add(sectionName);
		
		RoundPanel basketPanel = new RoundPanel(20, 20);
		basketPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		basketPanel.setBackground(Color.WHITE);
		basketPanel.setBounds(437, 104, 279, 398);
		((RoundPanel) basketPanel).setCustomBorderColor(new Color(59, 167, 176));
		((RoundPanel) basketPanel).setCustomBorderThickness(2.5F);
		body.add(basketPanel);
		basketPanel.setLayout(null);
		
		JLabel basketImage = new JLabel("");
		basketImage.setBounds(81, 23, 117, 227);
		ImageIcon original2 = new ImageIcon(getClass().getResource("/basketball.png"));
		Image resizedPng2 = original2.getImage().getScaledInstance(117, 227, Image.SCALE_SMOOTH);
		
		basketButton = new JButton("");
		basketButton.setContentAreaFilled(false);
		basketButton.setBorder(null);
		basketButton.setBounds(10, 11, 259, 376);
		basketPanel.add(basketButton);
		basketImage.setIcon(new ImageIcon(resizedPng2));
		basketPanel.add(basketImage);
		
		JLabel sectionName2 = new JLabel("Baloncesto");
		sectionName2.setHorizontalAlignment(SwingConstants.CENTER);
		sectionName2.setForeground(new Color(59, 167, 176));
		sectionName2.setFont(new Font("Inter 24pt Light", Font.PLAIN, 28));
		sectionName2.setBounds(10, 344, 259, 31);
		basketPanel.add(sectionName2);
		
		RoundPanel padelPanel = new RoundPanel(20, 20);
		padelPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		padelPanel.setBackground(Color.WHITE);
		padelPanel.setBounds(795, 104, 279, 398);
		((RoundPanel) padelPanel).setCustomBorderColor(new Color(59, 167, 176));
		((RoundPanel) padelPanel).setCustomBorderThickness(2.5F);
		body.add(padelPanel);
		padelPanel.setLayout(null);
		
		JLabel padelImage = new JLabel("");
		padelImage.setBounds(25, 23, 228, 157);
		ImageIcon original3 = new ImageIcon(getClass().getResource("/padel.png"));
		Image resizedPng3 = original3.getImage().getScaledInstance(228, 157, Image.SCALE_SMOOTH);
		
		padelButton = new JButton("");
		padelButton.setContentAreaFilled(false);
		padelButton.setBorder(null);
		padelButton.setBounds(10, 11, 259, 376);
		padelPanel.add(padelButton);
		padelImage.setIcon(new ImageIcon(resizedPng3));
		padelPanel.add(padelImage);
		
		JLabel sectionName3 = new JLabel("Pádel");
		sectionName3.setHorizontalAlignment(SwingConstants.CENTER);
		sectionName3.setForeground(new Color(59, 167, 176));
		sectionName3.setFont(new Font("Inter 24pt Light", Font.PLAIN, 28));
		sectionName3.setBounds(10, 344, 259, 31);
		padelPanel.add(sectionName3);
		
		RoundPanel othersPanel = new RoundPanel(20, 20);
		othersPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		othersPanel.setBackground(Color.WHITE);
		othersPanel.setBounds(1153, 104, 279, 398);
		((RoundPanel) othersPanel).setCustomBorderColor(new Color(59, 167, 176));
		((RoundPanel) othersPanel).setCustomBorderThickness(2.5F);
		body.add(othersPanel);
		othersPanel.setLayout(null);
		
		JLabel othersImage = new JLabel("");
		othersImage.setBounds(48, 23, 183, 184);
		ImageIcon original4 = new ImageIcon(getClass().getResource("/others.png"));
		Image resizedPng4 = original4.getImage().getScaledInstance(183, 184, Image.SCALE_SMOOTH);
		
		othersButton = new JButton("");
		othersButton.setContentAreaFilled(false);
		othersButton.setBorder(null);
		othersButton.setBounds(10, 11, 259, 376);
		othersPanel.add(othersButton);
		othersImage.setIcon(new ImageIcon(resizedPng4));
		othersPanel.add(othersImage);
		
		JLabel sectionName4 = new JLabel("Otros");
		sectionName4.setHorizontalAlignment(SwingConstants.CENTER);
		sectionName4.setForeground(new Color(59, 167, 176));
		sectionName4.setFont(new Font("Inter 24pt Light", Font.PLAIN, 28));
		sectionName4.setBounds(10, 344, 259, 31);
		othersPanel.add(sectionName4);
		
		JLabel lblNewLabel = new JLabel("¿QUE TE APETECE JUGAR HOY?");
		lblNewLabel.setForeground(new Color(53, 201, 165));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Inter 28pt Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(514, 600, 486, 38);
		body.add(lblNewLabel);
		
		// Events
		
		footballButton.addActionListener(new buttons());
		basketButton.addActionListener(new buttons());
		padelButton.addActionListener(new buttons());
		othersButton.addActionListener(new buttons());
		menu.addActionListener(new buttons());
	}
	
	/*
	 * Private class for events
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == menu) {
				SideMenu s = new SideMenu(HomeUser.this, u);
				s.setVisible(true);
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	




}
