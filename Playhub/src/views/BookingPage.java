package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.DBManagerClient;
import controllers.DBManagerOwner;
import models.Booking;
import models.Business;
import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;

public class BookingPage extends JFrame {

	private JPanel contentPane;
	
	private User u;
	private Business b;
	
	private JComboBox<String> court;
	private JComboBox<String> date;
	private JComboBox<String> time;

	/**
	 * Create the frame.
	 */
	public BookingPage(User u, Business b) {
		this.u = u;
		this.b = b;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel(b.getName());
		name.setForeground(new Color(120, 120, 120));
		name.setFont(new Font("Inter 28pt Black", Font.PLAIN, 30));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(38, 38, 718, 40);
		contentPane.add(name);
		
		/*
		 * Combobox for selecting the court to play in
		 */
		
		int numberCourts = b.getAvaliablesPitchs();

		List<String> courtsList = new ArrayList<>();
		
		for(int i = 1; i <= numberCourts; i++) {
			courtsList.add("Pista "+i);
		}
		
		court = new JComboBox<String>();
		court.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		court.setBounds(53, 115, 194, 34);
		court.addItem("Selecciona pista");
		
		for(String s: courtsList) {
			court.addItem(s);
		}
		contentPane.add(court);
		
		/*
		 * Combobox for selecting the time to book
		 */
		
		List<String> timesTable = new ArrayList<>();
		
		for (int i = 9; i < 22; i++) {
		    String start = String.format("%02d:00", i);
		    String end = String.format("%02d:00", i + 1);
		    timesTable.add(start + " - " + end);
		}
		
		time = new JComboBox<String>();
		time.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		time.setBounds(300, 115, 194, 34);
		time.addItem("Selecciona horas");
		
		for (String timeSlot : timesTable) {
		    time.addItem(timeSlot);
		}
		
		contentPane.add(time);
		
		/*
		 * Combobox for selecting the date to book
		 */
		
		date = new JComboBox<String>();
		date.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		date.setBounds(547, 115, 194, 34);
		date.addItem("Selecciona la fecha");
		
		// Set the correct format 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Today´s date
		LocalDate today = LocalDate.now();

		// Add 7 days from today
		for (int i = 1; i <= 7; i++) {
		    LocalDate dateToAdd = today.plusDays(i);
		    date.addItem(dateToAdd.format(formatter));
		}
		
		contentPane.add(date);
		
		/*
		 * Rest of the Frame
		 */
		
		JLabel image = new JLabel("");
		image.setBounds(221, 190, 352, 141);
		ImageIcon icon = new ImageIcon(getImage(b.getName()));
		Image resized = icon.getImage().getScaledInstance(352, 141, Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(resized));
		contentPane.add(image);
		
		JButton book = new RoundButton("Reservar", 10, 10);
		book.setForeground(new Color(255, 255, 255));
		book.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 20));
		book.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		book.setBorder(null);
		book.setBackground(new Color(54, 184, 140));
		book.setBounds(10, 410, 774, 40);
		contentPane.add(book);
		
		JPanel price = new RoundPanel(5, 5);
		price.setBackground(new Color(255, 255, 255));
		price.setBounds(232, 353, 330, 34);
		contentPane.add(price);
		price.setLayout(null);
		
		JLabel payment = new JLabel("Importe total:");
		payment.setForeground(new Color(72, 72, 72));
		payment.setFont(new Font("Inter 24pt Light", Font.PLAIN, 16));
		payment.setHorizontalAlignment(SwingConstants.CENTER);
		payment.setBounds(0, 5, 102, 23);
		price.add(payment);
		
		String amount = String.format("%.2f €", b.getPricePerHour());
		JLabel totalPrice = new JLabel(amount);
		totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		totalPrice.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 16));
		totalPrice.setBounds(241, 5, 89, 23);
		price.add(totalPrice);
		
		book.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				booking(b.getPricePerHour(), b.getOwnerId());
			}
		});
	}
	
	/*
	 * External Methods
	 */
	
	public String getImage(String businessName) {
		int id = DBManagerOwner.getBusinessId(businessName);
		String path = DBManagerOwner.getImagePathByBusinessId(id);
		
		return path;
	}
	
	public void booking(double income, int id) {
		String courtSelected = "";
		
		if (time.getSelectedIndex() == 0 || date.getSelectedIndex() == 0) {
		    JOptionPane.showMessageDialog(null, "Por favor, selecciona pista, hora y fecha.");
		    return;
		}
		
		if(court.getSelectedIndex() == 0) {
			courtSelected = "Pista no disponible";
		}else {
			courtSelected = (String) court.getSelectedItem();
		}

		double clientBalance = DBManagerClient.getBalance(u.getName());
		
		if(clientBalance < income) {
			JOptionPane.showMessageDialog(null, "No se puede finalizar la reserva, saldo insuficiente");
			dispose();
		}else {
			int userId = DBManagerClient.getUserId(u.getName());
			int businessId = DBManagerOwner.getBusinessId(b.getName());
			String dateSelected = (String) date.getSelectedItem();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate bookingDate = LocalDate.parse(dateSelected, formatter);
			
			String timeSelected = (String) time.getSelectedItem();
			double totalPrice = income;
			
			Booking booking = new Booking(userId, businessId, courtSelected, bookingDate, timeSelected, totalPrice);
			
			DBManagerClient.insertBooking(booking);
			
			DBManagerOwner.updateIncome(income, id);
			DBManagerClient.reduceBalance(income, u.getName());
			JOptionPane.showMessageDialog(null, "¡Has realizado la reserva correctamente!");
			dispose();
		}
	}
	
}
