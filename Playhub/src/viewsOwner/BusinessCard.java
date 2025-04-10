package viewsOwner;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controllers.DBManagerOwner;
import models.Business;
import roundedComponents.RoundPanel;

public class BusinessCard extends RoundPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BusinessCard(Business b) {
		super(20, 20);
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setCustomBorderColor(new Color(53, 201, 165));
		
		JLabel title = new JLabel(b.getName());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		title.setBounds(10, 32, 336, 25);
		add(title);
		
		JLabel image = new JLabel("");
		image.setBounds(10, 77, 336, 212);
		ImageIcon icon = new ImageIcon(getImage(b.getName()));
		Image resized = icon.getImage().getScaledInstance(336, 212, Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(resized));
		add(image);
		
		JLabel location = new JLabel(b.getLocation());
		location.setFont(new Font("Inter 28pt Light", Font.ITALIC, 15));
		location.setHorizontalAlignment(SwingConstants.LEFT);
		location.setBounds(10, 317, 336, 33);
		add(location);
		
	}
	
	public String getImage(String businessName) {
		int id = DBManagerOwner.getBusinessId(businessName);
		String path = DBManagerOwner.getImagePathByBusinessId(id);
		
		return path;
	}
}
