package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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
import roundedComponents.RoundTextField;

public class Signup extends JFrame {

	private JPanel contentPane;
	
	private JButton signup;
	private JTextField emailtf;
	private RoundTextField usertf;
	private JPasswordField passtf;
	private RoundTextField phonetf;
	private JButton home;

	/**
	 * Create the frame.
	 */
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Here we see how we can resize an image to make it smaller
		
		JLabel logo = new JLabel("");
		logo.setBounds(707, 85, 100, 100);
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		Image resized = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(resized));
		contentPane.add(logo);
		
		/*
		 * We create the differents textfields including their placeholders
		 */
		
		emailtf = new RoundTextField(10, 10, 10);
		emailtf.setHorizontalAlignment(SwingConstants.CENTER);
		emailtf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		emailtf.setColumns(10);
		emailtf.setBackground(new Color(237, 244, 242));
		emailtf.setBorder(null);
		emailtf.setBounds(563, 286, 388, 40);
		emailtf.setText("Correo");
		emailtf.setForeground(Color.GRAY);
		contentPane.add(emailtf);
		
		emailtf.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (emailtf.getText().equals("Correo")) {
		        	emailtf.setText("");
		        	emailtf.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (emailtf.getText().isEmpty()) {
		        	emailtf.setText("Correo");
		        	emailtf.setForeground(Color.GRAY);
		        }
		    }
		});
		
		usertf = new RoundTextField(10, 10, 10);
		usertf.setText("Usuario");
		usertf.setHorizontalAlignment(SwingConstants.CENTER);
		usertf.setForeground(Color.GRAY);
		usertf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		usertf.setColumns(10);
		usertf.setBorder(null);
		usertf.setBackground(new Color(237, 244, 242));
		usertf.setBounds(563, 360, 388, 40);
		contentPane.add(usertf);
		
		usertf.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (usertf.getText().equals("Usuario")) {
		        	usertf.setText("");
		        	usertf.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (usertf.getText().isEmpty()) {
		        	usertf.setText("Usuario");
		        	usertf.setForeground(Color.GRAY);
		        }
		    }
		});
		
		passtf = new JPasswordField(10);
		passtf.setText("Contraseña");
		passtf.setHorizontalAlignment(SwingConstants.CENTER);
		passtf.setForeground(Color.GRAY);
		passtf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		passtf.setColumns(10);
		passtf.setBorder(null);
		passtf.setBackground(new Color(237, 244, 242));
		passtf.setBounds(563, 432, 388, 40);
		passtf.setEchoChar((char) 0); // mostrar el texto en claro
		contentPane.add(passtf);
		
		passtf.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (String.valueOf(passtf.getPassword()).equals("Contraseña")) {
		        	passtf.setText("");
		        	passtf.setForeground(Color.BLACK);
		        	passtf.setEchoChar('•'); // volver a ocultar caracteres
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (String.valueOf(passtf.getPassword()).isEmpty()) {
		        	passtf.setText("Contraseña");
		        	passtf.setForeground(Color.GRAY);
		        	passtf.setEchoChar((char) 0); // mostrar texto claro de nuevo
		        }
		    }
		});
		
		phonetf = new RoundTextField(10, 10, 10);
		phonetf.setText("Telefono");
		phonetf.setHorizontalAlignment(SwingConstants.CENTER);
		phonetf.setForeground(Color.GRAY);
		phonetf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		phonetf.setColumns(10);
		phonetf.setBorder(null);
		phonetf.setBackground(new Color(237, 244, 242));
		phonetf.setBounds(563, 507, 388, 40);
		contentPane.add(phonetf);
		
		phonetf.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (phonetf.getText().equals("Telefono")) {
		        	phonetf.setText("");
		        	phonetf.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (phonetf.getText().isEmpty()) {
		        	phonetf.setText("Telefono");
		        	phonetf.setForeground(Color.GRAY);
		        }
		    }
		});
		
		
		JLabel title2 = new JLabel("HUB");
		title2.setHorizontalTextPosition(SwingConstants.CENTER);
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Inter 28pt Thin", Font.PLAIN, 90));
		title2.setBounds(1091, 312, 320, 147);
		contentPane.add(title2);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setForeground(new Color(255, 255, 255));
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 90));
		title1.setHorizontalTextPosition(SwingConstants.CENTER);
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setBounds(100, 312, 320, 147);
		contentPane.add(title1);
		
		signup = new RoundButton("Crear Cuenta", 15, 15);
		signup.setFocusPainted(false);
		signup.setHorizontalTextPosition(SwingConstants.CENTER);
		signup.setForeground(new Color(255, 255, 255));
		signup.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 15));
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.setBorder(null);
		signup.setBackground(new Color(0, 0, 0));
		signup.setBounds(563, 634, 388, 40);
		contentPane.add(signup);
		
		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signup.setBackground(new Color(56, 56, 56));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signup.setBackground(new Color(0, 0, 0));
			}
			
		});
		
		JLabel panel = new JLabel("");
		panel.setBounds(520, 70, 471, 630);
		panel.setIcon(new ImageIcon(getClass().getResource("/signup-panel.png")));
		contentPane.add(panel);
		
		home = new JButton("");
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setHorizontalTextPosition(SwingConstants.CENTER);
		home.setOpaque(false);
		home.setBorder(null);
		home.setBounds(10, 710, 50, 50);
		home.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		contentPane.add(home);
		
		JLabel lblback = new JLabel("");
		lblback.setBounds(0, 0, 1530, 810);
		lblback.setIcon(new ImageIcon(getClass().getResource("/back.png")));
		contentPane.add(lblback);
		
		SwingUtilities.invokeLater(() -> {
		    panel.requestFocusInWindow();
		});
		
		// Events for the buttons
		
		home.addActionListener(new buttons());
		signup.addActionListener(new buttons());
	}
	
	/*
	 * Private class for handling the events
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == home) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}else if(button == signup) {
				register();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void register() {
		String email = emailtf.getText();
		String name = usertf.getText();
		String pass = passtf.getText();
		String phone = phonetf.getText();
		
		User u = new User(email, name, pass, phone);
		
		if(DBManagerClient.registerUser(u)) {
			JOptionPane.showMessageDialog(null, "¡Te has registrado correctamente!");
			HomeUser h = new HomeUser(u);
			h.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "¡Ya existe un usuario con estas credenciales!");
			blankFields();
		}
	}
	
	public void blankFields() {
		emailtf.setText("Correo");
		emailtf.setForeground(Color.gray);
		usertf.setText("Usuario");
		usertf.setForeground(Color.gray);
		passtf.setText("Contraseña");
		passtf.setForeground(Color.gray);
		passtf.setEchoChar((char) 0); // mostrar el texto en claro
		phonetf.setText("Telefono");
		phonetf.setForeground(Color.gray);
	}
	
	public boolean areEmpty() {
		if(emailtf.getText().isEmpty() || usertf.getText().isEmpty() || passtf.getText().isEmpty() || phonetf.getText().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
}
