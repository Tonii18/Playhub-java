package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import devices.Connections;
import models.Booking;
import models.Business;
import models.User;

public class DBManagerClient {
	
	public static boolean loginUser(User u) {
		boolean loggued = false;
		
		String username = u.getName();
		String pass = u.getPass();
		
		String sql = "SELECT * FROM usuario WHERE nombre = ? AND contraseña = ?";
		
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
	
	public static boolean registerUser(User u) {
		boolean registered = false;
		
		String email = u.getMail();
		String name = u.getName();
		String password = u.getPass();
		String phone = u.getPhone();
		
		if(userExists(name)) {
			registered = false;
		}else {
			String sql = "INSERT INTO usuario (correo, nombre, contraseña, telefono, saldo) VALUES(?, ?, ?, ?, 0.00)";
			
			try {
				Connection conn = Connections.obtener();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, email);
				ps.setString(2, name);
				ps.setString(3, password);
				ps.setString(4, phone);
				
				ps.executeUpdate();
				registered = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return registered;
	}
	
	public static boolean userExists(String name) {
		boolean exists = false;
		String sql = "SELECT * FROM usuario WHERE nombre = ?";

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
		
		String sql = "SELECT correo FROM usuario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
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
		
		String sql = "SELECT telefono FROM usuario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				phone = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return phone;
	}
	
	public static double getBalance(String name) {
		double balance = 0.00;
		
		String sql = "SELECT saldo FROM usuario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				balance = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return balance;
	}
	
	public static void setNewBalance(String name, double amount) {
		String sql = "UPDATE usuario SET saldo = saldo + ? WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, name);
			
			int rows = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Get sport name by its Id
	 
	public static String getSportName(int sportId) {
		String name = "";

		String sql = "SELECT nombre FROM deporte WHERE id = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sportId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				name = rs.getString("nombre");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return name;
	}
	
	// Get sportID by its name
	
	public static int getSportId(String sportname) {
		int id = 0;

		String sql = "SELECT id FROM deporte WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sportname);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return id;
	}
	
	// Get business 
	
	public static List<Business> getBusinessesBySport(int sId) {
	    List<Business> businesses = new ArrayList<>();
	    
	    String query = "";
	    
	    if(sId == 1) {
	    	query = "SELECT * FROM negocio WHERE deporte_id = ? OR deporte_id = 9";
	    }else {
	    	query = "SELECT * FROM negocio WHERE deporte_id = ?";
	    }

	    try{
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(query);

	        ps.setInt(1, sId);
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
	
	// Reduce balance from the client
	
	public static void reduceBalance(double price, String name) {
		String sql = "UPDATE usuario SET saldo = saldo - ? WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, price);
			ps.setString(2, name);
			
			int rows = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Insert new booking 
	
	public static void insertBooking(Booking booking) {
	    String sql = "INSERT INTO reservas (usuario_id, negocio_id, pista, fecha, franja_horaria, precio) VALUES (?, ?, ?, ?, ?, ?)";
	    
	    try {
	        Connection conn = Connections.obtener();
	        PreparedStatement ps = conn.prepareStatement(sql);
	        
	        ps.setInt(1, booking.getUserId());
	        ps.setInt(2, booking.getBusinessId());
	        ps.setString(3, booking.getCourt());
	        ps.setDate(4, java.sql.Date.valueOf(booking.getDate()));
	        ps.setString(5, booking.getTimeSlot());
	        ps.setDouble(6, booking.getPrice());
	        
	        ps.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// Get userId by its name
	
	public static int getUserId(String name) {
		int id = 0;

		String sql = "SELECT id FROM usuario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return id;
	}
	
	// Get all the bookings from an user
	
	public static List<Booking> getBookingsByUserId(int userId){
		List<Booking> list = new ArrayList<>();
		
		String sql = "SELECT * FROM reservas WHERE usuario_id = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bookingId = rs.getInt("id");
				int businessId = rs.getInt("negocio_id");
				String court = rs.getString("pista");
				LocalDate date = rs.getDate("fecha").toLocalDate();
				String time = rs.getString("franja_horaria");
				double price = rs.getDouble("precio");

				Booking b = new Booking(bookingId, userId, businessId, court, date, time, price);
				list.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

}
