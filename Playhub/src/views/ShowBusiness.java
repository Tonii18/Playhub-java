package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.DBManagerClient;
import models.Business;
import models.User;

public class ShowBusiness extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private String sport;
	private User u;
	
	private JPanel cardsContainer;

	/**
	 * Create the frame.
	 */
	public ShowBusiness(User u, String sport) {
		this.u = u;
		this.sport = sport;
		
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
		
		JLabel title2 = new JLabel("HUB");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 40));
		title2.setBounds(810, 23, 110, 44);
		navbar.add(title2);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setForeground(new Color(255, 255, 255));
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setBounds(588, 23, 110, 44);
		navbar.add(title1);
		
		JLabel logo = new JLabel("");
		logo.setBounds(730, 10, 70, 70);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo-resized.png")));
		navbar.add(logo);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1530, 90);
		background.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		navbar.add(background);
		
		JPanel body = new JPanel();
		body.setBackground(new Color(255, 255, 255));
		body.setBounds(-7, 87, 1530, 697);
		contentPane.add(body);
		body.setLayout(null);
		
		JLabel Sport = new JLabel(sport.toUpperCase());
		Sport.setForeground(new Color(59, 167, 176));
		Sport.setHorizontalAlignment(SwingConstants.CENTER);
		Sport.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		Sport.setBounds(552, 20, 425, 59);
		body.add(Sport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new LineBorder(new Color(59, 167, 176)));
		scrollPane.setBounds(94, 89, 1341, 574);
		body.add(scrollPane);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		cardsContainer = new JPanel();
		cardsContainer.setBackground(new Color(255, 255, 255));
		cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(cardsContainer);
		
		JButton back = new JButton("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow_back (2).png")));
		back.setBounds(25, 613, 50, 50);
		body.add(back);
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeUser hu = new HomeUser(u);
				hu.setVisible(true);
				dispose();
			}
			
		});
		
		loadBusinessCards();

	}
	
	/*
	 * External methods
	 */
	
	private void loadBusinessCards() {
	    String newSport = sport.toLowerCase();
	    int sportId = DBManagerClient.getSportId(newSport);
	    List<Business> businesses = DBManagerClient.getBusinessesBySport(sportId);

	    // Cambiar la organización del cardsContainer a GridLayout (3 columnas)
	    cardsContainer.setLayout(new GridLayout(0, 3, 20, 20));  // 3 columnas, 20px de separación entre componentes

	    for (int i = 0; i < businesses.size(); i++) {
	        Business b = businesses.get(i);
	        ShowBusinessCard card = new ShowBusinessCard(b, u);

	        card.setPreferredSize(new Dimension(356, 380));  // Ajusta el tamaño de la tarjeta de negocio
	        card.setMinimumSize(new Dimension(356, 380));
	        card.setMaximumSize(new Dimension(356, 380));

	        cardsContainer.add(card);
	    }

	    cardsContainer.revalidate();
	    cardsContainer.repaint();
	}

	

}
