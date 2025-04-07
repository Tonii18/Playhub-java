package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.User;

public class SideMenu extends JFrame {

	private JPanel contentPane;
	
	private JButton logout;
	private JButton profile;
	private JButton close;
	
	private HomeUser h;
	private User u;

	/**
	 * Create the frame.
	 */
	public SideMenu(HomeUser h, User u) {
		this.h = h;
		this.u = u;
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 0, 400, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		logout = new JButton("Cerrar sesion");
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setBorder(null);
		logout.setBounds(66, 410, 267, 46);
		panel.add(logout);
		
		profile = new JButton("Ver Perfil");
		profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		profile.setContentAreaFilled(false);
		profile.setBorderPainted(false);
		profile.setBorder(null);
		profile.setForeground(new Color(255, 255, 255));
		profile.setFont(new Font("Inter 28pt Black", Font.PLAIN, 20));
		profile.setBounds(66, 332, 267, 46);
		panel.add(profile);
		
		close = new JButton("");
		close.setFocusPainted(false);
		close.setBorderPainted(false);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setContentAreaFilled(false);
		close.setBorder(null);
		close.setBounds(366, 11, 24, 24);
		close.setIcon(new ImageIcon(getClass().getResource("/close.png")));
		panel.add(close);
		
		JLabel pic = new JLabel("");
		pic.setBounds(150, 48, 100, 100);
		pic.setIcon(new ImageIcon(getClass().getResource("/pic.png")));
		panel.add(pic);
		
		JLabel buttonLbl1 = new JLabel("");
		buttonLbl1.setBounds(66, 410, 267, 46);
		buttonLbl1.setIcon(new ImageIcon(getClass().getResource("/buttonBack.png")));
		panel.add(buttonLbl1);
		
		JLabel buttonLbl2 = new JLabel("");
		buttonLbl2.setBounds(66, 332, 267, 46);
		buttonLbl2.setIcon(new ImageIcon(getClass().getResource("/buttonBack.png")));
		panel.add(buttonLbl2);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 400, 500);
		background.setIcon(new ImageIcon(getClass().getResource("/back.png")));
		contentPane.add(background);
		
		close.addActionListener(new buttons());
		logout.addActionListener(new buttons());
		profile.addActionListener(new buttons());
	}
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == close) {
				dispose();
			}else if(button == logout) {
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cerrar sesion?");
				if(option == 0) {
					Login l = new Login();
					l.setVisible(true);
					dispose();
					h.dispose();
				}
			}else if(button == profile) {
				ProfilePage p = new ProfilePage(u);
				p.setVisible(true);
				dispose();
				h.dispose();
			}
		}
		
	}
}
