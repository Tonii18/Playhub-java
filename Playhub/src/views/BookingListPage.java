package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Business;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
