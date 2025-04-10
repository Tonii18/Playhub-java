package viewsOwner;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManagerOwner;
import models.Business;
import models.Owner;
import roundedComponents.RoundButtonImage;
import roundedComponents.RoundPanel;

public class BusinessView extends JFrame {

	private JPanel contentPane;
	private JButton add;
	private JButton back;
	
	private Owner o;
	
	private JPanel cardsContainer;

	/**
	 * Create the frame.
	 */
	public BusinessView(Owner o) {
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
		
		JLabel title2 = new JLabel("HUB");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 40));
		title2.setBounds(810, 23, 110, 44);
		navbar.add(title2);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setForeground(new Color(255, 255, 255));
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		title1.setBounds(588, 23, 110, 44);
		navbar.add(title1);
		
		JLabel logo = new JLabel("");
		logo.setBounds(730, 10, 70, 70);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo-resized.png")));
		navbar.add(logo);
		
		JLabel navbarBck = new JLabel("");
		navbarBck.setBounds(0, 0, 1530, 90);
		navbarBck.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		navbar.add(navbarBck);
		
		JPanel body = new JPanel();
		body.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 20));
		body.setBounds(-8, 90, 1530, 690);
		contentPane.add(body);
		body.setLayout(null);
		
		JPanel addingPanel = new RoundPanel(20, 20);
		addingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addingPanel.setBackground(new Color(255, 255, 255));
		addingPanel.setBounds(97, 97, 356, 496);
		body.add(addingPanel);
		addingPanel.setLayout(null);
		
		add = new RoundButtonImage("Añadir nuevo negocio", 15, 15);
		add.setIconTextGap(10);
		add.setForeground(new Color(53, 201, 195));
		add.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 20));
		add.setBackground(new Color(255, 255, 255));
		add.setBorder(null);
		add.setHorizontalTextPosition(SwingConstants.CENTER);
		add.setIcon(new ImageIcon(getClass().getResource("/add_circle.png")));
		((RoundButtonImage) add).setCustomBorderColor(new Color(53, 201, 165));
		add.setBounds(10, 10, 336, 476);
		addingPanel.add(add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(486, 97, 976, 496);
		body.add(scrollPane);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		cardsContainer = new JPanel();
		cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.X_AXIS));
		scrollPane.setViewportView(cardsContainer);

		
		back = new JButton("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow_back (2).png")));
		back.setBounds(37, 616, 50, 50);
		body.add(back);
		
		// Method to get the business list
		
		loadBusinessCards();

		
		// Events
		
		add.addActionListener(new buttons());
		back.addActionListener(new buttons());
	}
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == add) {
				AddBusiness ad = new AddBusiness(o);
				ad.setVisible(true);
				dispose();
			}else if(button == back) {
				HomeOwner opp = new HomeOwner(o);
				opp.setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	private void loadBusinessCards() {
		int ownerId = DBManagerOwner.getId(o.getName());
	    List<Business> businesses = DBManagerOwner.getBusinessesByOwner(ownerId);

	    for (int i = 0; i < businesses.size(); i++) {
	        Business b = businesses.get(i);
	        BusinessCard card = new BusinessCard(b);

	        card.setPreferredSize(new Dimension(356, 380));
	        card.setMinimumSize(new Dimension(356, 380));
	        card.setMaximumSize(new Dimension(356, 380));

	        cardsContainer.add(card);

	        if (i < businesses.size() - 1) {
	            cardsContainer.add(Box.createRigidArea(new Dimension(20, 0)));
	        }
	    }

	    cardsContainer.revalidate();
	    cardsContainer.repaint();
	}

}
