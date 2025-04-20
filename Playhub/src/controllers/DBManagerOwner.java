package controllers;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import devices.Connections;
import models.Business;
import models.Owner;

public class DBManagerOwner {

	public static boolean loginOwner(Owner o) {
		boolean loggued = false;

		String username = o.getName();
		String pass = o.getPass();

		String sql = "SELECT * FROM propietario WHERE nombre = ? AND contraseña = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, pass);

			loggued = ps.executeQuery().next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return loggued;
	}

	public static boolean registerOwner(Owner o) {
		boolean registered = false;

		String email = o.getEmail();
		String name = o.getName();
		String surname = o.getSurname();
		String password = o.getPass();
		String phone = o.getPhone();

		if (ownerExists(name)) {
			registered = false;
		} else {
			String sql = "INSERT INTO propietario (nombre, apellidos, correo, contraseña, telefono, ingreso) VALUES(?, ?, ?, ?, ?, 0.00)";

			try {
				Connection conn = Connections.obtener();
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, name);
				ps.setString(2, surname);
				ps.setString(3, email);
				ps.setString(4, password);
				ps.setString(5, phone);

				ps.executeUpdate();
				registered = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return registered;
	}

	public static boolean ownerExists(String name) {
		boolean exists = false;
		String sql = "SELECT * FROM propietario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			exists = rs.next(); // Si hay al menos un resultado, el usuario existe

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exists;
	}

	public static String getEmail(String name) {
		String email = "";

		String sql = "SELECT correo FROM propietario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				email = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return email;
	}

	public static String getPhoneNumber(String name) {
		String phone = "";

		String sql = "SELECT telefono FROM propietario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				phone = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return phone;
	}

	public static String getSurname(String name) {
		String surname = "";

		String sql = "SELECT apellidos FROM propietario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				surname = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return surname;
	}

	// Get the total income from a owner by its name

	public static double getIncome(String name) {
		double income = 0.00;

		String sql = "SELECT ingreso FROM propietario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				income = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return income;
	}

	// Get the id from a owner by his name

	public static int getId(String name) {
		int id = 0;

		String sql = "SELECT id FROM propietario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return id;
	}

	// Get the sport id by its name

	public static int getSportId(String name) {
		int id = 0;

		String sql = "SELECT id FROM deporte WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return id;
	}

	// Get the sport list from database to show them on the combobox

	public static List<String> getSports() {
		List<String> sports = new ArrayList<>();

		String sql = "SELECT nombre FROM deporte";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				sports.add(rs.getString("nombre"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return sports;
	}

	// Set a new sport into database if you dont want any of the defaults ones

	public static void setSports(String sport) {
		String sql = "INSERT INTO deporte (nombre) VALUES (?)";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, sport);

			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Insert business

	public static int insertBusiness(Business b, File imageFile) {
		int generatedId = -1;

		String insertBusinessQuery = "INSERT INTO negocio (nombre, descripcion, ubicacion, precio_por_hora, numero_pistas, deporte_id, propietario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement stmt = conn.prepareStatement(insertBusinessQuery, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, b.getName());
			stmt.setString(2, b.getDescription());
			stmt.setString(3, b.getLocation());
			stmt.setDouble(4, b.getPricePerHour());
			stmt.setInt(5, b.getAvaliablesPitchs());
			stmt.setInt(6, b.getSportId());
			stmt.setInt(7, b.getOwnerId());

			int affectedRows = stmt.executeUpdate();

			if (affectedRows > 0) {
				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						generatedId = rs.getInt(1);
						insertBusinessImage(generatedId, imageFile.getAbsolutePath(), true);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return generatedId;
	}

	// Insert the business image

	private static void insertBusinessImage(int businessId, String imageUrl, boolean isMain) {
		String insertImageQuery = "INSERT INTO negocio_imagen (negocio_id, url_imagen, es_principal) VALUES (?, ?, ?)";

		try (Connection conn = Connections.obtener();
				PreparedStatement stmt = conn.prepareStatement(insertImageQuery)) {
			stmt.setInt(1, businessId);
			stmt.setString(2, imageUrl);
			stmt.setBoolean(3, isMain);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Get de Business by the Owner ID

	public static List<Business> getBusinessesByOwner(int ownerId) {
		List<Business> businesses = new ArrayList<>();

		String query = "SELECT * FROM negocio WHERE propietario_id = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, ownerId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nombre");
				String description = rs.getString("descripcion");
				String location = rs.getString("ubicacion");
				double pricePerHour = rs.getDouble("precio_por_hora");
				int avaliablesPitchs = rs.getInt("numero_pistas");
				int sportId = rs.getInt("deporte_id");
				int propId = rs.getInt("propietario_id");

				Business b = new Business(name, description, location, pricePerHour, avaliablesPitchs, sportId, propId);
				businesses.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return businesses;
	}

	// Get ImagePath by business name

	public static String getImagePathByBusinessId(int businessId) {
		String imagePath = "";

		String sql = "SELECT url_imagen FROM negocio_imagen WHERE negocio_id = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, businessId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				imagePath = rs.getString("url_imagen");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return imagePath;
	}

	// Get id from bussinnes by its name

	public static int getBusinessId(String name) {
		int id = 0;

		String sql = "SELECT id FROM negocio WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return id;
	}
	
	// Update total income to owner
	
	public static void updateIncome(double income, int ownerId) {
		String sql = "UPDATE propietario SET ingreso = ingreso + ? WHERE id = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, income);
			ps.setInt(2, ownerId);
			
			int rows = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Get business by its id
	
	public static Business getBusinessById(int id) {
	    Business business = null;

	    try (Connection conn = Connections.obtener()) {
	        String query = "SELECT * FROM negocio WHERE id = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String descripcion = rs.getString("descripcion");
	            String ubicacion = rs.getString("ubicacion");
	            double precioPorHora = rs.getDouble("precio_por_hora");
	            int numeroPistas = rs.getInt("numero_pistas");
	            int deporteId = rs.getInt("deporte_id");
	            int propietarioId = rs.getInt("propietario_id");

	            String imagePath = getImagePathByBusinessId(id);

	            business = new Business(
	                id,
	                nombre,
	                descripcion,
	                ubicacion,
	                precioPorHora,
	                numeroPistas,
	                deporteId,
	                propietarioId,
	                imagePath
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return business;
	}



}
