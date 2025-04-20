package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import controllers.DBManagerClient;
import controllers.DBManagerOwner;
import models.Booking;
import models.Business;
import roundedComponents.RoundPanel;

public class BookingView extends RoundPanel {

	/**
	 * Create the panel.
	 */
	public BookingView(Booking b) {
		super(20, 20);
		setCustomBorderColor(new Color(54, 184, 140));
		setLayout(null);
		
		int businessId = b.getBusinessId();
		
		Business buss = DBManagerOwner.getBusinessById(businessId);
		
		JLabel image = new JLabel("");
		image.setBounds(10, 10, 70, 70);
		ImageIcon icon = new ImageIcon(buss.getImagePath());
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(resizedIcon);
		add(image);
		
		JLabel name = new JLabel(buss.getName());
		name.setFont(new Font("Inter 18pt SemiBold", Font.PLAIN, 15));
		name.setBounds(90, 6, 330, 22);
		add(name);
		
		String sportName = DBManagerClient.getSportName(buss.getSportId());
		JLabel sport = new JLabel(sportName);
		sport.setFont(new Font("Inter 28pt Light", Font.ITALIC, 13));
		sport.setBounds(90, 34, 110, 22);
		add(sport);
		
		JLabel time = new JLabel(b.getTimeSlot());
		time.setFont(new Font("Inter 28pt Light", Font.ITALIC, 13));
		time.setBounds(90, 62, 330, 22);
		add(time);
		
		JLabel date = new JLabel(b.getDate().toString());
		date.setFont(new Font("Inter 28pt Light", Font.ITALIC, 13));
		date.setBounds(210, 34, 148, 22);
		add(date);
	}

}
