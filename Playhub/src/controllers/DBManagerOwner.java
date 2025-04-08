package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import devices.Connections;
import models.Owner;
import models.User;

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
		
		if(ownerExists(name)) {
			registered = false;
		}else {
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
		
		String sql = "SELECT telefono FROM propietario WHERE nombre = ?";
		
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
	
	public static String getSurname(String name) {
		String surname = "";
		
		String sql = "SELECT apellidos FROM propietario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				surname = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return surname;
	}
	
	public static double getIncome(String name) {
		double income = 0.00;
		
		String sql = "SELECT ingreso FROM propietario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				income = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return income;
	}
	
	/*
	 * public boolean insertarNegocio(Business negocio)
	   public List<Business> obtenerNegociosPorPropietario(int propietarioId)
	 */
	
	

}
