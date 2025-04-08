package viewsOwner;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controllers.DBManagerOwner;
import models.Owner;
import roundedComponents.RoundButton;
import roundedComponents.RoundPanel;
import roundedComponents.RoundTextField;

public class OwnerSignup extends JFrame {

	private JPanel contentPane;
	private JTextField emailtf;
	private RoundTextField nametf;
	private RoundTextField surnametf;
	private JPasswordField passtf;
	private RoundTextField phonetf;
	private JButton signup;
	private JButton back;

	/**
	 * Create the frame.
	 */
	public OwnerSignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new RoundPanel(20, 20);
		panel.setBackground(new Color(219, 219, 219));
		panel.setBounds(157, 97, 1200, 576);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel subpanel1 = new RoundPanel(20, 20);
		subpanel1.setBounds(10, 10, 600, 555);
		panel.add(subpanel1);
		subpanel1.setLayout(null);
		
		JLabel title = new JLabel("Registrate como propietario de un negocio");
		title.setForeground(new Color(48, 48, 48));
		title.setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(39, 25, 521, 36);
		subpanel1.add(title);
		
		/*
		 * Inputs and placeholders
		 */
		
		emailtf = new RoundTextField(10, 10, 10);
		emailtf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		emailtf.setForeground(Color.gray);
		emailtf.setText("Correo");
		emailtf.setHorizontalAlignment(SwingConstants.CENTER);
		emailtf.setBounds(112, 107, 375, 42);
		subpanel1.add(emailtf);
		emailtf.setColumns(10);
		
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
		
		nametf = new RoundTextField(10, 10, 10);
		nametf.setText("Nombre");
		nametf.setHorizontalAlignment(SwingConstants.CENTER);
		nametf.setForeground(Color.GRAY);
		nametf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		nametf.setColumns(10);
		nametf.setBounds(112, 167, 375, 42);
		subpanel1.add(nametf);
		
		nametf.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (nametf.getText().equals("Nombre")) {
		        	nametf.setText("");
		        	nametf.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (nametf.getText().isEmpty()) {
		        	nametf.setText("Nombre");
		        	nametf.setForeground(Color.GRAY);
		        }
		    }
		});
		
		surnametf = new RoundTextField(10, 10, 10);
		surnametf.setText("Apellidos");
		surnametf.setHorizontalAlignment(SwingConstants.CENTER);
		surnametf.setForeground(Color.GRAY);
		surnametf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		surnametf.setColumns(10);
		surnametf.setBounds(112, 227, 375, 42);
		subpanel1.add(surnametf);
		
		surnametf.addFocusListener(new java.awt.event.FocusAdapter() {
		    @Override
		    public void focusGained(java.awt.event.FocusEvent e) {
		        if (surnametf.getText().equals("Apellidos")) {
		        	surnametf.setText("");
		        	surnametf.setForeground(Color.BLACK);
		        }
		    }

		    @Override
		    public void focusLost(java.awt.event.FocusEvent e) {
		        if (surnametf.getText().isEmpty()) {
		        	surnametf.setText("Apellidos");
		        	surnametf.setForeground(Color.GRAY);
		        }
		    }
		});
		
		passtf = new JPasswordField();
		passtf.setBorder(null);
		passtf.setText("Contraseña");
		passtf.setHorizontalAlignment(SwingConstants.CENTER);
		passtf.setForeground(Color.GRAY);
		passtf.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		passtf.setColumns(10);
		passtf.setBounds(112, 287, 375, 42);
		passtf.setEchoChar((char) 0); // mostrar el texto en claro
		subpanel1.add(passtf);
		
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
		phonetf.setBounds(112, 347, 375, 42);
		subpanel1.add(phonetf);
		
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
		
		/*
		 * 
		 */
		
		signup = new RoundButton("Registrarme", 10, 10);
		signup.setHorizontalTextPosition(SwingConstants.CENTER);
		signup.setForeground(new Color(255, 255, 255));
		signup.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.setBorder(null);
		signup.setBackground(new Color(0, 0, 0));
		signup.setBounds(112, 455, 375, 42);
		subpanel1.add(signup);
		
		JLabel vector = new JLabel("");
		vector.setBounds(661, 142, 491, 291);
		ImageIcon icon = new ImageIcon(getClass().getResource("/bussinessregister.png"));
		Image resized = icon.getImage().getScaledInstance(491, 280, Image.SCALE_SMOOTH);
		vector.setIcon(new ImageIcon(resized));
		panel.add(vector);
		
		JLabel subtitle = new JLabel("Registrare como propietario para ofrecer tus pistas, servicios y gestionar tus reservas. Todo desde el mismo lugar");
		subtitle.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		subtitle.setForeground(new Color(255, 255, 255));
		subtitle.setHorizontalAlignment(SwingConstants.CENTER);
		subtitle.setHorizontalTextPosition(SwingConstants.CENTER);
		subtitle.setBounds(234, 710, 1046, 39);
		contentPane.add(subtitle);
		
		back = new JButton("");
		back.setContentAreaFilled(false);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setBorder(null);
		back.setBounds(10, 708, 50, 50);
		contentPane.add(back);
		
		JLabel background = new JLabel("");
		background.setHorizontalTextPosition(SwingConstants.CENTER);
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setBounds(-8, -19, 1530, 810);
		background.setIcon(new ImageIcon(getClass().getResource("/back.png")));
		contentPane.add(background);
		
		SwingUtilities.invokeLater(() -> {
		    panel.requestFocusInWindow();
		});
		
		// Events
		
		signup.addActionListener(new buttons());
		back.addActionListener(new buttons());
	}
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == signup) {
				registerUser();
			}else if(button == back) {
				OwnerLogin ol = new OwnerLogin();
				ol.setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void registerUser() {
		String email = emailtf.getText();
		String name = nametf.getText();
		String surname = surnametf.getText();
		String pass = passtf.getText();
		String phone = phonetf.getText();
		
		Owner o = new Owner(email, name, surname, pass, phone);
		
		if(DBManagerOwner.registerOwner(o)) {
			JOptionPane.showMessageDialog(null, "¡Te has regisrtado con éxito!");
			
			HomeOwner ho = new HomeOwner(o);
			ho.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "¡Ya existe un usuario con estas credenciales!");
			blankFields();
		}
	}
	
	public void blankFields() {
		emailtf.setText("Correo");
		emailtf.setForeground(Color.gray);
		nametf.setText("Usuario");
		nametf.setForeground(Color.gray);
		surnametf.setText("Apellidos");
		surnametf.setForeground(Color.gray);
		passtf.setText("Contraseña");
		passtf.setForeground(Color.gray);
		passtf.setEchoChar((char) 0); // mostrar el texto en claro
		phonetf.setText("Telefono");
		phonetf.setForeground(Color.gray);
	}
}
