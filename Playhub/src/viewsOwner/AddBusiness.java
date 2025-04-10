package viewsOwner;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.DBManagerOwner;
import models.Business;
import models.Owner;
import roundedComponents.RoundButton;
import roundedComponents.RoundButtonImage;

public class AddBusiness extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField nametf;
	private JTextField pricetf;
	private JTextField numberstf;
	private JTextField locationtf;
	
	private JButton back;
	private JButton create;
	
	private JComboBox<String> comboBox;
	
	private JTextArea textArea;
	
	private File selectedImageFile = null;
	
	private Owner o;
	private JButton addCustome;
	private JLabel sportLabel;
	private JLabel priceLabel;
	private JLabel courtsLabel;
	private JLabel locationLabel;
	private JLabel descriptionLabel;
	private JLabel imageLabel;

	/**
	 * Create the frame.
	 */
	public AddBusiness(Owner o) {
		this.o = o;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1530, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navbar = new JPanel();
		navbar.setBounds(-7, 0, 1530, 90);
		contentPane.add(navbar);
		navbar.setLayout(null);
		
		JLabel title2 = new JLabel("HUB");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Inter 28pt ExtraLight", Font.PLAIN, 40));
		title2.setBounds(810, 23, 110, 44);
		navbar.add(title2);
		
		JLabel title1 = new JLabel("PLAY");
		title1.setForeground(new Color(255, 255, 255));
		title1.setFont(new Font("Inter 28pt Black", Font.PLAIN, 40));
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setBounds(588, 23, 110, 44);
		navbar.add(title1);
		
		JLabel logo = new JLabel("");
		logo.setBounds(730, 10, 70, 70);
		logo.setIcon(new ImageIcon(getClass().getResource("/logo-resized.png")));
		navbar.add(logo);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1530, 90);
		background.setIcon(new ImageIcon(getClass().getResource("/back-rotated.png")));
		navbar.add(background);
		
		JPanel body = new JPanel();
		body.setBorder(null);
		body.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		body.setBounds(-7, 89, 1530, 695);
		contentPane.add(body);
		body.setLayout(null);
		
		nametf = new JTextField(10);
		nametf.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		nametf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		nametf.setBounds(97, 96, 380, 50);
		body.add(nametf);
		nametf.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		comboBox.setBounds(97, 242, 380, 50);
		
		comboBox.addItem("Selecciona un deporte");
		
		List<String> sportList = DBManagerOwner.getSports();
		for(String s: sportList) {
			comboBox.addItem(s);
		}
		
		body.add(comboBox);
		
		pricetf = new JTextField(10);
		pricetf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		pricetf.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		pricetf.setBounds(97, 388, 380, 50);
		body.add(pricetf);
		
		create = new RoundButton("Crear Negocio", 20, 20);
		create.setBorder(null);
		create.setForeground(new Color(255, 255, 255));
		create.setFont(new Font("Inter 28pt ExtraBold", Font.PLAIN, 20));
		create.setBackground(new Color(59, 167, 176));
		create.setBounds(97, 512, 380, 72);
		body.add(create);
		
		numberstf = new JTextField(10);
		numberstf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		numberstf.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		numberstf.setBounds(574, 96, 380, 50);
		body.add(numberstf);
		
		locationtf = new JTextField(10);
		locationtf.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		locationtf.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		locationtf.setBounds(574, 242, 380, 50);
		body.add(locationtf);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(120, 120, 120)));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Inter 28pt Light", Font.PLAIN, 20));
		textArea.setBounds(574, 388, 380, 196);
		body.add(textArea);
		
		JButton addImage = new RoundButtonImage("", 15, 15);
		addImage.setBackground(new Color(255, 255, 255));
		addImage.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		addImage.setFont(new Font("Inter 24pt Medium", Font.PLAIN, 20));
		addImage.setBounds(1051, 96, 380, 196);
		addImage.setIcon(new ImageIcon(getClass().getResource("/input-image.png")));
		body.add(addImage);
		
		addImage.addActionListener(e -> {
		    JFileChooser fileChooser = new JFileChooser();
		    int option = fileChooser.showOpenDialog(null);
		    if (option == JFileChooser.APPROVE_OPTION) {
		        selectedImageFile = fileChooser.getSelectedFile();
		        addImage.setIcon(null);
		        addImage.setText("Imagen seleccionada");
		    }
		});

		
		back = new JButton("");
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setBounds(24, 623, 50, 50);
		back.setIcon(new ImageIcon(getClass().getResource("/arrow_back (2).png")));
		body.add(back);
		
		addCustome = new RoundButton("Añadir deporte", 10, 10);
		addCustome.setBackground(new Color(54, 184, 140));
		addCustome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addCustome.setBorder(null);
		addCustome.setForeground(new Color(255, 255, 255));
		addCustome.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		addCustome.setBounds(97, 302, 380, 34);
		body.add(addCustome);
		
		JLabel nameLabel = new JLabel("Nombre del negocio");
		nameLabel.setForeground(new Color(59, 167, 176));
		nameLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		nameLabel.setBounds(97, 56, 215, 21);
		body.add(nameLabel);
		
		sportLabel = new JLabel("Deporte de tu negocio");
		sportLabel.setForeground(new Color(59, 167, 176));
		sportLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		sportLabel.setBounds(97, 211, 215, 21);
		body.add(sportLabel);
		
		priceLabel = new JLabel("Precio por hora");
		priceLabel.setForeground(new Color(59, 167, 176));
		priceLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		priceLabel.setBounds(97, 357, 215, 21);
		body.add(priceLabel);
		
		courtsLabel = new JLabel("Número de pistas");
		courtsLabel.setForeground(new Color(59, 167, 176));
		courtsLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		courtsLabel.setBounds(574, 65, 215, 21);
		body.add(courtsLabel);
		
		locationLabel = new JLabel("Ubicacion");
		locationLabel.setForeground(new Color(59, 167, 176));
		locationLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		locationLabel.setBounds(574, 211, 215, 21);
		body.add(locationLabel);
		
		descriptionLabel = new JLabel("Descripcion");
		descriptionLabel.setForeground(new Color(59, 167, 176));
		descriptionLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		descriptionLabel.setBounds(574, 357, 215, 21);
		body.add(descriptionLabel);
		
		imageLabel = new JLabel("Selecciona una imagen");
		imageLabel.setForeground(new Color(59, 167, 176));
		imageLabel.setFont(new Font("Inter 28pt Medium", Font.PLAIN, 15));
		imageLabel.setBounds(1051, 65, 215, 21);
		body.add(imageLabel);
		ImageIcon icon = new ImageIcon(getClass().getResource("/form-image.png"));
		Image resized = icon.getImage().getScaledInstance(517, 316, Image.SCALE_SMOOTH);
		
		addCustome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newSport = JOptionPane.showInputDialog(null, "Introduce el nuevo deporte que quieras añadir");
				DBManagerOwner.setSports(newSport);
				comboBox.addItem(newSport);
			}
			
		});
		
		// Events
		
		back.addActionListener(new buttons());
		create.addActionListener(new buttons());
	}
	
	/*
	 * Private class
	 */
	
	private class buttons implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			
			if(button == back) {
				BusinessView bv = new BusinessView(o);
				bv.setVisible(true);
				dispose();
			}else if(button == create) {
				createBusiness();
			}
		}
		
	}
	
	/*
	 * External methods
	 */
	
	public void createBusiness() {
		String name = nametf.getText();
		String priceStr = pricetf.getText();
		String courtsStr = numberstf.getText();
		String location = locationtf.getText();
		String description = textArea.getText();
		String sportName = (String) comboBox.getSelectedItem();
		
		if (name.isEmpty() || priceStr.isEmpty() || courtsStr.isEmpty() || location.isEmpty() || description.isEmpty()
				|| sportName == null || selectedImageFile == null) {
			JOptionPane.showMessageDialog(this, "Por favor, rellena todos los campos y selecciona una imagen.");
			return;
		}
		
		int ownerId = DBManagerOwner.getId(o.getName());
		double price = Double.parseDouble(priceStr);
		int sportId = DBManagerOwner.getSportId(sportName);
		int avaliablesCourts = Integer.parseInt(courtsStr);
		
		Business b = new Business(name, description, location, price, avaliablesCourts, sportId, ownerId);
		
		int newBusinessId = DBManagerOwner.insertBusiness(b, selectedImageFile);

		if (newBusinessId != -1) {
			JOptionPane.showMessageDialog(this, "Negocio creado correctamente.");
			BusinessView bv = new BusinessView(o);
			bv.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Error al crear el negocio.");
		}
		
	}
}
