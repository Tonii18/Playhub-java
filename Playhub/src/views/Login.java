package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controllers.DBManagerClient;
import models.User;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;
import viewsOwner.OwnerLogin;

public class Login extends JFrame {

	private JPanel contentPane;
	
	private RoundButton business;
	private RoundButton login;
	private RoundButton signup;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title3 = new JLabel("HUB");
		title3.setHorizontalAlignment(SwingConstants.CENTER);
		title3.setForeground(Color.WHITE);
		title3.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 70));
		title3.setBounds(789, 665, 147, 83);
		contentPane.add(title3);
		
		JLabel title2 = new JLabel("PLAY");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Inter 28pt Black", Font.BOLD, 70));
		title2.setBounds(579, 665, 211, 83);
		contentPane.add(title2);
		
		JLabel title1 = new JLabel("WELCOME TO");
		title1.setForeground(new Color(255, 255, 255));
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setFont(new Font("Inter 28pt Thin", Font.PLAIN, 35));
		title1.setBounds(632, 616, 249, 38);
		contentPane.add(title1);
		
		RoundPanel loginpanel = new RoundPanel(20, 20);
		loginpanel.setBackground(new Color(255, 255, 255));
		loginpanel.setBounds(564, 227, 385, 351);
		contentPane.add(loginpanel);
		loginpanel.setLayout(null);
		
		/*
		 * Code for panel section
		 */
		
		business = new RoundButton("¿Eres un negocio?", 10, 10);
		business.setBackground(new Color(255, 255, 255));
		business.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		business.setBorder(null);
		business.setHorizontalTextPosition(SwingConstants.CENTER);
		business.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		business.setBounds(10, 300, 365, 40);
		loginpanel.add(business);
		
		business.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				business.setBackground(new Color(235, 235, 235));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				business.setBackground(new Color(255, 255, 255));
			}
			
		});
		
		login = new RoundButton("Inicia sesion", 10, 10);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setText("Iniciar sesion");
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(0, 0, 0));
		login.setHorizontalTextPosition(SwingConstants.CENTER);
		login.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		login.setBorder(null);
		login.setBounds(10, 198, 365, 40);
		loginpanel.add(login);
		
		signup = new RoundButton("Crear cuenta", 10, 10);
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.setText("Crear cuenta");
		signup.setHorizontalTextPosition(SwingConstants.CENTER);
		signup.setForeground(new Color(0, 0, 0));
		signup.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		signup.setBorder(null);
		signup.setBackground(new Color(255, 255, 255));
		signup.setCustomBorderColor(Color.BLACK);
		signup.setBounds(10, 249, 365, 40);
		loginpanel.add(signup);
		
		username = new RoundTextField(10, 10, 10);
		username.setForeground(Color.GRAY);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		username.setBackground(new Color(237, 244, 242));
		username.setBorder(null);
		username.setText("Usuario");
		username.setBounds(10, 96, 365, 40);
		loginpanel.add(username);
		username.setColumns(10);
		
		username.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (username.getText().equals("Usuario")) {
		            username.setText("");
		            username.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (username.getText().isEmpty()) {
		            username.setText("Usuario");
		            username.setForeground(Color.GRAY);
		        }
		    }
		});
		
		passwordField = new JPasswordField();
		passwordField.setText("Contraseña");
		passwordField.setForeground(Color.GRAY);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		passwordField.setBackground(new Color(237, 244, 242));
		passwordField.setBorder(null);
		passwordField.setBounds(10, 147, 365, 40);
		passwordField.setEchoChar((char) 0); // mostrar el texto en claro
		
		passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (String.valueOf(passwordField.getPassword()).equals("Contraseña")) {
		            passwordField.setText("");
		            passwordField.setForeground(Color.BLACK);
		            passwordField.setEchoChar('•'); // volver a ocultar caracteres
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (String.valueOf(passwordField.getPassword()).isEmpty()) {
		            passwordField.setText("Contraseña");
		            passwordField.setForeground(Color.GRAY);
		            passwordField.setEchoChar((char) 0); // mostrar texto claro de nuevo
		        }
		    }
		});
		
		loginpanel.add(passwordField);
		
		JLabel subtitle = new JLabel("Inicia sesion en tu cuenta");
		subtitle.setFont(new Font("Inter 18pt ExtraBold", Font.PLAIN, 25));
		subtitle.setHorizontalTextPosition(SwingConstants.CENTER);
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setBounds(10, 22, 365, 25);
		loginpanel.add(subtitle);
		
		JLabel logo = new JLabel("");
		logo.setBounds(687, 39, 140, 140);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		contentPane.add(logo);
		
		JLabel lblbck = new JLabel("");
		lblbck.setBounds(0, 0, 1530, 810);
		lblbck.setIcon(new ImageIcon(getClass().getResource("/back.png")));
		contentPane.add(lblbck);
		
		SwingUtilities.invokeLater(() -> {
		    loginpanel.requestFocusInWindow();
		});
		
		// Events for the buttons
		
		signup.addActionListener(new buttons());
		login.addActionListener(new buttons());
		business.addActionListener(new buttons());
	}
	
	/*
	 * Private class for handling the buttons events
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == signup) {
				Signup s = new Signup();
				s.setVisible(true);
				dispose();
			}else if(button == login) {
				login();
			}else if(button == business) {
				OwnerLogin ol = new OwnerLogin();
				ol.setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void login() {
		String name = username.getText();
		String pass = new String(passwordField.getPassword());
		
		User u = new User(name, pass);
		
		if(DBManagerClient.loginUser(u)) {
			String email = DBManagerClient.getEmail(name);
			String phone = DBManagerClient.getPhoneNumber(name);
			
			JOptionPane.showMessageDialog(null, "¡Has iniciado sesion correctamente!");
			
			User fullUser = new User(email, name, pass, phone);
			
			HomeUser h = new HomeUser(fullUser);
			h.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
			blankFields();
		}
	}
	
	public void blankFields() {
		username.setText("Usuario");
		username.setForeground(Color.gray);
		passwordField.setText("Contraseña");
		passwordField.setForeground(Color.gray);
		passwordField.setEchoChar((char) 0);
	}
	
}
