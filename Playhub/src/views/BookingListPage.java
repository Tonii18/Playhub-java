package views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManagerClient;
import models.Booking;
import models.User;

public class BookingListPage extends JFrame {

	private JPanel contentPane;
	
	private User u;

	/**
	 * Create the frame.
	 */
	public BookingListPage(User u) {
		this.u = u;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int userId = DBManagerClient.getUserId(u.getName());
		List<Booking> list = DBManagerClient.getBookingsByUserId(userId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 414, 639);
		contentPane.add(scrollPane);
		
		JPanel listPanel = new JPanel();
		listPanel.setBackground(new Color(255, 255, 255));
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		//listPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(listPanel);
		
		for (Booking booking : list) {
		    BookingView view = new BookingView(booking);
		    
		    // Fijamos tamaño uniforme
		    view.setMaximumSize(new Dimension(380, 90));
		    view.setPreferredSize(new Dimension(380, 90));
		    view.setMinimumSize(new Dimension(380, 90));
		    
		    // Añadimos margen inferior entre elementos
		    view.setBorder(new EmptyBorder(5, 5, 10, 5)); // espacio inferior de 10px
		    
		    listPanel.add(Box.createVerticalStrut(10));
		    
		    listPanel.add(view);
		}
	}
}
