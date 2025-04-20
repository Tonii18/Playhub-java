package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import models.Business;
import models.User;
import roundedComponents.RoundPanel;

public class BookingView extends RoundPanel {

	/**
	 * Create the panel.
	 */
	public BookingView(Business b) {
		super(20, 20);
		setCustomBorderColor(new Color(54, 184, 140));
		setLayout(null);
		
		JLabel image = new JLabel("");
		image.setBorder(new LineBorder(new Color(0, 0, 0)));
		image.setBounds(10, 10, 70, 70);
		add(image);
		
		JLabel name = new JLabel("New label");
		name.setFont(new Font("Inter 18pt SemiBold", Font.PLAIN, 15));
		name.setBounds(90, 6, 330, 22);
		add(name);
		
		JLabel sport = new JLabel("New label");
		sport.setFont(new Font("Inter 28pt Light", Font.ITALIC, 13));
		sport.setBounds(90, 34, 148, 22);
		add(sport);
		
		JLabel time = new JLabel("New label");
		time.setFont(new Font("Inter 28pt Light", Font.ITALIC, 13));
		time.setBounds(90, 62, 330, 22);
		add(time);
		
		JLabel date = new JLabel("New label");
		date.setFont(new Font("Inter 28pt Light", Font.ITALIC, 13));
		date.setBounds(248, 34, 148, 22);
		add(date);
	}

}
