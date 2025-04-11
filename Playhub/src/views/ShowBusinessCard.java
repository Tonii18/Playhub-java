package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.DBManagerClient;
import controllers.DBManagerOwner;
import models.Business;
import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundLabel;
import roundedComponents.RoundPanel;

public class ShowBusinessCard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ShowBusinessCard(Business b, User u) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel image = new RoundLabel("", 10, 10);
		image.setBounds(132, 10, 100, 100);
		
		ImageIcon icon = new ImageIcon(getImage(b.getName()));
		Image resized = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(resized));

		add(image);
		((RoundLabel) image).setCustomBorderColor(new Color(59, 167, 176));
		
		RoundPanel panel = new RoundPanel(20, 20);
		panel.setBounds(10, 60, 344, 225);
		panel.setCustomBorderColor(new Color(59, 167, 176));
		add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel(b.getName());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setBounds(10, 60, 319, 20);
		panel.add(title);
		
		JLabel location = new JLabel(b.getLocation());
		location.setFont(new Font("Inter 24pt Light", Font.ITALIC, 13));
		location.setBounds(50, 90, 276, 20);
		panel.add(location);
		
		JLabel type = new JLabel(getSportName(b.getSportId())); // Here we get the sport name by filtering its id with the method below
		type.setFont(new Font("Inter 24pt Light", Font.ITALIC, 13));
		type.setBounds(50, 130, 276, 20);
		panel.add(type);
		
		JButton goInto = new RoundButton("VER", 10, 10);
		goInto.setBackground(new Color(59, 167, 176));
		goInto.setForeground(new Color(255, 255, 255));
		goInto.setFont(new Font("Inter 28pt Black", Font.PLAIN, 15));
		goInto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		goInto.setBorder(null);
		goInto.setBounds(10, 173, 324, 42);
		panel.add(goInto);
		
	}
	
	public static String getSportName(int id) {
		return DBManagerClient.getSportName(id);
	}
	
	public String getImage(String businessName) {
		int id = DBManagerOwner.getBusinessId(businessName);
		String path = DBManagerOwner.getImagePathByBusinessId(id);
		
		return path;
	}

}
