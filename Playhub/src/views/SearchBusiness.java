package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.User;
import roundedComponents.RoundButtonImage;
import roundedComponents.RoundPanel;

public class SearchBusiness extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private User u;

	/**
	 * Create the frame.
	 */
	public SearchBusiness(User u) {
		this.u = u;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

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
		
		JLabel subtitle = new JLabel("¿Cuál es tu deporte favorito?");
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setForeground(new Color(120, 120, 120));
		subtitle.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		subtitle.setBounds(458, 54, 597, 70);
		body.add(subtitle);
		
		JPanel searchBar = new RoundPanel(10, 10);
		searchBar.setBackground(new Color(255, 255, 255));
		searchBar.setBounds(307, 186, 900, 56);
		((RoundPanel) searchBar).setCustomBorderColor(new Color(59, 167, 176));
		body.add(searchBar);
		searchBar.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(120, 120, 120));
		textField.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 25));
		textField.setBorder(null);
		textField.setBounds(10, 11, 763, 34);
		searchBar.add(textField);
		textField.setColumns(10);
		
		JButton search = new RoundButtonImage("", 10, 10);
		search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		search.setBorder(null);
		search.setBackground(new Color(54, 184, 140));
		search.setBounds(783, 11, 107, 34);
		search.setIcon(new ImageIcon(getClass().getResource("/search.png")));
		searchBar.add(search);
		
		JLabel image = new JLabel("");
		image.setBounds(567, 300, 380, 300);
		image.setIcon(new ImageIcon(getClass().getResource("/looking-for-sport.png")));
		body.add(image);
		
		JButton back = new JButton("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setBounds(10, 620, 50, 50);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow_back (2).png")));
		body.add(back);
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeUser hu = new HomeUser(u);
				hu.setVisible(true);
				dispose();
			}
			
		});
		
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowBusiness sb = new ShowBusiness(u, textField.getText());
				sb.setVisible(true);
				dispose();
			}
			
		});
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					search.doClick();
				}
			}
			
		});
	}
}
