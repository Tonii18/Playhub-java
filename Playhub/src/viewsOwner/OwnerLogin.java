package viewsOwner;

import java.awt.Color;
import java.awt.Cursor;
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
import views.Login;

public class OwnerLogin extends JFrame {

	private JPanel contentPane;
	
	private JButton signup;
	private JTextField username;
	private JPasswordField passwordField;
	private JLabel tile;
	private JTextField buss;
	private JLabel logo;
	private JLabel panel2Bck;
	private JLabel text;
	private JLabel vector;
	private JButton login;
	private JButton back;

	/**
	 * Create the frame.
	 */
	public OwnerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new RoundPanel(20, 20);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(198, 69, 459, 633);
		contentPane.add(panel);
		panel.setLayout(null);
		
		buss = new RoundTextField(10, 10, 10);
		buss.setForeground(new Color(255, 255, 255));
		buss.setHorizontalAlignment(SwingConstants.CENTER);
		buss.setText("Bussiness Edition");
		buss.setFont(new Font("Inter 24pt Black", Font.PLAIN, 30));
		buss.setFocusable(false);
		buss.setEditable(false);
		buss.setBackground(new Color(54, 184, 140));
		buss.setBorder(null);
		buss.setBounds(26, 34, 407, 58);
		panel.add(buss);
		buss.setColumns(10);
		
		tile = new JLabel("Inicia sesion en tu cuenta");
		tile.setHorizontalTextPosition(SwingConstants.CENTER);
		tile.setHorizontalAlignment(SwingConstants.CENTER);
		tile.setFont(new Font("Inter 18pt ExtraBold", Font.PLAIN, 25));
		tile.setBounds(45, 156, 369, 42);
		panel.add(tile);
		
		signup = new RoundButton("Crear cuenta", 10, 10);
		signup.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.setBorder(null);
		signup.setBounds(45, 554, 369, 42);
		((RoundButton) signup).setCustomBorderColor(Color.BLACK);
		panel.add(signup);
		
		login = new RoundButton("Crear cuenta", 10, 10);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setBackground(new Color(0, 0, 0));
		login.setForeground(new Color(255, 255, 255));
		login.setText("Iniciar sesion");
		login.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		((RoundButton) login).setCustomBorderColor(Color.BLACK);
		login.setBorder(null);
		login.setBounds(45, 501, 369, 42);
		panel.add(login);
		
		/*
		 * Adding the textfields and their placeholders
		 */
		
		username = new RoundTextField(10, 10, 10);
		username.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBorder(null);
		username.setBackground(new Color(237, 244, 242));
		username.setForeground(Color.gray);
		username.setBounds(45, 337, 369, 42);
		username.setText("Usuario");
		panel.add(username);
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
		
		passwordField = new JPasswordField(10);
		passwordField.setText("Contraseña");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(237, 244, 242));
		passwordField.setBounds(45, 402, 369, 42);
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
		
		panel.add(passwordField);
		
		/*
		 *  Rest of the frame
		 */

		JPanel panel2 = new JPanel();
		panel2.setBounds(855, 69, 459, 633);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		logo = new JLabel("");
		logo.setBounds(179, 23, 100, 100);
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		Image resized = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(resized));
		panel2.add(logo);
		
		vector = new JLabel("");
		vector.setBounds(39, 231, 380, 391);
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/loginVector.png"));
		Image resized2 = icon2.getImage().getScaledInstance(380, 391, Image.SCALE_SMOOTH);
		vector.setIcon(new ImageIcon(resized2));
		panel2.add(vector);
		
		text = new JLabel("Acceso para empresas y organizaciones");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setHorizontalTextPosition(SwingConstants.CENTER);
		text.setForeground(new Color(255, 255, 255));
		text.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 23));
		text.setBounds(10, 144, 439, 32);
		panel2.add(text);
		
		panel2Bck = new JLabel("");
		panel2Bck.setBounds(0, 0, 459, 633);
		panel2Bck.setIcon(new ImageIcon(getClass().getResource("/back.png")));
		panel2.add(panel2Bck);
		
		back = new JButton("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setIcon(new ImageIcon(getClass().getResource("/arrow-back.png")));
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setBounds(10, 710, 50, 50);
		contentPane.add(back);
		
		JLabel background = new JLabel("");
		background.setBounds(-8, -19, 1530, 810);
		background.setIcon(new ImageIcon(getClass().getResource("/back.png")));
		contentPane.add(background);
		
		SwingUtilities.invokeLater(() -> {
		    panel.requestFocusInWindow();
		});
		
		// Events
		
		login.addActionListener(new buttons());
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
			
			if(button == login) {
				loginOwner();
			}else if(button == signup){
				OwnerSignup os = new OwnerSignup();
				os.setVisible(true);
				dispose();
			}else if(button == back) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void loginOwner() {
		String name = username.getText();
		String pass = new String(passwordField.getPassword());
		
		Owner o = new Owner(name, pass);
		
		if(DBManagerOwner.loginOwner(o)) {
			String email = DBManagerOwner.getEmail(name);
			String surname = DBManagerOwner.getSurname(name);
			String phone = DBManagerOwner.getPhoneNumber(name);
			
			JOptionPane.showMessageDialog(null, "¡Has iniciado sesion correctamente!");
			
			Owner fullOwner = new Owner(email, name, surname, pass, phone);
			
			HomeOwner ho = new HomeOwner(fullOwner);
			ho.setVisible(true);
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
